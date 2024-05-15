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

public class InicioAlbertoOchoa extends AppCompatActivity {
    Button btn_cerrar_seccion;
    Button btn_vehiculos;
    Button btn_servicios;
    Button btn_seguimiento;
    Button btn_comentarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio_alberto_ochoa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_cerrar_seccion = findViewById(R.id.btn_cerrar_seccion);
        btn_vehiculos = findViewById(R.id.btn_vehiculos);
        btn_servicios = findViewById(R.id.btn_servicios);
        btn_seguimiento = findViewById(R.id.btn_seguimiento);
        btn_comentarios = findViewById(R.id.btn_comentarios );

        btn_cerrar_seccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irCerrarSeccion();
            }
        });
        btn_vehiculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irVehiculos();
            }
        });
        btn_servicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irServicios();
            }
        });
        btn_seguimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irSeguimiento();
            }
        });
        btn_comentarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irComentarios();
            }
        });



    }


    public void irCerrarSeccion(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void irVehiculos(){
        Intent intent = new Intent(this, Vehiculos.class);
        startActivity(intent);
    }

    public void irServicios(){
        Intent intent = new Intent(this, Servicios.class);
        startActivity(intent);
    }

    public void irSeguimiento(){
        Intent intent = new Intent(this, Seguimiento.class);
        startActivity(intent);
    }

    public void irComentarios(){
        Intent intent = new Intent(this, comentarios.class);
        startActivity(intent);
    }

}