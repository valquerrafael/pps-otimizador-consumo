package model;

import enums.EstadoEletronico;

public class Eletronico {

    private final String name;
    private EstadoEletronico estado = EstadoEletronico.DESLIGADO;

    public Eletronico(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public EstadoEletronico getEstado() {
        return estado;
    }

    public void ligar() {
        System.out.println("Ligando " + this.name + ".");
        this.estado = EstadoEletronico.LIGADO;
    }

    public void desligar() {
        System.out.println("Desligando " + this.name + ".");
        this.estado = EstadoEletronico.DESLIGADO;
    }

}
