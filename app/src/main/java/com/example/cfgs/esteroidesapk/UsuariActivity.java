package com.example.cfgs.esteroidesapk;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UsuariActivity extends Activity {
    EditText etUsuari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuari);
        etUsuari = (EditText) findViewById(R.id.ptUsuari);
        MainActivity.listUsuaris.add(new Usuari(etUsuari.getText().toString()));
    }
    public void playGame(View view) {
        Intent i = new Intent(this, JuegoActivity.class );
        startActivity(i);
    }
}
