package com.example.chitramitra;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private CardView cardView;
    private TextView item_name;
    private com.example.chitramitra.GridAdapter gridAdapter;
    private ArrayList<com.example.chitramitra.GridItem> gridItems;
    private EditText editText;
 private Button button;
    public static String BASE_URL="https://www.omdbapi.com";
    public static String MOVIE_NAME;
    public static String  API_KEY ="a3bfa62d";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        gridView = findViewById(R.id.gridView);
        editText =findViewById(R.id.editText);
        button = findViewById(R.id.button);
        cardView = findViewById(R.id.cardView);
        item_name = findViewById(R.id.item_name);






       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             MOVIE_NAME = editText.getText().toString();
               /*****************************************************************/
               Retrofit retrofit = new Retrofit.Builder()
                       .baseUrl(BASE_URL)
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();

               com.example.chitramitra.ApiInteface myInteface = retrofit.create((com.example.chitramitra.ApiInteface.class));

               Call<com.example.chitramitra.MovieResults> call = myInteface.getMovies(MOVIE_NAME,API_KEY);

               call.enqueue(new Callback<com.example.chitramitra.MovieResults>() {
                   @Override
                   public void onResponse(Call<com.example.chitramitra.MovieResults> call, Response<com.example.chitramitra.MovieResults> response) {


                       //
                       if (!response.isSuccessful()) {
                           // Handle error
                           Toast.makeText(MainActivity.this, "No Response", Toast.LENGTH_SHORT).show();
                           return;
                       }
                       com.example.chitramitra.MovieResults results = response.body();
                       List<com.example.chitramitra.Search> listOfMovies=results.getSearch();
                       gridItems = new ArrayList<>();
                       for (int i = 0 ; i<listOfMovies.size() ; i++){
                           com.example.chitramitra.Search firstMovie= listOfMovies.get(i);
                           gridItems.add(new com.example.chitramitra.GridItem(firstMovie.getPoster(), firstMovie.getTitle()));
                       }
                       gridAdapter = new com.example.chitramitra.GridAdapter(MainActivity.this, gridItems);
                       gridView.setAdapter(gridAdapter);

                   }


                   @Override
                   public void onFailure(Call<com.example.chitramitra.MovieResults> call, Throwable t) {
                       Toast.makeText(MainActivity.this, "Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
                   }
               });



             /************************************************************************/
           }
       });




    }
}