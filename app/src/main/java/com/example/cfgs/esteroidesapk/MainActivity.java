package com.example.cfgs.esteroidesapk;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class MainActivity extends Activity {
    private AnimatorSet titleSet ;
    private TextView title;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        title = (TextView) this.findViewById(R.id.tittle);
        titleSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.title);
        titleSet.setTarget(title);
        titleSet.start();
        TimeInterpolator inter = new LinearInterpolator();
        ValueAnimator rotateTitle = ObjectAnimator.ofFloat(title, "rotation", 360, 0);
        rotateTitle.setDuration(3000);
        rotateTitle.setInterpolator(inter);
        titleSet.play( rotateTitle );
        titleSet.start();
    }


    public void playGame(View view) {
        Intent i = new Intent(this, UsuariActivity.class );
        startActivity(i);
    }

    public void init(){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.audio);
        mp.setLooping(true);
        mp.start();

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.tools) {

        }
        if (id == R.id.info) {
            mostrarDialogo();
        }
        return super.onOptionsItemSelected(item);
    }

    public void mostrarDialogo(){
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
}
