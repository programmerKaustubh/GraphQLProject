package com.kmema.android.graphqlproject.Film;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.kmema.android.graphqlproject.AllFilmQuery;
import com.kmema.android.graphqlproject.NetworkClient.MyApolloClient;
import com.kmema.android.graphqlproject.R;
import com.kmema.android.graphqlproject.dummy.DummyContent.DummyItem;

import java.util.List;

import javax.annotation.Nonnull;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class FilmFragment extends Fragment implements FilmClickListner{

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 3;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FilmFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FilmFragment newInstance(int columnCount) {
        FilmFragment fragment = new FilmFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
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
        View view = inflater.inflate(R.layout.fragment_film_list, container, false);
        getFilms(view);
        return view;
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
/*        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void filmRecyclerViewClickListener(View view, AllFilmQuery.Film film) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FilmDetailFragment filmDetailFragment = new FilmDetailFragment();
        Bundle bundle = new Bundle();
        FilmModel filmModel = new FilmModel();

        filmModel.setTitle(film.title());
        filmModel.setEdited(String.valueOf(film.episodeID()));
        filmModel.setOpeningCrawl(film.openingCrawl());
        filmModel.setDirector(film.director());
        filmModel.setProducers(String.valueOf(film.producers()));
        filmModel.setReleaseDate(film.releaseDate());
        filmModel.setCreated(film.created());
        filmModel.setEdited(film.edited());
        bundle.putSerializable("FilmModel",filmModel);

        /*bundle.putString("title",film.title());
        bundle.putString("episodeID", String.valueOf(film.episodeID()));
        bundle.putString("openingCrawl",film.openingCrawl());
        bundle.putString("director",film.director());
        bundle.putString("producer", String.valueOf(film.producers()));
        bundle.putString("releasedate",film.releaseDate());
        bundle.putString("created",film.created());
        bundle.putString("edited",film.edited());*/
        filmDetailFragment.setArguments(bundle);
        filmDetailFragment.show(fragmentManager,"filmDialog");
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
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }

    private static final String TAG = "Film Fragment";

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
        public void onFailure(@Nonnull ApolloException e) {
            Log.e(TAG, "ON RESPONSE ERROR" + e.getMessage());
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
