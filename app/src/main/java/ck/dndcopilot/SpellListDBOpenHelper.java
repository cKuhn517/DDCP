package ck.dndcopilot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

/**
 * Created by Chris on 1/14/2016.
 */
public class SpellListDBOpenHelper extends SQLiteAssetHelper{

    private static final String TAG = "SpellListDBOpenHelper";

    public static final String K_SM_ID = "_id";
    public static final String K_SM_BRD = "Brd";
    public static final String K_SM_CLR = "Clr";
    public static final String K_SM_DRD = "Drd";
    public static final String K_SM_PAL = "Pal";
    public static final String K_SM_RGR = "Rgr";
    public static final String K_SM_WIZ = "Wiz";
    public static final String K_SM_KNOWN = "knw";
    public static final String K_SM_MEMORIZED = "mem";
    public static final String K_SM_CAST = "cst";
    public static final String K_SM_SCROLL = "scroll";
    public static final String K_SM_ITEM = "item";
    public static final String K_SM_ITEMNAME = "itemnm";
    public static final String K_SM_TOTAL = "tot";
    public static final String K_SM_SPELLNAME = "Spell Name";
    public static final String K_SM_EFFECT = "Effect";
    public static final String K_SM_COMP = "Comp";
    public static final String K_SM_TIME = "Time";
    public static final String K_SM_RANGE = "Range";
    public static final String K_SM_DURATION = "Duration";
    public static final String K_SM_SAVE = "Save";
    public static final String K_SM_SR = "SR";
    public static final int C_SM_ID = 0;
    public static final int C_SM_BRD = 1;
    public static final int C_SM_CLR = 2;
    public static final int C_SM_DRD = 3;
    public static final int C_SM_PAL = 4;
    public static final int C_SM_RGR = 5;
    public static final int C_SM_WIZ = 6;
    public static final int C_SM_KNOWN = 7;
    public static final int C_SM_MEMORIZED = 8;
    public static final int C_SM_CAST = 9;
    public static final int C_SM_SCROLL = 10;
    public static final int C_SM_ITEM = 11;
    public static final int C_SM_ITEMNAME = 12;
    public static final int C_SM_TOTAL = 13;
    public static final int C_SM_SPELLNAME = 14;
    public static final int C_SM_EFFECT = 15;
    public static final int C_SM_COMP = 16;
    public static final int C_SM_TIME = 17;
    public static final int C_SM_RANGE = 18;
    public static final int C_SM_DURATION = 19;
    public static final int C_SM_SAVE = 20;
    public static final int C_SM_SR = 21;

    public static final String[] ALL_KEYS = new String[] {K_SM_ID};

    String DATABASE_PATH = "/data/data/ck.dndcopilot/databases/";
    public static String DATABASE_NAME;
    public static final String DATABASE_TABLE = "spellmaster";
    public static final int DATABASE_VERSION = 1;

    private SQLiteDatabase myDB;

    public SpellListDBOpenHelper(Context ctx, String dbName) {
        super(ctx, dbName, null, DATABASE_VERSION);
        DATABASE_NAME = dbName;
    }

    public boolean learnSpell(long rowID) {
        String where = K_SM_ID + "=" + rowID;
        ContentValues newValues = new ContentValues();
        newValues.put(K_SM_KNOWN, 1);
        return myDB.update(DATABASE_TABLE, newValues, where, null) != 0;
    }

    public boolean memSpell(long rowID, int cnt) {
        String where = K_SM_ID + "=" + rowID;
        ContentValues newValues = new ContentValues();
        newValues.put(K_SM_MEMORIZED, cnt);
        return myDB.update(DATABASE_TABLE, newValues, where, null) != 0;
    }

    public boolean castSpell(long rowID) {
        String where = K_SM_ID + "=" + rowID;
        Cursor c = myDB.query(true, DATABASE_TABLE, ALL_KEYS, where, null, null, null, null, null);
        int tmp = Integer.parseInt(c.getString(C_SM_CAST).toString());
        if (tmp>0)
            tmp--;
        else
            tmp = 0;
        ContentValues newValues = new ContentValues();
        newValues.put(K_SM_CAST, tmp);
        return myDB.update(DATABASE_TABLE, newValues, where, null) != 0;
    }

/*    public Cursor getCastable() {
        String where = K_SM_MEMORIZED + ">0";
    }*/

    /*
    public boolean insertData(String name) {
        SQLiteDatabase myDB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CHAR_NAME, name);
        long result = myDB.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase myDB = this.getWritableDatabase();
        return myDB.rawQuery("select * from " + TABLE_NAME, null);

    }

    public boolean updateData(String id, String name) {
        SQLiteDatabase myDB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CHAR_ID, id);
        contentValues.put(COL_CHAR_NAME, name);
        myDB.update(TABLE_NAME, contentValues, COL_CHAR_ID + " = ?", new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        return myDB.delete(TABLE_NAME, COL_CHAR_ID + " = ?", new String[] {id});
    }
    */

}
