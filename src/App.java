import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        showMainMenus();
    }
    
    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static void showMainMenus(){    
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear usuario");
            System.out.println("2. Mostrar usuarios");
            System.out.println("3. Ingresar Dinero");
            System.out.println("4. Retirar Dinero");
            System.out.println("5. Transferir");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    createClient();
                    break;    
                case 2:
                    searchClient();
                    break;
                case 3:
                    insertMoney();
                    break;
                case 4:
                    deleteMoney();
                    break;
                case 5:
                    transferMoney();
                    break;
                case 6:
                System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
        
    }
    static void createClient(){
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado introducir usuario");
        System.out.println("--------------------------------------------");
        Usuario u = new Usuario();
        u.setName();
        u.setDinero();
        listaUsuarios.add(u);
        System.out.println("Usuario creado con éxito.");
        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();        
    }

    static void searchClient(){
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado listar clientes");
        System.out.println("--------------------------------------------");
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Lista de usuarios:");
            for (Usuario usuario : listaUsuarios) {
                usuario.imprimirInfoUsuario();
            }
        }
        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }

    static void insertMoney() {
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado Ingresar dinero");
        System.out.println("--------------------------------------------");

        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Clientes registrados:");

        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println((i + 1) + ". " + listaUsuarios.get(i).getNombre());
        }

        System.out.println("--------------------------------------------");
        System.out.print("Seleccione un cliente: ");

        int clientIndex = scanner.nextInt();

        if (clientIndex < 1 || clientIndex > listaUsuarios.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        System.out.print("\nCuanto desea ingresar?: ");
        int money = scanner.nextInt();

        Usuario selectedClient = listaUsuarios.get(clientIndex - 1);
        selectedClient.addMoney(money);

        System.out.println("\nEl dinero se ingreso correctamente " + selectedClient.getNombre());
        System.out.println("El saldo de su cuenta de ahorros es $" + selectedClient.getDinero());
        System.out.println("--------------------------------------------");

        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }


    static void deleteMoney() {
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado retirar dinero");
        System.out.println("--------------------------------------------");

        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Clientes registrados:");
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println((i + 1) + ". " + listaUsuarios.get(i).getNombre());
        }

        System.out.println("--------------------------------------------");
        System.out.print("Seleccione el número del cliente: ");
        int clientIndex = scanner.nextInt();

        if (clientIndex < 1 || clientIndex > listaUsuarios.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Usuario selectedClient = listaUsuarios.get(clientIndex - 1);

        System.out.println("\nEl saldo de su cuenta de ahorros es $" + selectedClient.getDinero());
        System.out.print("Ingrese el valor a retirar de la cuenta: ");
        double delete = scanner.nextDouble();

        try{
            if (delete >= selectedClient.getDinero()){
                throw new MoneyException("Tiene menos dinero en la cuenta");
            }
            
        }catch(MoneyException e){
            System.out.println(e.getMessage());
        }

        selectedClient.deleteMoney(delete);

        System.out.println("\nEl dinero se retiro correctamente de " + selectedClient.getNombre());
        System.out.println("El saldo de su cuenta ahora es $" + selectedClient.getDinero());
        System.out.println("--------------------------------------------");

        if (clientIndex < 1 || clientIndex > listaUsuarios.size()) {
            System.out.println("Selección inválida.");
            return;
        }
        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }

    static void transferMoney(){
        try{
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado transferir dinero");
        System.out.println("--------------------------------------------");

        if (listaUsuarios.isEmpty()) {
            throw new ListException("No hay un solo cliente registrado");
        }

        if(listaUsuarios.size() < 2){
            throw new UserException("Solo hay un cliente registrado");

        }

        System.out.println("Clientes registrados:");
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println((i + 1) + ". " + listaUsuarios.get(i).getNombre());
        }

        System.out.println("--------------------------------------------");
        System.out.print("Seleccione el número del cliente que va a realizar la transferencia: ");
        int clientIndex = scanner.nextInt();

        if (clientIndex < 1 || clientIndex > listaUsuarios.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Usuario selectedClient = listaUsuarios.get(clientIndex - 1);

        System.out.println("\nEl saldo de su cuenta es $" + selectedClient.getDinero());
        System.out.print("Ingrese el valor a transferir de la cuenta: ");
        double delete = scanner.nextDouble();

        try{
            if (delete >= selectedClient.getDinero()){
                throw new MoneyException("Tiene menos dinero en la cuenta");
            }
            
        }catch(MoneyException e){
            System.out.println(e.getMessage());
        }

        selectedClient.deleteMoney(delete);
        System.out.println("El saldo de su cuenta ahora es $" + selectedClient.getDinero());
        System.out.println("--------------------------------------------");

        System.out.print("Presiona Enter para continuar");
        scanner.nextLine();
        scanner.nextLine();

        System.out.println("Clientes registrados:");
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println((i + 1) + ". " + listaUsuarios.get(i).getNombre());
        }

        System.out.println("--------------------------------------------");
        System.out.print("Seleccione el número del cliente al que va a transferir: ");
       
        int clientIndex2 = scanner.nextInt();

        if (clientIndex2 < 1 || clientIndex2 > listaUsuarios.size() && clientIndex2 != clientIndex) {
            System.out.println("Selección inválida.");
            return;
        }

        Usuario selectedClient2 = listaUsuarios.get(clientIndex2 - 1);
        selectedClient2.addMoney(delete);

        System.out.println("\nEl dinero se transfirio correctamente a " + selectedClient2.getNombre());
        System.out.println("El saldo de la cuenta ahora es $" + selectedClient2.getDinero());
        System.out.println("--------------------------------------------");

        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();

    }catch(ListException e){
        System.out.println(e.getMessage());
    }catch(UserException e){
        System.out.println(e.getMessage());
    }

    }

}