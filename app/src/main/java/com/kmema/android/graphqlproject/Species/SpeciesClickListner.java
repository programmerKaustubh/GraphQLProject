package com.kmema.android.graphqlproject.Species;

import android.view.View;

import com.kmema.android.graphqlproject.AllSpeciesQuery;

/**
 * Created by kmema on 11/17/2017.
 */

/**
 * {@link SpeciesClickListner} need be implemented by Fragments/Activities to listen to click on Recycler
 * {@link MySpeciesRecyclerViewAdapter}
 */

interface SpeciesClickListner  {
    void SpeciesRecyclerViewClickListener(View view, AllSpeciesQuery.Species species);
}
