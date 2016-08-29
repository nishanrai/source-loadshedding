package com.itsoch.loadshedding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;


public class TwoFragment extends Fragment{

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);
        MyAdapter adapter = new MyAdapter(getActivity(), data2.generateData());

        // if extending Activity 2. Get ListView from activity_main.xml
        ListView listView = (ListView)v.findViewById(R.id.listview2);   // 3. setListAdapter
        listView.setAdapter(adapter);

    

        return v;
    }



}
