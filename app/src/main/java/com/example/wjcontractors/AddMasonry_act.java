package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wjcontractors.DB.DataHandler;
import com.example.wjcontractors.DB.Masonry_db;

public class AddMasonry_act extends AppCompatActivity {

    EditText Masonry_name, address, nic, age, Ms_name;
    DataHandler dataHandler = new DataHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_masonry2);

        Masonry_name = findViewById(R.id.MasonryName2);
        address = findViewById(R.id.Address2);
        nic = findViewById(R.id.Nic2);
        age = findViewById(R.id.Age2);
        Ms_name = findViewById(R.id.MS_name2);

        dataHandler.openDB();

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

    private boolean validateAddress() {
        String masonryeaddress = address.getText().toString().trim();
        if (masonryeaddress.isEmpty()) {
            address.setError("Address is Empty");
            return false;
        } else {
            address.setError(null);
            return true;
        }
    }

    // Nic Validation
    private boolean validateNic() {
        String Mnic = nic.getText().toString().trim();
        if (Mnic.isEmpty()) {
            nic.setError("Nic is Empty");
            return false;
        } else {
            nic.setError(null);
            return true;
        }
    }
    // Age Validation
    private boolean validateAge() {
        String Mage = age.getText().toString().trim();
        if (Mage.isEmpty()) {
            age.setError("Age is Empty");
            return false;
        } else {
            age.setError(null);
            return true;
        }
    }
    // MSupervisor Validation
    private boolean validateMSname() {
        String MSname = Ms_name.getText().toString().trim();
        if (MSname.isEmpty()) {
            Ms_name.setError("MS Name is Empty");
            return false;
        } else {
            Ms_name.setError(null);
            return true;
        }
    }

    public void addMbtn (View view){
        String masonryename = Masonry_name.getText().toString().trim();
        String masonryeaddress = address.getText().toString().trim();
        String Mnic = nic.getText().toString().trim();
        String Mage = age.getText().toString().trim();
        String MSname = Ms_name.getText().toString().trim();

        if ( !validateName() | !validateAddress() | !validateNic() | !validateAge() | !validateMSname()){
            return;
        }
        Masonry_db masonry_db = new Masonry_db(masonryename,masonryeaddress,Mnic,Mage,MSname);
        try {
            dataHandler.Add_masonry(masonry_db);
            Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Added Error", Toast.LENGTH_SHORT).show();
        }
    }


}