package Dominio;

public class Pagando implements Estado{
    
    private Carrito carrito;
    
    
    public Pagando(Carrito carrito) {
    
        this.carrito = carrito;
    }
    
    
    @Override
    public boolean pagar() {
        if (this.carrito.cantidadItems() > 0) {
            int total= 0;
            for (Producto item : carrito.getListaProductos()) {
                total +=item.getPrecio();            }
            
            carrito.setEstado(new Cerrado(carrito));
            
        }
        return false;
    }
    
    @Override
    public boolean agregarProducto(Producto producto) {
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
    
        this.carrito.setEstado(new Vacio(carrito));
    
        
        
        return true;
    }
    
    @Override
    public boolean cancelarCompra() {
        return false;
    }
    
    @Override
    public String toString() {
        return "Pagando";
    }
}
