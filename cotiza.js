// Precios fijos de los productos (puedes agregar más productos si es necesario)
const precios = [15000, 26600, 115000, 94000]; 
const nombres = ["297", "563", "571", "568"]; 

// Mostrar productos disponibles
alert("Productos disponibles:");
for (let i = 0; i < precios.length; i++) {
    alert((i + 1) + ". " + nombres[i] + " - $ " + precios[i]);
}

let total = 0; 

// Bucle para ingresar varios productos
while (true) {
    let codigoProducto = parseInt(prompt("\nIngrese el código del producto (1-" + precios.length + ") o 0 para finalizar:"));
    
    if (codigoProducto === 0) {
        break;  // Termina el bucle si el usuario ingresa 0
    }

    if (codigoProducto < 1 || codigoProducto > precios.length) {
        alert("Código de producto inválido, intente nuevamente.");
        continue;
    }

    // Pedir la cantidad de unidades
    let cantidad = parseInt(prompt("Ingrese la cantidad de unidades:"));

    // Verificar si se aplica el descuento
    let precio = precios[codigoProducto - 1];  // Obtener el precio del producto seleccionado
    let descuento = 0;
    if (cantidad > 10) {
        descuento = 0.10; 
        alert("Se aplica un descuento del 10% por más de 10 unidades.");
    }

    // Calcular el precio final con descuento si es aplicable
    let precioFinal = precio * cantidad * (1 - descuento);

    // Mostrar el detalle de la compra
    alert("Producto: " + nombres[codigoProducto - 1]);
    alert("Cantidad: " + cantidad);
    alert("Precio por unidad: $ " + precio);
    alert("Descuento aplicado: " + (descuento * 100) + "%");
    alert("Total por producto: $ " + precioFinal);

    total += precioFinal;
}

// Mostrar el total final de la compra
alert("\nTotal a pagar: $ " + total);
