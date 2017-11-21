package com.kmema.android.graphqlproject;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.kmema.android.graphqlproject.Film.FilmFragment;
import com.kmema.android.graphqlproject.Species.SpeciesFragment;
import com.kmema.android.graphqlproject.person.PersonFragment;
import com.kmema.android.graphqlproject.planet.PlanetFragment;
import com.kmema.android.graphqlproject.vehicle.VehicleFragment;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements NodeClickListener {
    private android.support.v4.app.FragmentManager mFragmentManager;
    private ArrayList<Integer> colorList;
    private static final String CURRENT_FRAGMENT_KEY = "currentFragment";
    private static final String CURRENT_FRAGMENT_NUMBER_KEY = "currentFragmentNumber";
    private static int currentFragment;


    /**
     * @param savedInstanceState to save the instance of old state of activity and related data
     *
     * Loads savedInstanceState or if that is null loads 0th fragment, that is person fragment
     *                           which loads people information
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();

        if (savedInstanceState != null) {
            android.support.v4.app.Fragment fragment = getSupportFragmentManager().getFragment(savedInstanceState, CURRENT_FRAGMENT_KEY);
            mFragmentManager.beginTransaction().replace(R.id.containerLayout, fragment).commit();
            currentFragment = savedInstanceState.getInt(CURRENT_FRAGMENT_NUMBER_KEY);
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
        outState.putInt(CURRENT_FRAGMENT_NUMBER_KEY,currentFragment);
        super.onSaveInstanceState(outState);
    }

    private void updateCurrentFragment(int id) {
        switch (id) {
            case 0:
                PersonFragment personFragment = new PersonFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, personFragment, "personfragment").commit();
                currentFragment = 0;
                break;
            case 1:
                VehicleFragment vehicleFragment = new VehicleFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, vehicleFragment, "vehiclefragment").commit();
                currentFragment = 1;
                break;
            case 2:
                FilmFragment filmFragment = new FilmFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, filmFragment, "filmfragment").commit();
                currentFragment = 2;
                break;
            case 3:
                SpeciesFragment speciesFragment = new SpeciesFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, speciesFragment, "speciesfragment").commit();
                currentFragment = 3;
                break;
            case 4:
                PlanetFragment planetFragment = new PlanetFragment();
                mFragmentManager.beginTransaction().replace(R.id.containerLayout, planetFragment, "planetfragment").commit();
                currentFragment = 4;
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        return  true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.refreshButton:
                updateCurrentFragment(currentFragment);
                break;
        }
        return true;
    }
}