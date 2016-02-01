package ck.dndcopilot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CharacterHomeActivity extends AppCompatActivity {

    CharHomeDBOpenHelper CharDb;
    GameDataDBAssetHelper GameDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String message = intent.getStringExtra(CharacterSelectActivity.MSG_CHAR_NAME);

        CharDb = new CharHomeDBOpenHelper(this, message);
        GameDb = new GameDataDBAssetHelper(this);

        //set character name
        TextView textView_charname = (TextView) findViewById(R.id.textView_char_name);
        textView_charname.setText(message);

        //TODO temporary method used to fill in my character info, should be reduced and removed as features are added.
        ulfgarr();

        //update the printed stats with information from the databases
        updateStats();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void ulfgarr() {
        //character sheet data;

        //wiz schools
    }

    public void cHome_spells(View view) {
        Intent intent = new Intent(this, SpellsActivity.class);
        startActivity(intent);
    }

    public void cHome_charSheet(View view) {
        Intent intent = new Intent(this, CharSheetActivity.class);
        startActivity(intent);
    }

    public void updateStats() {

        //update current level
        int lvl = CharDb.curLvl();

        TextView textLevel = (TextView) findViewById(R.id.textView_char_home_lvl_val);
        textLevel.setText(Integer.toString(lvl));

        //update XP bar
        int curXP = CharDb.curXP();
        int needXP = GameDb.getXPToNextLvl(lvl);

        ProgressBar xpBar = (ProgressBar) findViewById(R.id.progressBar_char_home_xp);
        TextView textCurXP = (TextView) findViewById(R.id.textView_char_home_xp_have);
        TextView textNeedXP = (TextView) findViewById(R.id.textView_char_home_xp_need);
        textCurXP.setText(Integer.toString(curXP));
        textNeedXP.setText(Integer.toString(needXP));
        xpBar.setProgress(curXP);
        xpBar.setMax(needXP);
    }

    public void addXPButton(View view) {
        //get amount to add from edittext
        EditText editText = (EditText) findViewById(R.id.editText_char_home_xp_amount);
        int amt = Integer.parseInt(editText.getText().toString());

        CharDb.addXP(amt);

    }
}
