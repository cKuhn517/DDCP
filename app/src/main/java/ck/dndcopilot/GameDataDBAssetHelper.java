package ck.dndcopilot;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Chris on 1/18/2016.
 */
public class GameDataDBAssetHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "gamedata.sqlite";
    private static final int DATABASE_VERSION = 1;

    public GameDataDBAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }
}
