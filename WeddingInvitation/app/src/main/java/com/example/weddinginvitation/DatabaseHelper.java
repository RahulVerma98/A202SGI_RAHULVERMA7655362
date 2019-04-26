package com.example.weddinginvitation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Using SQLite command we create the variables that will be stored into the table
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String  DATABASE_NAME = "functionInformation.db"; //name of the database
    public static final String  TABLE_NAME = "functionInformation_table"; // table name
    public static final String  COL1 = "ID"; // column names
    public static final String  COL2 = "NAME1";
    public static final String  COL3 = "NAME2";
    public static final String  COL4 = "FUNCTION";
    public static final String  COL5 = "LOCATION";
    public static final String  COL6 = "TIME";
    public static final String  COL7 = "DATE";





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // String interpolation is used to for the SQL command that Creates the table
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + // Autoincrement adds 1 to the new id
                "NAME1 TEXT, NAME2 TEXT, FUNCTION TEXT, LOCATION TEXT, TIME TEXT, DATE TEXT)" ;
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS  " + TABLE_NAME ); // SQL command that only lets us proceed forward if table exists.
        onCreate(db);

    }

    public boolean addData(String name1, String name2, String function, String location, String time, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // Variables being stored into the columns
        contentValues.put(COL2,name1);
        contentValues.put(COL3,name2);
        contentValues.put(COL4,function);
        contentValues.put(COL5,location);
        contentValues.put(COL6,time);
        contentValues.put(COL7,date);


        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor viewData(){ // data stored in db can be viewed with this method
        SQLiteDatabase db = this.getReadableDatabase();
        String viewTable = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(viewTable, null);

        return cursor;
    }
}
