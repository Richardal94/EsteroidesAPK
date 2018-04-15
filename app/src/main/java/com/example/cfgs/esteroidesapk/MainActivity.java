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
import android.widget.Button;
import android.widget.ImageView;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MainActivity extends Activity {

    private static Context mContext;
    private AnimatorSet titleSet ;
    private ImageView tittle;
    private ImageView startGameTittle;
    private Button btnExit;
    private Button btnScore;
    private Button btnPlay;
    public static SortedSet<Usuari> listUsuaris = new TreeSet<Usuari>();
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this.getApplicationContext();
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        init();
        animations();

    }

    public void init(){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.audio);
        mp.setLooping(true);
        mp.start();
        tittle = (ImageView)findViewById(R.id.tittleImg) ;
        startGameTittle= (ImageView)findViewById(R.id.startGameImg);
        btnExit = (Button)findViewById(R.id.bntExit);
        btnScore = (Button)findViewById(R.id.btnScore);
        btnPlay = (Button)findViewById(R.id.btnPlay);

    }

    public void animations(){
        titleSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.title);
        titleSet.setTarget(tittle);
        titleSet.start();
        TimeInterpolator inter = new LinearInterpolator();
        ValueAnimator rotateTitle = ObjectAnimator.ofFloat(tittle, "rotation", 360, 0);
        rotateTitle.setDuration(3000);
        rotateTitle.setInterpolator(inter);
        titleSet.play( rotateTitle );
        titleSet.start();
        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(startGameTittle, View.ALPHA, 0,1);
        fadeAnim.setDuration(1500);
        fadeAnim.setRepeatCount(ValueAnimator.INFINITE);
        fadeAnim.setRepeatMode(ValueAnimator.REVERSE);
        fadeAnim.start();

    }

    public void initBotons(View view){
        btnExit.setVisibility(View.VISIBLE);
        btnScore.setVisibility(View.VISIBLE);
        btnPlay.setVisibility(View.VISIBLE);
        startGameTittle.setVisibility(View.INVISIBLE);
    }
    public void playGame(View view) {
        //Intent i = new Intent(this, UsuariActivity.class );
        //startActivity(i);
        Intent i = new Intent(this, JuegoActivity.class );
        startActivity(i);
    }

    public void scoreGame(View view) {
        Intent i = new Intent(this, ScoreActivity.class );
        startActivity(i);
    }

    public void exitGame(View view){
        this.finish();
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


}
