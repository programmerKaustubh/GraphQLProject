package com.kmema.android.graphqlproject.planet;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.kmema.android.graphqlproject.AllPlanetQuery;
import com.kmema.android.graphqlproject.NetworkClient.MyApolloClient;
import com.kmema.android.graphqlproject.R;

import java.util.List;

import javax.annotation.Nonnull;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link }
 * interface.
 */
public class PlanetFragment extends Fragment implements PlanetClickListener {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 3;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PlanetFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        PlanetModel planetModel = new PlanetModel();
        planetModel.setName(planet.name());
        planetModel.setDiameter(String.valueOf(planet.diameter()));
        planetModel.setRotationPeriod(String.valueOf(planet.rotationPeriod()));
        planetModel.setOrbitalPeriod(String.valueOf(planet.orbitalPeriod()));
        planetModel.setGravity(planet.gravity());
        planetModel.setPopulation(String.valueOf(planet.population()));
        planetModel.setClimates(String.valueOf(planet.climates()));
        planetModel.setTerrains(String.valueOf(planet.terrains()));
        planetModel.setSurfaceWater(String.valueOf(planet.surfaceWater()));
        planetModel.setCreated(planet.created());
        planetModel.setEdited(planet.edited());
        bundle.putSerializable("PlanetModel",planetModel);
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
                    public void onFailure(@Nonnull ApolloException e) {
                        // TODO: 11/17/2017 handle onFailure condition
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
