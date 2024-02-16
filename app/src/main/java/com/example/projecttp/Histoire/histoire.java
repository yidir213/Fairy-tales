package com.example.projecttp.Histoire;

import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

public class histoire {
    String titre;
    ArrayList<Scène> lesScènes;
    int pos;
    int img;



    public histoire(String titre, int img) {
        this.titre = titre;
        this.img=img;
    }

    public histoire(String titre, int img ,int pos) {
        this.titre = titre;
        this.img=img;
        this.pos=pos;
    }

    public histoire(String titre, int img, ArrayList<Scène> lesScènes) {
        this.titre = titre;
        this.img = img;
        this.lesScènes = lesScènes;
    }



    public String getTitre() {
        return titre;
    }

    public int getPos() {
        return pos;
    }
    public ArrayList<Scène> getLesScènes() {
        return lesScènes;
    }
    public int getImg() {
        return img;
    }

}
