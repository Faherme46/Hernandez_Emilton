package com.example.hernandez_mejia.clases;

public class Producto {

    private String nombre;
    private String urlImg;
    private Double precio;

    public Producto(String nombre, String urlImg, Double precio) {
        this.nombre = nombre;
        this.urlImg = urlImg;
        this.precio = precio;
    }

    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUrlImg() {
        return urlImg;
    }    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Double getPrecio() {
        return precio;
    }   public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
