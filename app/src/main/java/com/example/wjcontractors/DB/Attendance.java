package com.example.wjcontractors.DB;

public class Attendance {
    private String Name;
    private String Attendance;

    public Attendance(String name, String attendance) {
        Name = name;
        Attendance = attendance;
    }

    public Attendance() {
        Name = "";
        Attendance = "";
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAttendance() {
        return Attendance;
    }

    public void setAttendance(String attendance) {
        Attendance = attendance;
    }
}
