package com.example.wjcontractors.DB;

public class Masonry_db {
    private String Name;
    private String Address;
    private String Nic;
    private String Age;
    private String Supervisor_Name;

    public Masonry_db(String name, String address, String nic, String age, String supervisor_Name) {
        Name = name;
        Address = address;
        Nic = nic;
        Age = age;
        Supervisor_Name = supervisor_Name;
    }

    public Masonry_db() {
        Name = "";
        Address = "";
        Nic = "";
        Age = "";
        Supervisor_Name = "";
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNic() {
        return Nic;
    }

    public void setNic(String nic) {
        Nic = nic;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getSupervisor_Name() {
        return Supervisor_Name;
    }

    public void setSupervisor_Name(String supervisor_Name) {
        Supervisor_Name = supervisor_Name;
    }
}
