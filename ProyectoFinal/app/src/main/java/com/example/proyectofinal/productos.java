package com.example.proyectofinal;

public class productos {
    public String id, producto, categoria, ingredientes,url;
    public boolean disponibilidad;
    public int precio;

    public productos() {
    }

    public String getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public int getPrecio() {
        return precio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
