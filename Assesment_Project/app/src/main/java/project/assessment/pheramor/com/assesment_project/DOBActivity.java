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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DOBActivity extends AppCompatActivity {

    EditText dob;
    Button next;
    RadioGroup radioGroup;
    RegisterUser newUser;
    Intent intent;
    Date date;
    String gender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dob);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff006666));

        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        dob = (EditText)findViewById(R.id.date);
        next = (Button)findViewById(R.id.button_next);
        newUser = (RegisterUser)getIntent().getSerializableExtra("USER_OBJECT");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dob.getText().toString().equals("")) {
                    Toast.makeText(DOBActivity.this,"Enter the date of birth",Toast.LENGTH_SHORT).show();
                } else {

                    DateFormat format = new SimpleDateFormat("MM.dd.yyyy", Locale.ENGLISH);
                    try {
                        date = format.parse(dob.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    int i = radioGroup.getCheckedRadioButtonId();
                    switch (i) {
                        case R.id.female:
                            gender = "F";
                            break;
                        case R.id.male:
                            gender = "M";
                            break;
                        default:
                            gender = " ";

                    }
                    newUser.setGender(gender);
                    newUser.setDob(date);
                    intent = new Intent(DOBActivity.this, InterestActivity.class);
                    intent.putExtra("USER_OBJECT", newUser);

                    startActivity(intent);

                }
            }
        });


    }
}
