package hu.progmasters.gondor.units;

import hu.progmasters.enums.GondorUnitsEnum;
import hu.progmasters.markerInterfaces.Melee;
import hu.progmasters.commonAbstracts.Unit;

public class Footman extends Unit implements Melee {

    public Footman() {                              // Katona
        hp = 100;
        damage = 10;
        cost = GondorUnitsEnum.FOOTMAN.getCost();
        loot = 20;
    }

}
