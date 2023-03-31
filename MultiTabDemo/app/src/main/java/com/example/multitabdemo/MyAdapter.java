package com.example.multitabdemo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyAdapter extends FragmentStatePagerAdapter {
    private int tabCount;

    public MyAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    /***
     * this is to return the relevent Fragment
     * @param position
     * @return
     */

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){ // position indicates the tab position
            case 0:
                Fragment1 fragment1 = new Fragment1();
                return fragment1;
            case 1:
                Fragment2 fragment2 = new Fragment2();
                return fragment2;
            case 2:
                Fragment3 fragment3 = new Fragment3();
                return fragment3;
            default:
                return null;
        }
    }

    /***
     * it is used to specify the number of tabs
     * @return
     */
    @Override
    public int getCount() {
        return tabCount;
    }
}
