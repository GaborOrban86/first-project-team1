package hu.progmasters.gondor.buildings;

import hu.progmasters.enums.GondorUnitsEnum;
import hu.progmasters.commonAbstracts.Building;

public class Wall extends Building {
    public Wall() {
        hp = 150;
        cost = GondorUnitsEnum.WALL.getCost();
    }

}
