package com.example.projecttp.BaseDeDonnes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttp.Histoire.Scène;
import com.example.projecttp.Histoire.histoire;
import com.example.projecttp.MainActivity2;
import com.example.projecttp.R;
import com.example.projecttp.StoriesData.StoryData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewHistoireAdapter extends RecyclerView.Adapter<HistoireViewHolder>{
    ArrayList<histoire> Histoires;
    ArrayList<histoire> Histoires_Favori;
    HistoireFavoriAdapter HistoireFavories;
    Context context;

    public RecyclerViewHistoireAdapter(ArrayList<histoire> histoires, Context context) {
        this.context=context;
        this.Histoires=histoires;
    }

    @NonNull
    @Override
    public HistoireViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_histoire_list,null,false);
        HistoireViewHolder viewHolder = new HistoireViewHolder(v,Histoires_Favori,HistoireFavories);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoireViewHolder holder, int position) {
        histoire h=Histoires.get(position);
        holder.t1.setText(h.getTitre());
        holder.img.setImageResource(h.getImg());
        holder.favImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean m=false;
                for (int j = 0; j < Histoires_Favori.size(); j++) {
                    if (Histoires_Favori.get(j).getPos() == holder.getBindingAdapterPosition()) {
                        m=true;
                        break;
                    }}

                if (!m){
                    holder.favImage.setColorFilter(Color.parseColor("#FFFF4081"));
                    System.out.println("ajoutée");
                    holder.Histoires_Favori.add(new histoire(holder.t1.getText().toString(),h.getImg(),holder.getBindingAdapterPosition()));
                    holder.adapter.Histoires_Favori.size();
                    holder.adapter.notifyItemInserted(Histoires_Favori.size());
                }else{
                    int index=0;
                    //On avait pu utiliser les HashMaps pour éviter une complexité élevée ils sont la meilleurs option  si on avait plusieurs histoires mais  dans notre app  on a pas met beaucoup donc nous avons preferée ce fonctionnement
                    for (int i = 0; i < Histoires_Favori.size(); i++) {
                        if (Histoires_Favori.get(i).getPos() == holder.getBindingAdapterPosition()) {
                            index = i;
                            break;
                        }
                    }
                    holder.favImage.setColorFilter(Color.parseColor("#B8B3B3"));
                    holder.Histoires_Favori.remove(index);
                    holder.adapter.notifyItemRemoved(index);
                    holder.adapter.notifyItemRangeChanged(index, holder.Histoires_Favori.size() - index);
                }
            }
        });


        holder.itemView.setOnClickListener(v -> {
//            ArrayList<Scène> myList=StoryData.getStories().get(position).getLesScènes();
            Intent intent = new Intent(v.getContext(), MainActivity2.class);
            intent.putExtra("position",position);
            v.getContext().startActivity(intent);
        });
//Autre methode qui a marché(plus de complexité)
//        holder.itemView.setOnClickListener(v -> {
//            ArrayList<Scène> myList=h.getLesScènes();
//            Intent intent = new Intent(v.getContext(), MainActivity2.class);
//            Bundle args = new Bundle();
//            args.putSerializable("ARRAYLIST",(Serializable)myList);
//            intent.putExtra("BUNDLE",args);
//            v.getContext().startActivity(intent);
//        });
    }

    @Override
    public int getItemCount() {
        return Histoires.size();
    }

    public void setHistoires_Favori(ArrayList<histoire> histoires_Favori) {
        Histoires_Favori = histoires_Favori;
    }

    public void setHistoireFavories(HistoireFavoriAdapter histoireFavories) {
        HistoireFavories = histoireFavories;
    }

}

class HistoireViewHolder extends RecyclerView.ViewHolder{
    ImageButton favImage;
    ArrayList<histoire> Histoires_Favori;
    HistoireFavoriAdapter adapter;
    TextView t1;
    ImageView img;
    public HistoireViewHolder(@NonNull View itemView
            ,ArrayList<histoire> Histoires, HistoireFavoriAdapter adapter) {
        super(itemView);
        this.t1=itemView.findViewById(R.id.t1);
        this.img=itemView.findViewById(R.id.histoire_image);
        this.favImage=itemView.findViewById(R.id.fav);
        this.Histoires_Favori=Histoires;
        this.adapter=adapter;
    }
}

