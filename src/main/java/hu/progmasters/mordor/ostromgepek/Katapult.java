package hu.progmasters.mordor.ostromgepek;

import hu.progmasters.enumok.MordorEgysegekEnum;
import hu.progmasters.kozosAbstractok.Ostromgep;

public class Katapult extends Ostromgep {

    public Katapult() {
        sebzes = 10;
        koltseg = MordorEgysegekEnum.CATAPULT.getCost();
    }
}
