package com.example.projecttp;



import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;


import com.example.projecttp.BaseDeDonnes.HistoireFavoriAdapter;
import com.example.projecttp.BaseDeDonnes.RecyclerViewHistoireAdapter;
import com.example.projecttp.Histoire.histoire;
import com.example.projecttp.StoriesData.StoryData;


import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    RecyclerView rv,favori_list;
    ArrayList<histoire> stories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.RecyclerView_main);



        stories= StoryData.getStories();
        RecyclerViewHistoireAdapter adapter=new RecyclerViewHistoireAdapter(stories,this);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(lm);


        //listes des favorites
        ArrayList<histoire> Histoires_favori=new ArrayList<>();

        favori_list=findViewById(R.id.favori_list);
        HistoireFavoriAdapter adapter2=new HistoireFavoriAdapter(Histoires_favori);
        RecyclerView.LayoutManager lm2=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,true);
        favori_list.setLayoutManager(lm2);
        favori_list.setAdapter(adapter2);

        adapter.setHistoires_Favori(Histoires_favori);
        adapter.setHistoireFavories(adapter2);
        rv.setAdapter(adapter);

    }
}