package com.example.chitramitra;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private com.example.chitramitra.GridAdapter gridAdapter;
    private ArrayList<com.example.chitramitra.GridItem> gridItems;
    private EditText editText;
    public static String BASE_URLl="https://api.themoviedb.org";
    public static String MOVIE_NAME;

    FirebaseFirestore firestore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firestore = FirebaseFirestore.getInstance();



        editText =findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        gridView = findViewById(R.id.gridViewMainActivity);
        CardView cardView = findViewById(R.id.cardView);
        TextView item_name = findViewById(R.id.item_name);
        TextView user_name = findViewById(R.id.textView2);
        ImageView logOut = findViewById(R.id.imageView3);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });



/*********************************************/

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
                i.putExtra("imdb",gt.Imdb);
                startActivity(i);

            }
        });
/*********************************************/



    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MOVIE_NAME = editText.getText().toString();
            Intent i = new Intent(getApplicationContext(),SearchResults.class);
            i.putExtra("keyy",MOVIE_NAME);
            startActivity(i);


            /************************************************************************/
        }
    });


    /*******************************************/
        // Authentication
        OkHttpClient.Builder okhttpbuilder = new OkHttpClient.Builder();
        okhttpbuilder.addInterceptor(new Interceptor() {
            @NonNull
            @Override
            public okhttp3.Response intercept(@NonNull Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl.Builder urlBuilder = request.url().newBuilder();
                urlBuilder.addQueryParameter("api_key", "57453eb2f7f8ba8a78c74495cd88a76d");

                Request.Builder newRequest = request.newBuilder().url(urlBuilder.build());

                return chain.proceed(newRequest.build());
            }
        });

        /*****************************************************************/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URLl)
                .client(okhttpbuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        com.example.chitramitra.ApiInteface myInteface = retrofit.create((com.example.chitramitra.ApiInteface.class));

        Call<Root> call = myInteface.getMoviesHomePage();

        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<com.example.chitramitra.Root> call, Response<Root> response) {


                //

                if (!response.isSuccessful()) {
                    // Handle error
                    Log.d("No Response",response.toString());
                    Toast.makeText(getApplicationContext(), "No Response", Toast.LENGTH_SHORT).show();
                    return;
                }
                com.example.chitramitra.Root results = response.body();
                List<Result> listOfMovies = results.getResults();
                gridItems = new ArrayList<>();
                for (int i = 0; i < listOfMovies.size(); i++) {
                    com.example.chitramitra.Result firstMovie = listOfMovies.get(i);
                    gridItems.add(new com.example.chitramitra.GridItem("https://image.tmdb.org/t/p/original"+firstMovie.getPosterPath(), firstMovie.getTitle(), firstMovie.getReleaseDate(),
                            firstMovie.getOverview()));
                }
                gridAdapter = new com.example.chitramitra.GridAdapter(getApplicationContext(), gridItems);
                gridView.setAdapter(gridAdapter);

            }


            @Override
            public void onFailure(Call<com.example.chitramitra.Root> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




/**************************************************/
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("TAG", "Value is: " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
///************************************************FireStore******************************************/
//        Map<String,Object> users = new HashMap<>();
//        users.put("FirstName", "Xyz");
//        users.put("MiddleName", "Abc");
//        users.put("FirstName", "DEF");
//
//        firestore.collection("users").add(users).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//            @Override
//            public void onSuccess(DocumentReference documentReference) {
//                //Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                //Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        /************************realtime Database**************************/
//        // Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
//
//        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d("TAG", "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Failed to read value
//                Log.w("TAG", "Failed to read value.", error.toException());
//            }
//        });
    }
}