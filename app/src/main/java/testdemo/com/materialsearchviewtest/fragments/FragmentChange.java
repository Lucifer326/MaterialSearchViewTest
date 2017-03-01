// Singleton
package testdemo.com.materialsearchviewtest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import testdemo.com.materialsearchviewtest.R;
import testdemo.com.materialsearchviewtest.model.EmployeeListRestrictionsParcelable;
import testdemo.com.materialsearchviewtest.utilities.PreferencesUtilities;

public class FragmentChange implements FragmentChangeListener {

    private final String TAG = "FragmentChange";

    // All the possible fragments to display
    // Note that 0 - 3 correspond to MainActivity.onNavigationDrawerItemSelected(int position)
    // Convert these to Strings to use these as tags for .replace(), as well
    static final public int FRAGMENT_ALL_EMPLOYEES_LIST = 0;
    static final public int FRAGMENT_ABOUT = 1;
    static final public int FRAGMENT_SEARCH_LIST = 2;

    //private Stack<FragmentChangeEvent> fragmentStack = new Stack<>();

    private static FragmentChange instance;
    private int mPosition = 0;

    private String version = "0";

    public static FragmentChange getInstance() {
        if (instance == null) {
            instance = new FragmentChange();
        }
        return instance;
    }

    @Override
    public void onFragmentChange(Context context,
                                 FragmentChangeEvent fragmentChangeEvent,
                                 final FragmentManager fragmentManager,
                                 String tag) {
        // update the main content by replacing fragments

        Bundle bundle = new Bundle();

        // set current page to previous page
        PreferencesUtilities.setPreviousPageDisplayedPreference(context, PreferencesUtilities.getCurrentPageDisplayedPreference(context));

        mPosition = fragmentChangeEvent.getPosition();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (mPosition) {
            case FRAGMENT_ALL_EMPLOYEES_LIST: // App start or from onNavigationDrawerItemSelected

                EmployeeListRestrictionsParcelable employeeListRestrictionsParcelable = new EmployeeListRestrictionsParcelable();
                employeeListRestrictionsParcelable.setLocation("");
                employeeListRestrictionsParcelable.setDivision("");

                EmployeesListFragment fragment = new EmployeesListFragment();


                bundle.putParcelable(EmployeeListRestrictionsParcelable.BUNDLE_KEY, employeeListRestrictionsParcelable);
                fragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.container, fragment, Integer.toString(FragmentChange.FRAGMENT_ALL_EMPLOYEES_LIST));
                //fragmentStack.clear();  // start over with the stack at the All Employee list
                //fragmentStack.push(fragmentChangeEvent);
                break;

            case FRAGMENT_ABOUT: // About (from onNavigationDrawerItemSelected)

                AboutFragment aboutFragment = new AboutFragment();

                fragmentTransaction.replace(R.id.container, aboutFragment, Integer.toString(FragmentChange.FRAGMENT_ABOUT));
                break;

            case FRAGMENT_SEARCH_LIST: // App start or from onNavigationDrawerItemSelected

                employeeListRestrictionsParcelable = new EmployeeListRestrictionsParcelable();
                employeeListRestrictionsParcelable.setLocation("");
                employeeListRestrictionsParcelable.setDivision("");
                employeeListRestrictionsParcelable.setSearch(fragmentChangeEvent.getSearchString());

                SearchListFragment searchListFragment = new SearchListFragment();

                bundle.putParcelable(EmployeeListRestrictionsParcelable.BUNDLE_KEY, employeeListRestrictionsParcelable);
                searchListFragment.setArguments(bundle);

                PreferencesUtilities.setLastSearchStringPreference(context, fragmentChangeEvent.getSearchString());

                fragmentTransaction.replace(R.id.container, searchListFragment, Integer.toString(FragmentChange.FRAGMENT_SEARCH_LIST));

                break;

            default:
                break; // do nothing
        }

        fragmentTransaction.commit(); // IllegalStateException: Activity has been destroyed

        // set current page
        PreferencesUtilities.setCurrentPageDisplayedPreference(context, mPosition);
    }

}
