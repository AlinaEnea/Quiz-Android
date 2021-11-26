package com.example.sourvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
TextView tvDate, tvPuncte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        tvDate = findViewById(R.id.enea_alina_mihaela_date);
        tvPuncte=findViewById(R.id.enea_alina_mihaela_nr_puncte);
        primireSiSetareDate();
    }
    void primireSiSetareDate(){
        //returnarea obiectului de tip Intent folosit pentru inceperea activitatii -> rezolvare exercitiu seminar
        Intent intent = getIntent();
        //returnarea obiectului de tip Bundle folosit pentru transferului de date, atasat obiectului de tip Intent -> rezolvare exercitiu seminar
        Bundle bundle = intent.getExtras();
                String nume = bundle.getString(String.valueOf(R.string.cheie_nume));
        String prenume = bundle.getString(String.valueOf(R.string.cheie_prenume));
        String puncte = bundle.getString(String.valueOf(R.string.cheie_puncte));
        String varsta = bundle.getString(String.valueOf(R.string.cheie_varsta));
    tvDate.setText("Felicitari, "+nume+" "+prenume+" (varsta: "+varsta+")!");
    tvPuncte.setText(puncte);
    }
}