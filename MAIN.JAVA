
import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}

class Restaurante {
    Scanner teclado = new Scanner(System.in);
    ArrayList<Producto> pedido = new ArrayList<>();

    Producto[] menu = {
        new Producto("Hamburguesa", 80),
        new Producto("Pizza", 120),
        new Producto("Tacos", 60),
        new Producto("Refresco", 30)
    };

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n===== MI RESTAURANTE =====");
            System.out.println("1. Realizar pedido");
            System.out.println("2. Ver total");
            System.out.println("3. Aplicar descuento");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    realizarPedido();
                    break;
                case 2:
                    verTotal();
                    break;
                case 3:
                    aplicarDescuento();
                    break;
                case 4:
                    System.out.println("Gracias por tu visita.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);
    }

    public void realizarPedido() {
        System.out.println("\n--- MENU DE PRODUCTOS ---");

        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". "
                    + menu[i].nombre + " - $"
                    + menu[i].precio);
        }

        System.out.print("Selecciona un producto (1-4): ");
        int opcion = teclado.nextInt();

        if (opcion >= 1 && opcion <= menu.length) {
            pedido.add(menu[opcion - 1]);
            System.out.println("Producto agregado correctamente.");
        } else {
            System.out.println("Producto no valido.");
        }
    }

    public double calcularTotal() {
        double total = 0;

        for (Producto producto : pedido) {
            total += producto.precio;
        }

        return total;
    }

    public void verTotal() {
        System.out.printf("Total del pedido: $%.2f%n",
                calcularTotal());
    }

    public void aplicarDescuento() {
        double total = calcularTotal();

        if (total >= 300) {
            double descuento = total * 0.10;
            double totalFinal = total - descuento;

            System.out.printf("Total original: $%.2f%n", total);
            System.out.printf("Descuento del 10%%: $%.2f%n",
                    descuento);
            System.out.printf("Total a pagar: $%.2f%n",
                    totalFinal);
        } else {
            System.out.printf("Tu total es: $%.2f%n", total);
            System.out.println(
                    "El descuento aplica a compras de $300 o mas.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        restaurante.mostrarMenu();
    }
}
