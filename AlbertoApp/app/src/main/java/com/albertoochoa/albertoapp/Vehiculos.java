package com.albertoochoa.albertoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Vehiculos extends AppCompatActivity {


    Button btn_regresar_inicio;
    Button btn_registro_vehiculos;
    Button btn_mis_vehiculos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vehiculos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_regresar_inicio = findViewById(R.id.btn_regresar_inicio);
        btn_registro_vehiculos = findViewById(R.id.btn_registro_vehiculos);
        btn_mis_vehiculos = findViewById(R.id.btn_mis_vehiculos);





        btn_mis_vehiculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMisVehiculos();
            }
        });


        btn_regresar_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irRegresarInicio();
            }
        });

        btn_registro_vehiculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irRegistroVehiculos();
            }
        });
    }


    public void irRegresarInicio(){
        Intent intent = new Intent(this, InicioAlbertoOchoa.class);
        startActivity(intent);
    }

    public void irRegistroVehiculos(){
        Intent intent = new Intent(this, RegistroVehiculos.class);
        startActivity(intent);
    }


    public void irMisVehiculos(){
        Intent intent = new Intent(this, MisVehiculos.class);
        startActivity(intent);
    }
}