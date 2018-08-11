package project.assessment.pheramor.com.assesment_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmailFragment extends Fragment {
    TextView email_address;
    Button next;
    Intent intent;
    RegisterUser newUser;

    public static EmailFragment getInstance(){
        return new EmailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main,container,false);

        next = (Button) view.findViewById(R.id.button_next);
        email_address = (EditText)view.findViewById(R.id.emailAddress);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = getActivity().getParentActivityIntent();
                //newUser = new RegisterUser();
               // newUser = (RegisterUser)intent.getSerializableExtra("USER_OBJECT");
                String email = email_address.getText().toString();

                String pattern_str = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(pattern_str);
                java.util.regex.Matcher match = pattern.matcher(email);
                if(match.matches()==false){
                    Toast.makeText(getActivity(),"Enter a vlaid Email address",Toast.LENGTH_SHORT).show();
                }
                else {
                    newUser.setEmail(email);

                    intent.putExtra("USER_OBJECT", newUser);
                    //startActivity(intent);
                    MainActivity.viewPager.setCurrentItem(1,true);
                }
            }
        });

        return view;
    }
}
