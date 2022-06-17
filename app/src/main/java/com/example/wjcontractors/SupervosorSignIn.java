package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wjcontractors.DB.DataHandler;

public class SupervosorSignIn extends AppCompatActivity {
    EditText username,password;
    DataHandler dataHandler = new DataHandler(this);
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "my_prefs";
    private static final String KEY_NAME = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervosor_sign_in);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);

        //database
        dataHandler.openDB();

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, null);
        if (name != null) {
            Intent intent = new Intent(getApplicationContext(), AdminMain.class);
            startActivity(intent);
        }
    }
    //name validation
    private boolean validUsername() {
        String fname = username.getText().toString().trim();

        if (fname.isEmpty()) {
            username.setError("Username is Empty.");
            return false;
        } else {
            username.setError(null);
            return true;
        }
    }

    //email validation
    private boolean validPassword() {
        String mail = password.getText().toString().trim();

        if (mail.isEmpty()) {
            password.setError("Password is Empty.");
            return false;
        }else {
            password.setError(null);
            return true;
        }

    }

    public void signin(View view) {
        String name = username.getText().toString().trim();
        String pass = password.getText().toString().trim();


        if (!validUsername() | !validPassword()) {
            return;
        }
        try {
            Boolean checkUsernamePasswordSupervisor=dataHandler.checkUsernamePasswordSupervisor(name,pass);
            if (checkUsernamePasswordSupervisor == true) {
                Toast.makeText(getApplicationContext(),"Logging Successfully",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SupervosorSignIn.this,SupervisorMain.class);
                startActivity(intent);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, username.getText().toString());
                editor.apply();
            } else {
                Toast.makeText(getApplicationContext(),"Logging Error",Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {

        }

    }
}