package hu.progmasters.gondor.epuletek;

import hu.progmasters.enumok.GondorUnitsEnum;
import hu.progmasters.kozosAbstractok.Building;

public class Tower extends Building {
    public Tower() {
        hp = 100;
        cost = GondorUnitsEnum.TOWER.getCost();
    }

}
