package hu.progmasters.gondor;

import hu.progmasters.jelolointerfacek.Kozelharci;
import hu.progmasters.kozosAbstractok.Unit;

public class Lovag extends Unit implements Kozelharci {
    public Lovag() {
        eletero = 250;
        sebzes = 20;
        koltseg = 150;
        zsakmany = 60;
    }


}
