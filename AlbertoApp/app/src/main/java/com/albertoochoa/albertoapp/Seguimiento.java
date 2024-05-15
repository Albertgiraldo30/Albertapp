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

public class Seguimiento extends AppCompatActivity {

  Button btn_regresar_seguimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seguimiento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        btn_regresar_seguimiento = findViewById(R.id.btn_regresar_seguimiento);

        btn_regresar_seguimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irRegresoSegui();
            }
        });
    }

    public void irRegresoSegui(){
        Intent intent = new Intent(this, InicioAlbertoOchoa.class);
        startActivity(intent);
    }


}