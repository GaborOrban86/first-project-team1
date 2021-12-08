package hu.progmasters.gondor.egysegek;

import hu.progmasters.enumok.GondorUnitsEnum;
import hu.progmasters.jelolointerfacek.Melee;
import hu.progmasters.kozosAbstractok.Unit;

public class Soldier extends Unit implements Melee {

    public Soldier() {                              // Katona
        hp = 100;
        damage = 10;
        cost = GondorUnitsEnum.FOOTMAN.getCost();
        loot = 20;
    }

}
