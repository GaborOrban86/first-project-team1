package hu.progmasters.mordor.ostromgepek;

import hu.progmasters.enumok.MordorEgysegekEnum;
import hu.progmasters.kozosAbstractok.Ostromgep;

public class Ballista extends Ostromgep {
    public Ballista() {
        sebzes = 50;
        koltseg = MordorEgysegekEnum.BALLISTA.getCost();
    }


}

