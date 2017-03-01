package testdemo.com.materialsearchviewtest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import testdemo.com.materialsearchviewtest.adapters.DrawerItemCustomAdapter;
import testdemo.com.materialsearchviewtest.fragments.FragmentChange;
import testdemo.com.materialsearchviewtest.fragments.FragmentChangeEvent;
import testdemo.com.materialsearchviewtest.model.DataModel;
import testdemo.com.materialsearchviewtest.utilities.PreferencesUtilities;

import static testdemo.com.materialsearchviewtest.fragments.FragmentChange.FRAGMENT_ABOUT;
import static testdemo.com.materialsearchviewtest.fragments.FragmentChange.FRAGMENT_ALL_EMPLOYEES_LIST;
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

        Fragment fragment = null;

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

}
