package com.kmema.android.graphqlproject.person;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kmema.android.graphqlproject.R;

/**
 * Created by kmema on 11/15/2017.
 */

public class PersonDetailFragment extends DialogFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.detail_dialog_person,container);
            return view;
    }
}
