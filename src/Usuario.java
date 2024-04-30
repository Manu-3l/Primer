import java.util.Scanner;

public class Usuario {
    Scanner scanner = new Scanner(System.in);
    private String nombre;
    private double dinero;

    public Usuario() {
        this.nombre = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setName() {
        System.out.print("Ingrese su nombre: ");
        nombre = scanner.nextLine();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public void setDinero(){
        System.out.print("Ingrese su dinero actual: ");
        dinero = scanner.nextDouble();
    }

    public void addMoney(double money){
        dinero += money;
    }

    public void deleteMoney(double amount){
        dinero -= amount;
        
    }

    public void imprimirInfoUsuario() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Dinero: " + dinero);
    }
}