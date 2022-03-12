package com.br.leandro.bancodigital.deposito;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.br.leandro.bancodigital.R;

import java.util.Locale;

public class DepositoFormActivity extends AppCompatActivity {

    private EditText edtvalor;
    private AlertDialog dialog;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposito_form);

        configToolbar();

        iniciaComponentes();

    }


    public void validaDeposito(View view) {
        double valorDeposito = (double) edtvalor.getShadowRadius() / 100;

        if(valorDeposito > 0) {

            ocultarTeclado();

            progressBar.setVisibility(View.VISIBLE);

            // Salvar Extrato

        }else {
            showDialog();
        }
    }

    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(
                this, R.style.CustomAlertDialog
        );

        View view = getLayoutInflater().inflate(R.layout.layout_dialog_info, null);

        TextView textTitulo = view.findViewById(R.id.textTitulo);
        textTitulo.setText("Atenção");

        TextView mensagem = view.findViewById(R.id.textMensagem);
        mensagem.setText("Digite um valor maior que 0.");

        Button btnOk = view.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(v -> dialog.dismiss());

        builder.setView(view);

        dialog = builder.create();
        dialog.show();
    }

    private void configToolbar(){
        TextView textTitulo = findViewById(R.id.textTitulo);
        textTitulo.setText("Depositar");

        findViewById(R.id.ibVoltar).setOnClickListener(v -> finish());
    }

    private void iniciaComponentes() {
        edtvalor = findViewById(R.id.edtvalor);
        edtvalor.setTextLocale(new Locale("PT", "br"));

        progressBar = findViewById(R.id.progressBar);
    }
    //Oculta o teclado do dispositivo
    private void ocultarTeclado() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(edtvalor.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}