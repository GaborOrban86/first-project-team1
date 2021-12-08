package hu.progmasters.mordor.units;

import hu.progmasters.enums.MordorUnitsEnum;
import hu.progmasters.signalInterfaces.Ranged;
import hu.progmasters.commonAbstracts.Unit;

public class Archer extends Unit implements Ranged {

    public Archer() {
        hp = 100;
        damage = 8;
        cost = MordorUnitsEnum.ARCHER.getCost();
        loot = 15;
    }
}
