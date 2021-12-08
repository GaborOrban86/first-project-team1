package hu.progmasters.gondor.egysegek;

import hu.progmasters.enumok.GondorUnitsEnum;
import hu.progmasters.jelolointerfacek.Melee;
import hu.progmasters.kozosAbstractok.Unit;

public class Knight extends Unit implements Melee {
    public Knight() {
        hp = 250;
        damage = 20;
        cost = GondorUnitsEnum.KNIGHT.getCost();
        loot = 60;
    }


}
