package hu.progmasters.gondor.egysegek;

import hu.progmasters.enumok.GondorEgysegekEnum;
import hu.progmasters.jelolointerfacek.Kozelharci;
import hu.progmasters.kozosAbstractok.Unit;

public class Soldier extends Unit implements Kozelharci {

    public Soldier() {                              // Katona
        eletero = 100;
        sebzes = 10;
        koltseg = GondorEgysegekEnum.FOOTMAN.getCost();
        zsakmany = 20;
    }

}
