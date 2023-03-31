package com.example.multitabdemo;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Multi Tabs");
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        
        // create the object of MyAdapter
        MyAdapter myAdapter = new MyAdapter(
                getSupportFragmentManager(), // fragment manager instance
                tabLayout.getTabCount() // no. of tabs
        );

        // hook the MyAdapter object with ViewPager
        viewPager.setAdapter(myAdapter); // set adapter in ViewPager

        // do the event handling in ViewPager
        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}