package com.kmema.android.graphqlproject.planet;

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


public class PlanetDetailFragment extends DialogFragment {

    @BindView(R.id.textViewNamePlanet)
    TextView textViewNamePlanet;

    @BindView(R.id.textViewDiameter)
    TextView textViewDiameter;

    @BindView(R.id.textViewRotationPeriod)
    TextView textViewRotationPeroid;

    @BindView(R.id.textViewOrbitalPeriod)
    TextView textViewOrbitalPeriod;

    @BindView(R.id.textViewGravity)
    TextView textViewGravity;

    @BindView(R.id.textViewPopulation)
    TextView textViewPopulation;

    @BindView(R.id.textViewClimate)
    TextView textViewClimate;

    @BindView(R.id.textViewTerrains)
    TextView textViewTeerrains;

    @BindView(R.id.textViewSurfaceWater)
    TextView textViewSurfaceWater;

    @BindView(R.id.textViewCreatedPlanet)
    TextView textViewCreatedPlanet;

    @BindView(R.id.textViewEditedPlanet)
    TextView textViewEditedPlanet;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail_dialog_planet, container);
        unbinder = ButterKnife.bind(this, view);
        PlanetDataModel planetDataModel = (PlanetDataModel) getArguments().getSerializable("PlanetDataModel");

        textViewNamePlanet.setText(planetDataModel.getName());
        textViewNamePlanet.setSelected(true);
        textViewDiameter.setText(planetDataModel.getDiameter());
        textViewDiameter.setSelected(true);
        textViewRotationPeroid.setText(planetDataModel.getRotationPeriod());
        textViewRotationPeroid.setSelected(true);
        textViewOrbitalPeriod.setText(planetDataModel.getOrbitalPeriod());
        textViewOrbitalPeriod.setSelected(true);
        textViewGravity.setText(planetDataModel.getGravity());
        textViewGravity.setSelected(true);
        textViewPopulation.setText(planetDataModel.getPopulation());
        textViewPopulation.setSelected(true);
        textViewClimate.setText(planetDataModel.getClimates());
        textViewClimate.setSelected(true);
        textViewTeerrains.setText(planetDataModel.getTerrains());
        textViewTeerrains.setSelected(true);
        textViewSurfaceWater.setText(planetDataModel.getSurfaceWater());
        textViewSurfaceWater.setSelected(true);
        textViewCreatedPlanet.setText(planetDataModel.getCreated());
        textViewCreatedPlanet.setSelected(true);
        textViewEditedPlanet.setText(planetDataModel.getEdited());
        textViewEditedPlanet.setSelected(true);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onStart() {
        if(getDialog()==null)
        {
            return;
        }
        getDialog().getWindow().setWindowAnimations(R.style.DialogSlide);
        super.onStart();
    }
}
