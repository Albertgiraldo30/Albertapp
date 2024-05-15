package com.albertoochoa.albertoapp;

public class Vehiculo {
    private String placa;
    private String marca;
    private String linea;
    private String modelo;
    private String cilindraje;
    private String color;
    private String servicio;
    private String claseVehiculo;
    private String tipoCarroceria;
    private String numeroMotor;
    private String capacidadVehiculo;
    private String numeroChasis;

    public Vehiculo() {
        // Constructor vacío requerido por Firebase
    }

    public Vehiculo(String placa, String marca, String linea, String modelo, String cilindraje, String color,
                    String servicio, String claseVehiculo, String tipoCarroceria, String numeroMotor,
                    String capacidadVehiculo, String numeroChasis) {
        this.placa = placa;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.color = color;
        this.servicio = servicio;
        this.claseVehiculo = claseVehiculo;
        this.tipoCarroceria = tipoCarroceria;
        this.numeroMotor = numeroMotor;
        this.capacidadVehiculo = capacidadVehiculo;
        this.numeroChasis = numeroChasis;
    }

    // Getters y setters

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getClaseVehiculo() {
        return claseVehiculo;
    }

    public void setClaseVehiculo(String claseVehiculo) {
        this.claseVehiculo = claseVehiculo;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getCapacidadVehiculo() {
        return capacidadVehiculo;
    }

    public void setCapacidadVehiculo(String capacidadVehiculo) {
        this.capacidadVehiculo = capacidadVehiculo;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }
}
