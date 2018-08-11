package project.assessment.pheramor.com.assesment_project;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class OptionalActivity extends AppCompatActivity {

    Spinner spinner1;
    Spinner spinner2;
    Button next;
    RegisterUser newUser;
    String[] race_values;
    String[] ethnicity_values;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optional);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff006666));
        newUser = (RegisterUser)getIntent().getSerializableExtra("USER_OBJECT");

        spinner1 = (Spinner)findViewById(R.id.race_spinner);
        spinner2 = (Spinner)findViewById(R.id.ethinicity_spinner);

        race_values = new String[]{"American Indian or Alaska Native","Asian","Black or African American","Native Hawaiian or Other Pacific Islander","White","Prefer not to answer"};
        ethnicity_values = new String[]{"Hispanic or Latino","Not Hispanic or Latino","Prefer not to answer"};


        final ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.spinner_item,race_values);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.spinner_item,ethnicity_values);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);

        next = (Button)findViewById(R.id.button_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newUser.setRace(spinner1.getSelectedItem().toString());
                newUser.setRace(spinner2.getSelectedItem().toString());
                intent = new Intent(OptionalActivity.this, ProfilePictureActivity.class);
                intent.putExtra("USER_OBJECT",newUser);
                startActivity(intent);
            }
        });
    }
}
