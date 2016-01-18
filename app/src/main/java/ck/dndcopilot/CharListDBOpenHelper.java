package ck.dndcopilot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a contract for the SQLite database of Characters
 *
 * Created by Chris on 1/2/2016.
 */
public class CharListDBOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "characters";
    public static final String TABLE_NAME = "character_table";
    public static final String COL_CHAR_ID    = "_id";
    public static final String COL_CHAR_NAME  = "chname";
    public static final String COL_CHAR_LVL   = "chlvl";
    public static final String COL_DT_CREATED = "chcreate";
    public static final String COL_DT_USED    = "chused";
    public static final int COLN_CHAR_ID    = 0;
    public static final int COLN_CHAR_NAME  = 1;
    public static final int COLN_CHAR_LVL   = 2;
    public static final int COLN_DT_CREATED = 3;
    public static final int COLN_DT_USED    = 4;
    public static final String[] ALL_KEYS = new String[] {COL_CHAR_ID};
    private static final String TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    COL_CHAR_ID    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_CHAR_NAME  + " TEXT, " +
                    COL_CHAR_LVL   + " INTEGER, " +
                    COL_DT_CREATED + " INTEGER, " +
                    COL_DT_USED    + " INTEGER);";

    private SQLiteDatabase db;

    public CharListDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        db = this.getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public Cursor getAllRows() {
        Cursor c = db.rawQuery("select * from " + TABLE_NAME, null);
        if (c != null)
            c.moveToFirst();
        return c;
    }

    public boolean insertData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CHAR_NAME, name);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME, null);

    }

    public boolean updateData(String id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CHAR_ID, id);
        contentValues.put(COL_CHAR_NAME, name);
        db.update(TABLE_NAME, contentValues, COL_CHAR_ID + " = ?", new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_CHAR_ID + " = ?", new String[] {id});
    }

    public boolean deletePosition (int pos) {
        SQLiteDatabase db = this.getWritableDatabase();
        boolean worked = true;
        try {
            db.execSQL("delete from " + TABLE_NAME + " where " + COL_CHAR_ID +
                    " = (select " + COL_CHAR_ID + " from " + TABLE_NAME + " order by " + COL_CHAR_ID +
                    " limit 1 offset " + pos + ")");
        }catch (SQLException e){
            worked = false;
        }
        return worked;
    }

    public ArrayList<String> listChars() {
        ArrayList<String> charNames = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME, null);
        boolean isNext;
        if (c.moveToFirst()) {
            do {
                charNames.add(c.getString(COLN_CHAR_NAME));
                isNext = c.moveToNext();
            } while (isNext);
        }

        return charNames;
    }

    public boolean isEmpty() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME, null);
        return !c.moveToFirst();
    }
}
