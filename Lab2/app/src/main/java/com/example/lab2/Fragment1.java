package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment {
    public Fragment1() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        //Physical button leading to fragment 2
        Button physicalBtn = view.findViewById(R.id.physical_btn);
        physicalBtn.setOnClickListener(v -> {
            Fragment2 fragment2 = new Fragment2();
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment2);
            transaction.commit();
        });

        //Mental button leading to fragment 3
        Button mentalBtn = view.findViewById(R.id.mental_btn);
        mentalBtn.setOnClickListener(v -> {
            Fragment3 fragment3 = new Fragment3();
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment3);
            transaction.commit();
        });

        return view;
    }
}