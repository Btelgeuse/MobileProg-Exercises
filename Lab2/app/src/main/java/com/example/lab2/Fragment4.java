package com.example.lab2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment4 extends Fragment {

    public Fragment4() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_4, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            int score = bundle.getInt("score_key", 0);

            TextView scoreView = view.findViewById(R.id.score_text_view);
            TextView verdictView = view.findViewById(R.id.verdict);
            scoreView.setText("Total Score: " + score);

            if (score <= 0) {
                verdictView.setText("Your health assessment indicates that you are in a healthy state.");
            } else if (score > 0 && score <=5) {
                verdictView.setText("Your health assessment indicates that you are in a sub-healthy state.");
            } else {
                verdictView.setText("Your health assessment indicates that you are in need of medical attention.");
            }
        }
        return view;
    }
}