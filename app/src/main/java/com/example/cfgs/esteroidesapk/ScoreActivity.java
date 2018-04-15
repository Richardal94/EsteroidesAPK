package com.example.cfgs.esteroidesapk;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;

public class ScoreActivity extends ListActivity {
    ArrayList<Category> scoreUsuaris = new ArrayList<Category>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        initArrayList();
        CategoryAdapter adaptador = new CategoryAdapter(this, scoreUsuaris);
        setListAdapter(adaptador);
    }

    public void initArrayList(){
        Usuari usuari1 = new Usuari("Juanjo", 1500);
        Usuari usuari2 = new Usuari("Jesus", 2500);
        MainActivity.listUsuaris.add(usuari1);
        MainActivity.listUsuaris.add(usuari2);
        Iterator<Usuari> it = MainActivity.listUsuaris.iterator();
        int i = 0;
        while(it.hasNext()){
            Usuari itUser = it.next();
            scoreUsuaris.add(new Category(i, itUser.getNom(), itUser.getPuntuacio()));
        }
    }
}
