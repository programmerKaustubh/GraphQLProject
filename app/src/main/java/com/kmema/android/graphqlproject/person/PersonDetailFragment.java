package com.kmema.android.graphqlproject.person;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        unbinder = ButterKnife.bind(this, view);
        PersonDataModel personDataModel = (PersonDataModel) getArguments().getSerializable("PersonDataModel");
        textViewName.setText(personDataModel.getName());
        textViewName.setSelected(true);
        textViewBirthday.setText(personDataModel.getBirthYear());
        textViewBirthday.setSelected(true);
        textViewEyeColor.setText(personDataModel.getEyeColor());
        textViewEyeColor.setSelected(true);
        textViewGender.setText(personDataModel.getGender());
        textViewGender.setSelected(true);
        textViewHairColor.setText(personDataModel.getHairColor());
        textViewHairColor.setSelected(true);
        textViewHeight.setText(personDataModel.getHeight());
        textViewHeight.setSelected(true);
        textViewMass.setText(personDataModel.getMass());
        textViewMass.setSelected(true);
        textViewSkinColor.setText(personDataModel.getSkinColor());
        textViewSkinColor.setSelected(true);
        textViewCreated.setText(personDataModel.getCreated());
        textViewCreated.setSelected(true);
        textViewEdited.setText(personDataModel.getEdited());
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
