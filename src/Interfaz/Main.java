package Interfaz;

import Dominio.Carrito;
import Dominio.Producto;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static Scanner consola = new Scanner(System.in);
    
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    
    public static void main(String[] args) {
        
        
        Carrito carritoSuper = new Carrito();
        System.out.println("");
        System.out.println(YELLOW + "BIENVENIDO A MARKET DON PEPE" + RESET);
        System.out.println("-----------------------------");
        System.out.println("");
        int opcionSalida = 0;
        
        
        do {
            
            System.out.println(carritoSuper);
            
            imagenCarrito();
            
            
            System.out.println(GREEN +"   MENU PRINCIPAL"+ RESET);
            System.out.println("---------------------");
            System.out.println("1- Agregar producto");
            System.out.println("2- Eliminar producto");
            System.out.println("3- Vaciar carro");
            System.out.println("4- Pagar");
            System.out.println("5- Salir");
            System.out.println("");
            opcionSalida = validarNumero(5, "Ingrese opcion: ");
            
            
            switch (opcionSalida) {
                case 1:
                    System.out.println("");
                    System.out.println("Agregar Producto: ");
                    System.out.println("------------------");
                    System.out.print("Ingrese nombre: ");
                    String nombreProducto;
                    nombreProducto = consola.nextLine();
                    
                    
                    nombreProducto = nombreProducto.toUpperCase();
                    
                    int precioProducto = validarNumero(0, "Ingrese precio: ");
                    
                    Producto producto1 = new Producto(precioProducto, nombreProducto);
                    carritoSuper.agregarProducto(producto1);
                    System.out.println("");
                    System.out.println("Producto agregado al carrito:");
                    System.out.println("");
                    
                    break;
                
                
                case 2:
                    
                    System.out.println("Eliminar producto");
                    System.out.print("---------------------");
                    System.out.println("");
                    if (carritoSuper.cantidadItems() > 0) {
                        for (Producto articulo : carritoSuper.getListaProductos()) {
                            System.out.println(""+(carritoSuper.getListaProductos().indexOf(articulo)+1) +"- " + articulo);
                        }
                        
                        int productoAEliminar = validarNumero(carritoSuper.cantidadItems(), "Seleccione un producto a eliminar: ");
                        carritoSuper.eliminarProducto(carritoSuper.getListaProductos().get(productoAEliminar - 1));
                        
                    } else {
                        System.out.println("");
                        System.out.println("Carrito vacio");
                        System.out.println("");
                    }
                    break;
                
                case 3:
                    
                    System.out.println("Vaciar carrito");
                    System.out.println("---------------");
                    boolean respuesta1 = validarSiNo("Esta seguro S/N: ");
                    if (respuesta1) {
                        carritoSuper.vaciarCarrito();
                    }
                    
                    break;
                case 4:
                    System.out.println("Pagar compra");
                    System.out.println("-------------");
                    if (carritoSuper.cantidadItems() > 0) {
                        
                        boolean respuesta2 = validarSiNo("Desea pagar la compra S/N: ");
                        if (respuesta2) {
                            carritoSuper.cerrarCompra();
                            carritoSuper.pagar();
                            System.out.println("");
                            System.out.println(carritoSuper);
                            boolean respuesta3 = validarSiNo("Desea abonar S/N: ");
                            if (respuesta3) {
                                System.out.println("");
                                System.out.println("Pago realizado");
                                System.out.println("");
                                carritoSuper.vaciarCarrito();
                                carritoSuper.getEstado().volverEstadoAnterior();
                                
                                
                            }
                        }
                    } else {
                        System.out.println("Carrito vacio");
                    }
                    
                    break;
                default:
                    
                    break;
            }
            
            
        } while (opcionSalida != 5);
        
        consola.close();
    }
    
    private static int validarNumero(int maximo, String titulo) {
        String numero = "";
        int resultado = 0;
        boolean salida = false;
        
        
        do {
            
            try {
                
                System.out.print(titulo);
                
                
                numero = consola.nextLine();
                if (numero.trim().length() > 0) {
                    
                    resultado = Integer.parseInt(numero);
                    
                    if (resultado > 0) {
                        if (maximo == 0) {
                            salida = true;
                        } else if (resultado <= maximo) {
                            salida = true;
                        } else {
                            System.out.println("Numero fuera de rango");
                            System.out.println("Ingresar entre 1 y " + maximo);
                        }
                    }
                }
                
            } catch (Exception e) {
                System.out.println("Error ingreso no valido");
            }
            
        } while (!salida);
        
        return resultado;
        
    }
    
    
    private static boolean validarSiNo(String titulo) {
        boolean salida = false;
        boolean resultado = false;
        do {
        
        System.out.print(titulo);
            String respuesta = consola.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                salida = true;
                resultado = true;
            } else if (respuesta.equalsIgnoreCase("n")) {
                salida = true;
                resultado = false;
            } else {
                System.out.println("Ingrese S o N");
            }
        } while (!salida);
        return resultado;
        
    }
    
    
    private static void imagenCarrito() {
        System.out.println("");
        System.out.println(YELLOW+"\\__________________|===O");
        System.out.println(" \\_________________|");
        System.out.println("  \\________________|");
        System.out.println("   \\_______________|");
        System.out.println("        0       0");
        System.out.println(""+RESET);
    }
    
    
}
