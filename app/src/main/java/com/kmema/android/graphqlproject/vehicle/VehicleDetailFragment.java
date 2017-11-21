package com.kmema.android.graphqlproject.vehicle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kmema.android.graphqlproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by kmema on 11/17/2017.
 */


/**
 * {@link VehicleDetailFragment} Displays Vehicle information in DialogFragment with left to right transition animation
 */
public class VehicleDetailFragment extends DialogFragment {

    @BindView(R.id.textViewNameVehicle)
    TextView textViewVehicleName;

    @BindView(R.id.textViewModelVehicle)
    TextView textViewModelModel;

    @BindView(R.id.textViewvehicleClass)
    TextView textViewVehicleClass;

    @BindView(R.id.textViewManufacturers)
    TextView textViewManufacturers;

    @BindView(R.id.textViewCostInCredits)
    TextView textViewCostInCredits;

    @BindView(R.id.textViewLength)
    TextView textViewLenght;

    @BindView(R.id.textViewCrew)
    TextView textViewCrew;

    @BindView(R.id.textViewPassengers)

    TextView textViewPassengers;

    @BindView(R.id.textViewmaxAtmospheringSpeed)
    TextView textViewAtmospheringSpeed;

    @BindView(R.id.textViewcargoCapacity)
    TextView textViewCargoCapacity;

    @BindView(R.id.textViewConsumables)
    TextView textViewConsumables;

    @BindView(R.id.textViewCreatedVehicle)
    TextView textViewCreated;

    @BindView(R.id.textViewEditedVehicle)
    TextView textViewEdited;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail_dialog_vehicle, container);
        unbinder = ButterKnife.bind(this, view);
        VehicleDataModel vehicleDataModel = (VehicleDataModel) getArguments().getSerializable("VehicleDataModel");
        textViewVehicleName.setText(vehicleDataModel.getName());
        textViewVehicleName.setSelected(true);
        textViewModelModel.setText(vehicleDataModel.getModel());
        textViewModelModel.setSelected(true);
        textViewVehicleName.setText(vehicleDataModel.getVehicleClass());
        textViewVehicleClass.setSelected(true);
        textViewManufacturers.setText(vehicleDataModel.getManufacturers());
        textViewManufacturers.setSelected(true);
        textViewCostInCredits.setText(vehicleDataModel.getCostInCredits());
        textViewCostInCredits.setSelected(true);
        textViewLenght.setText(vehicleDataModel.getLength());
        textViewLenght.setSelected(true);
        textViewCrew.setText(vehicleDataModel.getCrew());
        textViewCrew.setSelected(true);
        textViewPassengers.setText(vehicleDataModel.getPassengers());
        textViewPassengers.setSelected(true);
        textViewAtmospheringSpeed.setText(vehicleDataModel.getMaxAtmospheringSpeed());
        textViewAtmospheringSpeed.setSelected(true);
        textViewCargoCapacity.setText(vehicleDataModel.getCargoCapacity());
        textViewCargoCapacity.setSelected(true);
        textViewConsumables.setText(vehicleDataModel.getConsumables());
        textViewConsumables.setSelected(true);
        textViewCreated.setText(vehicleDataModel.getCreated());
        textViewCreated.setSelected(true);
        textViewEdited.setText(vehicleDataModel.getEdited());
        return view;
    }

    /**
     * onStart displaying animation for VehicleFragment
     */

    @Override
    public void onStart() {
        if (getDialog() == null) {
            return;
        }
        getDialog().getWindow().setWindowAnimations(R.style.DialogSlide);
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
