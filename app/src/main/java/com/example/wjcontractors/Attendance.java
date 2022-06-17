package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wjcontractors.CustomAdapter.AttendanceCustomAdapter;
import com.example.wjcontractors.CustomAdapter.MasonryCustomAdapter;
import com.example.wjcontractors.DB.__DataB;

import java.util.ArrayList;

public class Attendance extends AppCompatActivity {
    RecyclerView recyViewMas;


    __DataB Db;

    ArrayList<String> m_id, m_name;
    AttendanceCustomAdapter attendanceCustomAdapter;
    ImageView m_empty;
    TextView m_no_data;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        recyViewMas = findViewById(R.id.recyViewMas);
        m_empty = findViewById(R.id.m_empty);
        m_no_data = findViewById(R.id.m_no_data);
        clear=findViewById(R.id.clearAttendance);


        Db = new __DataB(Attendance.this);
        m_id = new ArrayList<>();
        m_name = new ArrayList<>();


        storeMasonrydatainArrays();

        attendanceCustomAdapter = new AttendanceCustomAdapter(Attendance.this,this, m_id, m_name);
        recyViewMas.setAdapter(attendanceCustomAdapter);
        recyViewMas.setLayoutManager(new LinearLayoutManager(Attendance.this));



        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDeleteDialog();
            }
        });
    }

    void confirmDeleteDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Delete All?");
        alertDialogBuilder
                .setMessage("Are you sure you want to delete all Data ?")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int i) {
                                __DataB dbConnector = new __DataB(Attendance.this);
                                dbConnector.deleteAttendanceAll();
                                //Refresh Activity
                                Intent intent = new Intent(Attendance.this, Attendance.class);
                                startActivity(intent);
                                finish();
                            }
                        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.create().show();


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

            }
            m_empty.setVisibility(View.GONE);
            m_no_data.setVisibility(View.GONE);
        }
    }
}