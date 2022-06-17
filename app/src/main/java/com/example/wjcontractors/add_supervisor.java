package com.example.wjcontractors;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wjcontractors.CustomAdapter.AddSupervisorCustomAdapter;
import com.example.wjcontractors.CustomAdapter.CSiteCustomAdapter;
import com.example.wjcontractors.DB.__DataB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class add_supervisor extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_btn;
    ImageView s_empty;
    TextView no_data;

    __DataB DB;

    ArrayList<String> s_id, s_name, s_email, s_password, s_c_password;
    AddSupervisorCustomAdapter addSupervisorCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supervisor);

        recyclerView = findViewById(R.id.recyViewSupervisor);
        add_btn = findViewById(R.id.addSupervisorFloBtn);
        s_empty = findViewById(R.id.s_empty);
        no_data = findViewById(R.id.no_data);

        DB = new __DataB(add_supervisor.this);
        s_id = new ArrayList<>();
        s_name = new ArrayList<>();
        s_email = new ArrayList<>();
        s_password = new ArrayList<>();
        s_c_password = new ArrayList<>();

        storeSupervisorDtatainArray();

        addSupervisorCustomAdapter = new AddSupervisorCustomAdapter(add_supervisor.this, this, s_id, s_name, s_email, s_password,s_c_password);
        recyclerView.setAdapter(addSupervisorCustomAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(add_supervisor.this));

    }
    public void add_sup (View view){
        Intent intent = new Intent(add_supervisor.this,add_supervisor_act.class);
        startActivity(intent);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            recreate();
        }
    }

    void storeSupervisorDtatainArray(){
        Cursor cursor = DB.readSupervisordata();
        if (cursor.getCount() == 0){
           s_empty.setVisibility(View.VISIBLE);
           no_data.setVisibility(View.VISIBLE);
        }else {
            while (cursor.moveToNext()){
                s_id.add(cursor.getString(0));
                s_name.add(cursor.getString(1));
                s_email.add(cursor.getString(2));
                s_password.add(cursor.getString(3));
                s_c_password.add(cursor.getString(4));
            }
            s_empty.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }


}