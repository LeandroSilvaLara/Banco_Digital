package com.br.leandro.bancodigital.autenticacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.br.leandro.bancodigital.MainActivity;
import com.br.leandro.bancodigital.R;
import com.br.leandro.bancodigital.helper.FirebaseHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtSenha;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniciaComponentes();

    }

    public void validaDados(View view) {
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();

        if (!senha.isEmpty()) {

            progressBar.setVisibility(View.VISIBLE);

            logar(email, senha);

        }else {
            edtSenha.requestFocus();
            edtSenha.setError("Informe sua senha.");
        }
        if (!email.isEmpty()) {

        }else {
            edtEmail.requestFocus();
            edtEmail.setError("Informe seu email.");
        }
    }

    public void criarConta(View view){
        startActivity(new Intent(this, CadastroActivity.class));
    }

    private void logar(String email, String senha) {
        FirebaseHelper.getAuth().signInWithEmailAndPassword(
                email, senha
        ).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(this, MainActivity.class));
                }else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void iniciaComponentes() {
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        progressBar = findViewById(R.id.progressBar);
    }
}