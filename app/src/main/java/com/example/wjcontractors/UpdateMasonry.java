package com.example.wjcontractors;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wjcontractors.DB.__DataB;

public class UpdateMasonry extends AppCompatActivity {
    EditText masonry_name, masonry_address, masonry_nic, masonry_age, masonry_S_name;
    Button Updatebtn, deletebtn;

    String id, name, address, nic, age, ms_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_masonry);

        masonry_name = findViewById(R.id.MasonryName2);
        masonry_address = findViewById(R.id.Address2);
        masonry_nic = findViewById(R.id.Nic2);
        masonry_age = findViewById(R.id.Age2);
        masonry_S_name = findViewById(R.id.MS_name2);
        Updatebtn = findViewById(R.id.M_update2);
        deletebtn = findViewById(R.id.M_delete);

        getAndsetIntentMasonryData();

        Updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                __DataB DB = new __DataB(UpdateMasonry.this);
                name = masonry_name.getText().toString().trim();
                address = masonry_address.getText().toString().trim();
                nic = masonry_nic.getText().toString().trim();
                age = masonry_age.getText().toString().trim();
                ms_name = masonry_S_name.getText().toString().trim();
                DB.updateMasonryData(id, name, address, nic, age, ms_name);
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });


    }

    public void getAndsetIntentMasonryData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("address") &&
                getIntent().hasExtra("nic") && getIntent().hasExtra("age") && getIntent().hasExtra("msname")) {
            // getting data from intent

            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            address = getIntent().getStringExtra("address");
            nic = getIntent().getStringExtra("nic");
            age = getIntent().getStringExtra("age");
            ms_name = getIntent().getStringExtra("msname");

            // Setting intent Data

            masonry_name.setText(name);
            masonry_address.setText(address);
            masonry_nic.setText(nic);
            masonry_age.setText(age);
            masonry_S_name.setText(ms_name);


        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }

    }

    public void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                __DataB db = new __DataB(UpdateMasonry.this);
                db.deletemasonryrOneData(id);
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