package com.example.android.laguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by masus on 2/27/2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context context;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new RestaurantsFragment();
        } else if(position == 1) {
            return new ParksFragment();
        } else if(position == 2) {
            return new LandmarksFragment();
        } else {
            return new MuseumsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return context.getString(R.string.tab_restaurants);
        } else if(position == 1) {
            return context.getString(R.string.tab_parks);
        } else if(position == 2) {
            return context.getString(R.string.tab_landmarks);
        } else {
            return context.getString(R.string.tab_museums);
        }
    }
}
