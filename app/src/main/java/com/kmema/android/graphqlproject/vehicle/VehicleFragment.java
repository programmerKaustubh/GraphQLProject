package com.kmema.android.graphqlproject.vehicle;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.kmema.android.graphqlproject.AllVehicleQuery;
import com.kmema.android.graphqlproject.NetworkClient.MyApolloClient;
import com.kmema.android.graphqlproject.R;
import com.kmema.android.graphqlproject.dummy.DummyContent.DummyItem;

import java.util.List;

import javax.annotation.Nonnull;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link
 * //OnListFragmentInteractionListener}
 * interface.
 */
public class VehicleFragment extends Fragment implements  VehicleClickListner{

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public VehicleFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vehicle_list, container, false);
        getVehicle(view);
        return view;
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
     /*   if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void VehicleRecyclerViewClickListener(View view, AllVehicleQuery.Vehicle vehicle) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        VehicleDetailFragment vehicleDetailFragment = new VehicleDetailFragment();
        VehicleDataModel  vehicleDataModel = new VehicleDataModel();
        vehicleDataModel.setName(vehicle.name());
        vehicleDataModel.setVehicleClass(vehicle.vehicleClass());
        vehicleDataModel.setManufacturers(String.valueOf(vehicle.manufacturers()));
        vehicleDataModel.setCostInCredits(String.valueOf(vehicle.costInCredits()));
        vehicleDataModel.setLength(String.valueOf(vehicle.length()));
        vehicleDataModel.setCrew(vehicle.crew());
        vehicleDataModel.setPassengers(vehicle.passengers());
        vehicleDataModel.setMaxAtmospheringSpeed(String.valueOf(vehicle.maxAtmospheringSpeed()));
        vehicleDataModel.setCargoCapacity(String.valueOf(vehicle.cargoCapacity()));
        vehicleDataModel.setConsumables(vehicle.consumables());
        vehicleDataModel.setCreated(vehicle.created());
        vehicleDataModel.setEdited(vehicle.edited());
        Bundle bundle = new Bundle();
        bundle.putSerializable("VehicleDataModel", vehicleDataModel);
        vehicleDetailFragment.setArguments(bundle);
        vehicleDetailFragment.show(fragmentManager,"vehicleDialog");
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    private static final String TAG = "Person Fragment: ";
    private void getVehicle(final View view) {
        MyApolloClient.getMyApolloClient().query(
                AllVehicleQuery.builder().build()).enqueue(new ApolloCall.Callback<AllVehicleQuery.Data>() {
            @Override
            public void onResponse(@Nonnull final Response<AllVehicleQuery.Data> response) {
                if(getActivity()==null)
                {
                    return;
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        attachVehicleDataToRecyclerView(view, response.data().allVehicles().vehicles());
                    }
                });
            }
            @Override
            public void onFailure(@Nonnull ApolloException e) {

            }
        });

    }

    private void attachVehicleDataToRecyclerView(View view, List<AllVehicleQuery.Vehicle> vehicles) {
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            recyclerView.setAdapter(new MyVehicleRecyclerViewAdapter(vehicles,context,this));
        }
    }
}
