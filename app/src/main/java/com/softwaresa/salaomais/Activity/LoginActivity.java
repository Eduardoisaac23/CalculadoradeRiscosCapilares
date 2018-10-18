package com.softwaresa.salaomais.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.softwaresa.salaomais.DAO.ConfiguracaoFirebase;
import com.softwaresa.salaomais.Entidades.Usuarios;
import com.softwaresa.salaomais.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTEmail;
    private EditText editTSenha;
    private TextView textVRecSenha;
    private TextView textVCadastrar;
    private Button btnLogar;
    private FirebaseAuth autenticacao;
    private Usuarios usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTEmail = findViewById(R.id.editTEmail);
        editTSenha = findViewById(R.id.editTSenha);
        textVCadastrar = findViewById(R.id.textVCadastrar);
        textVRecSenha = findViewById(R.id.textVRecSenha);
        btnLogar = findViewById(R.id.btnLogar);

        //chamar tela de Cadastro
        textVCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
                startActivity(intent);
            }
        });
        // Chamar tela de Recuperar senha
        textVRecSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recuperar  = new Intent( LoginActivity.this, RecuperarSenhaActivity.class);
                startActivity(recuperar);
            }
        });



        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!editTEmail.getText().toString().equals("") && !editTSenha.getText().toString().equals("")){

                    usuarios = new Usuarios();
                    usuarios.setEmail(editTEmail.getText().toString());
                    usuarios.setSenha(editTSenha.getText().toString());

                    valiadrlogin();

                } else {
                    Toast.makeText(LoginActivity.this, "Preencha os campos email e senha.", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
    private void valiadrlogin(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuarios.getEmail(),usuarios.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){



                    Toast.makeText(LoginActivity.this, "login efetuado com sucesso.",Toast.LENGTH_LONG).show();
                    abrirŧelaMenu();

                }else{
                    Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos.",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

public void abrirŧelaMenu(){
        Intent intentabrirŧelaMenu = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intentabrirŧelaMenu);
}

}
