package com.example.projecttp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.projecttp.Histoire.Scène;
import com.example.projecttp.StoriesData.StoryData;
import com.example.projecttp.outils.CustomScrollView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    TextView t1;
    Button b;
    CustomScrollView sc;
    RelativeLayout rlayout;
    ImageView pause_play;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t1=findViewById(R.id.storyTextView);
        b = findViewById(R.id.button);
        sc = findViewById(R.id.sc);
        pause_play =findViewById(R.id.pause_play);
        rlayout=findViewById(R.id.rlay);
//        Scène s = (Scène) getIntent().getSerializableExtra("the_Scene");
        int p=getIntent().getIntExtra("pos", -1);
        int nh=getIntent().getIntExtra("numHis", -1);
        int non1=StoryData.getStories().get(nh).getLesScènes().size() - p;

        Scène s =StoryData.getStories().get(nh).getLesScènes().get(p);
        MediaPlayer music = MediaPlayer.create(MainActivity3.this, s.getMusic());
        pause_play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                    if(music.isPlaying()) {
                        music.pause();
                        pause_play.setImageResource(R.drawable.baseline_play_arrow_24);
                    }
                    else{
                        music.start();
                        pause_play.setImageResource(R.drawable.baseline_pause_circle_24);
                    }
            }
        });
        t1.setText(s.getContenu());
        rlayout.setBackgroundResource(s.getImg());
        b.setOnClickListener(view -> {
            if(non1!=1) {
                Intent intent = new Intent(view.getContext(), MainActivity3.class);
                intent.putExtra("pos", p + 1);
                intent.putExtra("numHis", nh);
                intent.putExtra("the_Scene", (Serializable) s);
                view.getContext().startActivity(intent);
            }
            else{

                Intent intent =new Intent(view.getContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);

            }

        });
        sc.setOnScrollEndListener(new CustomScrollView.OnScrollEndListener() {
            @Override
            public void onScrollEnd() {

                if(non1==1) {
                    b.setText("Read more stories");
                    b.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                    b.setBackgroundResource(R.drawable.btn_w_color);
                    b.setTextColor(Color.parseColor("#FFFFFFFF"));
                }
                b.setVisibility(View.VISIBLE);

            }
            @Override
            public void onScrollUp() {
                b.setVisibility(View.GONE);
            }
        });

    }
}
