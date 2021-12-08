package hu.progmasters.mordor.egysegek;

import hu.progmasters.enumok.MordorUnitsEnum;
import hu.progmasters.jelolointerfacek.Melee;
import hu.progmasters.kozosAbstractok.Unit;

public class UrukHai extends Unit implements Melee {
    public UrukHai() {
        hp = 200;
        damage = 18;
        cost = MordorUnitsEnum.URUK_HAI.getCost();
        loot = 50;
    }
}
