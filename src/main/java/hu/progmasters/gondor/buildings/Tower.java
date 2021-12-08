package hu.progmasters.gondor.buildings;

import hu.progmasters.enums.GondorUnitsEnum;
import hu.progmasters.commonAbstracts.Building;

public class Tower extends Building {
    public Tower() {
        hp = 100;
        cost = GondorUnitsEnum.TOWER.getCost();
    }

}
