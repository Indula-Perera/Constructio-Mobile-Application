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

public class SDeleteAct extends AppCompatActivity {
    EditText supervisor_name, supervisor_email, supervisor_password, supervisor_c_password;
    Button Updatebtn, Deletebtn;
    String id, name, email, password, cpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdelete2);
        supervisor_name = findViewById(R.id.PersonName2);
        supervisor_email = findViewById(R.id.s_email2);
        supervisor_password = findViewById(R.id.s_pass2);
        supervisor_c_password = findViewById(R.id.s_cpass2);
        Deletebtn = findViewById(R.id.s_delerte_btn);

        getIntentSupervisordata();

        Deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog ();

            }
        });
    }

    public void getIntentSupervisordata(){
        if (getIntent() .hasExtra("id") && getIntent() .hasExtra("name") && getIntent() .hasExtra("email") &&
                getIntent() .hasExtra("password") && getIntent() .hasExtra("cpassword")){
            // getting data from intent

            id = getIntent() .getStringExtra("id");
            name = getIntent() .getStringExtra("name");
            email = getIntent() .getStringExtra("email");
            password = getIntent() .getStringExtra("password");
            cpassword = getIntent() .getStringExtra("cpassword");

            // Setting intent Data

            supervisor_name.setText(name);
            supervisor_email.setText(email);
            supervisor_password.setText(password);
            supervisor_c_password.setText(cpassword);

        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }


    public void confirmDialog (){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                __DataB Db = new __DataB(SDeleteAct.this);
                Db.deleteSupervisorOneData(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create() .show();
    }
}