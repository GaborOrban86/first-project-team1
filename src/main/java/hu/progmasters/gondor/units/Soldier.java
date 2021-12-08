package hu.progmasters.gondor.units;

import hu.progmasters.enums.GondorUnitsEnum;
import hu.progmasters.signalInterfaces.Melee;
import hu.progmasters.commonAbstracts.Unit;

public class Soldier extends Unit implements Melee {

    public Soldier() {                              // Katona
        hp = 100;
        damage = 10;
        cost = GondorUnitsEnum.FOOTMAN.getCost();
        loot = 20;
    }

}
