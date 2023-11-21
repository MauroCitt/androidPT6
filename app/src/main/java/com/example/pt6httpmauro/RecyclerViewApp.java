package com.example.pt6httpmauro;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pt6httpmauro.Models.Liga;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RecyclerViewApp extends RecyclerView.Adapter<RecyclerViewApp.ViewHolder> {
    private List<Liga> elements;

    public RecyclerViewApp(List<Liga> elements) {
        this.elements = elements;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewElement = LayoutInflater.from(parent.getContext()).inflate(R.layout.linea_recycler, parent, false);

        return new ViewHolder(viewElement);
    }


    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.getTxtElement().setText(elements.get(position).getNombreEquipo());
        holder.getTxtElement().setText(elements.get(position).getAbreviacionEquipo());
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtElement;
        private TextView txtElement2;

        public ViewHolder(View itemView) {
            super(itemView);
            //Quan fem click a la llista mostrem l'element
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewHolder.this.mostraElement(v);
                }
            });

            txtElement = itemView.findViewById(R.id.textView);
            txtElement2 = itemView.findViewById(R.id.textView2);
        }

        private void mostraElement(View v) {

            // Cridem la pantalla de mostrar personatge i li passem les dades
            Intent mostrarLiga = new Intent(v.getContext(), Liga.class);
            Liga liga = elements.get(getAdapterPosition());
            mostrarLiga.putExtra("name", liga.getNombreEquipo());
            mostrarLiga.putExtra("planet", liga.getAbreviacionEquipo());
            v.getContext().startActivity(mostrarLiga);

        }

        public TextView getTxtElement() {
            return txtElement;
        }

        public TextView getTxtElement2(){
            return txtElement2;
        }
    }

}
