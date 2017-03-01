package testdemo.com.materialsearchviewtest.fragments;


import android.content.Context;
import android.support.v4.app.FragmentManager;

public interface FragmentChangeListener {
    void onFragmentChange(Context context,
                          FragmentChangeEvent fragmentChangeEvent,
                          final FragmentManager fragmentManager,
                          String tag);
    //boolean onFragmentPop(FragmentChangeEvent fragmentChangeEvent);

}
