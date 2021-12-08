package hu.progmasters.gondor.units;

import hu.progmasters.enums.GondorUnitsEnum;
import hu.progmasters.markerInterfaces.Melee;
import hu.progmasters.commonAbstracts.Unit;

public class Knight extends Unit implements Melee {
    public Knight() {
        hp = 250;
        damage = 20;
        cost = GondorUnitsEnum.KNIGHT.getCost();
        loot = 60;
    }


}
