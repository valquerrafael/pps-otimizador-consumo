package model;

import enums.TipoAcessoRFID;

import java.util.ArrayList;
import java.util.List;

public class UnidadeAcademica implements RFIDSubscriber {

    private static UnidadeAcademica unidadeAcademica = null;
    private int docentesPresentes;
    private final List<Eletronico> eletronicos;

    private UnidadeAcademica() {
        this.docentesPresentes = 0;
        this.eletronicos = new ArrayList<>();
    }

    public static UnidadeAcademica getUnidadeAcademica() {
        if (unidadeAcademica == null) {
            unidadeAcademica = new UnidadeAcademica();
        }

        return unidadeAcademica;
    }

    public void addEletronico(Eletronico eletronico) {
        this.eletronicos.add(eletronico);
    }

    public void removeEletronico(Eletronico eletronico) {
        this.eletronicos.remove(eletronico);
    }

    @Override
    public void update(TipoAcessoRFID tipo) {
        if (tipo.equals(TipoAcessoRFID.ENTRADA)) {
            this.entrada();
        } else if (tipo.equals(TipoAcessoRFID.SAIDA)) {
            this.saida();
        }

        System.out.println("Quantidade de docentes presentes na unidade academica: " + this.docentesPresentes);
    }

    private void entrada() {
        if (this.docentesPresentes == 0) {
            System.out.println("Entrada do primeiro docente identificada.");
            this.ligarEletronicos();
        } else {
            System.out.println("Entrada de docente identificada.");
        }
        this.docentesPresentes++;
    }

    private void saida() {
        if (this.docentesPresentes > 0) {
            if (this.docentesPresentes == 1) {
                System.out.println("Saida do ultimo docente identificada.");
                this.desligarEletronicos();
            } else {
                System.out.println("Saida de docente identificada.");
            }
            this.docentesPresentes--;
        }
    }

    private void ligarEletronicos() {
        System.out.println("Ligando eletronicos da unidade academica.");
        for (Eletronico eletronico : this.eletronicos) {
            eletronico.ligar();
        }
    }

    private void desligarEletronicos() {
        System.out.println("Desligando eletronicos da unidade academica.");
        for (Eletronico eletronico : this.eletronicos) {
            eletronico.desligar();
        }
    }

}
