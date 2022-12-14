package com.example.idnp_lab05;

import static com.example.idnp_lab05.StorageHelper.isFileExist;
import static com.example.idnp_lab05.StorageHelper.readFile;
import static com.example.idnp_lab05.StorageHelper.writeFile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    private static final String TAG = "Activity_PostulanteInfo";
    ArrayList<String> lista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        EditText buscarDNI = findViewById(R.id.edtBuscarDNI);
        Button btnBuscar = findViewById(R.id.btnBuscar);
        TextView resultado = findViewById(R.id.txtResultado);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearManager);
        AdapterRecyclerView adapter = new AdapterRecyclerView();
        recyclerView.setAdapter(adapter);

        Intent intent = getIntent();
        Bundle bndl = intent.getBundleExtra("bundle");
        ArrayList pst = (ArrayList<Postulante>)bndl.getSerializable("array");

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dni = buscarDNI.getText().toString();

                if (isFileExist(getApplicationContext(), dni)) {
                    lista.add(readFile(getApplicationContext(), dni));
                    adapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(lista.size()-1);
                }
            }
        });
    }


    private class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.AdapterRecyclerViewHolder> {

        @NonNull
        @Override
        public AdapterRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdapterRecyclerViewHolder(getLayoutInflater().inflate(R.layout.item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdapterRecyclerView.AdapterRecyclerViewHolder holder, int position) {
            holder.print(position);
        }

        @Override
        public int getItemCount() {
            return lista.size();
        }

        class AdapterRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView textViewPostulante;
            public AdapterRecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                textViewPostulante = itemView.findViewById(R.id.textViewPostulante);
                itemView.setOnClickListener(this);
            }

            public void print(int position) {
                textViewPostulante.setText(lista.get(position));
            }

            @Override
            public void onClick(View view) {

            }
        }
    }
}