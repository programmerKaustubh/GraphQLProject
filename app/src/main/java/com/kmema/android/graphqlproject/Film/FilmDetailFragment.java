package com.kmema.android.graphqlproject.Film;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kmema.android.graphqlproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FilmDetailFragment extends android.support.v4.app.DialogFragment {


    @BindView(R.id.textViewTitle)
    TextView textViewTitle;

    @BindView(R.id.textViewEpisode)
    TextView textViewEpisode;

    @BindView(R.id.textViewOpeningCrawl)
    TextView textViewOpeningCrawl;

    @BindView(R.id.textViewDirector)
    TextView textViewDirector;

    @BindView(R.id.textViewProducer)
    TextView textViewProducer;

    @BindView(R.id.textViewReleaseDate)
    TextView textViewReleaseDate;

    @BindView(R.id.textViewCreated)
    TextView textViewCreated;

    @BindView(R.id.textViewEdited)
    TextView textViewEdited;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_dialog_film, container);
        unbinder = ButterKnife.bind(this, view);
        FilmModel filmModel = (FilmModel) getArguments().getSerializable("FilmModel");
        Log.e("FILM MODEL",filmModel.getOpeningCrawl());
        textViewTitle.setText(filmModel.getTitle());
        textViewTitle.setSelected(true);
        textViewEpisode.setText(filmModel.getEpisodeID());
        textViewEpisode.setSelected(true);
        textViewOpeningCrawl.setText(filmModel.getOpeningCrawl());
        textViewOpeningCrawl.setSelected(true);
        textViewDirector.setText(filmModel.getDirector());
        textViewDirector.setSelected(true);
        textViewProducer.setText(filmModel.getProducers());
        textViewProducer.setSelected(true);
        textViewReleaseDate.setText(filmModel.getReleaseDate());
        textViewReleaseDate.setSelected(true);
        textViewCreated.setText(filmModel.getCreated());
        textViewCreated.setSelected(true);
        textViewEdited.setText(filmModel.getEdited());
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
        if (getDialog() == null) {
            return;
        }
        getDialog().getWindow().setWindowAnimations(R.style.DialogSlide);
        super.onStart();
    }
}
