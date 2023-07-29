package com.example.chitramitra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchResults extends AppCompatActivity {
    private GridView gridView;
    private com.example.chitramitra.GridAdapter gridAdapter;
    private ArrayList<com.example.chitramitra.GridItem> gridItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        gridView = findViewById(R.id.gridView);
        Intent intent = getIntent();
        String MOVIE_NAME = intent.getStringExtra("keyy");
        String BASE_URL="https://www.omdbapi.com";
        String  API_KEY ="a3bfa62d";
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//               MovieDetails md = new MovieDetails(URLL);
//                gridView.

                Intent i = new Intent(getApplicationContext(),MovieDetails.class);
                GridItem gt = gridItems.get(position);

                i.putExtra("key",gt.imgURL);
                i.putExtra("title",gt.Title);
                i.putExtra("year",gt.Year);
                i.putExtra("imdb","Data Unavailable");
                startActivity(i);

            }
        });
                /*****************************************************************/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        com.example.chitramitra.ApiInteface myInteface = retrofit.create((com.example.chitramitra.ApiInteface.class));

        Call<MovieResults> call = myInteface.getMovies(MOVIE_NAME, API_KEY);

        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<com.example.chitramitra.MovieResults> call, Response<MovieResults> response) {


                //
                if (!response.isSuccessful()) {
                    // Handle error
                    Toast.makeText(getApplicationContext(), "No Response", Toast.LENGTH_SHORT).show();
                    return;
                }
                com.example.chitramitra.MovieResults results = response.body();
                List<Search> listOfMovies = results.getSearch();
                gridItems = new ArrayList<>();
                for (int i = 0; i < listOfMovies.size(); i++) {
                    com.example.chitramitra.Search firstMovie = listOfMovies.get(i);
                    gridItems.add(new com.example.chitramitra.GridItem(firstMovie.getPoster(), firstMovie.getTitle(), firstMovie.getYear(),
                            firstMovie.getImdbID()));
                }
                gridAdapter = new com.example.chitramitra.GridAdapter(getApplicationContext(), gridItems);
                gridView.setAdapter(gridAdapter);

            }


            @Override
            public void onFailure(Call<com.example.chitramitra.MovieResults> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}