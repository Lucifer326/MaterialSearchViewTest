package testdemo.com.materialsearchviewtest.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import testdemo.com.materialsearchviewtest.R;

public abstract class RecyclerFragment extends Fragment implements AdapterView.OnItemClickListener {

    private final String TAG = "RecyclerFragment";

    protected RecyclerView mRecyclerView;

    // Required Overrides for Sample Fragments
    protected abstract RecyclerView.LayoutManager getLayoutManager();
    protected abstract RecyclerView.ItemDecoration getItemDecoration();
    protected abstract int getDefaultItemCount();

    public RecyclerFragment () {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.section_list);
        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.addItemDecoration(getItemDecoration());

        mRecyclerView.getItemAnimator().setAddDuration(1000);
        mRecyclerView.getItemAnimator().setChangeDuration(1000);
        mRecyclerView.getItemAnimator().setMoveDuration(1000);
        mRecyclerView.getItemAnimator().setRemoveDuration(1000);

        return rootView;
    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.grid_options, menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.action_preferences:
//
////                startActivity(new Intent((AppCompatActivity)getActivity(), PreferenceActivity.class));
////
////                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
////
////                builder1.setMessage("Preferences");
////                builder1.setCancelable(true);
////
////                builder1.setPositiveButton(
////                        "Dismiss",
////                        new DialogInterface.OnClickListener() {
////                            public void onClick(DialogInterface dialog, int id) {
////                                dialog.cancel();
////                            }
////                        });
////
////
////                AlertDialog alert11 = builder1.create();
////                alert11.show();
////
////                return true;
////            default:
////                return super.onOptionsItemSelected(item);
//        }
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getActivity(),
//                "Clicked: " + position + ", index " + mRecyclerView.indexOfChild(view),
//                Toast.LENGTH_SHORT).show();
    }
}
