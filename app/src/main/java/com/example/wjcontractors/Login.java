package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void admin (View view){
        Intent intent = new Intent(Login.this,AdminSignIn.class);
        startActivity(intent);
    }

    public void supervisor (View view){
        Intent intent = new Intent(Login.this,SupervosorSignIn.class);
        startActivity(intent);
    }

    public void home (View view){
        Intent intent = new Intent(Login.this,HomeActivity.class);
        startActivity(intent);
    }
    public void about (View view){
        Intent intent = new Intent(Login.this,About.class);
        startActivity(intent);
    }
}
