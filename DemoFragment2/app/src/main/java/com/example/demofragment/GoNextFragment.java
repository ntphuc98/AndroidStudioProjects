package com.example.demofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class GoNextFragment extends Fragment {
    public GoNextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_go_next, container, false);
        Button goNextBtn = view.findViewById(R.id.goNextBtn);
        goNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new MessageFragment(), null);
                fragmentTransaction.commit();
            }
        });
        return  view;
    }
}
