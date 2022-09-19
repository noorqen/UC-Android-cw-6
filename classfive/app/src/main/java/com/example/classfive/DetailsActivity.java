package com.example.classfive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView nametext = findViewById(R.id.textViewnamed);
        TextView timetext = findViewById(R.id.textViewtimed);
        ImageView img = findViewById(R.id.imageViewdetails);

        Bundle bundle = getIntent().getExtras();
        Movies sendmovie = (Movies) bundle.getSerializable("movie");

        nametext.setText(sendmovie.getMovieName());
        timetext.setText(sendmovie.getMovieHrs() + "hr " + sendmovie.getMovieMints() + "mins");
        img.setImageResource(sendmovie.getMovieImg());
    }
}