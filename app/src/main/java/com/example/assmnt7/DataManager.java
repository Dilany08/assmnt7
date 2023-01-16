package com.example.assmnt7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.Cursor;

public class DataManager {

        private SQLiteDatabase db;

    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_FNAME = "fname";
    public static final String TABLE_ROW_SECTION = "section";
    public static final String TABLE_ROW_COURSE = "course";
    public static final String TABLE_ROW_MIDTERM = "midterm";
    public static final String TABLE_ROW_FINALS = "finals";

    private static final String DB_NAME = "student_info_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_STUDENT = "student_data";

    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context){
            super(context, DB_NAME, null, DB_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String newTableQueryString = "create table "
                    + TABLE_STUDENT + " ("
                    + TABLE_ROW_ID
                    + " text primary key not null,"
                    + TABLE_ROW_FNAME
                    + " text not null,"
                    + TABLE_ROW_SECTION
                    + " text not null,"
                    + TABLE_ROW_COURSE
                    + " text not null,"
                    + TABLE_ROW_MIDTERM
                    + " integer not null,"
                    + TABLE_ROW_FINALS
                    + " integer not null);";
            db.execSQL(newTableQueryString);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
    public DataManager(Context context) {
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insert(String _id, String name, String section, String course, String midterm, String finals){
        String query = "INSERT INTO " + TABLE_STUDENT + " (" +
                TABLE_ROW_ID + ", " +
                TABLE_ROW_FNAME + ", " +
                TABLE_ROW_SECTION + ", " +
                TABLE_ROW_COURSE + ", " +
                TABLE_ROW_MIDTERM + ", " +
                TABLE_ROW_FINALS + ") " +
                "VALUES (" +
                "'" + _id + "'" + ", " +
                "'" + name + "'" + ", " +
                "'" + section + "'" + ", " +
                "'" + course + "'" + ", " +
                "'" + midterm + "'" + ", " +
                "'" + finals + "'" +
                ")";
        Log.i("insert() = ", query);
        db.execSQL(query);
    }
            public Cursor searchAll() {
            Cursor c = db.rawQuery("SELECT *" + " from " +
                    TABLE_STUDENT, null);
            return c;
            }
            public String showData(Cursor c) {
                AppData myData = new AppData();
                while (c.moveToNext()) {
                    Log.i(c.getString(1), c.getString(2));
                    myData.setData(c.getString(0), c.getString(1),
                            c.getString(2) , c.getString(3), c.getString(4), c.getString(5));
                }
                return myData.getData();
            }
            public AppData editId(Cursor c) {
                AppData myData = new AppData();
                while (c.moveToNext()) {
                    myData.setId(c.getString(0));
                    myData.setFNAME((c.getString(1)));
                    myData.setCourse(c.getString(2));
                    myData.setSection(c.getString(3));
                    myData.setMidterm(c.getString(4));
                    myData.setFinals(c.getString(5));
                }
                return myData;
            }

        public void update(String _id, String fname, String course, String section, String midterm, String finals){
                    String query = "UPDATE " + TABLE_STUDENT + "SET " +
                            TABLE_ROW_FNAME + " = " +"'" + fname + "'" +
                            ", " + "SET " + TABLE_ROW_COURSE + "=" + "'" + course + "'" + ", " +
                             TABLE_ROW_SECTION + "=" + "'" + section + "'" + ", " +
                              TABLE_ROW_MIDTERM + "=" + "'" + midterm + "'" + ", " +
                             TABLE_ROW_FINALS + "=" + "'" + finals + "'" +
                            "WHERE " + TABLE_ROW_ID + " = " + "'" + _id + "'";
                            Log.i("update() = ",query);
                            db.execSQL(query);
        }
        public void delete(String _id) {
                String query = "DELETE FROM" + TABLE_STUDENT +
                        "WHERE" + TABLE_ROW_ID +
                        " = '" + _id + "';";
                Log.i("delete() = ", query);
                db.execSQL(query);
        }
    }

