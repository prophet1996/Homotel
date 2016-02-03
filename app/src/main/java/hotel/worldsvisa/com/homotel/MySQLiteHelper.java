package hotel.worldsvisa.com.homotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PROPHET on 01-02-2016.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static String TAG = "tag";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "databse";
    //TABLE NAME
    private static final String TABLE_NAME = "table";
    //TABLE table column names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_DATE = "date";
    private static final String KEY_NOP = "persons";
    private static final String KEY_TIME = "time";


    private static final String CREATE_TABLE_TABLE = "CREATE TABLE "
            + TABLE_NAME + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
            + KEY_EMAIL + " TEXT,"
            + KEY_NOP + " TEXT,"
            + KEY_DATE + " TEXT,"

            + KEY_TIME
            + " TEXT );";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXIST table"); /*            
            Drop older books table if existed*/
        onCreate(db);
    }

    public long addtable(table table) {
        //for logging
        Log.d("adding table", table.toString());
//to get reference to the writable db
        SQLiteDatabase db = this.getWritableDatabase();
        // craete content valuse to add key column values
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, table.db_name);
        values.put(KEY_EMAIL, table.db_email);
        values.put(KEY_DATE, table.db_date);
        values.put(KEY_NOP, table.db_nop);
        values.put(KEY_TIME, table.db_time);
        values.put(KEY_ID, table.id);

        // 3. insert
        Long insert = db.insert(TABLE_NAME, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        return insert;

    }


    public int updateEntry(table table) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, table.db_name);
        values.put(KEY_EMAIL, table.db_email);
        values.put(KEY_DATE, table.db_date);
        values.put(KEY_TIME, table.db_time);
        values.put(KEY_NOP, table.db_nop);
        values.put(KEY_ID, table.id);
        return db.update(TABLE_NAME, values, KEY_ID + " =?", new String[]{String.valueOf(table.id)});


    }

    public void delete(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " =?", new String[]{String.valueOf(id)});

    }

    public List<table> getAllCustomers() {
        List<table> customersArrayList = new ArrayList<table>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        Log.d(TAG, selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                table table = new table();

                table.id = c.getInt(c.getColumnIndex(KEY_ID));
                table.db_name = c.getString(c.getColumnIndex(KEY_NAME));
                table.db_email = c.getString(c.getColumnIndex(KEY_EMAIL));
                table.db_nop = c.getString(c.getColumnIndex(KEY_NOP));
                table.db_date = c.getString(c.getColumnIndex(KEY_DATE));
                table.db_time = c.getString(c.getColumnIndex(KEY_TIME));


                // adding to customers list
                customersArrayList.add(table);
            } while (c.moveToNext());
        }
        return customersArrayList;
    }

    public void getCustomer() {


    }
}
