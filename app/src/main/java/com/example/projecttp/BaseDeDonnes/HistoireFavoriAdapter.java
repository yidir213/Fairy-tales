package com.example.projecttp.BaseDeDonnes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttp.Histoire.Scène;
import com.example.projecttp.Histoire.histoire;
import com.example.projecttp.MainActivity2;
import com.example.projecttp.R;

import java.io.Serializable;
import java.util.ArrayList;

public class HistoireFavoriAdapter extends RecyclerView.Adapter<HistoireFavoriHolder> {

    ArrayList<histoire> Histoires_Favori;

    public HistoireFavoriAdapter(ArrayList<histoire> Histoires_Favori) {
        this.Histoires_Favori=Histoires_Favori;
    }
    @NonNull
    @Override
    public HistoireFavoriHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fav_story,null,false);
        HistoireFavoriHolder vh = new HistoireFavoriHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoireFavoriHolder holder, int position) {
        histoire h=Histoires_Favori.get(position);
        holder.t1.setText(h.getTitre());
        holder.favorite_image.setImageResource(h.getImg());
        holder.itemView.setOnClickListener(v -> {
            int pos=h.getPos();
            Intent intent =new Intent(v.getContext(),MainActivity2.class);
            intent.putExtra("position",pos);
            v.getContext().startActivity(intent);
//Autre methodes
//            ArrayList<Scène> myList=h.getLesScènes();
//            Intent intent = new Intent(v.getContext(), MainActivity2.class);
//            Bundle args = new Bundle();
//            args.putSerializable("ARRAYLIST",(Serializable)myList);
//            intent.putExtra("BUNDLE",args);
//            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return Histoires_Favori.size();
    }
}

class HistoireFavoriHolder extends RecyclerView.ViewHolder{
    TextView t1;
    ImageView favorite_image;
    public HistoireFavoriHolder(@NonNull View itemView) {
        super(itemView);
        this.t1=itemView.findViewById(R.id.t1);
        this.favorite_image=itemView.findViewById(R.id.favorite_image);

    }


}