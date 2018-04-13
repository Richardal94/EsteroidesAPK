package com.example.cfgs.esteroidesapk;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends Activity {

    private static Context mContext;
    private AnimatorSet titleSet ;
    private ImageView tittle;
    public ArrayList<Usuari> listUsuaris = new ArrayList<Usuari>();
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this.getApplicationContext();
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        init();
        tittle = (ImageView)findViewById(R.id.tittleImg) ;
        titleSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.title);
        titleSet.setTarget(tittle);
        titleSet.start();
        TimeInterpolator inter = new LinearInterpolator();
        ValueAnimator rotateTitle = ObjectAnimator.ofFloat(tittle, "rotation", 360, 0);
        rotateTitle.setDuration(3000);
        rotateTitle.setInterpolator(inter);
        titleSet.play( rotateTitle );
        titleSet.start();
    }


    public void playGame(View view) {
        Intent i = new Intent(this, UsuariActivity.class );
        startActivity(i);
    }

    public void scoreGame(View view) {
        Intent i = new Intent(this, ScoreActivity.class );
        startActivity(i);
    }

    public void exitGame(View view){
        this.finish();
    }

    public void init(){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.audio);
        mp.setLooping(true);
        mp.start();

    }

    public void abrirMenu(View view){
        Intent i = new Intent(this, PreferenciasActivity.class );
        startActivity(i);
    }

    public void mostrarDialogo(View view){
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder (this);
        dialogo1.setTitle ( "Informacion");
        dialogo1.setMessage ( "Programador: Richard Alvarez Hayes\nAplicacion: Asteroides");
        dialogo1.setCancelable (false);
        dialogo1.setPositiveButton ( "Cerrar", new
                DialogInterface.OnClickListener () {
                    public void onClick (DialogInterface dialogo1, int id) {

                    }
                });
        dialogo1.show ();
    }

    public Usuari buscarUsuari(String usuari){
        Iterator<Usuari> it = listUsuaris.iterator();
        Usuari iterat = null;
        while(it.hasNext()){
            iterat = it.next();
            if(iterat.getNom().equals(usuari)) return iterat;
        }
        return iterat;
    }

    public static Context getContext() {
        return mContext;
    }


}
