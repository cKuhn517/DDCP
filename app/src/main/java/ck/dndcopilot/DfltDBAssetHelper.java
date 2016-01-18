package ck.dndcopilot;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Chris on 1/18/2016.
 */
public class DfltDBAssetHelper extends SQLiteAssetHelper{

    private static final String DATABASE_NAME = "dflt.sqlite";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public DfltDBAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();
    }

    public boolean newChar(String name) {
        //db.
        return false;
    }
}
