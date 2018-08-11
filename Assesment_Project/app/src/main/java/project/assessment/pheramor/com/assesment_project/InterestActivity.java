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
import android.widget.RadioGroup;
import android.widget.Toast;

public class InterestActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    EditText from;
    EditText to;
    RegisterUser newUser;
    Button next;
    Intent intent;
    String interest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff006666));
        newUser = (RegisterUser)getIntent().getSerializableExtra("USER_OBJECT");

        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        from = (EditText)findViewById(R.id.from);
        to = (EditText)findViewById(R.id.to);


        next = (Button)findViewById(R.id.button_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int i = radioGroup.getCheckedRadioButtonId();
                String g = newUser.getGender();
                switch (i){
                    case  R.id.first:if(g.equals("F"))
                                interest = "Males";
                            else if(g.equals("M"))
                                interest = "Females";
                            break;
                    case R.id.second:if(g.equals("M"))
                        interest = "Males";
                    else if(g.equals("F"))
                        interest = "Females";
                        break;
                    case R.id.third:
                        interest = "Males & Females";
                        break;
                    default:
                        interest = "Unknown";

                }

                String f = from.getText().toString();
                String t = to.getText().toString();
                if (f.equals("")||t.equals("")) {
                    Toast.makeText(InterestActivity.this,"Please enter range",Toast.LENGTH_SHORT).show();
                }

                else if (Integer.parseInt(f) > Integer.parseInt(t)) {
                    Toast.makeText(InterestActivity.this,"Please check range. Second value should be more.",Toast.LENGTH_SHORT).show();
                }else {
                    newUser.setFrom_age(f);
                    newUser.setTo_age(t);
                    newUser.setInterests(interest);
                    intent = new Intent(InterestActivity.this, OptionalActivity.class);
                    intent.putExtra("USER_OBJECT", newUser);
                    startActivity(intent);
                }
            }
        });
    }
}
