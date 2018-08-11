package project.assessment.pheramor.com.assesment_project;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProfilePictureActivity extends AppCompatActivity {


    Button upload;
    Button next;
    ImageView picture;

    RegisterUser newUser;
    Intent intent;
    public static Uri uri;

    private static final int RESULT_LOAD = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile_picture);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff006666));
        upload = (Button)findViewById(R.id.upload_picture);
        next = (Button)findViewById(R.id.button_next);
        picture = (ImageView) findViewById(R.id.picture);
        uri = null;

        newUser = (RegisterUser)getIntent().getSerializableExtra("USER_OBJECT");


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery,RESULT_LOAD);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // newUser.setPhoto_id(uri);
                intent = new Intent(ProfilePictureActivity.this, SummaryActivity.class);
                intent.putExtra("USER_OBJECT",newUser);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_LOAD && resultCode == RESULT_OK && data!=null){
            uri = data.getData();
            picture.setImageURI(uri);
            picture.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
            upload.setVisibility(View.INVISIBLE);
        }
    }
}
