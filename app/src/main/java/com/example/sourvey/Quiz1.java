package com.example.sourvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class Quiz1 extends AppCompatActivity {

    TextView tvintrebare, raspA, raspB, raspC, raspD;
    private static int nrIntrebare=1;
    private static String raspuns_corect = null;
    private static int puncte = 0;
    Bundle deTrimis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        initilizareComponente();
        setareIntrebare(R.array.intrebare1);
    }
    void initilizareComponente(){
        tvintrebare = findViewById(R.id.card_intrebare);
        raspA = findViewById(R.id.enea_alina_mihaela_raspA);
        raspB = findViewById(R.id.enea_alina_mihaela_raspB);
        raspC = findViewById(R.id.enea_alina_mihaela_raspC);
        raspD = findViewById(R.id.enea_alina_mihaela_raspD);
    }
    void setareIntrebare(int resourceName){
        Resources res = getResources();
        String[] intrebare = res.getStringArray(resourceName);
        tvintrebare.setText(intrebare[0]);
        raspA.setText(intrebare[1]);
        raspA.setTextColor(Color.parseColor("#000000"));
        raspB.setText(intrebare[2]);
        raspB.setTextColor(Color.parseColor("#000000"));
        raspC.setText(intrebare[3]);
        raspC.setTextColor(Color.parseColor("#000000"));
        raspD.setText(intrebare[4]);
        raspD.setTextColor(Color.parseColor("#000000"));
        raspuns_corect = intrebare[5];
        verificaRaspuns();
    }
    void schimbareIntrebare(){
                nrIntrebare++;
        Handler handler = new Handler();
        handler. postDelayed(new Runnable() {
            public void run() {
                switch(nrIntrebare){
                    case 2: setareIntrebare(R.array.intrebare2);
                        break;
                    case 3: setareIntrebare(R.array.intrebare3);
                        break;
                    case 4: setareIntrebare(R.array.intrebare4);
                        break;
                    case 5: setareIntrebare(R.array.intrebare5);
                        break;
                    case 6: setareIntrebare(R.array.intrebare6);
                        break;
                    case 7: setareIntrebare(R.array.intrebare7);
                        break;
                    default:
                        deTrimis = primesteDate();
                        Intent intent = new Intent(getApplicationContext(),FinalActivity.class);
                        intent.putExtras(deTrimis);
                        startActivity(intent);
                        break;
                }
            }
        }, 900);
    }
    void verificaRaspuns(){
        raspA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(raspA.getText().equals(raspuns_corect)){
                    raspA.setTextColor(Color.parseColor("#157a32"));
                    puncte++;
                } else raspA.setTextColor(Color.parseColor("#ff9d9d"));
                schimbareIntrebare();
            }
        });
        raspB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(raspB.getText().equals(raspuns_corect)){
                    raspB.setTextColor(Color.parseColor("#157a32"));
                    puncte++;
                } else raspB.setTextColor(Color.parseColor("#ff9d9d"));
                schimbareIntrebare();
            }
        });
        raspC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(raspC.getText().equals(raspuns_corect)){
                    raspC.setTextColor(Color.parseColor("#157a32"));
                    puncte++;
                } else raspC.setTextColor(Color.parseColor("#ff9d9d"));
                schimbareIntrebare();
            }
        });
        raspD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(raspD.getText().equals(raspuns_corect)){
                    raspD.setTextColor(Color.parseColor("#157a32"));
                    puncte++;
                } else raspD.setTextColor(Color.parseColor("#ff9d9d"));
                schimbareIntrebare();
            }
        });
    }
    Bundle primesteDate(){
        //returnarea obiectului de tip Intent folosit pentru inceperea activitatii
        Intent intent = getIntent();
        //returnarea obiectului de tip Bundle folosit pentru transferului de date, atasat obiectului de tip Intent -> rezolvare exercitiu seminar
        Bundle bundle = intent.getExtras();
        bundle.putString(String.valueOf(R.string.cheie_puncte), String.valueOf(puncte));
        return bundle;
    }
}