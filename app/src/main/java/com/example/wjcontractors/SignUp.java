package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wjcontractors.DB.Admin;
import com.example.wjcontractors.DB.DataHandler;

public class SignUp extends AppCompatActivity {
    EditText et1, et2, et3, et4;
    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        et1 = (EditText) findViewById(R.id.name);
        et2 = (EditText) findViewById(R.id.email);
        et3 = (EditText) findViewById(R.id.password);
        et4 =(EditText)  findViewById(R.id.cpassword);

        //database
        dataHandler.openDB();

    }

    //name validation
    private boolean validUsername() {
        String fname = et1.getText().toString().trim();
        String vname = "^[A-Za-z]\\w{5,29}$";

        if (fname.isEmpty()) {
            et1.setError("Username is Empty.");
            return false;
        } else if (!fname.matches(vname)) {
            et1.setError("Invalid Name.");
            return false;
        } else {
            et1.setError(null);
            return true;
        }
    }

    //email validation
    private boolean validEmail() {
        String mail = et2.getText().toString().trim();
        String vemail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        if (mail.isEmpty()) {
            et2.setError("Email is Empty.");
            return false;
        } else if (!mail.matches(vemail)) {
            et2.setError("Invalid Email Address.");
            return false;
        } else {
            et2.setError(null);
            return true;
        }

    }

    //password validation
    private boolean validPassword() {
        String pass = et3.getText().toString().trim();
        String cpass = et4.getText().toString().trim();
        String vpassword = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        if (pass.isEmpty()) {
            et3.setError("Password is Empty.");
            return false;
        } else if (!pass.matches(vpassword)) {
            et3.setError("Use Strong Password.");
            return false;
        } else if (!pass.matches(cpass)) {
            et3.setError("Please Use same Password");
            return false;
        } else {
            et3.setError(null);
            return true;
        }

    }

    //confirm password validation
    private boolean validCPassword() {
        String cpass = et4.getText().toString().trim();
        String pass = et3.getText().toString().trim();

        if (cpass.isEmpty()) {
            et4.setError("Confirm Password is Empty.");
            return false;
        } else if (!pass.matches(cpass)) {
            et4.setError("Please Use same Password");
            return false;
        } else {
            et4.setError(null);
            return true;
        }

    }

    public void signup(View view) {
        String name = et1.getText().toString().trim();
        String emailaddress = et2.getText().toString().trim();
        String pass = et3.getText().toString().trim();
        String cpass = et4.getText().toString().trim();

        if (!validUsername() | !validEmail() | !validPassword() | !validCPassword()) {
            return;
        }
        if (!dataHandler.checkUsername(name)) {
            Admin admin = new Admin(name, emailaddress, pass, cpass);
            try {
                dataHandler.Admin_(admin);
                Toast.makeText(getApplicationContext(),"Create Successfully",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignUp.this,AdminSignIn.class);
                startActivity(intent);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(),"Username Already Exsists",Toast.LENGTH_LONG).show();
        }
    }
}