package com.example.idnp_lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtUsuario = findViewById(R.id.edtUser);
        EditText edtPassword = findViewById(R.id.edtPassword);
        TextView txtMensaje = findViewById(R.id.txtMensaje);
        Button btnIngresar = findViewById(R.id.btnLogin);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = edtUsuario.getText().toString();
                String password = edtPassword.getText().toString();

                if (usuario.equals("usuario") && password.equals("1234")) {
                    txtMensaje.setText("Usuario autenticado");

                    Button btnLogin = findViewById(R.id.btnLogin);

                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    txtMensaje.setText("Usuario NO autenticado");
                }
            }
        });
    }
}