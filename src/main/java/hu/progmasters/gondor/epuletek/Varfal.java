package hu.progmasters.gondor.epuletek;

import hu.progmasters.enumok.GondorEgysegekEnum;
import hu.progmasters.kozosAbstractok.Building;

public class Varfal extends Building {
    public Varfal() {
        eletero = 150;
        koltseg = GondorEgysegekEnum.WALL.getCost();
    }

}
