package ck.dndcopilot;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.IOException;
import java.sql.SQLException;

public class SpellsActivity extends AppCompatActivity {

    SpellListDBOpenHelper myDb;
    String charName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spells);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        charName = intent.getStringExtra(CharacterSelectActivity.MSG_CHAR_NAME);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        openDB("Ulfgarr");
    }

    private void openDB(String name) {
        myDb = new SpellListDBOpenHelper(this, name);
        /*
        try {
            myDb.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

        try {
            myDb.openDataBase();
        }catch(SQLException sqle){
            throw new Error("Unable to open database");
        }
        //myDb.open();
        */
    }

/*
    private void populateListView() {
        Cursor cursor = myDb.getCastable();
        String[] fromFieldNames = new String[] {SpellListDBOpenHelper.K_SM_ID,
                SpellListDBOpenHelper.K_SM_MEMORIZED, SpellListDBOpenHelper.K_SM_SCROLL,
                SpellListDBOpenHelper.K_SM_ITEM};
        int[] toViewIDs = new int[] {R.id.button_spell_cast_mem, R.id.button_spell_cast_scroll,
                R.id.}
    }
*/

}
