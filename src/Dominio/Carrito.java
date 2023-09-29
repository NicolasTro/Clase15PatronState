package Dominio;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    
    private Estado estado;
    private int costoTotal;
    
    
    private List<Producto> listaProductos = new ArrayList<>();
    
    public Estado getEstado() {
        return estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public List<Producto> getListaProductos() {
        return listaProductos;
    }
    
    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    
    public int getCostoTotal() {
        return costoTotal;
    }
    
    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }
    
    public Carrito() {
        this.listaProductos = new ArrayList<>();
        this.costoTotal = 0;
        this.estado = new Vacio(this);
    }
    
    
    public void pagar() {
        this.getEstado().pagar();
    }
    
    public boolean agregarProducto(Producto producto) {
        if (producto != null) {
            this.getListaProductos().add(producto);
            this.costoTotal = costoTotal();
            return this.estado.agregarProducto(producto);
        } else {
            return false;
        }
    }
    
    public boolean eliminarProducto(Producto producto) {
        
            if (producto != null) {
                return this.getEstado().eliminarProducto(producto);
                
            
            
        }
            return false;
    }
    
    public void cerrarCompra() {
        this.getEstado().cerrarCompra();
    }
    
    
    public int cantidadItems() {
        return this.listaProductos.size();
    }
    
    
    @Override
    public String toString() {
        return "Mi Carrito: \n" + "Estado = " + estado + "\n" +
                       "Articulos = " + listaProductos + "\n" +
                       "Costo total: $" + costoTotal + "\n";
        
    }
    
    public int costoTotal() {
        int costoTotal = 0;
        for (Producto articulo : this.listaProductos) {
            costoTotal += articulo.getPrecio();
        }
        return costoTotal;
    }
    
    public boolean vaciarCarrito() {
        
        
        this.listaProductos.clear();
        return true;
    }
    
    
}
