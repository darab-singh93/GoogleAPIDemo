package com.example.darabsingh.googleapidemo;

import com.example.darabsingh.googleapidemo.pojos.Places;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlacesAPI {
    @GET("maps/api/place/nearbysearch/json?location=-33.8670,151.1957&radius=500&types=atm&key=AIzaSyATpqO-kiO4F1BpFhChlRSGUeXivHqC05s")
    Call<Places> getPlaces();
}
