package com.kmema.android.graphqlproject.person;

import android.view.View;

import com.kmema.android.graphqlproject.AllPeopleQuery;


interface PersonClickListner {
    void personRecyclerViewClickListener(View view, AllPeopleQuery.person person);
}
