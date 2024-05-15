package com.albertoochoa.albertoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroVehiculos extends AppCompatActivity {

    Button btn_regresar_vehiculos;
    Button btn_registro_vehiculos;
    EditText licencia_transito;
    EditText input_placa;
    EditText input_marca;
    EditText input_linea;
    EditText input_modelo;
    EditText input_cilindraje;
    EditText input_color;
    EditText input_servicio;
    EditText input_clase_vehiculo;
    EditText input_tipo_carroceria;
    EditText input_numero_motor;
    EditText input_capacidad_vehiculo;
    EditText input_numero_chasis;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vehiculos);

        // Inicializar Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference();

        btn_regresar_vehiculos = findViewById(R.id.btn_regresar_vehiculos);
        btn_registro_vehiculos = findViewById(R.id.btn_registro_vehiculos);
        licencia_transito = findViewById(R.id.licencia_trasito);
        input_placa = findViewById(R.id.input_placa);
        input_marca = findViewById(R.id.input_marca);
        input_linea = findViewById(R.id.input_linea);
        input_modelo = findViewById(R.id.input_modelo);
        input_cilindraje = findViewById(R.id.input_cilidraje);
        input_color = findViewById(R.id.input_color);
        input_servicio = findViewById(R.id.input_servicio);
        input_clase_vehiculo = findViewById(R.id.input_clase_vehicu);
        input_tipo_carroceria = findViewById(R.id.input_tipo_carroseria);
        input_numero_motor = findViewById(R.id.input_numero_motor);
        input_capacidad_vehiculo = findViewById(R.id.input_capacidad_vehiculo);
        input_numero_chasis = findViewById(R.id.input_numero_chasis);

        btn_regresar_vehiculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irVehiculos();
            }
        });

        btn_registro_vehiculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarInformacionVehiculo();
            }
        });
    }

    private void guardarInformacionVehiculo() {
        String placa = input_placa.getText().toString().trim();
        String marca = input_marca.getText().toString().trim();
        String linea = input_linea.getText().toString().trim();
        String modelo = input_modelo.getText().toString().trim();
        String cilindraje = input_cilindraje.getText().toString().trim();
        String color = input_color.getText().toString().trim();
        String servicio = input_servicio.getText().toString().trim();
        String claseVehiculo = input_clase_vehiculo.getText().toString().trim();
        String tipoCarroceria = input_tipo_carroceria.getText().toString().trim();
        String numeroMotor = input_numero_motor.getText().toString().trim();
        String capacidadVehiculo = input_capacidad_vehiculo.getText().toString().trim();
        String numeroChasis = input_numero_chasis.getText().toString().trim();

        Vehiculo vehiculo = new Vehiculo(placa, marca, linea, modelo, cilindraje, color, servicio, claseVehiculo, tipoCarroceria, numeroMotor, capacidadVehiculo, numeroChasis);

        // Usar la placa como clave principal
        Task<Void> voidTask = databaseReference.child("vehiculos").child(placa).setValue(vehiculo)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        mostrarMensaje("El vehículo se ha registrado correctamente");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        mostrarMensaje("Error al registrar el vehículo");
                    }
                });
    }

    public void irVehiculos() {
        Intent intent = new Intent(this, Vehiculos.class);
        startActivity(intent);
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
