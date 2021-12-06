package hu.progmasters.mordor;

import hu.progmasters.jelolointerfacek.Kozelharci;
import hu.progmasters.kozosAbstractok.Unit;

public class Troll extends Unit implements Kozelharci {
    public Troll() {
        eletero = 200;
        sebzes = 18;
        koltseg = 140;
        zsakmany = 50;
    }
}
