package hu.progmasters.gondor;

import hu.progmasters.jelolointerfacek.Melee;
import hu.progmasters.kozosAbstractok.Unit;

public class Soldier extends Unit implements Melee {

    public Soldier() {                              // Katona
        eletero = 100;
        sebzes = 10;
        koltseg =50;
        zsakmany = 20;
    }
}
