package com.example.idnp_lab05;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btnNuevo = findViewById(R.id.btnNew);
        Button btnInfo = findViewById(R.id.btnInfo);
        ArrayList<Postulante> postulantes = new ArrayList<Postulante>();

        ActivityResultLauncher<Intent>  actLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()==1) {
                            Intent intent = result.getData();
                            if(intent != null) {
                                postulantes.add((Postulante) intent.getSerializableExtra("postulante"));
                            }
                        }
                    }
                }
        );
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistroActivity.class);
                actLauncher.launch(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle a = new Bundle();
                a.putSerializable("array", postulantes);
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                intent.putExtra("bundle", a);
                startActivity(intent);
            }
        });
    }
}