package hu.progmasters.mordor.egysegek;

import hu.progmasters.enumok.MordorEgysegekEnum;
import hu.progmasters.jelolointerfacek.Kozelharci;
import hu.progmasters.kozosAbstractok.Unit;

public class Troll extends Unit implements Kozelharci {
    public Troll() {
        eletero = 200;
        sebzes = 18;
        koltseg = MordorEgysegekEnum.URUK_HAI.getCost();
        zsakmany = 50;
    }
}
