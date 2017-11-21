package com.kmema.android.graphqlproject.person;
import android.view.View;
import com.kmema.android.graphqlproject.AllPeopleQuery;

/**
 * {@link PersonClickListner}need be implemented by Fragments/Activities to listen to click on Recycler
 * {@link MyPersonRecyclerViewAdapter}
 */
interface PersonClickListner {
    void personRecyclerViewClickListener(View view, AllPeopleQuery.person person);
}
