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
    Button brbB, brdB, clrB, drdB, ftrB, mnkB, palB, rgrB, rogB, sorB, wizB, saveButton, cancelButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.charsheet_frag_1, container, false);

        //<editor-fold desc="Class Plus Buttons">
        brbB = (Button) rootView.findViewById(R.id.button_cs1_brbp);
        brdB = (Button) rootView.findViewById(R.id.button_cs1_brdp);
        clrB = (Button) rootView.findViewById(R.id.button_cs1_clrp);
        drdB = (Button) rootView.findViewById(R.id.button_cs1_drdp);
        ftrB = (Button) rootView.findViewById(R.id.button_cs1_ftrp);
        mnkB = (Button) rootView.findViewById(R.id.button_cs1_mnkp);
        palB = (Button) rootView.findViewById(R.id.button_cs1_palp);
        rgrB = (Button) rootView.findViewById(R.id.button_cs1_rgrp);
        rogB = (Button) rootView.findViewById(R.id.button_cs1_rogp);
        sorB = (Button) rootView.findViewById(R.id.button_cs1_sorp);
        wizB = (Button) rootView.findViewById(R.id.button_cs1_wizp);

        brbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClass("brb");
            }
        });
        brdB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClass("brd");
            }
        });
        clrB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClass("clr");
            }
        });
        drdB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClass("drd");
            }
        });
        ftrB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClass("ftr");
            }
        });
        mnkB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClass("mnk");
            }
        });
        palB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClass("pal");
            }
        });
        rgrB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClass("rgr");
            }
        });
        rogB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClass("rog");
            }
        });
        sorB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClass("sor");
            }
        });
        wizB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClass("wiz");
            }
        });
        //</editor-fold>

        raceSpinner = (Spinner) rootView.findViewById(R.id.spinner_cs1_race);
        raceSpinnerAdapter = ArrayAdapter.createFromResource(this.getContext(), R.array.race, android.R.layout.simple_spinner_item);
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

        loadValues();

        return rootView;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void plusClass(String cls) {
        //TODO Increase class level on button push
    }

    private void loadValues() {
        //TODO Load values of ability table on CS1
    }

    private void saveValues() {
        //TODO Save values of ability table on CS1
        Toast.makeText(rootView.getContext(), "Race: " + raceValue, Toast.LENGTH_SHORT).show();

    }

}
