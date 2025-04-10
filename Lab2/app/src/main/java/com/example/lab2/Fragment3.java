package com.example.lab2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

public class Fragment3 extends Fragment {

    public Fragment3() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        int[] checkBoxIdsPlus = {
                R.id.checkbox1, R.id.checkbox2, R.id.checkbox3, R.id.checkbox4, R.id.checkbox5,
                R.id.checkbox6, R.id.checkbox7, R.id.checkbox8
        };

        int[] checkBoxIdsMinus = {
                R.id.checkbox9, R.id.checkbox10, R.id.checkbox11
        };

        Button submitBtn = view.findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(v -> {
            int totalScore = 0;

            for (int id : checkBoxIdsPlus) {
                CheckBox checkBox = view.findViewById(id);
                if (checkBox != null && checkBox.isChecked()) {
                    totalScore += 5;
                }
            }

            for (int id : checkBoxIdsMinus) {
                CheckBox checkBox = view.findViewById(id);
                if (checkBox != null && checkBox.isChecked()) {
                    totalScore -= 5;
                }
            }

            Fragment4 fragment4 = new Fragment4();

            Bundle bundle = new Bundle();
            bundle.putInt("score_key", totalScore);
            fragment4.setArguments(bundle);

            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment4);
            transaction.commit();
        });

        return view;
    }
}