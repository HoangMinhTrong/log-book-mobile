package com.example.picture.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.picture.DbBitmapUtility;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context _context;
    protected static final String DATABASE_NAME = "Picture";
    protected static final int DATABASE_VERSION = 1;

    // TABLE PIC
    protected static final String TABLE_NAME = "picture";
    protected static final String COLUMN_ID = "id";
    protected static final String COLUMN_IMG = "url_img";


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        _context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Script to create table.
        String script = "CREATE TABLE "
                + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_IMG + " TEXT)";

        // Execute script.
        sqLiteDatabase.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop table
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Recreate
        onCreate(sqLiteDatabase);
    }
    public void addImage( String image) throws SQLiteException {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_IMG, image);
        db.insert( TABLE_NAME, null, cv );
    }
    public Cursor getAll(){
        String query = "select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
