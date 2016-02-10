package ck.dndcopilot;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Chris on 1/31/2016.
 */
public class CharSheetAdapter extends FragmentPagerAdapter{

    public CharSheetAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CharSheetFrag1();
            case 1:
                return new CharSheetFrag2();
            case 2:
                return new CharSheetFrag3();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {

        return 3; //number of fragments
    }
}
