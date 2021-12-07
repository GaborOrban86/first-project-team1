package hu.progmasters.gondor.egysegek;

import hu.progmasters.jelolointerfacek.Tavolharci;
import hu.progmasters.kozosAbstractok.Unit;

public class Szamszerijasz extends Unit implements Tavolharci {

    public Szamszerijasz() {
        eletero = 80;
        sebzes = 10;
        koltseg = 40;
        zsakmany = 15;
    }
}
