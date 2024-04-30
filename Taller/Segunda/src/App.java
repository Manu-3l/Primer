import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        showMainMenus();
    }
    
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static void showMainMenus(){    
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear Producto");
            System.out.println("2. Mostrar Productos");
            System.out.println("3. Ingresar Dinero");
            System.out.println("4. Retirar Dinero");
            System.out.println("5. Transferir");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    createProduct();
                    break;    
                case 2:
                    searchProducto();
                    break;
                case 3:
                    listProduct();
                    break;
                case 4:
                    insertAmount();
                    break;
                case 5:
                    soldProduct();
                    break;
                case 6:
                    destroyProducto();
                    break;
                case 7:
                System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
        
    }
    static void createProduct(){
        try{
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado introducir Producto");
        System.out.println("--------------------------------------------");
        Producto p = new Producto();
        p.setName();
        p.setDinero();
        p.setId();
        p.setAmount();
        listaProductos.add(p);
        System.out.println("Producto creado con éxito.");
        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
        }catch(InputMismatchException e){
            System.out.println("Debe de digitar un caracter adecuado");
        }        
    }

    static void listProduct(){
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado listar Productos");
        System.out.println("--------------------------------------------");
        if (listaProductos.isEmpty()) {
            System.out.println("No hay Productos registrados.");
        } else {
            System.out.println("Lista de Productos:");
            for (Producto Producto : listaProductos) {
                Producto.imprimirInfoProducto();
            }
        }
        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }

    static void insertAmount() {
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado surtir producto");
        System.out.println("--------------------------------------------");

        if (listaProductos.isEmpty()) {
            System.out.println("No hay Productos registrados.");
            return;
        }

        System.out.println("Productos registrados:");

        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println((i + 1) + ". " + listaProductos.get(i).getNombre());
        }

        System.out.println("--------------------------------------------");
        System.out.print("Seleccione un Producto: ");

        int clientIndex = scanner.nextInt();

        if (clientIndex < 1 || clientIndex > listaProductos.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        System.out.print("\nCuanto se surtió?: ");
        short supply = scanner.nextShort();

        Producto selectedClient = listaProductos.get(clientIndex - 1);
        selectedClient.addAmount(supply);

        System.out.println("\nEl producto"+ selectedClient.getNombre() + "se ingreso correctamente " );
        System.out.println("Total en el inventario" + selectedClient.getAmount());
        System.out.println("--------------------------------------------");

        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }


    static void searchProducto() {
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado buscar Producto");
        System.out.println("--------------------------------------------");

        System.out.println("¿Cómo desea buscar al Producto?");
        System.out.println("1. Nombre");
        System.out.println("2. ID");
        System.out.print("Seleccione una opción: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        String nameSearch = "";
        short idSearch = 0;
        try{
        if (option == 1) {
            System.out.print("Ingrese el nombre completo del Producto: ");
            nameSearch = scanner.nextLine();
        } else if (option == 2) {
            System.out.print("Ingrese el ID del Producto: ");
            idSearch = scanner.nextShort();
        } else {
            System.out.println("Opción no válida. Volviendo al menú principal...");
            return;
        }
        }catch(InputMismatchException e){
            System.out.println("Debe de digitar un nombre si escogió la primera o un numero si escogió la segunda");
        }

        ArrayList<Producto> foundProducto = new ArrayList<>();

        for (Producto producto : listaProductos) {
            if (option == 1 && producto.getNombre().equalsIgnoreCase(nameSearch)) {
                foundProducto.add(producto);
            } else if (option == 2 && producto.getId() == idSearch) {
                foundProducto.add(producto);
            }
        }

        if (!foundProducto.isEmpty()) {

            if (foundProducto.size() > 1) {
                System.out.println("Se han encontrado varios Productos con el nombre o codigo proporcionado:");
                displayProductos(foundProducto);
            } else {

                System.out.println("Producto encontrado:");
                displayProductos(foundProducto);
            }
        } else {
            System.out.println("No se ha encontrado ningún Producto con el nombre proporcionado.");
        }

        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
    }

    static void displayProductos(ArrayList<Producto> foundProducto) {
        System.out.println("\nProducto(s) encontrado(s):");
        for (Producto client : foundProducto) {
            System.out.println("Nombre: " + client.getNombre());
            System.out.println("Dinero: " + client.getDinero());
            System.out.println("Precio: " + client.getId());
            System.out.println("Cantidad: " + client.getAmount());
            System.out.println("--------------------------------------------");
        }
    }

    static void destroyProducto() {
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado destruir producto");
        System.out.println("--------------------------------------------");

        System.out.println("¿Cómo desea buscar al Producto?");
        System.out.println("1. Nombre");
        System.out.println("2. ID");
        System.out.print("Seleccione una opción: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        String nameSearch = "";
        short idSearch = 0;
        try{
        if (option == 1) {
            System.out.print("Ingrese el nombre completo del Producto: ");
            nameSearch = scanner.nextLine();
        } else if (option == 2) {
            System.out.print("Ingrese el ID del Producto: ");
            idSearch = scanner.nextShort();
        } else {
            System.out.println("Opción no válida. Volviendo al menú principal...");
            return;
        }
        }catch(InputMismatchException e){
            System.out.println("Debe de digitar un nombre si escogió la primera o un numero si escogió la segunda");
        }

        ArrayList<Producto> foundProducto = new ArrayList<>();

        for (Producto producto : listaProductos) {
            if (option == 1 && producto.getNombre().equalsIgnoreCase(nameSearch)) {
                foundProducto.remove(producto);
            } else if (option == 2 && producto.getId() == idSearch) {
                foundProducto.remove(producto);
            }
        }

        if (!foundProducto.isEmpty()) {

            if (foundProducto.size() > 1) {
                System.out.println("Se han encontrado varios Productos con el nombre o codigo proporcionado y se han eliminado");
            } else {

                System.out.println("Producto encontrado y eliminado");
            }
        } else {
            System.out.println("No se ha encontrado ningún Producto con el nombre proporcionado.");
        }

        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
    }


    static void soldProduct() {
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado producto vendido");
        System.out.println("--------------------------------------------");

        if (listaProductos.isEmpty()) {
            System.out.println("No hay Productos registrados.");
            return;
        }

        System.out.println("Productos registrados:");
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println((i + 1) + ". " + listaProductos.get(i).getNombre());
        }

        System.out.println("--------------------------------------------");
        System.out.print("Seleccione el número del Producto: ");
        int productIndex = scanner.nextInt();

        try{
        if (productIndex < 1 || productIndex > listaProductos.size()) {
            System.out.println("Selección inválida.");
            return;
        }
        }catch(InputMismatchException e){
            System.out.println("Debe de digitar un numero entre ese rango, no letras u otros simbolos");
        }

        Producto selectedProduct = listaProductos.get(productIndex - 1);

        System.out.println("\nLa cantidadad de producto en el inventario es " + selectedProduct.getAmount());
        System.out.print("Ingrese la cantidad vendida: ");
        short delete = scanner.nextShort();

        try{
            if (delete >= selectedProduct.getAmount()){
                throw new ProductAmountException("No hay suficientes en el inventario");
            }
            
        }catch(ProductAmountException e){
            System.out.println(e.getMessage());
        }

        selectedProduct.deleteAmount(delete);

        System.out.println("\nSe vendieron correctamente " + selectedProduct.getNombre());
        System.out.println("Cantidad en el inventario " + selectedProduct.getAmount());
        System.out.println("--------------------------------------------");

        if (productIndex < 1 || productIndex > listaProductos.size()) {
            System.out.println("Selección inválida.");
            return;
        }
        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }

    

}

