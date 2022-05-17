package com.example.thuchanh1.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.thuchanh1.MainActivity;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private int pageNum;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior, int pageNum) {
        super(fm, behavior);
        this.pageNum = pageNum;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
        }
        return null;
    }

    @Override
    public int getCount() {
        return this.pageNum;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Fragment1";
            case 1:
                return "Fragment2";
            case 2:
                return "Fragment3";
        }
        return "";
    }
}
