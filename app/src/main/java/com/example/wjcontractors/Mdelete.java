package com.example.wjcontractors;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wjcontractors.CustomAdapter.MasonryCustomAdapter;
import com.example.wjcontractors.CustomAdapter.MasonryDeleteCusomAdapter;
import com.example.wjcontractors.DB.__DataB;

import java.util.ArrayList;

public class Mdelete extends AppCompatActivity {
    RecyclerView recyViewMas;


    __DataB Db;

    ArrayList<String> m_id, m_name, m_address, m_nic, m_age, ms_name;
    MasonryDeleteCusomAdapter masonryDeleteCusomAdapter;
    ImageView m_empty;
    TextView m_no_data;

    Button deleteaall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdelete);
        recyViewMas = findViewById(R.id.recyViewMas);
        m_empty = findViewById(R.id.m_empty);
        m_no_data = findViewById(R.id.m_no_data);
        deleteaall=findViewById(R.id.DeleteAll);

        deleteaall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });


        Db = new __DataB(Mdelete.this);
        m_id = new ArrayList<>();
        m_name = new ArrayList<>();
        m_address = new ArrayList<>();
        m_nic = new ArrayList<>();
        m_age = new ArrayList<>();
        ms_name = new ArrayList<>();

        storeMasonrydatainArrays();

        masonryDeleteCusomAdapter = new MasonryDeleteCusomAdapter(Mdelete.this, this, m_id, m_name, m_address, m_nic, m_age, ms_name);
        recyViewMas.setAdapter(masonryDeleteCusomAdapter);
        recyViewMas.setLayoutManager(new LinearLayoutManager(Mdelete.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    void storeMasonrydatainArrays() {
        Cursor cursor = Db.readMasonrydata();
        if (cursor.getCount() == 0) {
            m_empty.setVisibility(View.VISIBLE);
            m_no_data.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()) {

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

    public void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all Data ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                __DataB dbConnector = new __DataB(Mdelete.this);
                dbConnector.deleteMasonryAll();
                //Refresh Activity
                Intent intent = new Intent(Mdelete.this, Mdelete.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();

    }
}