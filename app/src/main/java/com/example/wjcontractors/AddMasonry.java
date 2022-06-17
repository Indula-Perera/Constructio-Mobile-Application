package com.example.wjcontractors;

import androidx.annotation.Nullable;
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

import com.example.wjcontractors.CustomAdapter.MasonryCustomAdapter;
import com.example.wjcontractors.DB.__DataB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddMasonry extends AppCompatActivity {

    RecyclerView recyViewMas;


    __DataB Db;

    ArrayList<String> m_id, m_name, m_address, m_nic, m_age, ms_name;
    MasonryCustomAdapter masonryCustomAdapter;
    ImageView m_empty;
    TextView m_no_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_masonry);

        recyViewMas = findViewById(R.id.recyViewMas);
        m_empty = findViewById(R.id.m_empty);
        m_no_data = findViewById(R.id.m_no_data);


        Db = new __DataB(AddMasonry.this);
        m_id = new ArrayList<>();
        m_name = new ArrayList<>();
        m_address = new ArrayList<>();
        m_nic = new ArrayList<>();
        m_age = new ArrayList<>();
        ms_name = new ArrayList<>();

        storeMasonrydatainArrays();

        masonryCustomAdapter = new MasonryCustomAdapter(AddMasonry.this,this, m_id, m_name, m_address, m_nic, m_age, ms_name);
        recyViewMas.setAdapter(masonryCustomAdapter);
        recyViewMas.setLayoutManager(new LinearLayoutManager(AddMasonry.this));
    }

    public void addMasonry (View view) {
        Intent intent = new Intent(AddMasonry.this, AddMasonry_act.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            recreate();
        }
    }

    void storeMasonrydatainArrays(){
        Cursor cursor = Db.readMasonrydata();
        if (cursor.getCount() == 0){
           m_empty.setVisibility(View.VISIBLE);
            m_no_data.setVisibility(View.VISIBLE);
        }else {
            while (cursor.moveToNext()){

                m_id.add(cursor.getString(0));
                m_name.add(cursor.getString(1));
                m_address.add(cursor.getString(2));
                m_nic.add(cursor.getString(3));
                m_age.add(cursor.getString(4));
                ms_name.add(cursor.getString(5));
            }
            m_empty.setVisibility(View.GONE);
            m_no_data.setVisibility(View.GONE);
        }
    }



}