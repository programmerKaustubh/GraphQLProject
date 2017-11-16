package com.kmema.android.graphqlproject.planet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kmema.android.graphqlproject.AllPlanetQuery;
import com.kmema.android.graphqlproject.R;
import com.kmema.android.graphqlproject.planet.PlanetFragment.OnListFragmentInteractionListener;
import com.kmema.android.graphqlproject.planet.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPlanetRecyclerViewAdapter extends RecyclerView.Adapter<MyPlanetRecyclerViewAdapter.ViewHolder> {

    private final List<AllPlanetQuery.Planet> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyPlanetRecyclerViewAdapter(List<AllPlanetQuery.Planet> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_planet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mPlanetName.setText(mValues.get(position).name());


/*        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mPlanetName;
        public AllPlanetQuery.Planet mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPlanetName = view.findViewById(R.id.textViewPlanetGrid);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mPlanetName.getText() + "'";
        }
    }
}
