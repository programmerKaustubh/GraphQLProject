package com.kmema.android.graphqlproject.Film;

import java.io.Serializable;

/**
 * Created by kmema on 11/17/2017.
 */

class FilmDataModel implements Serializable{
    private String title;
    private String episodeID;
    private String openingCrawl;
    private String director;
    private String producers;
    private String releaseDate;
    private String created;
    private String edited;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String getEpisodeID() {
        return episodeID;
    }

    public void setEpisodeID(String episodeID) {
        this.episodeID = episodeID;
    }

    String getOpeningCrawl() {
        return openingCrawl;
    }

    void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    String getDirector() {
        return director;
    }

    void setDirector(String director) {
        this.director = director;
    }

    String getProducers() {
        return producers;
    }

    void setProducers(String producers) {
        this.producers = producers;
    }

    String getReleaseDate() {
        return releaseDate;
    }

    void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }
}
