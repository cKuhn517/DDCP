package ck.dndcopilot;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Chris on 1/31/2016.
 */
public class CharSheetFrag1 extends Fragment {

    Spinner raceSpinner;
    ArrayAdapter<CharSequence> raceSpinnerAdapter;
    String raceValue = "";
    View rootView;
    Button saveButton, cancelButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.charsheet_frag_1, container, false);

        raceSpinner = (Spinner) rootView.findViewById(R.id.spinner_cs1_race);
        raceSpinnerAdapter = ArrayAdapter.createFromResource(this.getContext(),R.array.race,android.R.layout.simple_spinner_item);
        raceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceSpinner.setAdapter(raceSpinnerAdapter);
        raceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                raceValue = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        saveButton = (Button) rootView.findViewById(R.id.button_cs1_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveValues();
            }
        });

        cancelButton = (Button) rootView.findViewById(R.id.button_cs1_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadValues();
            }
        });

        return rootView;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void loadValues() {
        //TODO Load values of ability table on CS1
    }

    private void saveValues() {
        //TODO Save values of ability table on CS1
        Toast.makeText(rootView.getContext(), "Race: " + raceValue, Toast.LENGTH_SHORT).show();

    }

}
