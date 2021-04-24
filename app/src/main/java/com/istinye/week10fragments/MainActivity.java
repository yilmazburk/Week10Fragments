package com.istinye.week10fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> details;
    private TextView detailTextView;
    private Boolean isPortrait = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailTextView = findViewById(R.id.myDetailTextView);
        initialize();

        FragmentManager fragmentManager = this.getSupportFragmentManager();

        MyListFragment myListFragment = (MyListFragment) fragmentManager.findFragmentById(R.id.listFragment);

        DetailFragment detailFragment = (DetailFragment) fragmentManager.findFragmentById(R.id.detailFragment);
        detailFragment.setDetails(details);

        myListFragment.setMyDelegate(detailFragment);

        if (findViewById(R.id.portraitMode) != null) {
            isPortrait = true;
            fragmentManager.beginTransaction()
                    .hide(fragmentManager.findFragmentById(R.id.detailFragment))
                    .show(fragmentManager.findFragmentById(R.id.listFragment)).commit();
        }
        if (findViewById(R.id.landscapeMode) != null) {
            isPortrait = false;
            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.detailFragment))
                    .show(fragmentManager.findFragmentById(R.id.listFragment)).commit();
        }


    }

    private void initialize(){
        details = new ArrayList<>();
        details.add("Burkan Yılmaz Detail Page");
        details.add("Birkan Hakan Şimşek Detail Page");
        details.add("Ceyhun Emir Aygan Detail Page");
        details.add("Doğukan İnce Detail Page");
        details.add("Furkan Kaya Detail Page");
        details.add("Kaan İnce Detail Page");
    }

    public Boolean getPortrait() {
        return isPortrait;
    }
}