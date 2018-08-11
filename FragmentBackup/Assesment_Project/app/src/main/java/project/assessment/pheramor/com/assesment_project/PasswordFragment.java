package project.assessment.pheramor.com.assesment_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PasswordFragment extends Fragment {
    TextView email_address;
    Intent lastActivity;
    RegisterUser newUser;
    Button button;
    Intent intent;
    EditText password1;
    EditText password2;


    public static PasswordFragment getInstance(){
        return new PasswordFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_password,container,false);
        lastActivity = getActivity().getParentActivityIntent();
       // newUser = (RegisterUser)lastActivity.getSerializableExtra("USER_OBJECT");


        email_address = (TextView)view.findViewById(R.id.email_address);
        //String email = newUser.getEmail();
        //email_address.setText("Email:   " +email);
        password1 = (EditText)view.findViewById(R.id.password1);
        password2 = (EditText)view.findViewById(R.id.password2);
        //email_address.setText(lastActivity.getStringExtra("EMAIL_ADDRESS"));

        button = (Button)view.findViewById(R.id.button_next);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((password1.getText()==null)||(password1.getText().toString().equals(password2.getText().toString())==false)){
                    Toast.makeText(getActivity(),"Please try again",Toast.LENGTH_SHORT).show();
                }
                else {
                    intent = new Intent(getActivity(), NameActivity.class);
                    intent.putExtra("USER_OBJECT", newUser);
                    //startActivity(intent);
                }
            }
        });

        return view;
    }
}
