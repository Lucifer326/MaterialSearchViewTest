package testdemo.com.materialsearchviewtest;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import testdemo.com.materialsearchviewtest.adapters.DrawerItemCustomAdapter;
import testdemo.com.materialsearchviewtest.fragments.FragmentChange;
import testdemo.com.materialsearchviewtest.fragments.FragmentChangeEvent;
import testdemo.com.materialsearchviewtest.model.DataModel;
import testdemo.com.materialsearchviewtest.utilities.PreferencesUtilities;

import static testdemo.com.materialsearchviewtest.fragments.FragmentChange.FRAGMENT_ABOUT;
import static testdemo.com.materialsearchviewtest.fragments.FragmentChange.FRAGMENT_ALL_EMPLOYEES_LIST;
import static testdemo.com.materialsearchviewtest.fragments.FragmentChange.FRAGMENT_SEARCH_LIST;
import static testdemo.com.materialsearchviewtest.fragments.NavigationDrawerFragment.NAVIGATION_MENU_ABOUT;
import static testdemo.com.materialsearchviewtest.fragments.NavigationDrawerFragment.NAVIGATION_MENU_ALL_EMPLOYEES;
import static testdemo.com.materialsearchviewtest.fragments.NavigationDrawerFragment.NUMBER_OF_DRAWER_ITEMS;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private AppCompatActivity mActivity;

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;

    private MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity = this;

        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        setupToolbar();

        DataModel[] drawerItem = new DataModel[NUMBER_OF_DRAWER_ITEMS];

        drawerItem[NAVIGATION_MENU_ALL_EMPLOYEES] = new DataModel(R.mipmap.ic_person, getResources().getString(R.string.drawer_title_employees));
        drawerItem[NAVIGATION_MENU_ABOUT] = new DataModel(R.drawable.logo_default, getResources().getString(R.string.drawer_title_about));

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();

        // set which page was displayed last, if any
        int display = PreferencesUtilities.getNavigationMenuDisplayPreference(this);
        if (display > NAVIGATION_MENU_ABOUT) {
            display = NAVIGATION_MENU_ALL_EMPLOYEES;
        }
        selectNavigationMenuItem(display); // cause employee list to display when starting

        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setVoiceSearch(false);
        searchView.setCursorDrawable(R.drawable.custom_cursor);
        searchView.setEllipsize(true);
        searchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Search icon (magnifying glass) on the keyboard has been clicked so perform search
                // remember the search string
                PreferencesUtilities.setLastSearchStringPreference(mActivity.getApplicationContext(), query);

                Snackbar.make(findViewById(R.id.container), "Query: " + query, Snackbar.LENGTH_LONG).show();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentChange fragmentChange = FragmentChange.getInstance();
                FragmentChangeEvent fragmentChangeEvent = new FragmentChangeEvent(null);

                // adapter, fragment change , something, SQL query here
                String tag = Integer.toString(FRAGMENT_SEARCH_LIST);
                fragmentChangeEvent.setPosition(FRAGMENT_SEARCH_LIST);
                fragmentChangeEvent.setSearchString(query);
                fragmentChange.onFragmentChange(mActivity.getApplicationContext(), fragmentChangeEvent, fragmentManager, tag);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Search icon (magnifying glass) on the toolbar has been clicked
                // Also called for each keyboard click
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                // keyboard has been brought up
                Log.d(TAG, "onSearchViewShown");
            }

            @Override
            public void onSearchViewClosed() {
                Log.d(TAG, "onSearchViewClosed");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

    private void selectNavigationMenuItem(int position) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentChange fragmentChange = FragmentChange.getInstance();
        FragmentChangeEvent fragmentChangeEvent = new FragmentChangeEvent(null);

//        Fragment fragment = null;
        String tag = Integer.toString(FRAGMENT_ALL_EMPLOYEES_LIST);

        switch (position) {
            case NAVIGATION_MENU_ALL_EMPLOYEES:
                // go to all employees list
                tag = Integer.toString(FRAGMENT_ALL_EMPLOYEES_LIST);
                fragmentChangeEvent.setPosition(FRAGMENT_ALL_EMPLOYEES_LIST); // display employees in the division

                fragmentChange.onFragmentChange(this, fragmentChangeEvent, fragmentManager, tag);

                break;

            case NAVIGATION_MENU_ABOUT:
                tag = Integer.toString(FRAGMENT_ABOUT);
                fragmentChangeEvent.setPosition(FRAGMENT_ABOUT); // display employees in the division
                fragmentChange.onFragmentChange(this, fragmentChangeEvent, fragmentManager, tag);
                break;

            default:
                // something bad has happened
                tag = Integer.toString(FRAGMENT_ALL_EMPLOYEES_LIST);
                fragmentChangeEvent.setPosition(FRAGMENT_ALL_EMPLOYEES_LIST); // display employees in the division

                fragmentChange.onFragmentChange(this, fragmentChangeEvent, fragmentManager, tag);

                break;
        }


        mDrawerList.setItemChecked(position, true);
        mDrawerList.setSelection(position);
        setTitle(mNavigationDrawerItemTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectNavigationMenuItem(position);
        }

    }

    // Get the fragment being displayed, so as to remember when restarting.
    // There should only ever be one in the list, so return on first not null fragment
    public Fragment getVisibleFragment() {
        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null) { //&& fragment.isVisible())
                    return fragment;
                }
            }
        }
        return null;
    }

    @Override
    public void onBackPressed() {

        Fragment fragment = getVisibleFragment();
        String tag = fragment.getTag();
        int displayValue = new Integer(tag);
        //Log.d(TAG, "onBackPressed: tag: " + tag);
        //Log.d(TAG, "onBackPressed: displayValue: " + displayValue);

        int previous = PreferencesUtilities.getPreviousPageDisplayedPreference(this);
        int current = PreferencesUtilities.getCurrentPageDisplayedPreference(this);
        //Log.d(TAG, "onBackPressed: previous: " + previous);
        //Log.d(TAG, "onBackPressed: current: " + current);

        // if on one of the Navigation Menu pages, then exit
        if (current >= FRAGMENT_ALL_EMPLOYEES_LIST && current <= FRAGMENT_ABOUT) {
            super.onBackPressed(); // exit application
        } else {
            // Did individual come from All Employees, Locations Employees, or Divisions Employees
            if (previous == FRAGMENT_ALL_EMPLOYEES_LIST) {
                selectNavigationMenuItem(NAVIGATION_MENU_ALL_EMPLOYEES);
            } else {
                // destination is not a Navigation menu item,
                // but rather FRAGMENT_LOCATIONS_EMPLOYEE_LIST or FRAGMENT_DIVISIONS_EMPLOYEE_LIST
                FragmentManager fragmentManager = ((FragmentActivity) this).getSupportFragmentManager();
                FragmentChangeEvent fragmentChangeEvent = new FragmentChangeEvent(null);

                FragmentChange fragmentChange = FragmentChange.getInstance();

//                    if (previous == FRAGMENT_SEARCH_LIST) { // TIDO not sure if this is in the right place
//                        tag = this.getResources().getString(displaySearchEmployeesKey);
//                        fragmentChangeEvent.setPosition(FRAGMENT_SEARCH_LIST); // display employees in the division
//                        fragmentChangeEvent.setSearchString(PreferencesUtilities.getLastSearchStringPreference(this));
//
//                    }
                fragmentChange.onFragmentChange(this, fragmentChangeEvent, fragmentManager, tag);

            }

            if (searchView.isSearchOpen()) {
                searchView.closeSearch();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    searchView.setQuery(searchWrd, false);
                }
            }

            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
