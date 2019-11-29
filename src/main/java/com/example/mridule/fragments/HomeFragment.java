package com.example.mridule.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**
 * Created by mridule on 24/11/19.
 */

public class HomeFragment extends Fragment {
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView programmingList = (RecyclerView) view.findViewById(R.id.programminglist);
        programmingList.setLayoutManager(new LinearLayoutManager(getActivity()));
        String[] languages = {"A", "B", "C", "D", "A", "B", "C", "D", "A", "B", "C", "D", "A", "B", "C", "D"};
        programmingList.setAdapter(new ProgramminngAdapter(languages, getContext()));

        return view;
    }
}


