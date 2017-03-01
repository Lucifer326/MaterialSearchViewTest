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


public class SearchListFragment extends RecyclerFragment {

    private final String TAG = "SearchListFragment";

    protected EmployeesRecyclerAdapter mAdapter;

    public SearchListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: " + container);

        EmployeeListRestrictionsParcelable employeeListRestrictionsParcelable =
            this.getArguments().getParcelable(EmployeeListRestrictionsParcelable.BUNDLE_KEY);

        String searchString = employeeListRestrictionsParcelable.getSearch();

        View rootView = inflater.inflate(R.layout.activity_main, container, false);

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

        // set title for action bar
        String title = getResources().getString(R.string.title_search_results);
        title += " \"" + searchString + "\"";

        // if search string is empty then display all employees
        if (searchString.isEmpty()) {
            mAdapter.addEmployeesToRowItems();
        }
        else {
            mAdapter.populateEmployeeList(); // searchString here
        }

        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        //Log.d(TAG, "mAdapter: " + mAdapter);

        // Must be called AFTER RecyclerView.setAdapter()
        fastScroller.setRecyclerView(mRecyclerView);

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
//        actionBar.setTitle(title);

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
