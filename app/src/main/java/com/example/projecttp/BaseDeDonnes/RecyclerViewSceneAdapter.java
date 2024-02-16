package com.example.projecttp.BaseDeDonnes;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Scene;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttp.Histoire.Scène;
import com.example.projecttp.MainActivity2;
import com.example.projecttp.MainActivity3;
import com.example.projecttp.R;

import java.io.Serializable;
import java.util.ArrayList;

public class RecyclerViewSceneAdapter extends RecyclerView.Adapter<SceneViewHolder>{
    ArrayList<Scène> Scènes;
    int numHis;

    public RecyclerViewSceneAdapter(ArrayList<Scène> scènes) {
        this.Scènes = scènes;
    }
    public RecyclerViewSceneAdapter(ArrayList<Scène> scènes,int p) {
        this.Scènes = scènes;
        this.numHis=p;
    }
    @NonNull
    @Override
    public SceneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scene_list,null,false);
        SceneViewHolder viewHolder=new SceneViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SceneViewHolder holder, int position) {
        Scène s =Scènes.get(position);
        holder.t1.setText(s.getTitre());
        holder.t2.setText(s.getContenu().substring(0,290)+".... \n");
        holder.img.setImageResource(s.getImg());
        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(v.getContext(), MainActivity3.class);
            intent.putExtra("pos",position);
            intent.putExtra("numHis",numHis);
//            intent.putExtra("the_Scene",(Serializable)s);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return Scènes!=null ? Scènes.size(): 0;
    }
}

class SceneViewHolder extends RecyclerView.ViewHolder{
    TextView t1;

    TextView t2;
    ImageView img;
    public SceneViewHolder(@NonNull View itemView) {
        super(itemView);
        this.t1=itemView.findViewById(R.id.t1);
        this.t2=itemView.findViewById(R.id.t2);
        this.img=itemView.findViewById(R.id.imgScence);
    }
}