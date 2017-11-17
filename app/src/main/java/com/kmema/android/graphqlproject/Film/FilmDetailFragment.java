package com.kmema.android.graphqlproject.Film;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        textViewTitle.setText(getArguments().getString("title"));
        textViewTitle.setSelected(true);
        textViewEpisode.setText(getArguments().getString("episodeID"));
        textViewEpisode.setSelected(true);
        textViewOpeningCrawl.setText(getArguments().getString("openingCrawl"));
        textViewOpeningCrawl.setSelected(true);
        textViewDirector.setText(getArguments().getString("director"));
        textViewDirector.setSelected(true);
        textViewProducer.setText(getArguments().getString("producer"));
        textViewProducer.setSelected(true);
        textViewReleaseDate.setText(getArguments().getString("releasedate"));
        textViewReleaseDate.setSelected(true);
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
