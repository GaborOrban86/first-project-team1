package hu.progmasters.gondor.epuletek;

import hu.progmasters.enumok.GondorUnitsEnum;
import hu.progmasters.kozosAbstractok.Building;

public class Wall extends Building {
    public Wall() {
        hp = 150;
        cost = GondorUnitsEnum.WALL.getCost();
    }

}
