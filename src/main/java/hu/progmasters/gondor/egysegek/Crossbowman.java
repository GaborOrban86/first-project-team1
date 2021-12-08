package hu.progmasters.gondor.egysegek;

import hu.progmasters.enumok.GondorUnitsEnum;
import hu.progmasters.jelolointerfacek.Ranged;
import hu.progmasters.kozosAbstractok.Unit;

public class Crossbowman extends Unit implements Ranged {

    public Crossbowman() {
        hp = 80;
        damage = 10;
        cost = GondorUnitsEnum.CROSSBOWMAN.getCost();
        loot = 15;
    }
}
