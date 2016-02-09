package ck.dndcopilot;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CharSheetActivity extends FragmentActivity {

    ViewPager viewPager;
    //Spinner raceSpinner;
    //ArrayAdapter<CharSequence> raceSpinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_sheet);

        viewPager = (ViewPager) findViewById(R.id.CharSheetPager);
        PagerAdapter padapter = new CharSheetAdapter(getSupportFragmentManager());

        viewPager.setAdapter(padapter);

        // Fragment 1 code
        /*
        raceSpinner = (Spinner) findViewById(R.id.spinner_cs1_race);
        raceSpinnerAdapter = ArrayAdapter.createFromResource(this,R.array.race,android.R.layout.simple_spinner_item);
        raceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceSpinner.setAdapter(raceSpinnerAdapter);
        raceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" is selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/
    }

    public void buttonCs2Save() {
        EditText strScore = (EditText) findViewById(R.id.editText_cs2_strscore);
        Toast.makeText(this, "STR: " + strScore.getText(), Toast.LENGTH_LONG).show();
    }

}
