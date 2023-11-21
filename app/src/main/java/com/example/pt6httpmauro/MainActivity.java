package com.example.pt6httpmauro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.example.pt6httpmauro.Models.Equipo;
import com.example.pt6httpmauro.Models.Liga;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView mlb;
    ImageView mls;
    ImageView nba;
    ImageView nfl;
    ImageView nhl;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlb = findViewById(R.id.mlb);
        mls = findViewById(R.id.mls);
        nba = findViewById(R.id.nba);
        nfl = findViewById(R.id.nfl);
        nhl = findViewById(R.id.nhl);

        View.OnClickListener listener = this;
        mlb.setOnClickListener(listener);
        mls.setOnClickListener(listener);
        nba.setOnClickListener(listener);
        nfl.setOnClickListener(listener);
        nhl.setOnClickListener(listener);



    }

    @Override
    public void onClick(View view){
        Intent intent = new Intent(this, LigasActivity.class);

        if(view.getId()==R.id.mlb){
            intent.putExtra("extension", "mlb");
        } else if (view.getId() == R.id.mls) {
        intent.putExtra("extension", "mls");
        } else if (view.getId() == R.id.nba) {
        intent.putExtra("extension", "nba");
        } else if (view.getId() == R.id.nfl) {
        intent.putExtra("extension", "nfl");
        } else if (view.getId() == R.id.nhl) {
        intent.putExtra("extension", "nhl");
        }

        startActivity(intent);
    }

}

