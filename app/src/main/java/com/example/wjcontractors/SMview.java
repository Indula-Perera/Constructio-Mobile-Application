package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SMview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smview);
    }

    public void supervisor(View view) {
        Intent intent = new Intent(SMview.this, Sview.class);
        startActivity(intent);
    }


    public void masonry(View view) {
        Intent intent = new Intent(SMview.this, MView.class);
        startActivity(intent);

    }
}