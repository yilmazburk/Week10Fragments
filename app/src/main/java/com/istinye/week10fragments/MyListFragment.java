package com.istinye.week10fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class MyListFragment extends ListFragment {

    private OnItemClick myDelegate;

    public MyListFragment() {
        // Required empty public constructor
    }


    public static MyListFragment newInstance() {
        MyListFragment fragment = new MyListFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        /*if (context instanceof MainActivity) {
            myDelegate = (OnItemClick) context;
        }*/
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> listData = new ArrayList<String>();
        listData.add("Burkan Yılmaz");
        listData.add("Birkan Hakan Şimşek");
        listData.add("Ceyhun Emir Aygan");
        listData.add("Doğukan İnce");
        listData.add("Furkan Kaya");
        listData.add("Kaan İnce");


        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listData));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        if (myDelegate != null) {
            myDelegate.onClick(position);
        }
    }

    public void setMyDelegate(OnItemClick myDelegate) {
        this.myDelegate = myDelegate;
    }
}