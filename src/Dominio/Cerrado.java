package Dominio;

public class Cerrado implements Estado{
    
    private Carrito carrito;
    public Cerrado (Carrito carrito){
        this.carrito = carrito;
    }
    
    @Override
    public boolean pagar() {
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
        this.carrito.vaciarCarrito();
        this.carrito.setCostoTotal(0);
        this.carrito.setEstado(new Vacio(carrito));
        return true;
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
        return "Compra cerrada";
    }
}
