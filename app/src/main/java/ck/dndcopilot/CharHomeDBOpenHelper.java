package ck.dndcopilot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chris on 1/18/2016.
 */
public class CharHomeDBOpenHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME;
    private static final int DATABASE_VERSION = 1;

    //<editor-fold desc="Public Table Variables">
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

    public static final String TABLE_CHARSPECEQ = "charspecequipment";

    public static final String C_CHARSPEQ_ID                    = "_id";
    public static final String C_CHARSPEQ_NAME                  = "name";
    public static final String C_CHARSPEQ_EQUIPPED              = "equipped";
    public static final String C_CHARSPEQ_SLOT                  = "slot";
    public static final String C_CHARSPEQ_TYPE                  = "type";
    public static final String C_CHARSPEQ_SUBTYPE1              = "subtype1";
    public static final String C_CHARSPEQ_SUBTYPE2              = "subtype2";
    public static final String C_CHARSPEQ_BDMG                  = "bdmg";
    public static final String C_CHARSPEQ_MDMG                  = "mdmg";
    public static final String C_CHARSPEQ_MDMGTYPE              = "mdmgtype";
    public static final String C_CHARSPEQ_CRIT                  = "crit";
    public static final String C_CHARSPEQ_RANGE                 = "range";
    public static final String C_CHARSPEQ_WEIGHT                = "weight";
    public static final String C_CHARSPEQ_COST                  = "cost";
    public static final String C_CHARSPEQ_AC                    = "ac";
    public static final String C_CHARSPEQ_MAXDEXBONUS           = "maxdexbns";
    public static final String C_CHARSPEQ_ARMORCHECKPENALTY     = "armorchkpen";
    public static final String C_CHARSPEQ_ARCANESPELLFAILURE    = "arcspellfail";
    public static final String C_CHARSPEQ_SPEED30               = "spd30";
    public static final String C_CHARSPEQ_SPEED20               = "spd20";
    public static final String C_CHARSPEQ_ATTRIBUTE             = "atr";
    public static final String C_CHARSPEQ_ATTRIBUTEEFFECT       = "atreff";
    public static final String C_CHARSPEQ_SPELLID               = "sp_id";
    public static final String C_CHARSPEQ_SPELLCOUNT            = "sp_cnt";
    public static final String C_CHARSPEQ_SPELLAUTORESET        = "sp_autoreset";

    public static final int N_CHARSPEQ_ID                       = 0;
    public static final int N_CHARSPEQ_NAME                     = 1;
    public static final int N_CHARSPEQ_EQUIPPED                 = 2;
    public static final int N_CHARSPEQ_SLOT                     = 3;
    public static final int N_CHARSPEQ_TYPE                     = 4;
    public static final int N_CHARSPEQ_SUBTYPE1                 = 5;
    public static final int N_CHARSPEQ_SUBTYPE2                 = 6;
    public static final int N_CHARSPEQ_BDMG                     = 7;
    public static final int N_CHARSPEQ_MDMG                     = 8;
    public static final int N_CHARSPEQ_MDMGTYPE                 = 9;
    public static final int N_CHARSPEQ_CRIT                     = 10;
    public static final int N_CHARSPEQ_RANGE                    = 11;
    public static final int N_CHARSPEQ_WEIGHT                   = 12;
    public static final int N_CHARSPEQ_COST                     = 13;
    public static final int N_CHARSPEQ_AC                       = 14;
    public static final int N_CHARSPEQ_MAXDEXBONUS              = 15;
    public static final int N_CHARSPEQ_ARMORCHECKPENALTY        = 16;
    public static final int N_CHARSPEQ_ARCANESPELLFAILURE       = 17;
    public static final int N_CHARSPEQ_SPEED30                  = 18;
    public static final int N_CHARSPEQ_SPEED20                  = 19;
    public static final int N_CHARSPEQ_ATTRIBUTE                = 20;
    public static final int N_CHARSPEQ_ATTRIBUTEEFFECT          = 21;
    public static final int N_CHARSPEQ_SPELLID                  = 22;
    public static final int N_CHARSPEQ_SPELLCOUNT               = 23;
    public static final int N_CHARSPEQ_SPELLAUTORESET           = 24;

    public static final String TABLE_EQUIPPED = "equipped";

    public static final String C_EQUIPPED_ID                    = "_id";
    public static final String C_EQUIPPED_SOURCEID              = "source_id";
    public static final String C_EQUIPPED_SOURCE                = "source";
    public static final String C_EQUIPPED_TYPE                  = "type";
    public static final String C_EQUIPPED_ITEMID                = "item_id";
    public static final String C_EQUIPPED_ITEM                  = "item";

    public static final int N_EQUIPPED_ID                       = 0;
    public static final int N_EQUIPPED_SOURCEID                 = 1;
    public static final int N_EQUIPPED_SOURCE                   = 2;
    public static final int N_EQUIPPED_TYPE                     = 3;
    public static final int N_EQUIPPED_ITEMID                   = 4;
    public static final int N_EQUIPPED_ITEM                     = 5;

    public static final String TABLE_SKILLS = "skills";

    public static final String C_SKILLS_ID                      = "_id";
    public static final String C_SKILLS_SKILLNAME               = "skillname";
    public static final String C_SKILLS_KEY                     = "key" ;
    public static final String C_SKILLS_RANKS                   = "ranks" ;
    public static final String C_SKILLS_MISC                    = "misc" ;
    public static final String C_SKILLS_AVAILABLE               = "available" ;
    public static final String C_SKILLS_UNTRAINED               = "untrained" ;
    public static final String C_SKILLS_ARMORCHECKPENALTY       = "armorchkpen";

    public static final int N_SKILLS_ID                         = 0;
    public static final int N_SKILLS_SKILLNAME                  = 1;
    public static final int N_SKILLS_KEY                        = 2;
    public static final int N_SKILLS_RANKS                      = 3;
    public static final int N_SKILLS_MISC                       = 4;
    public static final int N_SKILLS_AVAILABLE                  = 5;
    public static final int N_SKILLS_UNTRAINED                  = 6;
    public static final int N_SKILLS_ARMORCHECKPENALTY          = 7;

    public static final String TABLE_SPELLS = "spells";

    public static final String C_SPELLS_ID                      = "_id";
    public static final String C_SPELLS_EQUIPID                 = "eq_id";
    public static final String C_SPELLS_SPELLID                 = "sp_id";
    public static final String C_SPELLS_COUNT                   = "cnt";

    public static final int N_SPELLS_ID                         = 0;
    public static final int N_SPELLS_EQUIPID                    = 1;
    public static final int N_SPELLS_SPELLID                    = 2;
    public static final int N_SPELLS_COUNT                      = 3;

    public static final String TABLE_SPELLSLOTS = "spellslots";

    public static final String C_SPELLSLOTS_ID                  = "_id";
    public static final String C_SPELLSLOTS_LVL                 = "lvl";
    public static final String C_SPELLSLOTS_SPELLID             = "sp_id";
    public static final String C_SPELLSLOTS_SCHOOL              = "school";

    public static final int N_SPELLSLOTS_ID                     = 0;
    public static final int N_SPELLSLOTS_LVL                    = 1;
    public static final int N_SPELLSLOTS_SPELLID                = 2;
    public static final int N_SPELLSLOTS_SCHOOL                 = 3;

    public static final String TABLE_WIZARD = "wizard";

    public static final String C_WIZARD_ID                      = "_id";
    public static final String C_WIZARD_SPECSCHOOL              = "school";
    public static final String C_WIZARD_SPECCASTABLE            = "castable";

    public static final int N_WIZARD_ID                         = 0;
    public static final int N_WIZARD_SPECSCHOOL                 = 1;
    public static final int N_WIZARD_SPECCASTABLE               = 2;

    //</editor-fold>

    private SQLiteDatabase db;
    private GameDataDBAssetHelper GameDb;
    private Context context;

    public CharHomeDBOpenHelper(Context ctx, String name) {
        super(ctx, name, null, DATABASE_VERSION);
        DATABASE_NAME = name;
        context = ctx;
        db = this.getWritableDatabase();
        GameDb = new GameDataDBAssetHelper(ctx);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create character sheet table
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_CHARSHEET+" (" +
                C_CHARSHEET_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, " +
                C_CHARSHEET_SRC + ", " +
                C_CHARSHEET_NAME + ", " +
                C_CHARSHEET_RACE + ", " +
                C_CHARSHEET_SIZE + ", " +
                C_CHARSHEET_AGE + ", " +
                C_CHARSHEET_GENDER + ", " +
                C_CHARSHEET_LVL + " INTEGER, " +
                C_CHARSHEET_XP + " INTEGER, " +
                C_CHARSHEET_BARBARIAN + " INTEGER, " +
                C_CHARSHEET_BARD + " INTEGER, " +
                C_CHARSHEET_CLERIC + " INTEGER, " +
                C_CHARSHEET_DRUID + " INTEGER, " +
                C_CHARSHEET_FIGHTER + " INTEGER, " +
                C_CHARSHEET_MONK + " INTEGER, " +
                C_CHARSHEET_PALADIN + " INTEGER, " +
                C_CHARSHEET_RANGER + " INTEGER, " +
                C_CHARSHEET_ROGUE + " INTEGER, " +
                C_CHARSHEET_SORCERER + " INTEGER, " +
                C_CHARSHEET_WIZARD + " INTEGER, " +
                C_CHARSHEET_STRENGTH + " INTEGER, " +
                C_CHARSHEET_DEXTERITY + " INTEGER, " +
                C_CHARSHEET_CONSTITUTION + " INTEGER, " +
                C_CHARSHEET_INTELLIGENCE + " INTEGER, " +
                C_CHARSHEET_WISDOM + " INTEGER, " +
                C_CHARSHEET_CHARISMA + " INTEGER, " +
                C_CHARSHEET_MAXHP + " INTEGER, " +
                C_CHARSHEET_CURHP + " INTEGER, " +
                C_CHARSHEET_SUBDMG + " INTEGER, " +
                C_CHARSHEET_DR + ", " +
                C_CHARSHEET_DIETYPE + ", " +
                C_CHARSHEET_SPEED + ", " +
                C_CHARSHEET_ARMOR + ", " +
                C_CHARSHEET_SHIELD + ", " +
                C_CHARSHEET_NATURALARMOR + ", " +
                C_CHARSHEET_MISCARMOR + ", " +
                C_CHARSHEET_MISSCHANCE + ", " +
                C_CHARSHEET_ARCANESPELLFAILURE + ", " +
                C_CHARSHEET_ARMORCHECKPENALTY + ", " +
                C_CHARSHEET_SPELLRESISTANCE + ", " +
                C_CHARSHEET_INITIATIVEMISC + " INTEGER, " +
                C_CHARSHEET_BASEATTACK + ", " +
                C_CHARSHEET_FORTITUDEBASE + " INTEGER, " +
                C_CHARSHEET_FORTITUDEABILITY + " INTEGER, " +
                C_CHARSHEET_FORTITUDEMAGIC + " INTEGER, " +
                C_CHARSHEET_FORTITUDEMISC + " INTEGER, " +
                C_CHARSHEET_REFLEXBASE + " INTEGER, " +
                C_CHARSHEET_REFLEXABILITY + " INTEGER, " +
                C_CHARSHEET_REFLEXMAGIC + " INTEGER, " +
                C_CHARSHEET_REFLEXMISC + " INTEGER, " +
                C_CHARSHEET_WILLBASE + " INTEGER, " +
                C_CHARSHEET_WILLABILITY + " INTEGER, " +
                C_CHARSHEET_WILLMAGIC + " INTEGER, " +
                C_CHARSHEET_WILLMISC + " INTEGER, " +
                C_CHARSHEET_MELEEBASE + " INTEGER, " +
                C_CHARSHEET_MELEEMISC + " INTEGER, " +
                C_CHARSHEET_RANGEBASE + " INTEGER, " +
                C_CHARSHEET_RANGEMISC + " INTEGER );");

        //Insert default character stats
        db.execSQL("INSERT INTO "+TABLE_CHARSHEET+" VALUES(1,'perm','"+ DATABASE_NAME +
                "',NULL,NULL,NULL,NULL,1,0,0,0,0,0,0,0,0,0,0,0,0,10,10,10,10,10,10,1,1,0,NULL" +
                ",NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL," +
                "NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);");

        //Create table for tracking equipment
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_CHARSPECEQ + " (" +
                C_CHARSPEQ_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , " +
                C_CHARSPEQ_NAME + ", " +
                C_CHARSPEQ_EQUIPPED + ", " +
                C_CHARSPEQ_SLOT + ", " +
                C_CHARSPEQ_TYPE + ", " +
                C_CHARSPEQ_SUBTYPE1 + ", " +
                C_CHARSPEQ_SUBTYPE2 + ", " +
                C_CHARSPEQ_BDMG + ", " +
                C_CHARSPEQ_MDMG + ", " +
                C_CHARSPEQ_MDMGTYPE + ", " +
                C_CHARSPEQ_CRIT + ", " +
                C_CHARSPEQ_RANGE + ", " +
                C_CHARSPEQ_WEIGHT + ", " +
                C_CHARSPEQ_COST + ", " +
                C_CHARSPEQ_AC + " INTEGER, " +
                C_CHARSPEQ_MAXDEXBONUS + " INTEGER, " +
                C_CHARSPEQ_ARMORCHECKPENALTY + " INTEGER, " +
                C_CHARSPEQ_ARCANESPELLFAILURE + " INTEGER, " +
                C_CHARSPEQ_SPEED30 + " INTEGER, " +
                C_CHARSPEQ_SPEED20 + " INTEGER, " +
                C_CHARSPEQ_ATTRIBUTE + ", " +
                C_CHARSPEQ_ATTRIBUTEEFFECT + " INTEGER, " +
                C_CHARSPEQ_SPELLID + " INTEGER, " +
                C_CHARSPEQ_SPELLCOUNT + " INTEGER, " +
                C_CHARSPEQ_SPELLAUTORESET + ");");

        //Create table for equipment currently equipped
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_EQUIPPED + " (" +
                C_EQUIPPED_ID       + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , " +
                C_EQUIPPED_SOURCEID + " INTEGER, " +
                C_EQUIPPED_SOURCE   + ", " +
                C_EQUIPPED_TYPE     + ", " +
                C_EQUIPPED_ITEMID   + " INTEGER, " +
                C_EQUIPPED_ITEM     + ");");

        //Insert default rows for character equipment slots into equipped table
        db.execSQL("INSERT INTO " + TABLE_EQUIPPED + " VALUES(1,-1,'head','head',NULL,NULL);");
        db.execSQL("INSERT INTO " + TABLE_EQUIPPED + " VALUES(2,-1,'eyes','eyes',NULL,NULL);");
        db.execSQL("INSERT INTO " + TABLE_EQUIPPED + " VALUES(3,-1,'neck','neck',NULL,NULL);");
        db.execSQL("INSERT INTO " + TABLE_EQUIPPED + " VALUES(4,-1,'shoulders','shoulders',NULL,NULL);");
        db.execSQL("INSERT INTO " + TABLE_EQUIPPED + " VALUES(5,-1,'ring1','ring',NULL,NULL);");
        db.execSQL("INSERT INTO " + TABLE_EQUIPPED + " VALUES(6,-1,'ring2','ring',NULL,NULL);");
        db.execSQL("INSERT INTO " + TABLE_EQUIPPED + " VALUES(7,-1,'hands','hands',NULL,NULL);");
        db.execSQL("INSERT INTO " + TABLE_EQUIPPED + " VALUES(8,-1,'arms','arms',NULL,NULL);");
        db.execSQL("INSERT INTO " + TABLE_EQUIPPED + " VALUES(9,-1,'body','body',NULL,NULL);");
        db.execSQL("INSERT INTO " + TABLE_EQUIPPED + " VALUES(10,-1,'torso','torso',NULL,NULL);");
        db.execSQL("INSERT INTO " + TABLE_EQUIPPED + " VALUES(11,-1,'waist','waist',NULL,NULL);");
        db.execSQL("INSERT INTO " + TABLE_EQUIPPED + " VALUES(12,-1,'feet','feet',NULL,NULL);");

        //Create table for skill ranks
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_SKILLS + " (" +
                C_SKILLS_ID                     + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                C_SKILLS_SKILLNAME              + ", " +
                C_SKILLS_KEY                    + ", " +
                C_SKILLS_RANKS                  + " INTEGER, " +
                C_SKILLS_MISC                   + " INTEGER, " +
                C_SKILLS_AVAILABLE              + " INTEGER, " +
                C_SKILLS_UNTRAINED              + " INTEGER, " +
                C_SKILLS_ARMORCHECKPENALTY      + " INTEGER);");

        //Insert row for each skill
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(1, 'Alchemy', 'Int', NULL, NULL, NULL, 0, 0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(2,'Animal empathy','Cha',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(3,'Appraise','Int',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(4,'Balance','Dex',NULL,NULL,NULL,1,1);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(5,'Bluff','Cha',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(6,'Climb','Str',NULL,NULL,NULL,1,1);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(7,'Concentration','Con',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(8,'Craft','Int',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(9,'Decipher Script','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(10,'Diplomacy','Cha',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(11,'Disable Device','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(12,'Disguise','Cha',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(13,'Escape Artist','Dex',NULL,NULL,NULL,1,1);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(14,'Forgery','Int',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(15,'Gather Information','Cha',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(16,'Handle Animal','Cha',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(17,'Heal','Wis',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(18,'Hide','Dex',NULL,NULL,NULL,1,1);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(19,'Innuendo','Wis',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(20,'Intimidate','Cha',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(21,'Intuit Direction','Wis',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(22,'Jump','Str',NULL,NULL,NULL,1,1);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(23,'Knowledge (arcana)','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(24,'Knowledge (architecture)','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(25,'Knowledge (geography)','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(26,'Knowledge (history)','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(27,'Knowledge (local)','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(28,'Knowledge (nature)','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(29,'Knowledge (nobility and royalty)','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(30,'Knowledge (the planes)','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(31,'Knowledge (religion)','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(32,'Listen','Wis',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(33,'Move silently','Dex',NULL,NULL,NULL,1,1);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(34,'Open lock','Dex',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(35,'Perform','Cha',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(36,'Pick pocket','Dex',NULL,NULL,NULL,0,1);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(37,'Profession','Wis',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(38,'Read lips','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(39,'Ride','Dex',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(40,'Scry','Int',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(41,'Search','Int',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(42,'Sense motive','Wis',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(43,'Speak language','NA',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(44,'Spellcraft','Int',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(45,'Spot','Wis',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(46,'Swim','Str',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(47,'Tumble','Dex',NULL,NULL,NULL,0,1);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(48,'Use magic device','Cha',NULL,NULL,NULL,0,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(49,'Use rope','Dex',NULL,NULL,NULL,1,0);");
        db.execSQL("INSERT INTO " + TABLE_SKILLS + " VALUES(50,'Wilderness lore','Wis',NULL,NULL,NULL,1,0);");

        //Create table of spells
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_SPELLS + " (" +
                C_SPELLS_ID         + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, " +
                C_SPELLS_EQUIPID    + " INTEGER, " +
                C_SPELLS_SPELLID    + " INTEGER, " +
                C_SPELLS_COUNT      + " INTEGER);");

        //Create table for currently memorized spells
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_SPELLSLOTS + " (" +
                C_SPELLSLOTS_ID         + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, " +
                C_SPELLSLOTS_LVL        + " INTEGER, " +
                C_SPELLSLOTS_SPELLID    + " INTEGER, " +
                C_SPELLSLOTS_SCHOOL     + ");");

        //Create table for wizard specific data
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_WIZARD + " (" +
                C_WIZARD_ID             + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, " +
                C_WIZARD_SPECSCHOOL     + ", " +
                C_WIZARD_SPECCASTABLE   + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHARSHEET);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHARSPECEQ);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EQUIPPED);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SKILLS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPELLS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPELLSLOTS);
        onCreate(db);
    }

    public int curLvl() {
        String[] vars = new String[] {C_CHARSHEET_LVL};
        String where = C_CHARSHEET_SRC + " = 'perm'";
        Cursor c = db.query(true, TABLE_CHARSHEET, vars, where, null, null, null, null, null);
        c.moveToFirst();
        return c.getInt(c.getColumnIndexOrThrow(C_CHARSHEET_LVL));
    }

    public int curXP() {
        String[] vars = new String[] {C_CHARSHEET_XP};
        String where = C_CHARSHEET_SRC + " = 'perm'";
        Cursor c = db.query(true,TABLE_CHARSHEET,vars,where,null,null,null,null,null);
        c.moveToFirst();
        return c.getInt(c.getColumnIndexOrThrow(C_CHARSHEET_XP));
    }

    public boolean addXP(int amt) {

        int lvl = curLvl();
        int curXP = curXP();
        int needXP = GameDb.getXPToNextLvl(lvl);
        int newXP = curXP + amt;

        String where = C_CHARSHEET_SRC + " = 'perm'";
        ContentValues newValues = new ContentValues();
        newValues.put(C_CHARSHEET_XP, newXP);

        //if you level up increase level and needed xp and initiate level up process
        boolean lvlup = newXP >= needXP;
        if (lvlup)
            newValues.put(C_CHARSHEET_LVL, lvl+1);

        //Update XP (and maybe LVL) value(s)
        boolean updtXP = db.update(TABLE_CHARSHEET, newValues, where, null) != 0;

        return lvlup;
    }

}
