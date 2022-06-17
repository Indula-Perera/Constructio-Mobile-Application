package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wjcontractors.CustomAdapter.CSiteCustomAdapter;
import com.example.wjcontractors.DB.__DataB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddCSite extends AppCompatActivity {

    RecyclerView recyView;
    FloatingActionButton addButton;
    ImageView c_empty;
    TextView c_no_data;

    __DataB DB;

    ArrayList<String> c_site_id, c_site_name, c_site_location, c_site_supervisor;
    CSiteCustomAdapter cSiteCustomAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_csite);

        recyView = findViewById(R.id.recyView);
        addButton = findViewById(R.id.addButton);
        c_empty = findViewById(R.id.c_empty);
        c_no_data = findViewById(R.id.c_no_data);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddCSite.this, AddCSiteType.class);
                startActivity(intent);
            }
        });

        DB = new __DataB(AddCSite.this);
        c_site_id = new ArrayList<>();
        c_site_name = new ArrayList<>();
        c_site_location = new ArrayList<>();
        c_site_supervisor = new ArrayList<>();

        storeCSiteDtatainArray();

        cSiteCustomAdapter = new CSiteCustomAdapter(AddCSite.this, c_site_id, c_site_name, c_site_location, c_site_supervisor);
        recyView.setAdapter(cSiteCustomAdapter);
        recyView.setLayoutManager(new LinearLayoutManager(AddCSite.this));


    }


    void storeCSiteDtatainArray(){
        Cursor cursor = DB.readCSiteData();
        if (cursor.getCount() == 0){
            c_empty.setVisibility(View.VISIBLE);
           c_no_data.setVisibility(View.VISIBLE);
        }else {
            while (cursor.moveToNext()){
                c_site_id.add(cursor.getString(0));
                c_site_name.add(cursor.getString(1));
                c_site_location.add(cursor.getString(2));
                c_site_supervisor.add(cursor.getString(3));
            }
            c_empty.setVisibility(View.GONE);
            c_no_data.setVisibility(View.GONE);
        }
    }

}