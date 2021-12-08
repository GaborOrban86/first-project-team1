package hu.progmasters.mordor.egysegek;

import hu.progmasters.enumok.MordorUnitsEnum;
import hu.progmasters.jelolointerfacek.Ranged;
import hu.progmasters.kozosAbstractok.Unit;

public class Archer extends Unit implements Ranged {

    public Archer() {
        hp = 100;
        damage = 8;
        cost = MordorUnitsEnum.ARCHER.getCost();
        loot = 15;
    }
}
