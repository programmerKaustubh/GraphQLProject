package com.kmema.android.graphqlproject.vehicle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kmema.android.graphqlproject.AllVehicleQuery;
import com.kmema.android.graphqlproject.R;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link VehicleDetailFragment} and makes a call to the
 * specified {@link VehicleClickListner}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyVehicleRecyclerViewAdapter extends RecyclerView.Adapter<MyVehicleRecyclerViewAdapter.ViewHolder> {

    private final List<AllVehicleQuery.Vehicle> mValues;
    private final VehicleClickListner vehicleClickListner;
    private final Context context;
    public MyVehicleRecyclerViewAdapter(List<AllVehicleQuery.Vehicle> items, Context context, VehicleClickListner vehicleClickListner) {
        mValues = items;
        this.context = context;
        this.vehicleClickListner = vehicleClickListner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_vehicle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mVehicleName.setText(mValues.get(position).name());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != vehicleClickListner) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                vehicleClickListner.VehicleRecyclerViewClickListener(v, mValues.get(position));
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
        public final TextView mVehicleName;
        public AllVehicleQuery.Vehicle mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mVehicleName = view.findViewById(R.id.textViewVehicleGrid);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mVehicleName.getText() + "'";
        }
    }
}
