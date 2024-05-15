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

public class MainActivity extends AppCompatActivity {

    Button btnRegistro;
    Button btn_ingreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnRegistro = findViewById(R.id.btnRegistro);
        btn_ingreso = findViewById(R.id.btn_ingreso);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irRegistro();
            }
        });

        btn_ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irInicio();
            }
        });
    }

    public void irInicio() {
        Intent intent = new Intent(this, InicioAlbertoOchoa.class);
        startActivity(intent);
    }

    public void irRegistro() {
        Intent intent = new Intent(this, RegistroAlberto.class);
        startActivity(intent);
    }
}
