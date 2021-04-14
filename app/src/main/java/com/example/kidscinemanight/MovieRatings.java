package com.example.kidscinemanight;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MovieRatings extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
        String[] country = { "Raya and the Last Dragon", "Hotel Transylvania 4", "The Mitchelles vs the Machines"};

        String r = "";
    MediaPlayer mediaPlayer;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_ratings);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    RadioGroup rg = findViewById(R.id.rg);
    mediaPlayer = MediaPlayer.create(this, R.raw.tone);
    mediaPlayer.start();
    ImageView img = findViewById(R.id.stop);
    img.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                img.setImageResource(R.drawable.start);
            }
            else{
                img.setImageResource(R.drawable.stop);
                mediaPlayer.start();
        }}
    });




    rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId ==R.id.rb1)
                r = "Good";
            else if(checkedId ==R.id.rb2)
                r = "Average";
            else
                r = "Bad";
        }
    });

        Button btn = findViewById(R.id.save_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MovieRatings.this, "you picked "+r, Toast.LENGTH_SHORT).show();
            }
        });
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
        }
        }