package hu.progmasters.mordor.egysegek;

import hu.progmasters.jelolointerfacek.Kozelharci;
import hu.progmasters.kozosAbstractok.Unit;

public class Ork extends Unit implements Kozelharci {
    public Ork() {
        eletero = 120;
        sebzes = 15;
        koltseg = 55;
        zsakmany = 25;
    }


}
