package project.assessment.pheramor.com.assesment_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    RegisterUser newUser;
    Button button;
    EditText first_name;
    EditText last_name;

    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_name);

        first_name = (EditText)findViewById(R.id.first_name);
        last_name = (EditText)findViewById(R.id.last_name);
        button = (Button)findViewById(R.id.button_next);

        newUser = (RegisterUser)getIntent().getSerializableExtra("USER_OBJECT");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(NameActivity.this, SummaryActivity.class);
                newUser.setFirstName(first_name.getText().toString());
                newUser.setLastName(last_name.getText().toString());
                intent.putExtra("USER_OBJECT",newUser);
                startActivity(intent);
            }
        });


    }
}
