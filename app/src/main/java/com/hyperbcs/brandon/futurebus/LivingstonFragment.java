package com.hyperbcs.brandon.futurebus;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Brandon on 2/7/15.
 */
public class LivingstonFragment extends Fragment {

    public LivingstonFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_livi, container, false);

        return rootView;
    }
}
