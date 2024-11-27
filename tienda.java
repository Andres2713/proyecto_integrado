import java.util.Scanner;

public class tienda {
    public static void main(String[] args) {
        // Precios fijos de los productos (puedes agregar más productos si es necesario)
        int[] precios = {15000, 26600, 115000, 94000}; 
        String[] nombres = {"297", "563", "571", "568"}; 
        Scanner scanner = new Scanner(System.in);

        // Mostrar productos disponibles
        System.out.println("Productos disponibles:");
        for (int i = 0; i < precios.length; i++) {
            System.out.println((i + 1) + ". " + nombres[i] + " - $ " + precios[i]);
        }

        int total = 0; 

        // Bucle para ingresar varios productos
        while (true) {
            System.out.print("\nIngrese el código del producto (1-" + precios.length + ") o 0 para finalizar: ");
            int codigoProducto = scanner.nextInt();

            if (codigoProducto == 0) {
                break;  // Termina el bucle si el usuario ingresa 0
            }

            if (codigoProducto < 1 || codigoProducto > precios.length) {
                System.out.println("Código de producto inválido, intente nuevamente.");
                continue;
            }

            // Pedir la cantidad de unidades
            System.out.print("Ingrese la cantidad de unidades: ");
            int cantidad = scanner.nextInt();

            // Verificar si se aplica el descuento
            int precio = precios[codigoProducto - 1];  // Obtener el precio del producto seleccionado
            double descuento = 0;
            if (cantidad > 10) {
                descuento = 0.10; 
                System.out.print("Se aplica un descuento del 10% por más de 10 unidades.");
            }

            // Calcular el precio final con descuento si es aplicable
            double precioFinal = precio * cantidad * (1 - descuento);

            // Mostrar el detalle de la compra
            System.out.println("Producto: " + nombres[codigoProducto - 1]);
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio por unidad: $ " + precio);
            System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
            System.out.println("Total por producto: $ " + precioFinal);

            total += precioFinal;
        }

        // Mostrar el total final de la compra
        System.out.println("\nTotal a pagar: $ " + total);
        scanner.close();
    }
}