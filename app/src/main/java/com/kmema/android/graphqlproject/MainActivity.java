package com.kmema.android.graphqlproject;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.Toolbar;


import com.kmema.android.graphqlproject.Film.FilmFragment;
import com.kmema.android.graphqlproject.Species.SpeciesFragment;
import com.kmema.android.graphqlproject.person.PersonFragment;
import com.kmema.android.graphqlproject.planet.PlanetFragment;
import com.kmema.android.graphqlproject.vehicle.VehicleFragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NodeClickListener {

    private static final String TAG = "MainActivity" ;
    private android.support.v4.app.FragmentManager mFragmentManager;
    ArrayList<Integer> colorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();
        PersonFragment personFragment = new PersonFragment();
        mFragmentManager.beginTransaction().replace(R.id.containerLayout,personFragment, personFragment.getTag()).commit();
        colorList = new ArrayList<>();
        colorList.add(0,R.color.colorGreen);
        colorList.add(1,R.color.colorRed);
        colorList.add(2,R.color.colorOrange);
        colorList.add(3,R.color.colorBlue);
        colorList.add(4,R.color.colorPurple);

        ArrayList<String> mList = new ArrayList<String>();
        mList.add(0,"Person");
        mList.add(1,"Vehicle");
        mList.add(2,"Film");
        mList.add(3,"Species");
        mList.add(4,"Planet");
        RecyclerView mRecyclerView = findViewById(R.id.recycleListViewNode);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        Toast.makeText(this, "SIZE"+ mList.size(), Toast.LENGTH_LONG).show();
        RecyclerView.Adapter mAdapter = new MyNodeRecyclerViewAdapter(mList,colorList,MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
        //default call to people when creates an activity
    }

    @Override
    public void recyclerViewClickListener(View view, int position) {

        Toast.makeText(this, "CLICKED", Toast.LENGTH_SHORT).show();
        Window window = getWindow();

        switch (position)
        {
            case 0:
                PersonFragment personFragment = new PersonFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout,personFragment, personFragment.getTag()).commit();
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorGreen)));
                window.setStatusBarColor(getResources().getColor(R.color.colorGreenDark));
                Toast.makeText(this, "Position People", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                VehicleFragment vehicleFragment = new VehicleFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, vehicleFragment, vehicleFragment.getTag()).commit();
                Toast.makeText(this, "Position Vehicle", Toast.LENGTH_SHORT).show();
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                window.setStatusBarColor(getResources().getColor(R.color.colorRedLight));
                break;

            case 2:
                FilmFragment filmFragment = new FilmFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, filmFragment, filmFragment.getTag()).commit();
                Toast.makeText(this, "Position Film", Toast.LENGTH_SHORT).show();
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorOrange)));
                window.setStatusBarColor(getResources().getColor(R.color.colorRed));
                break;

            case 3:
                SpeciesFragment speciesFragment = new SpeciesFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, speciesFragment, speciesFragment.getTag()).commit();
                Toast.makeText(this, "Position Species", Toast.LENGTH_SHORT).show();
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorBlueLight)));
                window.setStatusBarColor(getResources().getColor(R.color.colorBlue));
                break;

            case 4:
                PlanetFragment planetFragment = new PlanetFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, planetFragment, planetFragment.getTag()).commit();
                Toast.makeText(this, "Position Planet", Toast.LENGTH_SHORT).show();
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPurpleLight)));
                window.setStatusBarColor(getResources().getColor(R.color.colorPurple));
                break;
        }
    }
}
