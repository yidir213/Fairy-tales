package com.example.projecttp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projecttp.BaseDeDonnes.RecyclerViewSceneAdapter;
import com.example.projecttp.Histoire.Scène;
import com.example.projecttp.StoriesData.StoryData;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView rv2;
    TextView t3;
    TextView titre;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b2= findViewById(R.id.retour);


        rv2=findViewById(R.id.RecyclerView_Scene);
        int p=getIntent().getIntExtra("position", -1);
        ArrayList<Scène> mylist= StoryData.getStories().get(p).getLesScènes();
        titre=findViewById(R.id.titre);
        titre.setText(StoryData.getStories().get(p).getTitre());
//Autre methode
//        Bundle args = intent.getBundleExtra("BUNDLE");
//        ArrayList<Scène> mylist = (ArrayList<Scène>) args.getSerializable("ARRAYLIST");



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //on essayée cela ca a marchée mais a chaque fois il crée une nouvelle inten
//                Intent intent =new Intent(view.getContext(),MainActivity.class);
//                startActivity(intent);
                onBackPressed();
            }
        });
        RecyclerViewSceneAdapter adapter2=new RecyclerViewSceneAdapter(mylist,p);
        RecyclerView.LayoutManager lm2=new LinearLayoutManager(MainActivity2.this,LinearLayoutManager.HORIZONTAL,false);
        rv2.setHasFixedSize(true);
        rv2.setAdapter(adapter2);
        rv2.setLayoutManager(lm2);
    }
}