package com.example.lecture2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        //button
        Button editButton = view.findViewById(R.id.edit_button);
        editButton.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "Edit profile clicked", Toast.LENGTH_SHORT).show();
        });

        //Intent to go back to MainActivity
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);

        return view;
    }
}