package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wjcontractors.DB.DataHandler;

public class CalculateSalaryType extends AppCompatActivity {
    EditText Masonry_name, MarkAttendance;
    DataHandler dataHandler = new DataHandler(this);
    String id, name,attendance;
    TextView cname, mname, mnametxt, day, daytxt, perday, perdaytxt, total, totaltxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_salary_type);
        Masonry_name = findViewById(R.id.MasonryName2);
        MarkAttendance = findViewById(R.id.Mark_Attendance);
        //getAndsetIntentMasonryData();

        dataHandler.openDB();

        cname=findViewById(R.id.companyname);
        mname=findViewById(R.id.name1);
        mnametxt=findViewById(R.id.nametxt);
        day=findViewById(R.id.day);
        daytxt=findViewById(R.id.daytxt);
        perday=findViewById(R.id.perday);
        perdaytxt=findViewById(R.id.perdaytxt);
        total=findViewById(R.id.total);
        totaltxt=findViewById(R.id.totaltxt);
    }
    //username empty
    private boolean validUsername() {
        String name = Masonry_name.getText().toString().trim();

        if (name.isEmpty()) {
            Masonry_name.setError("Username is Empty.");
            return false;
        } else {
            Masonry_name.setError(null);
            return true;
        }

    }

    //password empty
    private boolean validDays() {
        String days = MarkAttendance.getText().toString().trim();

        if (days.isEmpty()) {
            MarkAttendance.setError("Days are Empty.");
            return false;
        } else {
            MarkAttendance.setError(null);
            return true;
        }

    }
    /*public void getAndsetIntentMasonryData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name")  && getIntent().hasExtra("attendance")) {
            // getting data from intent

            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            attendance = getIntent().getStringExtra("attendance");

            // Setting intent Data

            Masonry_name.setText(name);
            MarkAttendance.setText(attendance);


        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }

    }*/

    public void calculate(View view){
        if (!validUsername() | !validDays()) {
            return;
        }
        String masonname = Masonry_name.getText().toString();
        String masonday = MarkAttendance.getText().toString();

        int salary = 3000;
        int days = Integer.parseInt(MarkAttendance.getText().toString());


        cname.setText("W J Construction");
        mname.setText("Name :");
        mnametxt.setText(masonname);
        day.setText("Days :");
        daytxt.setText(masonday);
        perday.setText("Per Day :");
        perdaytxt.setText("3000");
        total.setText("Total :");
        totaltxt.setText("" + days * salary);
    }
}