package project.assessment.pheramor.com.assesment_project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SummaryActivity extends AppCompatActivity {

    TextView email;
    TextView name;
    RegisterUser newUser;
    Button register;
    JSONObject obj;
    String TAG = "PHERAMOR";
    JsonObject obj2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_summary);

        email = (TextView)findViewById(R.id.email);
        name = (TextView)findViewById(R.id.name);

        newUser = (RegisterUser)getIntent().getSerializableExtra("USER_OBJECT");

        email.setText("Email : "+newUser.getEmail());
        name.setText("Name: "+newUser.getName());

        register = (Button)findViewById(R.id.register);
        obj = new JSONObject();
        try{
            obj.put("email",newUser.getEmail());
            obj.put("name",newUser.getName());
        }
        catch (JSONException e){

        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick ");
                new postData().execute(String.valueOf(obj));
                //Toast.makeText(SummaryActivity.this,"Succesfully registered. Satus: "+obj2.get("status").toString()+" Message: "+obj2.get("message").toString(),Toast.LENGTH_SHORT).show();

            }
        });


    }
    public class postData extends AsyncTask<String, String,String>{

        @Override
        protected String doInBackground(String... strings) {
            Log.d(TAG,"doInBackground");
            String response = null;
            String data = strings[0];
            Log.d(TAG,"Data: "+data);

            BufferedReader reader = null;
            HttpURLConnection connection = null;

            try {
                URL url = new URL("https://external.dev.pheramor.com/");
                connection = (HttpURLConnection) url.openConnection();
                Log.d(TAG,"Connection created");
                connection.setDoOutput(true);

                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                Log.d(TAG,"Connection properties set");
                Writer writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
                writer.write(data);

                writer.close();
                Log.d(TAG,"Wrote data");
                InputStream inputStream = connection.getInputStream();
                Log.d(TAG,"Get input stream");
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));
                Log.d(TAG,"Created Buffer reader");
                String inputLine;
                while ((inputLine = reader.readLine()) != null)
                    buffer.append(inputLine + "\n");
                if (buffer.length() == 0) {

                    return null;
                }
                response = buffer.toString();
               // JSONObject parser = new JSONObject(response);

                Gson gson = new Gson();
                gson.toJson(response);
                JsonParser parser = new JsonParser();
                obj2 = (JsonObject) parser.parse(response);
                Log.i(TAG, response);
                Log.i(TAG, "obj: "+obj2);
                Log.i(TAG, "obj status: "+obj2.get("status"));
                //Toast.makeText(SummaryActivity.this,"Succesfully registered. Satus: "+obj.get("status").toString()+" Message: "+obj.get("message").toString(),Toast.LENGTH_SHORT).show();


                return response;

                //return null;
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            } catch (ProtocolException e1) {
                e1.printStackTrace();
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return null;
        }
            @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

        }


