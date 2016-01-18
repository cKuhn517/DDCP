package ck.dndcopilot;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chris on 1/18/2016.
 */
public class CharHomeDBOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dflt.sqlite";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_CHARSHEET = "charsheet";
    public static final String C_CHARSHEET_ID                   = "_id";
    public static final String C_CHARSHEET_SRC                  = "source";
    public static final String C_CHARSHEET_NAME                 = "name";
    public static final String C_CHARSHEET_RACE                 = "race";
    public static final String C_CHARSHEET_SIZE                 = "size";
    public static final String C_CHARSHEET_AGE                  = "age";
    public static final String C_CHARSHEET_GENDER               = "gender";
    public static final String C_CHARSHEET_LVL                  = "level";
    public static final String C_CHARSHEET_XP                   = "xp";
    public static final String C_CHARSHEET_BARBARIAN            = "brb";
    public static final String C_CHARSHEET_BARD                 = "brd";
    public static final String C_CHARSHEET_CLERIC               = "clr";
    public static final String C_CHARSHEET_DRUID                = "drd";
    public static final String C_CHARSHEET_FIGHTER              = "ftr";
    public static final String C_CHARSHEET_MONK                 = "mnk";
    public static final String C_CHARSHEET_PALADIN              = "pal";
    public static final String C_CHARSHEET_RANGER               = "rgr";
    public static final String C_CHARSHEET_ROGUE                = "rog";
    public static final String C_CHARSHEET_SORCERER             = "sor";
    public static final String C_CHARSHEET_WIZARD               = "wiz";
    public static final String C_CHARSHEET_STRENGTH             = "str";
    public static final String C_CHARSHEET_DEXTERITY            = "dex";
    public static final String C_CHARSHEET_CONSTITUTION         = "con";
    public static final String C_CHARSHEET_INTELLIGENCE         = "int";
    public static final String C_CHARSHEET_WISDOM               = "wis";
    public static final String C_CHARSHEET_CHARISMA             = "cha";
    public static final String C_CHARSHEET_MAXHP                = "maxhp";
    public static final String C_CHARSHEET_CURHP                = "curhp";
    public static final String C_CHARSHEET_SUBDMG               = "subdmg";
    public static final String C_CHARSHEET_DR                   = "dr";
    public static final String C_CHARSHEET_DIETYPE              = "dietype";
    public static final String C_CHARSHEET_SPEED                = "speed";
    public static final String C_CHARSHEET_ARMOR                = "armor";
    public static final String C_CHARSHEET_SHIELD               = "shield";
    public static final String C_CHARSHEET_NATURALARMOR         = "natarmor";
    public static final String C_CHARSHEET_MISCARMOR            = "miscarmor";
    public static final String C_CHARSHEET_MISSCHANCE           = "misschance";
    public static final String C_CHARSHEET_ARCANESPELLFAILURE   = "arcspelfail";
    public static final String C_CHARSHEET_ARMORCHECKPENALTY    = "armorchkpen";
    public static final String C_CHARSHEET_SPELLRESISTANCE      = "spres";
    public static final String C_CHARSHEET_INITIATIVEMISC       = "initmis";
    public static final String C_CHARSHEET_BASEATTACK           = "baseatk";
    public static final String C_CHARSHEET_FORTITUDEBASE        = "fortbase";
    public static final String C_CHARSHEET_FORTITUDEABILITY     = "fortabil";
    public static final String C_CHARSHEET_FORTITUDEMAGIC       = "fortmgc";
    public static final String C_CHARSHEET_FORTITUDEMISC        = "fortmisc";
    public static final String C_CHARSHEET_REFLEXBASE           = "refbase";
    public static final String C_CHARSHEET_REFLEXABILITY        = "refabil";
    public static final String C_CHARSHEET_REFLEXMAGIC          = "refmgc";
    public static final String C_CHARSHEET_REFLEXMISC           = "refmisc";
    public static final String C_CHARSHEET_WILLBASE             = "willbase";
    public static final String C_CHARSHEET_WILLABILITY          = "willabil";
    public static final String C_CHARSHEET_WILLMAGIC            = "willmgc";
    public static final String C_CHARSHEET_WILLMISC             = "willmisc";
    public static final String C_CHARSHEET_MELEEBASE            = "meleebase";
    public static final String C_CHARSHEET_MELEEMISC            = "meleemisc";
    public static final String C_CHARSHEET_RANGEBASE            = "rangebase";
    public static final String C_CHARSHEET_RANGEMISC            = "rangemisc";
    public static final int N_CHARSHEET_ID                      = 0;
    public static final int N_CHARSHEET_SRC                     = 1;
    public static final int N_CHARSHEET_NAME                    = 2;
    public static final int N_CHARSHEET_RACE                    = 3;
    public static final int N_CHARSHEET_SIZE                    = 4;
    public static final int N_CHARSHEET_AGE                     = 5;
    public static final int N_CHARSHEET_GENDER 		            = 6;
    public static final int N_CHARSHEET_LVL 		            = 7;
    public static final int N_CHARSHEET_XP 		                = 8;
    public static final int N_CHARSHEET_BARBARIAN 		        = 9;
    public static final int N_CHARSHEET_BARD 		            = 10;
    public static final int N_CHARSHEET_CLERIC 		            = 11;
    public static final int N_CHARSHEET_DRUID 		            = 12;
    public static final int N_CHARSHEET_FIGHTER 		        = 13;
    public static final int N_CHARSHEET_MONK 		            = 14;
    public static final int N_CHARSHEET_PALADIN 		        = 15;
    public static final int N_CHARSHEET_RANGER 		            = 16;
    public static final int N_CHARSHEET_ROGUE 		            = 17;
    public static final int N_CHARSHEET_SORCERER 		        = 18;
    public static final int N_CHARSHEET_WIZARD 		            = 19;
    public static final int N_CHARSHEET_STRENGTH 		        = 20;
    public static final int N_CHARSHEET_DEXTERITY 		        = 21;
    public static final int N_CHARSHEET_CONSTITUTION 		    = 22;
    public static final int N_CHARSHEET_INTELLIGENCE 		    = 23;
    public static final int N_CHARSHEET_WISDOM 		            = 24;
    public static final int N_CHARSHEET_CHARISMA 		        = 25;
    public static final int N_CHARSHEET_MAXHP 		            = 26;
    public static final int N_CHARSHEET_CURHP 		            = 27;
    public static final int N_CHARSHEET_SUBDMG 		            = 28;
    public static final int N_CHARSHEET_DR 		                = 29;
    public static final int N_CHARSHEET_DIETYPE 		        = 30;
    public static final int N_CHARSHEET_SPEED 		            = 31;
    public static final int N_CHARSHEET_ARMOR 		            = 32;
    public static final int N_CHARSHEET_SHIELD 		            = 33;
    public static final int N_CHARSHEET_NATURALARMOR 		    = 34;
    public static final int N_CHARSHEET_MISCARMOR 		        = 35;
    public static final int N_CHARSHEET_MISSCHANCE 		        = 36;
    public static final int N_CHARSHEET_ARCANESPELLFAILURE 		= 37;
    public static final int N_CHARSHEET_ARMORCHECKPENALTY 		= 38;
    public static final int N_CHARSHEET_SPELLRESISTANCE 		= 39;
    public static final int N_CHARSHEET_INITIATIVEMISC 		    = 40;
    public static final int N_CHARSHEET_BASEATTACK 		        = 41;
    public static final int N_CHARSHEET_FORTITUDEBASE 		    = 42;
    public static final int N_CHARSHEET_FORTITUDEABILITY 		= 43;
    public static final int N_CHARSHEET_FORTITUDEMAGIC 		    = 44;
    public static final int N_CHARSHEET_FORTITUDEMISC 		    = 45;
    public static final int N_CHARSHEET_REFLEXBASE 		        = 46;
    public static final int N_CHARSHEET_REFLEXABILITY 		    = 47;
    public static final int N_CHARSHEET_REFLEXMAGIC 		    = 48;
    public static final int N_CHARSHEET_REFLEXMISC 		        = 49;
    public static final int N_CHARSHEET_WILLBASE 		        = 50;
    public static final int N_CHARSHEET_WILLABILITY 		    = 51;
    public static final int N_CHARSHEET_WILLMAGIC 		        = 52;
    public static final int N_CHARSHEET_WILLMISC 		        = 53;
    public static final int N_CHARSHEET_MELEEBASE 		        = 54;
    public static final int N_CHARSHEET_MELEEMISC 		        = 55;
    public static final int N_CHARSHEET_RANGEBASE 		        = 56;
    public static final int N_CHARSHEET_RANGEMISC 		        = 57;


    private SQLiteDatabase db;
    private Context context;

    public CharHomeDBOpenHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
        context = ctx;
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        DfltDBAssetHelper dfltDb = new DfltDBAssetHelper(context);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
