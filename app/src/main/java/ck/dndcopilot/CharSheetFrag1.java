package ck.dndcopilot;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Chris on 1/31/2016.
 */
public class CharSheetFrag1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.charsheet_frag_1, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
