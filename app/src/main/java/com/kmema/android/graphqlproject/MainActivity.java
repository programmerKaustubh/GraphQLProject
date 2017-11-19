package com.kmema.android.graphqlproject;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.kmema.android.graphqlproject.Film.FilmFragment;
import com.kmema.android.graphqlproject.Species.SpeciesFragment;
import com.kmema.android.graphqlproject.person.PersonFragment;
import com.kmema.android.graphqlproject.planet.PlanetFragment;
import com.kmema.android.graphqlproject.vehicle.VehicleFragment;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements NodeClickListener {
    private android.support.v4.app.FragmentManager mFragmentManager;
    ArrayList<Integer> colorList;
    private static final String CURRENT_FRAGMENT_KEY = "currentFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();

        if (savedInstanceState != null) {
            android.support.v4.app.Fragment fragment = getSupportFragmentManager().getFragment(savedInstanceState, CURRENT_FRAGMENT_KEY);
            mFragmentManager.beginTransaction().replace(R.id.containerLayout, fragment).commit();
        } else {
            updateCurrentFragment(0);
        }
        colorList = new ArrayList<>();
        colorList.add(0, R.color.colorGreen);
        colorList.add(1, R.color.colorRed);
        colorList.add(2, R.color.colorOrange);
        colorList.add(3, R.color.colorBlue);
        colorList.add(4, R.color.colorPurple);
        ArrayList<String> mList = new ArrayList<>();
        mList.add(0, "Person");
        mList.add(1, "Vehicle");
        mList.add(2, "Film");
        mList.add(3, "Species");
        mList.add(4, "Planet");
        RecyclerView mRecyclerView = findViewById(R.id.recycleListViewNode);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter mAdapter = new MyNodeRecyclerViewAdapter(mList, colorList, MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void recyclerViewClickListener(View view, int position) {
        updateCurrentFragment(position);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.containerLayout);
        getSupportFragmentManager().putFragment(outState, CURRENT_FRAGMENT_KEY, fragment);
        super.onSaveInstanceState(outState);
    }

    private void updateCurrentFragment(int id) {
        switch (id) {
            case 0:
                PersonFragment personFragment = new PersonFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, personFragment, "personfragment").commit();
                break;
            case 1:
                VehicleFragment vehicleFragment = new VehicleFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, vehicleFragment, "vehiclefragment").commit();
                break;
            case 2:
                FilmFragment filmFragment = new FilmFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, filmFragment, "filmfragment").commit();
                break;
            case 3:
                SpeciesFragment speciesFragment = new SpeciesFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, speciesFragment, "speciesfragment").commit();
                break;
            case 4:
                PlanetFragment planetFragment = new PlanetFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, planetFragment, "planetfragment").commit();
                break;
        }
    }
}