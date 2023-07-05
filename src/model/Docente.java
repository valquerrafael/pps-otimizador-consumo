package model;

public class Docente {

    private final String name;

    public Docente(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void entrar(RFID rfid) {
        System.out.println("Docente " + this.name + " entrou.");
        rfid.notificarEntrada();
    }

    public void sair(RFID rfid) {
        System.out.println("Docente " + this.name + " saiu.");
        rfid.notificarSaida();
    }

}
