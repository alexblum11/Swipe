package com.example.alexblum.swipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

/**
 * Created by Alexander on 12/11/2016.
 */

public class SwipeAdapter extends FragmentStatePagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = new FragmentPage();
        Bundle bundle = new Bundle();
        bundle.putInt("count",i+1);
        bundle.putString("question","What is your favorite color?");
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return 8;
    }
}
