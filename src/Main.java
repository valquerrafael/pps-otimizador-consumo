import model.Docente;
import model.Eletronico;
import model.RFID;
import model.UnidadeAcademica;

public class Main {
    public static void main(String[] args) {

        Docente docente1 = new Docente("Alex");
        Docente docente2 = new Docente("Felipe");
        Docente docente3 = new Docente("Rita");
        Docente docente4 = new Docente("Valquer");
        Eletronico lampada1 = new Eletronico("lampada central");
        Eletronico lampada2 = new Eletronico("lampada secundaria");
        Eletronico arcondicionado = new Eletronico("arcondicionado");

        RFID rfid = RFID.getRFID();
        UnidadeAcademica unidadeAcademica = UnidadeAcademica.getUnidadeAcademica();

        unidadeAcademica.addEletronico(lampada1);
        unidadeAcademica.addEletronico(lampada2);
        unidadeAcademica.addEletronico(arcondicionado);

        rfid.subscribe(unidadeAcademica);

        docente1.entrar(rfid);
        System.out.println();
        docente2.entrar(rfid);
        System.out.println();
        docente3.entrar(rfid);
        System.out.println();
        docente4.entrar(rfid);
        System.out.println();

        docente1.sair(rfid);
        System.out.println();
        docente2.sair(rfid);
        System.out.println();
        docente3.sair(rfid);
        System.out.println();
        docente4.sair(rfid);

    }
}