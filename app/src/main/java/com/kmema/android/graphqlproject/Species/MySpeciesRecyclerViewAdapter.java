package com.kmema.android.graphqlproject.Species;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kmema.android.graphqlproject.AllSpeciesQuery;
import com.kmema.android.graphqlproject.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SpeciesDetailFragment} and makes a call to the
 * specified {@link }.
 * TODO: Replace the implementation with code for your data type.
 */
public class MySpeciesRecyclerViewAdapter extends RecyclerView.Adapter<MySpeciesRecyclerViewAdapter.ViewHolder> {

    private final List<AllSpeciesQuery.Species> mValues;

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    private SpeciesClickListner speciesClickListner;
    private Context context;

    public MySpeciesRecyclerViewAdapter(List<AllSpeciesQuery.Species> items, Context context, SpeciesClickListner speciesClickListner) {
        mValues = items;
        this.context = context;
        this.speciesClickListner = speciesClickListner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_species, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mSpeciesName.setText(mValues.get(position).name());
       holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != speciesClickListner) {
                    // Notify the active callbacks interface (the activity/fragment, if the
                    // fragment is attached to one) that an item has been selected.
                    speciesClickListner.SpeciesRecyclerViewClickListener(v,mValues.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mSpeciesName;
        public AllSpeciesQuery.Species mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mSpeciesName = view.findViewById(R.id.textViewSpeciesGrid);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mSpeciesName.getText() + "'";
        }
    }
}
