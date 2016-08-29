package com.itsoch.loadshedding;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;



import com.getbase.floatingactionbutton.FloatingActionsMenu;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class home extends Fragment{

    public home() {
        // Required empty public constructor
    }

    private TabLayout tabLayout;
    private ViewPager viewPager;
    InterstitialAd mInterstitialAd;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.home=1;
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0); // Get preferences file (0 = no option flags set)
        boolean firstRun = settings.getBoolean("f1", true); // Is it first run? If not specified, use "true"
        if (firstRun) {

            SharedPreferences.Editor editor = settings.edit(); // Open the editor for our settings
            editor.putBoolean("G1", true);
            editor.putBoolean("G2", false);
            editor.putBoolean("G3", false);
            editor.putBoolean("f1" , false);
            editor.commit(); // Save all changed settings
        } else {
            Log.w("activity", "second time");

        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home, container, false);


        final   FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);

              viewPager = (ViewPager)v.findViewById(R.id.viewpager1);
        tabLayout = (TabLayout)v.findViewById(R.id.tabs1);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
       final FloatingActionsMenu fm = (FloatingActionsMenu)v.findViewById(R.id.fab_menu);
       final ImageView im = (ImageView)v.findViewById(R.id.head);
        im.setImageResource(R.drawable.banner);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {

                if (position != 0) {
                    fm.collapse();
                    fm.setVisibility(View.INVISIBLE);
                    im.setImageResource(R.drawable.save);

                } else {

                    fm.setVisibility(View.VISIBLE);
                    im.setImageResource(R.drawable.banner);

                }
            }

        });

      final com.getbase.floatingactionbutton.FloatingActionButton fab1 = (com.getbase.floatingactionbutton.FloatingActionButton)v.findViewById(R.id.btn1);
        final com.getbase.floatingactionbutton.FloatingActionButton fab2 = (com.getbase.floatingactionbutton.FloatingActionButton)v.findViewById(R.id.btn2);
        final com.getbase.floatingactionbutton.FloatingActionButton fab3 = (com.getbase.floatingactionbutton.FloatingActionButton)v.findViewById(R.id.btn3);

        final  LinearLayout ll = (LinearLayout) v.findViewById(R.id.LL);
        fab1.setIcon(R.drawable.one);
        fab2.setIcon(R.drawable.two);

        fab3.setIcon(R.drawable.three);

        fab1.setTitle("hello");

       // fab1.setTitle("hey");


        fm.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
            }

            @Override
            public void onMenuCollapsed() {


            }
        });

      fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("G1", true);
                editor.putBoolean("G2", false);
                editor.putBoolean("G3", false);

                fm.collapse();
                editor.commit();
                Intent i = getActivity().getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getActivity().getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("G2", true);
                editor.putBoolean("G1", false);
                editor.putBoolean("G3", false);

                fm.collapse();
                editor.commit();
                Intent i = getActivity().getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getActivity().getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);


            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();

                editor.putBoolean("G3", true);
                editor.putBoolean("G2", false);
                editor.putBoolean("G1", false);

                fm.collapse();
                editor.commit();
                Intent i = getActivity().getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getActivity().getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);


            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), SCHEDULE.class);
                getActivity().startActivity(intent);

            }
        });



        return v;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);
        boolean g1 = settings.getBoolean("G1", false);
        boolean g2 = settings.getBoolean("G2", false);
        boolean g3 = settings.getBoolean("G3", false);



        if(g1)

            adapter.addFrag(new OneFragment(), "My Group");
       if (g2)

           adapter.addFrag(new TwoFragment(), "My Group");

        if(g3)
             adapter.addFrag(new ThreeFragment(), "My Group");



        adapter.addFrag(new energy(),"energy tips");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);

        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
