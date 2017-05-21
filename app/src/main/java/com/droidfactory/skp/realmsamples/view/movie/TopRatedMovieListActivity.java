package com.droidfactory.skp.realmsamples.view.movie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.droidfactory.skp.realmsamples.R;
import com.droidfactory.skp.realmsamples.model.Movie;
import com.droidfactory.skp.realmsamples.model.MoviesResponse;
import com.droidfactory.skp.realmsamples.rest.ApiInterface;
import com.droidfactory.skp.realmsamples.rest.RetrofitClient;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by User on 5/21/2017.
 */

public class TopRatedMovieListActivity extends AppCompatActivity {

    @BindView(R.id.movies_recycler_view)
    RecyclerView moviesRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_top_rated_movie);

        ButterKnife.bind(TopRatedMovieListActivity.this);

        loadSkin();
    }

    private void loadSkin() {
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(TopRatedMovieListActivity.this));

        /*new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();*/

        ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiInterface.getTopRatedMovies(RetrofitClient.API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {

            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                int statusCode = response.code();
                List<Movie> movies = response.body().getResults();
                moviesRecyclerView.setAdapter(new MovieListAdapter(movies,
                        R.layout.movies_list_single_item,
                        getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e("Stetho", t.toString());
            }
        });
    }
}
