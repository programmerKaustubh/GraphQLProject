package com.kmema.android.graphqlproject.Film;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kmema.android.graphqlproject.AllFilmQuery;
import com.kmema.android.graphqlproject.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link FilmDetailFragment} and makes a call to the
 * specified {@link FilmClickListner}.
 *
 */
public class MyFilmRecyclerViewAdapter extends RecyclerView.Adapter<MyFilmRecyclerViewAdapter.ViewHolder> {

    private final List<AllFilmQuery.Film> mValues;
    Context context;
    private final FilmClickListner filmClickListner;

    public MyFilmRecyclerViewAdapter(List<AllFilmQuery.Film> items, Context context, FilmClickListner filmClickListner) {
        mValues = items;
        this.context = context;
        this.filmClickListner = filmClickListner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_film, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mFilmName.setText(mValues.get(position).title());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != filmClickListner) {
                    filmClickListner.filmRecyclerViewClickListener(v, mValues.get(position));
                    Toast.makeText(context, "" + mValues.get(position).title(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mFilmName;
        AllFilmQuery.Film mItem;
        ViewHolder(View view) {
            super(view);
            mView = view;
            mFilmName = view.findViewById(R.id.textViewFilmGrid);
        }
        @Override
        public String toString() {
            return super.toString() + " '" + mFilmName.getText() + "'";
        }
    }
}
