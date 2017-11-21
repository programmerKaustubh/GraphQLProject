
package com.kmema.android.graphqlproject.person;

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
import com.kmema.android.graphqlproject.AllPeopleQuery;
import com.kmema.android.graphqlproject.NetworkClient.MyApolloClient;
import com.kmema.android.graphqlproject.R;

import java.util.List;

import javax.annotation.Nonnull;

/**
 * A fragment representing a list of Items @{@link PersonDataModel } and @{@link PersonDetailFragment}.
 *
 */
public class PersonFragment extends Fragment implements PersonClickListner {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 3;
    private static final String TAG = "Person Fragment: ";


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PersonFragment() {
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
        View view = inflater.inflate(R.layout.fragment_person_list, container, false);
        getPeople(view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        android.support.v7.app.ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorGreen)));
            actionBar.setTitle("Person Fragment");
        }
        Window window = getActivity().getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.colorGreenDark));
    }

    @Override
    public void personRecyclerViewClickListener(View view, AllPeopleQuery.person person) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        PersonDetailFragment personDetailFragment = new PersonDetailFragment();
        Bundle bundle = new Bundle();
        PersonDataModel personDataModel = new PersonDataModel();
        personDataModel.setName(person.name());
        personDataModel.setBirthYear(person.birthYear());
        personDataModel.setEyeColor(person.eyeColor());
        personDataModel.setGender(person.gender());
        personDataModel.setHairColor(person.hairColor());
        personDataModel.setHeight(String.valueOf(person.height()));
        personDataModel.setMass(String.valueOf(person.mass()));
        personDataModel.setSkinColor(person.skinColor());
        personDataModel.setCreated(person.created());
        personDataModel.setEdited(person.edited());
        bundle.putSerializable("PersonDataModel", personDataModel);
        personDetailFragment.setArguments(bundle);
        personDetailFragment.show(fragmentManager, "personDialog");
    }

    private void getPeople(final View view) {
        MyApolloClient.getMyApolloClient().query(
                AllPeopleQuery.builder().build()).enqueue(new ApolloCall.Callback<AllPeopleQuery.Data>() {
            @Override
            public void onResponse(@Nonnull final Response<AllPeopleQuery.Data> response) {
                if (getActivity() == null) {
                    return;
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        attachPeopleDataToRecyclerView(view, response.data().allPeople().people());
                    }
                });
            }

            @Override
            public void onFailure(@Nonnull final ApolloException e) {
                if (getActivity() == null) {
                    return;
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity().getBaseContext(), "Check Network Connection " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private void attachPeopleDataToRecyclerView(View view, List<AllPeopleQuery.person> people) {

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            recyclerView.setAdapter(new MyPersonRecyclerViewAdapter(people, getContext(), this));
        }
    }
}