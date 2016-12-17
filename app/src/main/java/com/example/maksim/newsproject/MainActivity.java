package com.example.maksim.newsproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.maksim.newsproject.Adapter.NewsAdapter;
import com.example.maksim.newsproject.Model.ModelNews;
import com.example.maksim.newsproject.Model.SourceNews;
import com.example.maksim.newsproject.RetrofitAPI.API;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView list;
    NewsAdapter na;
    private Gson gson = new GsonBuilder().create();
    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://newsapi.org")
            .build();
    private API api = retrofit.create(API.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.news_l);

        new AsyncTaskExample().execute();

    }

    private class AsyncTaskExample extends AsyncTask<Integer, Integer, Integer> {

        String status; // status loading
        ArrayList<ModelNews> news; // list news

        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(), "Подождите, идет загрузка", Toast.LENGTH_SHORT).show();
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {

            try {
                Call<SourceNews> call = api.getPost();
                SourceNews response = call.execute().body();
                status = response.getStatus();
                news = response.getSources();
                na = new NewsAdapter(getApplicationContext(), news);

                Log.d("LOG: ", "Complite download");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            list.setAdapter(na);
        }
    }
}
