package com.example.pt6httpmauro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.example.pt6httpmauro.Models.Equipo;
import com.example.pt6httpmauro.Models.Liga;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<Liga> ligas = new ArrayList<>();
    private RequestQueue queue = null;
    public List<Liga> getElements(){ return ligas; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerViewApp adapter = new RecyclerViewApp(ligas);
        RecyclerView viewLista = findViewById(R.id.viewLista);
    }
}