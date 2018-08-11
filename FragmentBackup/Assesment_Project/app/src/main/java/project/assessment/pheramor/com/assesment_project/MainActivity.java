package project.assessment.pheramor.com.assesment_project;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*TextView email_address;
    Button next;
    Intent intent;*/
    RegisterUser newUser;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    FragmentPagerAdapter adapterViewPager;
    public static ViewPager viewPager;
    String TAG = "PHERAMOR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        Log.d(TAG,"MainActivity onCreate");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff006666));

        newUser = new RegisterUser();
        getIntent().putExtra("USR_OBJECT",newUser);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        adapterViewPager = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);
       /* next = (Button) findViewById(R.id.button_next);
        email_address = (EditText)findViewById(R.id.emailAddress);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, PasswordActivity.class);
                newUser = new RegisterUser();
                String email = email_address.getText().toString();

                String pattern_str = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(pattern_str);
                java.util.regex.Matcher match = pattern.matcher(email);
                if(match.matches()==false){
                    Toast.makeText(MainActivity.this,"Enter a vlaid Email address",Toast.LENGTH_SHORT).show();
                }
                else {
                    newUser.setEmail(email);

                    intent.putExtra("USER_OBJECT", newUser);
                    startActivity(intent);
                }
            }
        });*/

    }

    public static class PageAdapter extends FragmentPagerAdapter{
        private static int NUM_ITEMS = 2;

        public PageAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return EmailFragment.getInstance();

                case 1:
                    return PasswordFragment.getInstance();
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    }


}
