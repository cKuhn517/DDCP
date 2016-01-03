package ck.dndcopilot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Create a contract for the SQLite database of Characters
 *
 * Created by Chris on 1/2/2016.
 */
public class CharListDBOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "characters";
    private static final String TABLE_NAME = "character_table";
    private static final String COL_CHAR_ID    = "chid";
    private static final String COL_CHAR_NAME  = "chname";
    private static final String COL_CHAR_LVL   = "chlvl";
    private static final String COL_DT_CREATED = "chcreate";
    private static final String COL_DT_USED    = "chused";
    private static final String TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    COL_CHAR_ID    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_CHAR_NAME  + " TEXT, " +
                    COL_CHAR_LVL   + " INTEGER, " +
                    COL_DT_CREATED + " INTEGER, " +
                    COL_DT_USED    + " INTEGER);";

    public CharListDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

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
}
