package com.example.chitramitra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MovieDetails extends AppCompatActivity {
    private View rootView;

String URL;
//
//    public MovieDetails(String URL) {
//        this.URL = URL;
//    }
//
//    public MovieDetails(int contentLayoutId, String URL) {
//        super(contentLayoutId);
//        this.URL = URL;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        TextView textView = findViewById(R.id.MovieTitle);
        TextView textView2 = findViewById(R.id.MovieYear);
        Button bookNow = findViewById(R.id.BookTickets);
        TextView Description = findViewById(R.id.Description);


        rootView = findViewById(android.R.id.content);
        Intent intent = getIntent();
        String URL = intent.getStringExtra("key");
        String title = intent.getStringExtra("title");
        String year = intent.getStringExtra("year");
        String imdb = intent.getStringExtra("imdb");

        bookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://in.bookmyshow.com/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Picasso.get().load(URL).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                rootView.setBackground(new BitmapDrawable(getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                // handle error case
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                // handle loading placeholder image
            }
        });

        textView.setText(title);
        textView2.setText(year);
        Description.setText(imdb);
    }
}