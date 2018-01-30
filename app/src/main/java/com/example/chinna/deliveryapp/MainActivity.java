package com.example.chinna.deliveryapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        Button b1,b2,b3,b4,b5,terms;
        Fragment f;
        ViewPager viewPager;
        TabLayout tabLayout;
        TextView textView;
        private int[] tabIcons = {
            R.drawable.chickenicon,R.drawable.muttoniconn,R.drawable.fishicon,R.drawable.cheking,R.drawable.account
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

//        textView = (TextView)findViewById(R.id.text);

//        b1 = (Button) findViewById(R.id.chicken);
//        b2 = (Button) findViewById(R.id.mutton);
//        b3 = (Button) findViewById(R.id.fish);
//        b4 = (Button) findViewById(R.id.prawns);
//        b5 = (Button) findViewById(R.id.account);
//
//
//        b1.setOnClickListener(this);
//        b2.setOnClickListener(this);
//        b3.setOnClickListener(this);
//        b4.setOnClickListener(this);
//        b5.setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChickenFragment(), "Chicken");
        adapter.addFragment(new MuttonFragment(), "Mutton");
        adapter.addFragment(new FishFragment(), "Fish");
        adapter.addFragment(new PrawnsFragment(),"CheckOut");
        adapter.addFragment(new AccountFragment(),"Account");
        viewPager.setAdapter(adapter);
    }



//    @Override
//    public void onClick(View view){
//        if (view.getId() == R.id.chicken){
//            f= new ChickenFragment();
//        }
//        if (view.getId() == R.id.mutton){
//            f = new MuttonFragment();
//        }
//        else if (view.getId() == R.id.fish){
//            f= new FishFragment();
//        }
//        else if (view.getId() == R.id.prawns){
//            f= new PrawnsFragment();
//        }
//        else if (view.getId() == R.id.account){
//            f= new AccountFragment();
//        }
//
//
//        FragmentManager manager = getFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.chickenmain, f);
//        transaction.commit();
//    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.action_logout){

            Intent i = new Intent(getApplicationContext(),SigninActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
