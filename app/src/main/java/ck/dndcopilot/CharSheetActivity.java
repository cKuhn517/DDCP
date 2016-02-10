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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_sheet);

        viewPager = (ViewPager) findViewById(R.id.CharSheetPager);
        PagerAdapter padapter = new CharSheetAdapter(getSupportFragmentManager());

        viewPager.setAdapter(padapter);

    }

}
