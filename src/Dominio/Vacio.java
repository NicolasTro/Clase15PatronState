package Dominio;

public class Vacio implements Estado {
    
    private Carrito carrito;
    
    
    public Vacio(Carrito carrito) {
        
        this.carrito = carrito;
    }
    
    
    @Override
    public boolean pagar() {
        return false;
    }
    
    @Override
    public boolean agregarProducto(Producto producto) {
        
            this.carrito.setEstado(new Cargando(carrito));
            return true;
        
    }
    
    @Override
    public boolean eliminarProducto(Producto producto) {
        return false;
    }
    
    @Override
    public boolean volverEstadoAnterior() {
        return false;
    }
    
    
    @Override
    public boolean cerrarCompra() {
        return false;
    }
    
    @Override
    public boolean cancelarCompra() {
        return false;
    }
    
    
    @Override
    public String toString() {
        return "Carrito vacio";
    }
}
