package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdminMain extends AppCompatActivity {
    private TextView admin_user;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "my_pref";
    private static final String KEY_NAME = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        admin_user=findViewById(R.id.intent);


        //share_preference
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, null);
        if (name != null) {
            admin_user.setText(name + "!");
        }
    }


    public void addCSite (View view) {
        Intent intent = new Intent(AdminMain.this,AddCSite.class);
        startActivity(intent);
    }
    public void addSupervisor (View view) {
        Intent intent = new Intent(AdminMain.this,add_supervisor.class);
        startActivity(intent);
    }

    public void addMasonry (View view) {
        Intent intent = new Intent(AdminMain.this,AddMasonry.class);
        startActivity(intent);
    }

    public void viewdata (View view){
        Intent intent = new Intent(AdminMain.this, SMview.class);
        startActivity(intent);
    }
    public void deletedata (View view){
        Intent intent = new Intent(AdminMain.this, SMdelete.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }
    public void logout(View view){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        finish();
    }
}