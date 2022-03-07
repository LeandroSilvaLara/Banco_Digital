package com.br.leandro.bancodigital.deposito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.widget.TextView;

import com.br.leandro.bancodigital.R;

public class DepositoFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposito_form);

        configToolbar();
    }

    private void configToolbar(){
        TextView textTitulo = findViewById(R.id.textTitulo);
        textTitulo.setText("Depositar");

        findViewById(R.id.ibVoltar).setOnClickListener(v -> finish());
    }
}