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

import com.example.wjcontractors.CustomAdapter.AttendanceCustomAdapter;
import com.example.wjcontractors.CustomAdapter.SalaryCustomAdapter;
import com.example.wjcontractors.DB.__DataB;

import java.util.ArrayList;

public class CalculateSalary extends AppCompatActivity {
    RecyclerView recyViewMas;


    __DataB Db;

    ArrayList<String> m_id, m_name,m_att;
    SalaryCustomAdapter attendanceCustomAdapter;
    ImageView m_empty;
    TextView m_no_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_salary);
        recyViewMas = findViewById(R.id.recyViewMas);
        m_empty = findViewById(R.id.m_empty);
        m_no_data = findViewById(R.id.m_no_data);



        Db = new __DataB(CalculateSalary.this);
        m_id = new ArrayList<>();
        m_name = new ArrayList<>();
        m_att = new ArrayList<>();


        storeMasonrydatainArrays();

        attendanceCustomAdapter = new SalaryCustomAdapter(CalculateSalary.this,this, m_id, m_name,m_att);
        recyViewMas.setAdapter(attendanceCustomAdapter);
        recyViewMas.setLayoutManager(new LinearLayoutManager(CalculateSalary.this));
    }
    void storeMasonrydatainArrays(){
        Cursor cursor = Db.AttendancereadAllData();
        if (cursor.getCount() == 0){
            m_empty.setVisibility(View.VISIBLE);
            m_no_data.setVisibility(View.VISIBLE);
        }else {
            while (cursor.moveToNext()){

                m_id.add(cursor.getString(0));
                m_name.add(cursor.getString(1));
                m_att.add(cursor.getString(2));

            }
            m_empty.setVisibility(View.GONE);
            m_no_data.setVisibility(View.GONE);
        }
    }
    public void calculate(View view){
        Intent intent=new Intent(CalculateSalary.this,CalculateSalaryType.class);
        startActivity(intent);
    }
}