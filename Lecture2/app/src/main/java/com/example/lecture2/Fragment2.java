package com.example.lecture2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class Fragment2 extends Fragment {

    public Fragment2() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.todo_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> tasks = Arrays.asList(
                "Learn how to use Fragments",
                "Learn RecyclerView",
                "Submit Mobile Programming assignment",
                "Dance class tonight"
        );

        recyclerView.setAdapter(new com.example.lecture2.TodoAdapter(tasks));
        return view;
    }
}