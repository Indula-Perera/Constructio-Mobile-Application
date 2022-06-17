package com.example.wjcontractors.DB;

public class AddCsite_db {
    private String Name;
    private String Location;
    private String Supervisor_name;

    public AddCsite_db() {
        Name = "";
        Location = "";
        Supervisor_name = "";
    }

    public AddCsite_db(String name, String location, String supervisor_name) {
        Name = name;
        Location = location;
        Supervisor_name = supervisor_name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getSupervisor_name() {
        return Supervisor_name;
    }

    public void setSupervisor_name(String supervisor_name) {
        Supervisor_name = supervisor_name;
    }
}
