package hu.progmasters.mordor.units;

import hu.progmasters.enums.MordorUnitsEnum;
import hu.progmasters.signalInterfaces.Melee;
import hu.progmasters.commonAbstracts.Unit;

public class UrukHai extends Unit implements Melee {
    public UrukHai() {
        hp = 200;
        damage = 18;
        cost = MordorUnitsEnum.URUK_HAI.getCost();
        loot = 50;
    }
}
