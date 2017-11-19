package com.kmema.android.graphqlproject.Species;

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
import com.kmema.android.graphqlproject.AllSpeciesQuery;
import com.kmema.android.graphqlproject.Film.FilmDetailFragment;
import com.kmema.android.graphqlproject.NetworkClient.MyApolloClient;
import com.kmema.android.graphqlproject.R;
import java.util.List;

import javax.annotation.Nonnull;

/**
 * A fragment representing a list of Items @{@link SpeciesDataModel } and @{@link SpeciesDetailFragment}.
 *
 */
public class SpeciesFragment extends Fragment implements SpeciesClickListner{

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 3;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SpeciesFragment() {
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
        View view = inflater.inflate(R.layout.fragment_species_list, container, false);
        getSpecies(view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        android.support.v7.app.ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorBlueLight)));
            actionBar.setTitle("Species Fragment");
        }
        Window window = getActivity().getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.colorBlue));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    @Override
    public void SpeciesRecyclerViewClickListener(View view, AllSpeciesQuery.Species species) {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        SpeciesDetailFragment speciesDetailFragment = new SpeciesDetailFragment();
        SpeciesDataModel speciesDataModel = new SpeciesDataModel();
        Bundle bundle = new Bundle();
        speciesDataModel.setName(species.name());
        speciesDataModel.setClassification(species.classification());
        speciesDataModel.setDesignation(species.designation());
        speciesDataModel.setAverageHeight(String.valueOf(species.averageHeight()));
        speciesDataModel.setAverageLifespan(String.valueOf(species.averageLifespan()));
        speciesDataModel.setEyeColors(String.valueOf(species.eyeColors()));
        speciesDataModel.setHairColors(String.valueOf(species.hairColors()));
        speciesDataModel.setSkinColors(String.valueOf(species.skinColors()));
        speciesDataModel.setLanguage(species.language());
        speciesDataModel.setCreated(species.created());
        speciesDataModel.setEdited(species.edited());
        bundle.putSerializable("SpeciesDataModel", speciesDataModel);
        speciesDetailFragment.setArguments(bundle);
        speciesDetailFragment.show(fragmentManager,"speciesDialog");
    }


    private static final String TAG = "Fragment Species";
    private void getSpecies(final View view) {

        MyApolloClient.getMyApolloClient().query(AllSpeciesQuery.builder().build()).enqueue(new ApolloCall.Callback<AllSpeciesQuery.Data>() {
            @Override
            public void onResponse(@Nonnull final Response<AllSpeciesQuery.Data> response) {
                if (getActivity() == null) {
                    return;
                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        attachSpeciesDataToRecyclerView(view, response.data().allSpecies().species());
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
        });

    }

    private void attachSpeciesDataToRecyclerView(View view, List<AllSpeciesQuery.Species> species) {
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            recyclerView.setAdapter(new MySpeciesRecyclerViewAdapter(species, context,this));
        }
    }
}
