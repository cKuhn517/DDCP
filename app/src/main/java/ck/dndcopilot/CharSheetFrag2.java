package ck.dndcopilot;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Chris on 1/31/2016.
 */
public class CharSheetFrag2 extends Fragment {

    View rootView;
    EditText strScore;
    TextView strMod;
    Button saveButton, cancelButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.charsheet_frag_2, container, false);

        strScore = (EditText) rootView.findViewById(R.id.editText_cs2_strscore);
        strMod   = (TextView) rootView.findViewById(R.id.textView_cs2_strmod);

        saveButton = (Button) rootView.findViewById(R.id.button_cs2_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveValues();
            }
        });

        cancelButton = (Button) rootView.findViewById(R.id.button_cs2_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadValues();
            }
        });


        return rootView;
    }

    private void loadValues() {
        //TODO Load values of ability table on CS2
    }

    private void saveValues() {
        //TODO Save values of ability table on CS2
        Toast.makeText(rootView.getContext(), "STR: " + strScore.getText(), Toast.LENGTH_SHORT).show();

    }

}
