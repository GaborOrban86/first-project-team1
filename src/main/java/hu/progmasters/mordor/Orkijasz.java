package hu.progmasters.mordor;

import hu.progmasters.jelolointerfacek.Tavolharci;
import hu.progmasters.kozosAbstractok.Unit;

public class Orkijasz extends Unit implements Tavolharci {

    public Orkijasz() {
        eletero = 100;
        sebzes = 8;
        koltseg = 40;
        zsakmany = 15;
    }
}
