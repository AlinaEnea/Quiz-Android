package com.example.sourvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private Button btnLog;
    private CheckBox ckAgree;
    private TextInputEditText tNume, tPrenume, tVarsta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializare();
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valideazaDate()){
                Toast.makeText(getApplicationContext(),R.string.succes,Toast.LENGTH_SHORT).show();
                 Bundle bundle = new Bundle();
                 bundle.putString(String.valueOf(R.string.cheie_nume), tNume.getText().toString());
                    bundle.putString(String.valueOf(R.string.cheie_prenume), tPrenume.getText().toString());
                    bundle.putString(String.valueOf(R.string.cheie_varsta), tVarsta.getText().toString());
                Intent intent = new Intent(getApplicationContext(), Quiz1.class);
                intent.putExtras(bundle);
                startActivity(intent);
                }
            }
        });
    }
    private void initializare(){
        btnLog=findViewById(R.id.enea_alina_mihaela_login);
        ckAgree = findViewById(R.id.enea_alina_mihaela_agree);
        tNume = findViewById(R.id.enea_alina_mihaela_tiet_Nume);
        tPrenume=findViewById(R.id.enea_alina_mihaela_tiet_Prenume);
        tVarsta=findViewById(R.id.enea_alina_mihaela_tiet_Varsta);
    }
    private boolean valideazaDate(){
        if(tNume.getText() == null || tNume.getText().toString().trim().length() < 3){
            Toast.makeText(getApplicationContext(),R.string.nume_invalid,Toast.LENGTH_LONG).show();
            return false;
        }
        if(tPrenume.getText() == null || tPrenume.getText().toString().trim().length() < 3){
            Toast.makeText(getApplicationContext(),R.string.prenume_invalid,Toast.LENGTH_LONG).show();
            return false;
        }
        if(tVarsta.getText() == null
        || Integer.parseInt(tVarsta.getText().toString())>100 || Integer.parseInt(tVarsta.getText().toString())<16 ) {
            Toast.makeText(getApplicationContext(),R.string.varsta_invalida,Toast.LENGTH_LONG).show();
            return false;
        }
        if(!ckAgree.isChecked()){
            Toast.makeText(getApplicationContext(),R.string.terms,Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}