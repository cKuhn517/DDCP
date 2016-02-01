package ck.dndcopilot;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Chris on 1/18/2016.
 */
public class GameDataDBAssetHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "gamedata.sqlite";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASTERSPELL = "masterspell";

    public static final String C_MASTERSPELL_ID                 = "_id";
    public static final String C_MASTERSPELL_BRD                = "Brd";
    public static final String C_MASTERSPELL_CLR                = "Clr";
    public static final String C_MASTERSPELL_DRD                = "Drd";
    public static final String C_MASTERSPELL_PAL                = "Pal";
    public static final String C_MASTERSPELL_RGR                = "Rgr";
    public static final String C_MASTERSPELL_WIZ                = "Wiz";
    public static final String C_MASTERSPELL_KNOWN              = "knw";
    public static final String C_MASTERSPELL_MEMORIZED          = "mem";
    public static final String C_MASTERSPELL_CAST               = "cst";
    public static final String C_MASTERSPELL_SCROLL             = "scroll";
    public static final String C_MASTERSPELL_ITEM               = "item";
    public static final String C_MASTERSPELL_ITEMNAME           = "itemnm";
    public static final String C_MASTERSPELL_TOTAL              = "tot";
    public static final String C_MASTERSPELL_SPELLNAME          = "Spell Name";
    public static final String C_MASTERSPELL_EFFECT             = "Effect";
    public static final String C_MASTERSPELL_COMP               = "Comp";
    public static final String C_MASTERSPELL_TIME               = "Time";
    public static final String C_MASTERSPELL_RANGE              = "Range";
    public static final String C_MASTERSPELL_DURATION           = "Duration";
    public static final String C_MASTERSPELL_SAVE               = "Save";
    public static final String C_MASTERSPELL_SR                 = "SR";

    public static final int N_MASTERSPELL_ID                    = 0;
    public static final int N_MASTERSPELL_BRD                   = 1;
    public static final int N_MASTERSPELL_CLR                   = 2;
    public static final int N_MASTERSPELL_DRD                   = 3;
    public static final int N_MASTERSPELL_PAL                   = 4;
    public static final int N_MASTERSPELL_RGR                   = 5;
    public static final int N_MASTERSPELL_WIZ                   = 6;
    public static final int N_MASTERSPELL_KNOWN                 = 7;
    public static final int N_MASTERSPELL_MEMORIZED             = 8;
    public static final int N_MASTERSPELL_CAST                  = 9;
    public static final int N_MASTERSPELL_SCROLL                = 10;
    public static final int N_MASTERSPELL_ITEM                  = 11;
    public static final int N_MASTERSPELL_ITEMNAME              = 12;
    public static final int N_MASTERSPELL_TOTAL                 = 13;
    public static final int N_MASTERSPELL_SPELLNAME             = 14;
    public static final int N_MASTERSPELL_EFFECT                = 15;
    public static final int N_MASTERSPELL_COMP                  = 16;
    public static final int N_MASTERSPELL_TIME                  = 17;
    public static final int N_MASTERSPELL_RANGE                 = 18;
    public static final int N_MASTERSPELL_DURATION              = 19;
    public static final int N_MASTERSPELL_SAVE                  = 20;
    public static final int N_MASTERSPELL_SR                    = 21;

    public static final String TABLE_LEVELGUIDE = "levelguide";

    public static final String C_LEVELGUIDE_ID                  = "_id";
    public static final String C_LEVELGUIDE_CLASS               = "Class";
    public static final String C_LEVELGUIDE_LEVEL               = "level";
    public static final String C_LEVELGUIDE_XP                  = "xp";
    public static final String C_LEVELGUIDE_SKILLMAX            = "skillma";
    public static final String C_LEVELGUIDE_XCLASSSKILLMAX      = "xclskillma";
    public static final String C_LEVELGUIDE_FEAT                = "feat";
    public static final String C_LEVELGUIDE_ABILITY             = "ability";
    public static final String C_LEVELGUIDE_ATTACKBASE1         = "atkb1";
    public static final String C_LEVELGUIDE_ATTACKBASE2         = "atkb2";
    public static final String C_LEVELGUIDE_ATTACKBASE3         = "atkb3";
    public static final String C_LEVELGUIDE_ATTACKBASE4         = "atkb4";
    public static final String C_LEVELGUIDE_SAVEFORTITUDE       = "savefort";
    public static final String C_LEVELGUIDE_SAVEREFLEX          = "saveref";
    public static final String C_LEVELGUIDE_SAVEWILL            = "savewill";
    public static final String C_LEVELGUIDE_SPELLPD0            = "spellpd0";
    public static final String C_LEVELGUIDE_SPELLPD1            = "spellpd1";
    public static final String C_LEVELGUIDE_SPELLPD2            = "spellpd2";
    public static final String C_LEVELGUIDE_SPELLPD3            = "spellpd3";
    public static final String C_LEVELGUIDE_SPELLPD4            = "spellpd4";
    public static final String C_LEVELGUIDE_SPELLPD5            = "spellpd5";
    public static final String C_LEVELGUIDE_SPELLPD6            = "spellpd6";
    public static final String C_LEVELGUIDE_SPELLPD7            = "spellpd7";
    public static final String C_LEVELGUIDE_SPELLPD8            = "spellpd8";
    public static final String C_LEVELGUIDE_SPELLPD9            = "spellpd9";

    public static final int N_LEVELGUIDE_ID                     = 0;
    public static final int N_LEVELGUIDE_CLASS                  = 1;
    public static final int N_LEVELGUIDE_LEVEL                  = 2;
    public static final int N_LEVELGUIDE_XP                     = 3;
    public static final int N_LEVELGUIDE_SKILLMAX               = 4;
    public static final int N_LEVELGUIDE_XCLASSSKILLMAX         = 5;
    public static final int N_LEVELGUIDE_FEAT                   = 6;
    public static final int N_LEVELGUIDE_ABILITY                = 7;
    public static final int N_LEVELGUIDE_ATTACKBASE1            = 8;
    public static final int N_LEVELGUIDE_ATTACKBASE2            = 9;
    public static final int N_LEVELGUIDE_ATTACKBASE3            = 10;
    public static final int N_LEVELGUIDE_ATTACKBASE4            = 11;
    public static final int N_LEVELGUIDE_SAVEFORTITUDE          = 12;
    public static final int N_LEVELGUIDE_SAVEREFLEX             = 13;
    public static final int N_LEVELGUIDE_SAVEWILL               = 14;
    public static final int N_LEVELGUIDE_SPELLPD0               = 15;
    public static final int N_LEVELGUIDE_SPELLPD1               = 16;
    public static final int N_LEVELGUIDE_SPELLPD2               = 17;
    public static final int N_LEVELGUIDE_SPELLPD3               = 18;
    public static final int N_LEVELGUIDE_SPELLPD4               = 19;
    public static final int N_LEVELGUIDE_SPELLPD5               = 20;
    public static final int N_LEVELGUIDE_SPELLPD6               = 21;
    public static final int N_LEVELGUIDE_SPELLPD7               = 22;
    public static final int N_LEVELGUIDE_SPELLPD8               = 23;
    public static final int N_LEVELGUIDE_SPELLPD9               = 24;

    private SQLiteDatabase db;

    public GameDataDBAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();
    }

    public int getXPToNextLvl(int curlvl) {
        int nextlvl = curlvl+1;
        String[] vars = new String[] {C_LEVELGUIDE_XP};
        String where = C_LEVELGUIDE_ID + " = " + nextlvl;
        Cursor c = db.query(true,TABLE_LEVELGUIDE,vars,where,null,null,null,null,null);
        c.moveToFirst();
        return c.getInt(c.getColumnIndexOrThrow(C_LEVELGUIDE_XP));
    }
}
