package Dominio;

public interface Estado {
    
    
    
    
    public boolean pagar();
    public boolean agregarProducto(Producto producto) ;
    
    public boolean eliminarProducto(Producto producto);
    
    public boolean volverEstadoAnterior();
    
    
    
    
    public boolean cerrarCompra();
    
    public boolean cancelarCompra();
    
    
    
    
    
    
    
    
    
}
