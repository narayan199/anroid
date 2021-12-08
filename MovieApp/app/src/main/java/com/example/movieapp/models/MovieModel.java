package com.example.movieapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel  implements Parcelable {
    //Model Class for All Movie
    private   String title;
    private String poster_path;
    private String release_date;
    private  int id;
    private  float vote_average;
    private String overview;


    //Constructor

    public MovieModel(String title, String poster_path, String release_date, int id, float vote_average, String overview) {
        this.title = title;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.id = id;
        this.vote_average = vote_average;
        this.overview = overview;
    }


    //Geters

    protected MovieModel(Parcel in) {
        title = in.readString();
        poster_path = in.readString();
        release_date = in.readString();
        id = in.readInt();
        vote_average = in.readFloat();
        overview = in.readString();
    }
    //parceable
    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public int getId() {
        return id;
    }

    public float getvote_average() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(poster_path);
        dest.writeString(release_date);
        dest.writeInt(id);
        dest.writeFloat(vote_average);
        dest.writeString(overview);
    }
}
