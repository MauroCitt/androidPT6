package com.example.pt6httpmauro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pt6httpmauro.Models.Liga;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LigasActivity extends AppCompatActivity {

    private final List<Liga> ligas = new ArrayList<>();
    private RequestQueue queue = null;
    public List<Liga> getElements(){ return ligas; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligas);

        RecyclerViewApp adapter = new RecyclerViewApp(ligas);
        RecyclerView listaEquipos = findViewById(R.id.listaEquipos);
        listaEquipos.setAdapter(adapter);

        findViewById(R.id.btnCargarEquipos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hayConexion()){
                    Intent intent = getIntent();
                    String liga = intent.getStringExtra("extension");
                    loadData(listaEquipos, "https://www.vidalibarraquer.net/android/sports/" + liga + ".json");
                }
                else
                    Toast.makeText(getApplicationContext(), R.string.noInternet, Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean hayConexion() {
        boolean resultat = false;

        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        // Comprovem la versió del dispositiu Android
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                    resultat = true;
                }
            }
        } else { //versions anteriors d'Android
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {
                resultat = true;
            } else {
                resultat = false;
            }
        }

        return resultat;
    }

    private void loadData(RecyclerView viewLlista, String url) {
        if ( queue == null )
            queue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // S'esborra la llista
                            ligas.clear();
                            // Obtenim l'array que té per nom data
                            JSONArray jsonArray = response.getJSONArray("teams");
                            //Recorrem tots els elements
                            for (int i = 0; i < jsonArray.length(); i++) {
                                // Afegim el personatge a la llista
                                Liga liga = new Liga(
                                        jsonArray.getJSONObject(i).getString("team_name"),
                                        jsonArray.getJSONObject(i).getString("team_abbreviation")
                                );
                                ligas.add(liga);
                            }
                            viewLlista.getAdapter().notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LigasActivity.this, "Error en obtenir dades", Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(request);
    }
}