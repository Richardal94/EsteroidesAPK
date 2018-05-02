package com.example.cfgs.esteroidesapk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JuegoActivity extends Activity {
    MediaPlayer mp;
    public static Activity juegoActivity;
    public static int puntos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        juegoActivity = this;
        puntos = 0;
        setContentView(R.layout.activity_juego);
        mp = MediaPlayer.create(this, R.raw.playaudio);
        mp.setLooping(true);
        mp.start();
        mp.setVolume(new Float(0.1), new Float(0.1));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.release();
    }

}
