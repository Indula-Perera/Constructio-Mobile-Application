package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wjcontractors.DB.AddSupervisor_db;
import com.example.wjcontractors.DB.DataHandler;

public class add_supervisor_act extends AppCompatActivity {

    EditText s_name, email, password, c_password;
    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supervisor2);

        s_name = findViewById(R.id.PersonName);
        email = findViewById(R.id.Address2);
        password = findViewById(R.id.Nic2);
        c_password = findViewById(R.id.Age2);


        dataHandler.openDB();

    }

    // S Name Validation

    private boolean validateSname() {
        String sname = s_name.getText().toString().trim();
        String vname = "^[A-Za-z]\\w{5,29}$";
        if (sname.isEmpty()) {
            s_name.setError("Name is Empty");
            return false;
        } else if (!sname.matches(vname)) {
            s_name.setError("Invalid Name.");
            return false;
        } else {
            s_name.setError(null);
            return true;
        }
    }

    // email Validation

    private boolean validateSemail() {
        String semail = email.getText().toString().trim();
        String vemail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        if (semail.isEmpty()) {
            email.setError("Email is Empty");
            return false;
        } else if (!semail.matches(vemail)) {
            email.setError("Invalid Email Address.");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }


    // Password Validation

    private boolean validateSpass() {
        String spass = password.getText().toString().trim();
        String cpass = c_password.getText().toString().trim();
        String vpassword = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        if (spass.isEmpty()) {
            password.setError("Password is Empty");
            return false;
        } else if (!spass.matches(vpassword)) {
            password.setError("Use Strong Password.");
            return false;
        } else if (!spass.matches(cpass)) {
            password.setError("Please Use same Password");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }


    private boolean validateSCpass() {
        String scpass = c_password.getText().toString().trim();
        String spass = password.getText().toString().trim();
        if (scpass.isEmpty()) {
            c_password.setError("Confirm Password is Empty");
            return false;
        } else if (!spass.matches(scpass)) {
            c_password.setError("Please Use same Password");
            return false;
        } else {
            c_password.setError(null);
            return true;
        }
    }

    public void addSvBtn(View view) {
        String sname = s_name.getText().toString().trim();
        String semail = email.getText().toString().trim();
        String spass = password.getText().toString().trim();
        String scpass = c_password.getText().toString().trim();

        if (!validateSname() | !validateSemail() | !validateSpass() | !validateSCpass()) {
            return;
        }
        if (!dataHandler.checkUsernameSupervisor(sname)) {
            AddSupervisor_db addSupervisorDb = new AddSupervisor_db(sname, semail, spass, scpass);
            try {
                dataHandler.add_supervisor(addSupervisorDb);
                Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Added Error", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Username Already Exsists", Toast.LENGTH_LONG).show();
        }
    }


}