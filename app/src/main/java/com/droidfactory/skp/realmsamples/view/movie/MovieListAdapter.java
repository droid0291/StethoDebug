package com.droidfactory.skp.realmsamples.view.movie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.droidfactory.skp.realmsamples.R;
import com.droidfactory.skp.realmsamples.model.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 5/21/2017.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public MovieListAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MovieListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieListViewHolder holder, int position) {
        holder.textViewTitle.setText(movies.get(position).getTitle());
        holder.textViewSubTitle.setText(movies.get(position).getReleaseDate());
        holder.textViewDescription.setText(movies.get(position).getOverview());
        holder.textViewRating.setText(movies.get(position).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movies_layout)
        LinearLayout moviesLayout;

        @BindView(R.id.title)
        TextView textViewTitle;

        @BindView(R.id.subtitle)
        TextView textViewSubTitle;

        @BindView(R.id.description)
        TextView textViewDescription;

        @BindView(R.id.rating)
        TextView textViewRating;

        public MovieListViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
