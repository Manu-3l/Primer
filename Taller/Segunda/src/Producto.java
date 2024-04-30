import java.util.Scanner;

public class Producto {
        Scanner scanner = new Scanner(System.in);
        private String nombre;
        private double dinero;
        private short id;
        private short amount;
    
        
        

        public Producto() {
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

        public short getId() {
            return id;
        }

        public void setId(short id) {
            this.id = id;
        }

        public void setId() {
            System.out.print("Ingrese su nombre: ");
            id = scanner.nextShort();
        }

        public short getAmount() {
            return amount;
        }

        public void setAmount(short amount) {
            this.amount = amount;
        }

        public void setAmount() {
            System.out.print("Ingrese su nombre: ");
            amount = scanner.nextShort();
        }

    
        public void addAmount(short quantity){
            amount += quantity;
        }
    
        public void deleteAmount(short quantity){
            amount -= quantity;
        }
    
        public void imprimirInfoProducto() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Dinero: " + dinero);
            System.out.println("Dinero: " + id);
            System.out.println("Dinero: " + amount);
        }
}
    

