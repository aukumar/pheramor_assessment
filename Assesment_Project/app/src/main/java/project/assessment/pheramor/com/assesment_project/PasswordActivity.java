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
import android.widget.TextView;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity{
    TextView email_address;
    Intent lastActivity;
    RegisterUser newUser;
    Button button;
    Intent intent;
    EditText password1;
    EditText password2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_password);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff006666));

        lastActivity = getIntent();
        newUser = (RegisterUser)lastActivity.getSerializableExtra("USER_OBJECT");

        email_address = (TextView)findViewById(R.id.email_address);
        String email = newUser.getEmail();
        email_address.setText("Email:   " +email);
        password1 = (EditText)findViewById(R.id.password1);
        password2 = (EditText)findViewById(R.id.password2);
        //email_address.setText(lastActivity.getStringExtra("EMAIL_ADDRESS"));

        button = (Button)findViewById(R.id.button_next);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((password1.getText().toString().equals(""))||(password1.getText().toString().equals(password2.getText().toString())==false)){
                    Toast.makeText(PasswordActivity.this,"Please try again",Toast.LENGTH_SHORT).show();
                }
                else if(password1.getText().toString().length()<6){
                    Toast.makeText(PasswordActivity.this,"Password should contain atleast 6 characters",Toast.LENGTH_SHORT).show();
                }
                else {
                    newUser.setPassword(password1.getText().toString());
                    intent = new Intent(PasswordActivity.this, NameActivity.class);
                    intent.putExtra("USER_OBJECT", newUser);
                    startActivity(intent);
                }
            }
        });

    }


}
