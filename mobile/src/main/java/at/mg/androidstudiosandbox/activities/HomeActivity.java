package at.mg.androidstudiosandbox.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import at.mg.androidstudiosandbox.R;
import at.mg.androidstudiosandbox.fragments.HomeFragment;
import at.mg.androidstudiosandbox.fragments.NestedScrollViewFragment;
import at.mg.androidstudiosandbox.fragments.RecyclerFragment;

public class HomeActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(tb);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        NavigationView nv = (NavigationView) findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // update the main content by replacing fragments
                FragmentManager fragmentManager = getSupportFragmentManager();

                switch (item.getItemId()) {
                    case R.id.navigation_item_1:
                        fragmentManager.beginTransaction()
                                .replace(R.id.container, HomeFragment.newInstance(0))
                                .commit();
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.navigation_item_2:
                        fragmentManager.beginTransaction()
                                .replace(R.id.container, RecyclerFragment.newInstance())
                                .commit();
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.navigation_item_3:
                        fragmentManager.beginTransaction()
                                .replace(R.id.container, NestedScrollViewFragment.newInstance())
                                .commit();
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                }


                return false;
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the navigation drawer and the action bar app icon.
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                    /* host Activity */
                mDrawerLayout,                    /* DrawerLayout object */
                R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close  /* "close drawer" description for accessibility */
        ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                if (!isAdded()) {
//                    return;
//                }

                invalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                if (!isAdded()) {
//                    return;
//                }


                invalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }
        };


        // Defer code dependent on restoration of previous instance state.
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);

//        mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance(0))
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
