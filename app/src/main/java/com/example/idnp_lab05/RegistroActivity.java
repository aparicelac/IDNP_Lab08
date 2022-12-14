package com.example.idnp_lab05;

import static com.example.idnp_lab05.StorageHelper.writeFile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        EditText edtDNI = findViewById(R.id.edtDNI);
        EditText edtNombres = findViewById(R.id.edtNombres);
        EditText edtApellidoPat = findViewById(R.id.edtApellidoPat);
        EditText edtApellidoMat = findViewById(R.id.edtApellidoMat);
        EditText edtFecha = findViewById(R.id.edtFecha);
        EditText edtColegio = findViewById(R.id.edtColegio);
        EditText edtCarrera = findViewById(R.id.edtCarrera);
        Button btnRegistro = findViewById(R.id.btnRegistro);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Postulante p = new Postulante();
                p.setApellido_paterno(edtApellidoPat.getText().toString());
                p.setApellido_materno(edtApellidoMat.getText().toString());
                p.setNombres(edtNombres.getText().toString());
                p.setFecha_nacimiento(edtFecha.getText().toString());
                p.setColegio(edtColegio.getText().toString());
                p.setCarrera(edtCarrera.getText().toString());
                p.setCodigo(edtDNI.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("postulante", p);
                setResult(1, intent);
                RegistroActivity.super.onBackPressed();
                writeFile(getApplicationContext(), p.getCodigo(), p.toString());
                Toast.makeText(getApplicationContext(),"Registrado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}