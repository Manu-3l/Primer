import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Tickets.Ticket;

public class App {
   public static void main(String[] args) {
        
        listTickets.add(new Ticket("Bogota","10:00", 100,"Disponible", 188));
        listTickets.add(new Ticket("Tokyo","14:30", 150,"Disponible", 149));
        listTickets.add(new Ticket("Paris","17:00", 200,"Disponible",200));
        listTickets.add(new Ticket("New York","11:30", 150,"Cancelado", 140));
        listTickets.add(new Ticket("Beijing","13:00", 300,"Disponible", 233));
        showMainMenus();
    }

    static ArrayList <Ticket> listTickets = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static void showMainMenus(){    
        while (true) {
            
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Reservar Vuelo");
            System.out.println("2. Buscar Vuelo");
            System.out.println("3. Cancelar vuelo");
            System.out.println("4. Salir");


            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    createTicket();
                    break;    
                case 2:
                    searchFlight();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
        
    }

    static void createTicket(){

        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado reservar Vuelo");
        System.out.println("--------------------------------------------");

        int numVuelo = 0;
        System.out.print("Seleccione el número de vuelo para reservar: ");
        try{
                for(Ticket vuelo : listTickets){
                    numVuelo++;
                    System.out.print("Vuelo " + numVuelo + " " + vuelo.getDestino());
                }
                int numeroVuelo = scanner.nextInt();
                Ticket vueloSeleccionado = listTickets.get(numeroVuelo);
                if (numeroVuelo >= 1 && numeroVuelo <= listTickets.size()){
                    throw new NumbException("Este numero no esta en el intervalo pedido");
                }else if(vueloSeleccionado.getEstado().equalsIgnoreCase("Cancelado")){
                    throw new CanceledException("Este vuelo esta cancelado, seleccione otro vuelo");
                }else if(vueloSeleccionado.getCapacidadPasajeros() == vueloSeleccionado.getPasajerosActuales()){
                    throw new CanceledException("Este vuelo esta lleno, reserve otro vuelo");
                }
                vueloSeleccionado.reservarAsiento();
                   
                    
            }catch(CanceledException e){
                System.out.println(e.getMessage());
            }catch(NumbException e){
                System.out.println(e.getMessage());
            }catch(InputMismatchException e){
                System.out.println("debe de introducir un valor numerico");
            }
    }

    

    static void searchFlight(){
        
        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado buscar Vuelo");
        System.out.println("--------------------------------------------");

        System.out.println("¿Que vuelo desea buscar?");
        String destiny = "";

        try{
            System.out.print("Ingrese el nombre completo del Producto: ");
            destiny = scanner.nextLine();
        }catch(InputMismatchException e){
            System.out.println("Debe de digitar el nombre del destino");
        }

        ArrayList<Ticket> foundTickets = new ArrayList<>();

        for (Ticket ticket : listTickets) {
            if(ticket.getDestino().equalsIgnoreCase(destiny)){
                foundTickets.add(ticket);
            }

        }

        if (!foundTickets.isEmpty()) {

            if (foundTickets.size() > 1) {
                System.out.println("Se han encontrado varios Productos con el nombre o codigo proporcionado:");
                displayTicket(foundTickets);
            } else {

                System.out.println("Producto encontrado:");
                displayTicket(foundTickets);
            }
        } else {
            System.out.println("No se ha encontrado ningún Producto con el nombre proporcionado.");
        }

        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
    }

    static void displayTicket(ArrayList<Ticket> foundTickets) {
        System.out.println("\nProducto(s) encontrado(s):");
        for (Ticket vuelo : foundTickets) {
            System.out.println("Nombre: " + vuelo.getDestino());
            System.out.println("Dinero: " + vuelo.getHoraSalida());
            System.out.println("Precio: " + vuelo.getEstado());
            System.out.println("Cantidad: " + vuelo.getCapacidadPasajeros());
            System.out.println("--------------------------------------------");
        }
    }

    static void cancelTicket(){

        System.out.println("--------------------------------------------");
        System.out.println("      Haz seleccionado cancelar Vuelo");
        System.out.println("--------------------------------------------");


            try{
            System.out.print("Seleccione el número de vuelo para cancelar: ");
                int numeroVuelo = scanner.nextInt();
                if (numeroVuelo >= 1 && numeroVuelo <= listTickets.size()) {
                    Ticket vueloSeleccionado = listTickets.get(numeroVuelo - 1);
                    if (vueloSeleccionado.getEstado().equalsIgnoreCase("Reservado")) {
                        vueloSeleccionado.reservarAsiento();
                    }else if(!vueloSeleccionado.getEstado().equalsIgnoreCase("Reservado")){
                        throw new NotBookedException("Este vuelo no ha sido");
                    }
                } else {
                    System.out.println("Número de vuelo no válido.");
                }}catch(NotBookedException e){
                    System.out.println(e.getMessage());
                }catch(InputMismatchException e){
                    System.out.println("Valor no valido");
                }
        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();

    } 

}


