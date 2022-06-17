package com.example.wjcontractors.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class __DataB extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "WJConstruction.db";
    private static final int DATABASE_VERSION = 1;

    // construction site data table
    public static final String CONSTRUCTION_TABLE_NAME = "construction_site";
    public static final String SITE_ID = "site_id";
    public static final String SITE_NAME = "site_name";
    public static final String SITE_LOCATION = "site_location";
    public static final String SITE_SUPERVISOR = "site_supervisor";

    //Admininstrator
    public static final String ADMINISTRATOR_TABLE_NAME = "Admin";
    public static final String ADMINISTRATOR_id = "id";
    public static final String ADMINISTRATOR_name = "name";
    public static final String ADMINISTRATOR_email = "email";
    public static final String ADMINISTRATOR_password = "password";
    public static final String ADMINISTRATOR_cpassword = "cpassword";

    // Add Supervisor
    public static final String ADD_SUPERVISOR_TABLE_NAME = "add_supervisor";
    public static final String SUPERVISOR_ID = "supervisor_id";
    public static final String SUPERVISOR_NAME = "supervisor_name";
    public static final String SUPERVISOR_EMAIL = "supervisor_email";
    public static final String SUPERVISOR_PASSWORD = "supervisor_password";
    public static final String SUPERVISOR_CPASSWORD = "supervisor_cpassword";

    // Add Masonry

    public static final String ADD_MASONRY_TABLE_NAME = "Add_Masonry";
    public static final String MASONRY_ID = "masonry_id";
    public static final String MASONRY_NAME = "masonry_name";
    public static final String MASONRY_ADDRESS = "masonry_address";
    public static final String MASONRY_NIC = "masonry_nic";
    public static final String MASONRY_AGE = "masonry_age";
    public static final String MASONRY_SUPERVISOR_NAME = "masonry_supervisor_name";

    //Attendance
    public static final String ATTENDANCE_TABLE_NAME="Attendance";
    public static final String ATTENDANCE_ID="Id";
    public static final String ATTENDANCE_NAME="Name";
    public static final String ATTENDANCE_Date="Date";

    public __DataB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    // construction site
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + CONSTRUCTION_TABLE_NAME +
                " (" + SITE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SITE_NAME + " TEXT, " +
                SITE_LOCATION + " TEXT, " +
                SITE_SUPERVISOR + " TEXT);";

        // Admin

        String admin = "CREATE TABLE " + ADMINISTRATOR_TABLE_NAME +
                " (" + ADMINISTRATOR_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ADMINISTRATOR_name + " TEXT, " +
                ADMINISTRATOR_email + " TEXT, " +
                ADMINISTRATOR_password + " TEXT, " +
                ADMINISTRATOR_cpassword + " TEXT);";

        // Add Supervisor
        String add_supv = "CREATE TABLE " + ADD_SUPERVISOR_TABLE_NAME +
                " (" + SUPERVISOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SUPERVISOR_NAME + " TEXT, " +
                SUPERVISOR_EMAIL + " TEXT, " +
                SUPERVISOR_PASSWORD + " TEXT, " +
                SUPERVISOR_CPASSWORD + " TEXT);";

        // Add Masonry
        String add_masonry = "CREATE TABLE " + ADD_MASONRY_TABLE_NAME +
                " (" + MASONRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MASONRY_NAME + " TEXT, " +
                MASONRY_ADDRESS + " TEXT, " +
                MASONRY_NIC + " TEXT, " +
                MASONRY_AGE + " TEXT, " +
                MASONRY_SUPERVISOR_NAME + " TEXT);";

        // Add Attendance
        String attendance = "CREATE TABLE " + ATTENDANCE_TABLE_NAME +
                " (" + ATTENDANCE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ATTENDANCE_NAME + " TEXT, " +
                ATTENDANCE_Date + " TEXT);";

        db.execSQL(query);
        db.execSQL(admin);
        db.execSQL(add_supv);
        db.execSQL(add_masonry);
        db.execSQL(attendance);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + CONSTRUCTION_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ADMINISTRATOR_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ADD_SUPERVISOR_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ADD_MASONRY_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ATTENDANCE_TABLE_NAME);
        onCreate(db);
    }
    //read data in sites
    public Cursor readCSiteData(){
        String query = "SELECT * FROM " + CONSTRUCTION_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
    //read supervisor data
    public Cursor readSupervisordata(){
        String query = "SELECT * FROM " + ADD_SUPERVISOR_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    // read masonry data

    public Cursor readMasonrydata(){
        String query = "SELECT * FROM " + ADD_MASONRY_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    //update data supervisor

    public void updateSupervisorData (String row_id, String name, String email, String password, String cpassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SUPERVISOR_NAME, name);
        contentValues.put(SUPERVISOR_EMAIL, email);
        contentValues.put(SUPERVISOR_PASSWORD, password);
        contentValues.put(SUPERVISOR_CPASSWORD, cpassword);

        long result = db.update(ADD_SUPERVISOR_TABLE_NAME, contentValues, "supervisor_id=?", new String[]{row_id} );
        if (result == -1){
            Toast.makeText(context, "Failed to Update.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Update!", Toast.LENGTH_SHORT).show();
        }
    }

    //Delete data supervisor
    public void deleteSupervisorOneData (String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(ADD_SUPERVISOR_TABLE_NAME, "supervisor_id=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Delete!", Toast.LENGTH_SHORT).show();
        }

    }

    //update data masonry

    public void updateMasonryData (String row_id, String name, String address, String nic, String age, String ms_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MASONRY_NAME, name);
        contentValues.put(MASONRY_ADDRESS, address);
        contentValues.put(MASONRY_NIC, nic);
        contentValues.put(MASONRY_AGE, age);
        contentValues.put(MASONRY_SUPERVISOR_NAME, ms_name);

        long result = db.update(ADD_MASONRY_TABLE_NAME, contentValues, "masonry_id=?", new String[]{row_id} );
        if (result == -1){
            Toast.makeText(context, "Failed to Update.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Update!", Toast.LENGTH_SHORT).show();
        }
    }

    //delete data masonry

    public void deletemasonryrOneData (String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(ADD_MASONRY_TABLE_NAME, "masonry_id=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Delete!", Toast.LENGTH_SHORT).show();
        }

    }


    //Supervisor DeleteAll
    public void deleteSupervisorAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + ADD_SUPERVISOR_TABLE_NAME);
    }

    //Masonry DeleteAll
    public void deleteMasonryAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + ADD_MASONRY_TABLE_NAME);
    }

    //Masonry DeleteAll
    public void deleteAttendanceAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + ATTENDANCE_TABLE_NAME);
    }

    //Add Attendance Read Data
    public Cursor AttendancereadAllData() {
        String query = "SELECT * FROM " + ATTENDANCE_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
