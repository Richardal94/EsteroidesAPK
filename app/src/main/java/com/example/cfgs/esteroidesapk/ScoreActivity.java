package com.example.cfgs.esteroidesapk;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ScoreActivity extends Activity {
    ArrayList<Category> scoreUsuaris = new ArrayList<Category>();
    ListView lvScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        lvScore = (ListView)findViewById(R.id.lvScore);
        initArrayList();
        AdapterCategory adaptador = new AdapterCategory(this, scoreUsuaris);
        lvScore.setAdapter(adaptador);
    }

    public void initArrayList(){
        Usuari usuari1 = new Usuari("Juanjo", 1500);
        Usuari usuari2 = new Usuari("Jesus", 2500);
        Category cat1 = new Category(usuari1.getNom(), usuari1.getPuntuacio());
        Category cat2 = new Category(usuari2.getNom(), usuari2.getPuntuacio());
        scoreUsuaris.add(cat1);
        scoreUsuaris.add(cat2);
    }
}
