package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SMdelete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smdelete);
    }
    public void supervisor(View view) {
        Intent intent = new Intent(SMdelete.this, Sdelete.class);
        startActivity(intent);
    }


    public void masonry(View view) {
        Intent intent = new Intent(SMdelete.this, Mdelete.class);
        startActivity(intent);

    }
}