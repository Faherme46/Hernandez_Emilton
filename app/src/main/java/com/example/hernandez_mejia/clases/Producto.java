package com.example.hernandez_mejia.clases;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.PropertyName;

import java.io.Serializable;

public class Producto implements Serializable {

    private String nombre;
    private String urlImg;
    private Double precio;
    private String id;

    public Producto(String nombre, String urlImg, Double precio, String id) {
        this.nombre = nombre;
        this.urlImg = urlImg;
        this.precio = precio;
        this.id = id;
    }

    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @PropertyName("url_img")
    public String getUrlImg() {
        return urlImg;
    }
    @PropertyName("url_img")
    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Double getPrecio() {
        return precio;
    }   public void setPrecio(Double precio) {
        this.precio = precio;
    }
    @Exclude
    public String getId() {
        return id;
    }
    @Exclude
    public void setId(String id) {
        this.id = id;
    }
}
