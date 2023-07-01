package model;

import enums.TipoAcessoRFID;

public interface RFIDSubscriber {

    void update(TipoAcessoRFID tipo);

}
