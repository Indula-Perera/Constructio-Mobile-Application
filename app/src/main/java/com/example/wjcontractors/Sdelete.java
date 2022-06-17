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

import com.example.wjcontractors.CustomAdapter.AddSupervisorCustomAdapter;
import com.example.wjcontractors.CustomAdapter.SupervisorDeleteCustomAdaptor;
import com.example.wjcontractors.DB.__DataB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Sdelete extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_btn;
    ImageView s_empty;
    TextView no_data;
    Button deleteaall;

    __DataB DB;

    ArrayList<String> s_id, s_name, s_email, s_password, s_c_password;
    SupervisorDeleteCustomAdaptor supervisorDeleteCustomAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdelete);
        recyclerView = findViewById(R.id.recyViewSupervisor);
        add_btn = findViewById(R.id.addSupervisorFloBtn);
        s_empty = findViewById(R.id.s_empty);
        no_data = findViewById(R.id.no_data);
        deleteaall=findViewById(R.id.DeleteAll);


        deleteaall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

        DB = new __DataB(Sdelete.this);
        s_id = new ArrayList<>();
        s_name = new ArrayList<>();
        s_email = new ArrayList<>();
        s_password = new ArrayList<>();
        s_c_password = new ArrayList<>();

        storeSupervisorDtatainArray();

        supervisorDeleteCustomAdaptor = new SupervisorDeleteCustomAdaptor(Sdelete.this, this, s_id, s_name, s_email, s_password, s_c_password);
        recyclerView.setAdapter(supervisorDeleteCustomAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(Sdelete.this));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    void storeSupervisorDtatainArray() {
        Cursor cursor = DB.readSupervisordata();
        if (cursor.getCount() == 0) {
            s_empty.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()) {
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

    public void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all Data ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                __DataB dbConnector = new __DataB(Sdelete.this);
                dbConnector.deleteSupervisorAll();
                //Refresh Activity
                Intent intent = new Intent(Sdelete.this, Sdelete.class);
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