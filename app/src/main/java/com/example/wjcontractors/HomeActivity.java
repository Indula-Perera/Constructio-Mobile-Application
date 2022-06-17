package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void login(View view) {
        Intent intent = new Intent(HomeActivity.this, Login.class);
        startActivity(intent);
    }

    public void about(View view) {
        Intent intent = new Intent(HomeActivity.this, About.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }
}