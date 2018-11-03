package com.example.darabsingh.googleapidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.darabsingh.googleapidemo.pojos.Places;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);
        listView1=(ListView)findViewById(R.id.listView1);
    }
    public void getPlaces(View v)
    {
        Retrofit r=new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        PlacesAPI places=r.create(PlacesAPI.class);
        Call <Places> call=places.getPlaces();
         call.enqueue(new Callback<Places>() {
             @Override
             public void onResponse(Call<Places> call, Response<Places> response) {
                 Places places1=response.body();
                 //Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                 listView1.setAdapter(new MyAdapter(MainActivity.this,places1));

             }

             @Override
             public void onFailure(Call<Places> call, Throwable t) {

             }
         });

    }
}
