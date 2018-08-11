package project.assessment.pheramor.com.assesment_project;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {

    RegisterUser newUser;
    Button button;
    EditText first_name;
    EditText last_name;
    EditText zipcode;
    EditText height;

    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_name);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff006666));
        first_name = (EditText)findViewById(R.id.first_name);
        last_name = (EditText)findViewById(R.id.last_name);
        zipcode = (EditText)findViewById(R.id.zipcode);
        height = (EditText)findViewById(R.id.height);
        button = (Button)findViewById(R.id.button_next);

        newUser = (RegisterUser)getIntent().getSerializableExtra("USER_OBJECT");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zip = zipcode.getText().toString();
                String pattern_str = "\\d{5}";
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(pattern_str);
                java.util.regex.Matcher match = pattern.matcher(zip);
                if(match.matches()==false){
                    Toast.makeText(NameActivity.this,"Enter a vlaid Zipcode",Toast.LENGTH_SHORT).show();
                }
                else if(first_name.getText().toString().equals("") &&last_name.getText().toString().equals("")){
                    Toast.makeText(NameActivity.this,"Enter first & last names",Toast.LENGTH_SHORT).show();
                }
                else if(first_name.getText().toString().equals("")){
                    Toast.makeText(NameActivity.this,"Enter first name",Toast.LENGTH_SHORT).show();
                }
                else if(last_name.getText().toString().equals("")){
                    Toast.makeText(NameActivity.this,"Enter last name",Toast.LENGTH_SHORT).show();
                }
                else if(height.getText().toString().equals("")){
                    Toast.makeText(NameActivity.this,"Enter height",Toast.LENGTH_SHORT).show();
                }

                else {
                    intent = new Intent(NameActivity.this, DOBActivity.class);
                    newUser.setFirstName(first_name.getText().toString());
                    newUser.setLastName(last_name.getText().toString());
                    newUser.setZipCode(zip);
                    newUser.setHeight(height.getText().toString());
                    intent.putExtra("USER_OBJECT", newUser);
                    startActivity(intent);
                }
            }
        });


    }
}
