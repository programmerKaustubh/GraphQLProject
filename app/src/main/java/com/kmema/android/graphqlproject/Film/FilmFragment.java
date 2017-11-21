package com.kmema.android.graphqlproject.Film;

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
import com.kmema.android.graphqlproject.AllFilmQuery;
import com.kmema.android.graphqlproject.NetworkClient.MyApolloClient;
import com.kmema.android.graphqlproject.R;
import java.util.List;

import javax.annotation.Nonnull;

/**
 * A fragment representing a list of Items @{@link FilmDataModel } and @{@link FilmDetailFragment}.
 *
 */
public class FilmFragment extends Fragment implements FilmClickListner{

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 3;
    private static final String TAG = "Film Fragment";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FilmFragment() {
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
        View view = inflater.inflate(R.layout.fragment_film_list, container, false);
        getFilms(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        android.support.v7.app.ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorOrange)));
            actionBar.setTitle("Film Fragment");
        }
        Window window = getActivity().getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.colorRed));
    }

    @Override
    public void filmRecyclerViewClickListener(View view, AllFilmQuery.Film film) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FilmDetailFragment filmDetailFragment = new FilmDetailFragment();
        Bundle bundle = new Bundle();
        FilmDataModel filmDataModel = new FilmDataModel();
        filmDataModel.setTitle(film.title());
        filmDataModel.setEdited(String.valueOf(film.episodeID()));
        filmDataModel.setOpeningCrawl(film.openingCrawl());
        filmDataModel.setDirector(film.director());
        filmDataModel.setProducers(String.valueOf(film.producers()));
        filmDataModel.setReleaseDate(film.releaseDate());
        filmDataModel.setCreated(film.created());
        filmDataModel.setEdited(film.edited());
        bundle.putSerializable("FilmDataModel", filmDataModel);
        filmDetailFragment.setArguments(bundle);
        filmDetailFragment.show(fragmentManager,"filmDialog");
    }

    private void getFilms(final View view) {
    MyApolloClient.getMyApolloClient().query(
            AllFilmQuery.builder().build()).enqueue(new ApolloCall.Callback<AllFilmQuery.Data>() {
        @Override
        public void onResponse(@Nonnull final Response<AllFilmQuery.Data> response) {
            if(getActivity() == null)
            {
                return;
            }
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    attachFilmDataToRecyclerView(view, response.data().allFilms().films());
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

    private void attachFilmDataToRecyclerView(View view, List<AllFilmQuery.Film> films) {
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            recyclerView.setAdapter(new MyFilmRecyclerViewAdapter(films, getContext(),this));
        }
    }
}
