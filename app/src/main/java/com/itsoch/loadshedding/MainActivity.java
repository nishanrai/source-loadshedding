package com.itsoch.loadshedding;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;



public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
       private FragmentManager manager;
       public static int home = 0;
       public static final String PREFS_NAME = "MyPrefsFile";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
toolbar.setTitle("Sunsari Loadshedding");

        mAdView = (AdView)findViewById(R.id.ad_home);
        mAdView.loadAd(new AdRequest.Builder()
                .addTestDevice("D4CC20764FB65A5245824CFD2A564769")
                .build());


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AppBarLayout appBarLayout = (AppBarLayout)findViewById(R.id.appbarmain);
            toolbar.setElevation(0);
            appBarLayout.setElevation(0);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {

            home = 1;
            home fraghome = new home();
            android.support.v4.app.FragmentTransaction home = getSupportFragmentManager().beginTransaction();
            home.replace(R.id.frame, fraghome);
            home.commit();
        }



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (home==0) {

            home fraghome = new home();
            android.support.v4.app.FragmentTransaction home = getSupportFragmentManager().beginTransaction();
            home.replace(R.id.frame, fraghome);
            home.commit();
        }
        else {
            super.onBackPressed();
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
if (home == 1)
{}

{
    home fraghome = new home();
    android.support.v4.app.FragmentTransaction home = getSupportFragmentManager().beginTransaction();
    home.replace(R.id.frame, fraghome);
    home.commit();
}

        } else if (id == R.id.nav_sch) {
            Intent intent = new Intent(MainActivity.this, SCHEDULE.class);
           startActivity(intent);

        }

         else if (id == R.id.nav_app) {
            home=0;
            Intent intent = new Intent(MainActivity.this, about.class);
            startActivity(intent);
        }

        else if (id == R.id.nav_rate)
        {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id="
                                + getPackageName())));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id="
                                + getPackageName())));
            }
        }

        else if (id == R.id.nav_other)
        {
            startActivity(new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(getString(R.string.play_more_apps))));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

}

/*  case R.id.menu_moreapp:

                startActivity(new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.play_more_apps))));

                return true;

            case R.id.menu_rateapp:

                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id="
                                    + getPackageName())));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id="
                                    + getPackageName())));
                }*/