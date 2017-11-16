package com.kmema.android.graphqlproject.Film;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kmema.android.graphqlproject.AllFilmQuery;
import com.kmema.android.graphqlproject.R;
import com.kmema.android.graphqlproject.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link FilmFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyFilmRecyclerViewAdapter extends RecyclerView.Adapter<MyFilmRecyclerViewAdapter.ViewHolder> {

    private final List<AllFilmQuery.Film> mValues;
    private final FilmFragment.OnListFragmentInteractionListener mListener;

    public MyFilmRecyclerViewAdapter(List<AllFilmQuery.Film> items, FilmFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_film, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mFilmName.setText(mValues.get(position).title());


/*
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
*/
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mFilmName;
        public AllFilmQuery.Film mItem;

        public ViewHolder(View view) {
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
