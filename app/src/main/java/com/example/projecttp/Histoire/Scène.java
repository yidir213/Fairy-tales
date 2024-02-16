package com.example.projecttp.Histoire;

import android.media.Image;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.io.Serializable;

public class Scène implements Serializable {

    String titre;
    int img;
    String Contenu;
    int son;


    public Scène(String titre, int img) {
        this.titre = titre;
        this.img = img;
    }

    public Scène(String titre, int img, String contenu) {
        this.titre=titre;
        this.img = img;
        Contenu = contenu;
    }

    public Scène(String titre,int img, String contenu, int son) {
        this.titre=titre;
        this.img = img;
        Contenu = contenu;
        this.son = son;
    }
    public void setMusic(int son) {
        this.son = son;
    }

    public int getMusic() {
        return son;
    }

    public String getTitre() {
        return titre;
    }

    public int getImg() {
        return img;
    }

    public String getContenu() {
        return Contenu;
    }

}
