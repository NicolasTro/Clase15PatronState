package Dominio;

public class Producto {
    
    private int precio;
    private String descripcion;
    
    public int getPrecio() {
        return precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Producto(int precio, String descripcion) {
        this.precio = precio;
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "precio = $" + precio + ", descripcion = " + descripcion;
    }
}
