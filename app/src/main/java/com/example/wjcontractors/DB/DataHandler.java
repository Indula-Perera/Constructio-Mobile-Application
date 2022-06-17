package com.example.wjcontractors.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wjcontractors.AddCSite;

public class DataHandler {
    private Context con;
    private __DataB dbCon;
    private SQLiteDatabase db;
    private int result;

    public DataHandler(Context con) {
        this.con = con;
    }

    public void openDB() {
        this.dbCon = new __DataB(con);
        this.db = dbCon.getWritableDatabase();
    }

    //Admin
    public void Admin_(Admin admin) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(__DataB.ADMINISTRATOR_name, admin.getFull_Name());
        contentValues.put(__DataB.ADMINISTRATOR_email, admin.getEmail());
        contentValues.put(__DataB.ADMINISTRATOR_password, admin.getPassword());
        contentValues.put(__DataB.ADMINISTRATOR_cpassword, admin.getConfirm_Password());
        db.insert(__DataB.ADMINISTRATOR_TABLE_NAME, null, contentValues);
    }

    //Add Site
    public void Add_Site(AddCsite_db addCsite_db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(__DataB.SITE_NAME,addCsite_db.getName());
        contentValues.put(__DataB.SITE_LOCATION,addCsite_db.getLocation());
        contentValues.put(__DataB.SITE_SUPERVISOR,addCsite_db.getSupervisor_name());
        db.insert(__DataB.CONSTRUCTION_TABLE_NAME, null, contentValues);
    }

    // Add supervisor

    public void add_supervisor(AddSupervisor_db supervisor_db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(__DataB.SUPERVISOR_NAME, supervisor_db.getName());
        contentValues.put(__DataB.SUPERVISOR_EMAIL, supervisor_db.getEmail());
        contentValues.put(__DataB.SUPERVISOR_PASSWORD, supervisor_db.getPassword());
        contentValues.put(__DataB.SUPERVISOR_CPASSWORD, supervisor_db.getConfirm_password());
        db.insert(__DataB.ADD_SUPERVISOR_TABLE_NAME, null, contentValues);
    }

    // Add Masonry
    public void Add_masonry(Masonry_db masonry_db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(__DataB.MASONRY_NAME, masonry_db.getName());
        contentValues.put(__DataB.MASONRY_ADDRESS, masonry_db.getAddress());
        contentValues.put(__DataB.MASONRY_NIC, masonry_db.getNic());
        contentValues.put(__DataB.MASONRY_AGE, masonry_db.getAge());
        contentValues.put(__DataB.MASONRY_SUPERVISOR_NAME, masonry_db.getSupervisor_Name());
        db.insert(__DataB.ADD_MASONRY_TABLE_NAME, null, contentValues);
    }

    // Add Attendance
    public void Mark_Attendance(Attendance attendance) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(__DataB.ATTENDANCE_NAME, attendance.getName());
        contentValues.put(__DataB.ATTENDANCE_Date, attendance.getAttendance());
        db.insert(__DataB.ATTENDANCE_TABLE_NAME, null, contentValues);
    }

    //Check Username already Used Administrator
    public boolean checkUsername(String name) {
        Cursor cursor = db.rawQuery("SELECT * FROM " + __DataB.ADMINISTRATOR_TABLE_NAME + " WHERE name= '" + name + "'", null);
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }

    //Check Username already Used Attendance
    public boolean checkAttendanceName(String name) {
        Cursor cursor = db.rawQuery("SELECT * FROM " + __DataB.ATTENDANCE_TABLE_NAME + " WHERE Name= '" + name + "'", null);
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }

    //Check Sign In Record Database Admin
    public boolean checkUsernamePassword(String name, String pass) {
        Cursor cursor = db.rawQuery("SELECT * FROM " + __DataB.ADMINISTRATOR_TABLE_NAME + " WHERE name=? and password=?", new String[]{name, pass});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    //Check Username already Used Supervisor
    public boolean checkUsernameSupervisor(String name) {
        Cursor cursor = db.rawQuery("SELECT * FROM " + __DataB.ADD_SUPERVISOR_TABLE_NAME + " WHERE supervisor_name= '" + name + "'", null);
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }

    //Check Sign In Record Database Admin
    public boolean checkUsernamePasswordSupervisor(String name, String pass) {
        Cursor cursor = db.rawQuery("SELECT * FROM " + __DataB.ADD_SUPERVISOR_TABLE_NAME + " WHERE supervisor_name=? and supervisor_password=?", new String[]{name, pass});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }



}
