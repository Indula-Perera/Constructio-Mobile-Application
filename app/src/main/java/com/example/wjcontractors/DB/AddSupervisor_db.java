package com.example.wjcontractors.DB;

public class AddSupervisor_db {
    private String Name;
    private String Email;
    private String Password;
    private String Confirm_password;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirm_password() {
        return Confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        Confirm_password = confirm_password;
    }

    public AddSupervisor_db(String full_Name, String email, String password, String confirm_Password) {

        Name = full_Name;
        Email = email;
        Password = password;
        Confirm_password = confirm_Password;
    }

    public AddSupervisor_db() {
        Name = "";
        Email = "";
        Password = "";
        Confirm_password = "";
    }
}
