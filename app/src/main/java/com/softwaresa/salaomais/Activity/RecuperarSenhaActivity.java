package com.softwaresa.salaomais.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.softwaresa.salaomais.R;

import androidx.appcompat.app.AppCompatActivity;

public class RecuperarSenhaActivity extends AppCompatActivity {

    private ImageButton imgbtnVoltar2;
    private Button btnSlavarNovSenha;
    private EditText editTEmailbuscar;
    private EditText editTNovasenha;
    private EditText edittConfNovSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        editTEmailbuscar = findViewById(R.id.editTEmailbuscar);
        editTNovasenha = findViewById(R.id.editTNovasenha);
        edittConfNovSenha = findViewById(R.id.edittConfNovSenha);
        btnSlavarNovSenha = findViewById(R.id.btnSlavarNovSenha);
        imgbtnVoltar2 = findViewById(R.id.imgbtnVoltar2);

        imgbtnVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar2 = new Intent( RecuperarSenhaActivity.this, LoginActivity.class);
                startActivity(voltar2);
            }
        });

        btnSlavarNovSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTEmailbuscar.getText().toString().equals("") || editTNovasenha.getText().toString().equals("") ||
                edittConfNovSenha.getText().toString().equals("")){
                    Toast.makeText( RecuperarSenhaActivity.this, "Preencha todos os campos.",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
