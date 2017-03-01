package testdemo.com.materialsearchviewtest.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.util.Log;

import testdemo.com.materialsearchviewtest.R;
import testdemo.com.materialsearchviewtest.fragments.FragmentChange;

import static testdemo.com.materialsearchviewtest.fragments.NavigationDrawerFragment.NAVIGATION_MENU_ABOUT;
import static testdemo.com.materialsearchviewtest.fragments.NavigationDrawerFragment.NAVIGATION_MENU_ALL_EMPLOYEES;

public class PreferencesUtilities extends Utilities {

    private final static String TAG = "PreferencesUtilities";

    // display key for preferences
    private static String LAST_NAVIGATION_MENU_PAGE_DISPLAYED_KEY = "lastNavigationMenuPageDisplayedKey";
    private static String PREVIOUS_PAGE_DISPLAYED_KEY = "previousPageDisplayedKey";
    private static String CURRENT_PAGE_DISPLAYED_KEY  = "currentPageDisplayedKey";
    private static String LAST_LOCATION_KEY  = "lastLocationKey";
    private static String LAST_DIVISION_KEY  = "lastDivisionKey";
    private static String LAST_INDIVIDUAL_KEY  = "lastIndividualKey";
    private static String LAST_INDIVIDUAL_NAME_KEY  = "lastIndividualNameKey";
    private static String LAST_CALL_NUMBER_KEY  = "lastCallNumberKey";
    private static String LAST_SEARCH_STRING_KEY  = "lastSearchStringKey";

    // get most recent navigation menu displayed index
    public static int getNavigationMenuDisplayPreference(Context context) {

        String preferencesFileName = context.getResources().getString(R.string.preferences_file_name);
        SharedPreferences preferences = context.getSharedPreferences(preferencesFileName, context.MODE_PRIVATE);

        int displayInt = preferences.getInt(LAST_NAVIGATION_MENU_PAGE_DISPLAYED_KEY, 0);

        // if an invalid key was saved, this is bad
        // rather than crash, just display all employees list
        // with the next install, can remove this code
        if (displayInt < NAVIGATION_MENU_ALL_EMPLOYEES || displayInt > NAVIGATION_MENU_ABOUT) {
            Log.e(TAG, "getNavigationMenuDisplayPreference(): Bad key for Navigation Menu display: " + displayInt);
            displayInt = NAVIGATION_MENU_ALL_EMPLOYEES;
        }

        return displayInt;
    }

    // Remember the current page displayed in preferences
    public static void setNavigationMenuDisplayPreference(Context context, int keyInt) {

        // if an invalid key was passed in, this is bad
        // rather than crash, just display all employees list
        if (keyInt < NAVIGATION_MENU_ALL_EMPLOYEES || keyInt > NAVIGATION_MENU_ABOUT) {
            Log.e(TAG, "setNavigationMenuDisplayPreference(): Bad key for Navigation Menu display: " + keyInt);
            //keyInt = NAVIGATION_MENU_ALL_EMPLOYEES;
            //Log.e(TAG, "setNavigationMenuDisplayPreference(): So set to NAVIGATION_MENU_ALL_EMPLOYEES: " + keyInt);
        }
        else {
            String preferencesFileName = context.getResources().getString(R.string.preferences_file_name);
            SharedPreferences preferences = context.getSharedPreferences(preferencesFileName, context.MODE_PRIVATE);

            SharedPreferences.Editor editor = preferences.edit();

            editor.putInt(LAST_NAVIGATION_MENU_PAGE_DISPLAYED_KEY, keyInt);

            editor.commit();

        }

    }

    // get the previous page displayed index
    public static int getPreviousPageDisplayedPreference(Context context) {

        String preferencesFileName = context.getResources().getString(R.string.preferences_file_name);
        SharedPreferences preferences = context.getSharedPreferences(preferencesFileName, context.MODE_PRIVATE);

        int displayInt = preferences.getInt(PREVIOUS_PAGE_DISPLAYED_KEY, FragmentChange.FRAGMENT_ALL_EMPLOYEES_LIST);

        return displayInt;
    }

    // Remember the previous page displayed in preferences
    // Must be in range FragmentChange.FRAGMENT_ALL_EMPLOYEES_LIST to FRAGMENT_INDIVIDUAL
    // Called only from FragmentChange.onFragmentChange()
    public static void setPreviousPageDisplayedPreference(Context context, int keyInt) {

        String preferencesFileName = context.getResources().getString(R.string.preferences_file_name);
        SharedPreferences preferences = context.getSharedPreferences(preferencesFileName, context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt(PREVIOUS_PAGE_DISPLAYED_KEY, keyInt);

        editor.commit();
    }

    // get the current page displayed index
    public static int getCurrentPageDisplayedPreference(Context context) {

        String preferencesFileName = context.getResources().getString(R.string.preferences_file_name);
        SharedPreferences preferences = context.getSharedPreferences(preferencesFileName, context.MODE_PRIVATE);

        int displayInt = preferences.getInt(CURRENT_PAGE_DISPLAYED_KEY, FragmentChange.FRAGMENT_ALL_EMPLOYEES_LIST);

        return displayInt;
    }

    // Remember the current page displayed in preferences
    // Must be in range FragmentChange.FRAGMENT_ALL_EMPLOYEES_LIST to FRAGMENT_INDIVIDUAL
    // Called only from FragmentChange.onFragmentChange()
    public static void setCurrentPageDisplayedPreference(Context context, int keyInt) {

        String preferencesFileName = context.getResources().getString(R.string.preferences_file_name);
        SharedPreferences preferences = context.getSharedPreferences(preferencesFileName, context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt(CURRENT_PAGE_DISPLAYED_KEY, keyInt);

        editor.commit();
    }

     // get the last Search string
    public static String getLastSearchStringPreference(Context context) {

        String preferencesFileName = context.getResources().getString(R.string.preferences_file_name);
        SharedPreferences preferences = context.getSharedPreferences(preferencesFileName, context.MODE_PRIVATE);

        String name = preferences.getString(LAST_SEARCH_STRING_KEY, "Santa Fe");

        return name;
    }

    // Remember the last Search string
    public static void setLastSearchStringPreference(Context context, String searchString) {

        String preferencesFileName = context.getResources().getString(R.string.preferences_file_name);
        SharedPreferences preferences = context.getSharedPreferences(preferencesFileName, context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(LAST_SEARCH_STRING_KEY, searchString);

        editor.commit();
    }

}
