package ck.dndcopilot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class CharacterHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String message = intent.getStringExtra(CharacterSelectActivity.MSG_CHAR_NAME);
        TextView textView_charname = (TextView) findViewById(R.id.textView_char_name);
        textView_charname.setText(message);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void cHome_spells(View view) {
        Intent intent = new Intent(this, Spells.class);
        startActivity(intent);
    }
}
