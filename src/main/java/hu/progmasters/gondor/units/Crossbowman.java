package hu.progmasters.gondor.units;

import hu.progmasters.enums.GondorUnitsEnum;
import hu.progmasters.markerInterfaces.Ranged;
import hu.progmasters.commonAbstracts.Unit;

public class Crossbowman extends Unit implements Ranged {

    public Crossbowman() {
        hp = 80;
        damage = 10;
        cost = GondorUnitsEnum.CROSSBOWMAN.getCost();
        loot = 15;
    }
}
