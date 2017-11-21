package com.kmema.android.graphqlproject.planet;

import android.view.View;

import com.kmema.android.graphqlproject.AllPlanetQuery;

/**
 * Created by kmema on 11/16/2017.
 */


/**
 * {@link PlanetClickListener} need be implemented by Fragments/Activities to listen to click on Recycler
 * {@link MyPlanetRecyclerViewAdapter}
 */
interface PlanetClickListener {
    void planetRecyclerViewClickListener(View view, AllPlanetQuery.Planet planet);
}
