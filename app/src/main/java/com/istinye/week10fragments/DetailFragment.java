package com.istinye.week10fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment implements OnItemClick {

    private ArrayList<String> details;
    private TextView detailTextView;
    private MainActivity myContext;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            myContext = (MainActivity) context;
        }
    }

    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        detailTextView = view.findViewById(R.id.myDetailTextView);
        return view;
    }

    @Override
    public void onClick(int position) {
        if (myContext == null) return;
        if (position < details.size()) {
            if (myContext.getPortrait()) {
                Toast.makeText(myContext, "Turn device to landscape for details.", Toast.LENGTH_SHORT).show();
            } else {
                detailTextView.setText(details.get(position));
            }
        }
    }

    public void setDetails(ArrayList<String> details) {
        this.details = details;
    }
}