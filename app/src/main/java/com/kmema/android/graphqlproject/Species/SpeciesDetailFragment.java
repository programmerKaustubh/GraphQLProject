package com.kmema.android.graphqlproject.Species;

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

public class SpeciesDetailFragment extends DialogFragment {

    @BindView(R.id.textViewNameSpecies)
    TextView textViewSpeciesName;

    @BindView(R.id.textViewClassification)
    TextView textViewClassification;

    @BindView(R.id.textViewDesignation)
    TextView textViewDesignation;

    @BindView(R.id.textViewAverageHeight)
    TextView textViewAverageHeight;

    @BindView(R.id.textViewLifeSpan)
    TextView textViewAverageLifeSpan;


    @BindView(R.id.textViewEyeColorsSpecies)
    TextView textViewEyeColor;

    @BindView(R.id.textViewHairColorsSpecies)
    TextView textViewHairColor;

    @BindView(R.id.textViewSkinColorSpecies)
    TextView textViewSkinColorSpecies;

    @BindView(R.id.textViewLanguage)
    TextView textViewLanguage;

    @BindView(R.id.textViewCreatedSpecies)
    TextView textViewCreatedSpecies;

    @BindView(R.id.textViewEditedSpecies)
    TextView textViewEditedSpecies;


    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail_dialog_species, container);
        unbinder = ButterKnife.bind(this, view);

        SpeciesModel speciesModel = (SpeciesModel) getArguments().getSerializable("SpeciesModel");
        textViewSpeciesName.setText(speciesModel.getName());
        textViewSpeciesName.setSelected(true);

        textViewClassification.setText(speciesModel.getClassification());
        textViewClassification.setSelected(true);

        textViewDesignation.setText(speciesModel.getDesignation());
        textViewDesignation.setSelected(true);

        textViewAverageHeight.setText(speciesModel.getAverageHeight());
        textViewAverageHeight.setSelected(true);

        textViewAverageLifeSpan.setText(speciesModel.getAverageLifespan());
        textViewAverageLifeSpan.setSelected(true);

        textViewEyeColor.setText(speciesModel.getEyeColors());
        textViewEyeColor.setSelected(true);

        textViewSkinColorSpecies.setText(speciesModel.getSkinColors());
        textViewSkinColorSpecies.setSelected(true);

        textViewHairColor.setText(speciesModel.getHairColors());
        textViewHairColor.setSelected(true);

        textViewLanguage.setText(speciesModel.getLanguage());
        textViewLanguage.setSelected(true);

        textViewCreatedSpecies.setText(speciesModel.getCreated());
        textViewCreatedSpecies.setSelected(true);

        textViewEditedSpecies.setText(speciesModel.getEdited());
        textViewEditedSpecies.setSelected(true);
        return view;
    }

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
