package com.kmema.android.graphqlproject.vehicle;

import android.view.View;

import com.kmema.android.graphqlproject.AllVehicleQuery;

/**
 * Created by kmema on 11/17/2017.
 */

/**
 * {@link VehicleClickListner} need be implemented by Fragments/Activities to listen to click on Recycler
 * {@link MyVehicleRecyclerViewAdapter}
 */

interface VehicleClickListner {
    void VehicleRecyclerViewClickListener(View view, AllVehicleQuery.Vehicle vehicle);
}
