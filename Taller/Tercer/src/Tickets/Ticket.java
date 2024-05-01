package Tickets;

public class Ticket {
    private String destino;
    private String horaSalida;
    private int capacidadPasajeros;
    private int pasajerosActuales;
    private String estado;

    public Ticket(String destino, String horaSalida, int capacidadPasajeros, String estado, int pasajerosActuales) {
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.capacidadPasajeros = capacidadPasajeros;
        this.pasajerosActuales = pasajerosActuales;
        this.estado = "";
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public int getPasajerosActuales() {
        return pasajerosActuales;
    }

    public String getEstado() {
        return estado;
    }

    public boolean hayAsientosDisponibles() {
        return pasajerosActuales < capacidadPasajeros;
    }

    public void reservarAsiento() {
        if (hayAsientosDisponibles()) {
            pasajerosActuales++;
            if (pasajerosActuales < capacidadPasajeros) {
                estado = "Reservado";
            }
            System.out.println("¡Asiento reservado!");
        }
    }

    public void cancelarVuelo() {
        estado = "Disponible";
        System.out.println("El vuelo ha sido cancelado.");
    }
}