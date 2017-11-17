package com.kmema.android.graphqlproject.Film;

import android.view.View;

import com.kmema.android.graphqlproject.AllFilmQuery;

/**
 * Created by kmema on 11/16/2017.
 */

public interface FilmClickListner {
    void filmRecyclerViewClickListener(View view, AllFilmQuery.Film person);
}
