package com.kmema.android.graphqlproject.person;
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


public class PersonDetailFragment extends DialogFragment {

    @BindView(R.id.textViewName)
    TextView textViewName;

    @BindView(R.id.textViewBirthyear)
    TextView textViewBirthday;

    @BindView(R.id.textViewEyeColor)
    TextView textViewEyeColor;

    @BindView(R.id.textViewGender)
    TextView textViewGender;

    @BindView(R.id.textViewHairColor)
    TextView textViewHairColor;

    @BindView(R.id.textViewHeight)
    TextView textViewHeight;

    @BindView(R.id.textViewMass)
    TextView textViewMass;

    @BindView(R.id.textViewSkinColor)
    TextView textViewSkinColor;

    @BindView(R.id.textViewCreated)
    TextView textViewCreated;

    @BindView(R.id.textViewEdited)
    TextView textViewEdited;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_dialog_person, container);
        unbinder = ButterKnife.bind(this, view);
        PersonModel personModel = (PersonModel) getArguments().getSerializable("PersonModel");
        textViewName.setText(personModel.getName());
        textViewName.setSelected(true);
        textViewBirthday.setText(personModel.getBirthYear());
        textViewBirthday.setSelected(true);
        textViewEyeColor.setText(personModel.getEyeColor());
        textViewEyeColor.setSelected(true);
        textViewGender.setText(personModel.getGender());
        textViewGender.setSelected(true);
        textViewHairColor.setText(personModel.getHairColor());
        textViewHairColor.setSelected(true);
        textViewHeight.setText(personModel.getHeight());
        textViewHeight.setSelected(true);
        textViewMass.setText(personModel.getMass());
        textViewMass.setSelected(true);
        textViewSkinColor.setText(personModel.getSkinColor());
        textViewSkinColor.setSelected(true);
        textViewCreated.setText(personModel.getCreated());
        textViewCreated.setSelected(true);
        textViewEdited.setText(personModel.getEdited());
        textViewEdited.setSelected(true);
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
