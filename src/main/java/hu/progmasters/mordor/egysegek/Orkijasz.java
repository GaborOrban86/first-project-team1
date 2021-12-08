package hu.progmasters.mordor.egysegek;

import hu.progmasters.enumok.MordorEgysegekEnum;
import hu.progmasters.jelolointerfacek.Tavolharci;
import hu.progmasters.kozosAbstractok.Unit;

public class Orkijasz extends Unit implements Tavolharci {

    public Orkijasz() {
        eletero = 100;
        sebzes = 8;
        koltseg = MordorEgysegekEnum.ARCHER.getCost();
        zsakmany = 15;
    }
}
