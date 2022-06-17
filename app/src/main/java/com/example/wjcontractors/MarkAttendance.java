package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wjcontractors.DB.Attendance;
import com.example.wjcontractors.DB.DataHandler;
import com.example.wjcontractors.DB.Masonry_db;

import java.util.Calendar;

public class MarkAttendance extends AppCompatActivity {
    EditText Masonry_name, MarkAttendance;
    DataHandler dataHandler = new DataHandler(this);
    String id, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);
        Masonry_name = findViewById(R.id.MasonryName2);
        MarkAttendance = findViewById(R.id.Mark_Attendance);
        getAndsetIntentMasonryData();

        dataHandler.openDB();
        //calender
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        MarkAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MarkAttendance.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        MarkAttendance.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }

        });
    }

    public void getAndsetIntentMasonryData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name")) {
            // getting data from intent

            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");

            // Setting intent Data

            Masonry_name.setText(name);


        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }

    }

    //Name validation
    private boolean validateName() {
        String masonryename = Masonry_name.getText().toString().trim();
        if (masonryename.isEmpty()) {
            Masonry_name.setError("Name is Empty");
            return false;
        } else {
            Masonry_name.setError(null);
            return true;
        }
    }

    // Address Validation

    private boolean validateMark() {
        String markattendance = MarkAttendance.getText().toString().trim();
        if (markattendance.isEmpty()) {
            MarkAttendance.setError("Attendance is Empty");
            return false;
        } else {
            MarkAttendance.setError(null);
            return true;
        }
    }

    public void markattendance(View view) {
        if (!validateName() | !validateMark()) {
            return;
        }
        String Mname = Masonry_name.getText().toString().trim();
        String markattendance = MarkAttendance.getText().toString().trim();
        //if (!dataHandler.checkAttendanceName(name)) {
            Attendance attendance = new Attendance(Mname, markattendance);
            try {
                dataHandler.Mark_Attendance(attendance);
                successDialog();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        //} else {
         //   nameAlreadyUsed();
        //}

    }

    private void nameAlreadyUsed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Error");
        alertDialogBuilder
                .setMessage(name + "'s Attendance Already Marked.")
                .setCancelable(false)
                .setPositiveButton("Try Again",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(MarkAttendance.this, com.example.wjcontractors.Attendance.class);
                                startActivity(intent);
                            }
                        });
        alertDialogBuilder.create().show();
    }

    private void successDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Successfully");
        alertDialogBuilder
                .setMessage(name + "'s Attendance Mark Successfully!")
                .setCancelable(false)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
        alertDialogBuilder.create().show();
    }
}