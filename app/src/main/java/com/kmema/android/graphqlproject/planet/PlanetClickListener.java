package com.kmema.android.graphqlproject.planet;

import android.view.View;

import com.kmema.android.graphqlproject.AllPlanetQuery;

/**
 * Created by kmema on 11/16/2017.
 */

interface PlanetClickListener {
    void planetRecyclerViewClickListener(View view, AllPlanetQuery.Planet planet);
}
