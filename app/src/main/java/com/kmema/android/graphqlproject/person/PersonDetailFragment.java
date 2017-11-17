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
        textViewName.setText(getArguments().getString("name"));
        textViewName.setSelected(true);
        textViewBirthday.setText(getArguments().getString("birthday"));
        textViewBirthday.setSelected(true);
        textViewEyeColor.setText(getArguments().getString("eyecolor"));
        textViewEyeColor.setSelected(true);
        textViewGender.setText(getArguments().getString("gender"));
        textViewGender.setSelected(true);
        textViewHairColor.setText(getArguments().getString("haircolor"));
        textViewHairColor.setSelected(true);
        textViewHeight.setText(getArguments().getString("height"));
        textViewHeight.setSelected(true);
        textViewMass.setText(getArguments().getString("mass"));
        textViewMass.setSelected(true);
        textViewSkinColor.setText(getArguments().getString("skincolor"));
        textViewSkinColor.setSelected(true);
        textViewCreated.setText(getArguments().getString("created"));
        textViewCreated.setSelected(true);
        textViewEdited.setText(getArguments().getString("edited"));
        textViewEdited.setSelected(true);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
