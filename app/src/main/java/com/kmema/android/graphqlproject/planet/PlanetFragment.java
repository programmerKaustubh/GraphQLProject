package com.kmema.android.graphqlproject.planet;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.kmema.android.graphqlproject.AllPlanetQuery;
import com.kmema.android.graphqlproject.Film.FilmDataModel;
import com.kmema.android.graphqlproject.Film.FilmDetailFragment;
import com.kmema.android.graphqlproject.NetworkClient.MyApolloClient;
import com.kmema.android.graphqlproject.R;

import java.util.List;

import javax.annotation.Nonnull;

/**
 * A fragment representing a list of Items @{@link PlanetDataModel } and @{@link PlanetDetailFragment}.
 */
public class PlanetFragment extends Fragment implements PlanetClickListener {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 3;
    private static final String TAG = "Planet Fragment: ";
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PlanetFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planet_list, container, false);
        getPlanet(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        android.support.v7.app.ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPurpleLight)));
            actionBar.setTitle("Planet Fragment");
        }
        Window window = getActivity().getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.colorPurple));
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
    @Override
    public void planetRecyclerViewClickListener(View view, AllPlanetQuery.Planet planet) {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        PlanetDetailFragment planetDetailFragment = new PlanetDetailFragment();
        Bundle bundle = new Bundle();
        PlanetDataModel planetDataModel = new PlanetDataModel();
        planetDataModel.setName(planet.name());
        planetDataModel.setDiameter(String.valueOf(planet.diameter()));
        planetDataModel.setRotationPeriod(String.valueOf(planet.rotationPeriod()));
        planetDataModel.setOrbitalPeriod(String.valueOf(planet.orbitalPeriod()));
        planetDataModel.setGravity(planet.gravity());
        planetDataModel.setPopulation(String.valueOf(planet.population()));
        planetDataModel.setClimates(String.valueOf(planet.climates()));
        planetDataModel.setTerrains(String.valueOf(planet.terrains()));
        planetDataModel.setSurfaceWater(String.valueOf(planet.surfaceWater()));
        planetDataModel.setCreated(planet.created());
        planetDataModel.setEdited(planet.edited());
        bundle.putSerializable("PlanetDataModel", planetDataModel);
        planetDetailFragment.setArguments(bundle);
        planetDetailFragment.show(fragmentManager, "planetDialog");
    }

    private void getPlanet(final View view) {
        MyApolloClient.getMyApolloClient().query(AllPlanetQuery.builder().build()).enqueue(
                new ApolloCall.Callback<AllPlanetQuery.Data>() {
                    @Override
                    public void onResponse(@Nonnull final Response<AllPlanetQuery.Data> response) {
                        if (getActivity() == null) {
                            return;
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                attachPlanetDataToRecyclerView(view, response.data().allPlanets().planets());
                            }
                        });
                    }
                    @Override
                    public void onFailure(@Nonnull final ApolloException e) {
                        if(getActivity() == null)
                        {
                            return;
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity().getBaseContext(), "Check Network Connection"+ e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
                        Log.e(TAG, "ON RESPONSE ERROR" + e.getLocalizedMessage());
                    }
                }
        );
    }

    private void attachPlanetDataToRecyclerView(View view, List<AllPlanetQuery.Planet> planets) {

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            recyclerView.setAdapter(new MyPlanetRecyclerViewAdapter(planets, getContext(), this));
        }
    }
}
