package model;

import enums.TipoAcessoRFID;

import java.util.ArrayList;
import java.util.List;

public class RFID {

    private static RFID rfid = null;
    private final List<RFIDSubscriber> subscribers;

    private RFID() {
        this.subscribers = new ArrayList<>();
    }

    public static RFID getRFID() {
        if (rfid == null) {
            rfid = new RFID();
        }

        return rfid;
    }

    public void notificarEntrada() {
        System.out.println("Leitor de Identificação por Rádio Frequência notificando entrada de docente.");
        for (RFIDSubscriber subscriber : this.subscribers) {
            subscriber.update(TipoAcessoRFID.ENTRADA);
        }
    }

    public void notificarSaida() {
        System.out.println("Leitor de Identificação por Rádio Frequência notificando saida de docente.");
        for (RFIDSubscriber subscriber : this.subscribers) {
            subscriber.update(TipoAcessoRFID.SAIDA);
        }
    }

    public void subscribe(RFIDSubscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(RFIDSubscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

}
