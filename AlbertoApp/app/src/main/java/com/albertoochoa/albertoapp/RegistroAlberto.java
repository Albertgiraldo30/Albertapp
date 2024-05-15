package com.albertoochoa.albertoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroAlberto extends AppCompatActivity {

    Button btn_registrarse;
    EditText input_propietario;
    EditText input_cedula_nit;
    EditText input_dirreccion;
    EditText input_telefono;
    EditText input_correo;
    EditText input_nombre_usu;
    EditText input_contra;
    EditText input_confirma_contra;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alberto);

        // Inicializar Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference();

        btn_registrarse = findViewById(R.id.btn_registrarse);
        input_propietario = findViewById(R.id.input_propietario);
        input_cedula_nit = findViewById(R.id.input_cedula_nit);
        input_dirreccion = findViewById(R.id.input_dirreccion);
        input_telefono = findViewById(R.id.input_telefono);
        input_correo = findViewById(R.id.input_correo);
        input_nombre_usu = findViewById(R.id.input_nombre_usu);
        input_contra = findViewById(R.id.input_contra);
        input_confirma_contra = findViewById(R.id.input_confirma_contra);

        btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarInformacionFirebase();
            }
        });
    }

    private void agregarInformacionFirebase() {
        String propietario = input_propietario.getText().toString().trim();
        String cedulaNit = input_cedula_nit.getText().toString().trim();
        String direccion = input_dirreccion.getText().toString().trim();
        String telefono = input_telefono.getText().toString().trim();
        String correo = input_correo.getText().toString().trim();
        String nombreUsuario = input_nombre_usu.getText().toString().trim();
        String contra = input_contra.getText().toString().trim();
        String confirmaContra = input_confirma_contra.getText().toString().trim();

        Usuario usuario = new Usuario(propietario, cedulaNit, direccion, telefono, correo, nombreUsuario, contra, confirmaContra);

        databaseReference.child("usuarios").child(cedulaNit).setValue(usuario)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        mostrarMensaje("Usuario registrado correctamente");
                        irInicioSeccion();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        mostrarMensaje("Error al registrar el usuario");
                    }
                });
    }


    public void irInicioSeccion(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public static class Usuario {
        private String propietario;
        private String cedulaNit;
        private String direccion;
        private String telefono;
        private String correo;
        private String nombreUsuario;
        private String contra;
        private String confirmaContra;

        public Usuario() {
            // Constructor vacío requerido por Firebase
        }

        public Usuario(String propietario, String cedulaNit, String direccion, String telefono, String correo, String nombreUsuario, String contra, String confirmaContra) {
            this.propietario = propietario;
            this.cedulaNit = cedulaNit;
            this.direccion = direccion;
            this.telefono = telefono;
            this.correo = correo;
            this.nombreUsuario = nombreUsuario;
            this.contra = contra;
            this.confirmaContra = confirmaContra;
        }

        public String getPropietario() {
            return propietario;
        }

        public void setPropietario(String propietario) {
            this.propietario = propietario;
        }

        public String getCedulaNit() {
            return cedulaNit;
        }

        public void setCedulaNit(String cedulaNit) {
            this.cedulaNit = cedulaNit;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }

        public String getContra() {
            return contra;
        }

        public void setContra(String contra) {
            this.contra = contra;
        }

        public String getConfirmaContra() {
            return confirmaContra;
        }

        public void setConfirmaContra(String confirmaContra) {
            this.confirmaContra = confirmaContra;
        }
    }
}
