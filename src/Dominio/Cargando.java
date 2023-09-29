package Dominio;

public class Cargando implements Estado {
    
    private Carrito carrito;
    
    
    public Cargando(Carrito carrito) {
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
        
        if (this.carrito.cantidadItems() > 0) {
            this.carrito.setCostoTotal(this.carrito.getCostoTotal()-producto.getPrecio());
            this.carrito.getListaProductos().remove(producto);
            
            
            if (this.carrito.cantidadItems() == 0) {
                this.carrito.setEstado(new Vacio(carrito));
                this.carrito.setCostoTotal(0);
                return true;
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean volverEstadoAnterior() {
        Carrito carritoAux = this.carrito;
        carritoAux.setEstado(new Vacio(carrito));
        return carritoAux.vaciarCarrito();
    }
    
    
    @Override
    public boolean cerrarCompra() {
        this.carrito.setEstado(new Pagando(carrito));
        return true;
    }
    
    @Override
    public boolean cancelarCompra() {
       return  this.carrito.vaciarCarrito();
        
       
    }
    
    
    @Override
    public String toString() {
        return "Cargando";
    }
}
