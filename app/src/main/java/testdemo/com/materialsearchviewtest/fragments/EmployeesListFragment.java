package testdemo.com.materialsearchviewtest.fragments;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.futuremind.recyclerviewfastscroll.FastScroller;

import testdemo.com.materialsearchviewtest.R;
import testdemo.com.materialsearchviewtest.adapters.EmployeesRecyclerAdapter;
import testdemo.com.materialsearchviewtest.customview.CustomScrollerViewProvider;
import testdemo.com.materialsearchviewtest.decoration.DividerDecoration;
import testdemo.com.materialsearchviewtest.model.EmployeeListRestrictionsParcelable;


public class EmployeesListFragment extends RecyclerFragment {

    private final String TAG = "EmployeesListFragment";

    private static String locationOrDivisonString = "NoLocationOrDivisonString";
    private static String locationString = "NoLocation";
    private static String divisionString = "NoDivision";

    protected EmployeesRecyclerAdapter mAdapter;

    public EmployeesListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: " + container);

        EmployeeListRestrictionsParcelable employeeListRestrictionsParcelable =
            this.getArguments().getParcelable(EmployeeListRestrictionsParcelable.BUNDLE_KEY);
        String location = employeeListRestrictionsParcelable.getLocation();
        String division = employeeListRestrictionsParcelable.getDivision();

        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.section_list);

        FastScroller fastScroller = (FastScroller) rootView.findViewById(R.id.fastscroll);
        fastScroller.setViewProvider(new CustomScrollerViewProvider());

        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.addItemDecoration(getItemDecoration());

        mRecyclerView.getItemAnimator().setAddDuration(1000);
        mRecyclerView.getItemAnimator().setChangeDuration(1000);
        mRecyclerView.getItemAnimator().setMoveDuration(1000);
        mRecyclerView.getItemAnimator().setRemoveDuration(1000);

        mAdapter = getAdapter(); // EmployeesRecyclerAdapter


        mAdapter.addEmployeesToRowItems();

        // set title for action bar
        String title = getResources().getString(R.string.title_section1);
//
//        // set title
//        if (! location.equalsIgnoreCase("")) {
//          if ( ! division.equalsIgnoreCase("")) { // location and division (because location is Santa Fe)
//              mAdapter.populateLocationAndDivisionEmployeeListFromSQLite(location, division);
//              title += " - " + location + " - " + division;
//          }
//          else { // just location
//              mAdapter.populateLocationEmployeeListFromSQLite(location);
//              title += " - " + location;
//          }
//        }
//        else if (! division.equalsIgnoreCase("")) { // division only, no location
//            mAdapter.populateDivisionEmployeeListFromSQLite(division);
//            title += " - " + division;
//        }
//        else { // both location and division are blank, so display all
//            mAdapter.addEmployeesToRowItems();
//        }

        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        //Log.d(TAG, "mAdapter: " + mAdapter);

        // Must be called AFTER RecyclerView.setAdapter()
        fastScroller.setRecyclerView(mRecyclerView);

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        //String device_size = getResources().getString(R.string.device_size); // TODO device_size remove for production
        //actionBar.setTitle(title + " : " + device_size);
        actionBar.setTitle(title);

        return rootView;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    }

    @Override
    protected RecyclerView.ItemDecoration getItemDecoration() {
        //We must draw dividers ourselves if we want them in a list
        return new DividerDecoration(getActivity());
    }

    @Override
    protected int getDefaultItemCount() {
        return 100;
    }

//    @Override
    protected EmployeesRecyclerAdapter getAdapter() {

        return new EmployeesRecyclerAdapter(getActivity());
    }
}
