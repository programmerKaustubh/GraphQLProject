package com.kmema.android.graphqlproject.planet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kmema.android.graphqlproject.AllPlanetQuery;
import com.kmema.android.graphqlproject.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlanetDetailFragment} and makes a call to the
 * specified {@link PlanetClickListener}.
 *  */
public class MyPlanetRecyclerViewAdapter extends RecyclerView.Adapter<MyPlanetRecyclerViewAdapter.ViewHolder> {
    private final List<AllPlanetQuery.Planet> mValues;
    private Context context;
    private PlanetClickListener planetClickListener;

    MyPlanetRecyclerViewAdapter(List<AllPlanetQuery.Planet> items, Context context, PlanetClickListener planetClickListener) {
        mValues = items;
        this.context = context;
        this.planetClickListener = planetClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_planet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mPlanetName.setText(mValues.get(position).name());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != planetClickListener) {
                    planetClickListener.planetRecyclerViewClickListener(v,mValues.get(position));
                    Toast.makeText(context, ""+ mValues.get(position).name(), Toast.LENGTH_SHORT).show();
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
        final TextView mPlanetName;
        AllPlanetQuery.Planet mItem;

        ViewHolder(View view) {
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
