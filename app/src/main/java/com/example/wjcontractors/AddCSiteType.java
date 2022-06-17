package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wjcontractors.DB.AddCsite_db;
import com.example.wjcontractors.DB.DataHandler;

public class AddCSiteType extends AppCompatActivity {
    EditText name, location, Sname;
    DataHandler dataHandler =new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_csite_type);

        name = findViewById(R.id.editTextTextPersonName);
        location = findViewById(R.id.location);
        Sname = findViewById(R.id.supervisor);

        dataHandler.openDB();

    }

    //Name validate
    private boolean validateName() {
        String sitename = name.getText().toString().trim();
        if (sitename.isEmpty()) {
            name.setError("Name is Empty");
            return false;
        } else {
            name.setError(null);
            return true;
        }
    }

    //Locaton Validattion

    private boolean validateLocation() {
        String sitelocation = location.getText().toString().trim();
        if (sitelocation.isEmpty()) {
            location.setError("Location is Empty");
            return false;
        } else {
            location.setError(null);
            return true;
        }
    }

    // Supervisor validation

    private boolean validateSupervisor() {
        String sitesupervisor = Sname.getText().toString().trim();
        if (sitesupervisor.isEmpty()) {
            Sname.setError("Supervisor Name is Empty");
            return false;
        } else {
            Sname.setError(null);
            return true;
        }
    }

    public void addSbtn(View view) {
        String sitename = name.getText().toString().trim();
        String sitelocation = location.getText().toString().trim();
        String sitesupervisor = Sname.getText().toString().trim();

        if (!validateName() | !validateLocation() | !validateSupervisor()){
            return;
        }
        AddCsite_db addCsite_db=new AddCsite_db(sitename,sitelocation,sitesupervisor);
        try{
            dataHandler.Add_Site(addCsite_db);
            Toast.makeText(getApplicationContext(),"Added Successfully",Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Added Error",Toast.LENGTH_SHORT).show();
        }
    }


}