package hu.progmasters.mordor.egysegek;

import hu.progmasters.enumok.MordorEgysegekEnum;
import hu.progmasters.jelolointerfacek.Kozelharci;
import hu.progmasters.kozosAbstractok.Unit;

public class Ork extends Unit implements Kozelharci {
    public Ork() {
        eletero = 120;
        sebzes = 15;
        koltseg = MordorEgysegekEnum.GRUNT.getCost();
        zsakmany = 25;
    }


}
