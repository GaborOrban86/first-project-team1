package hu.progmasters.mordor.egysegek;

import hu.progmasters.enumok.MordorUnitsEnum;
import hu.progmasters.jelolointerfacek.Melee;
import hu.progmasters.kozosAbstractok.Unit;

public class Grunt extends Unit implements Melee {
    public Grunt() {
        hp = 120;
        damage = 15;
        cost = MordorUnitsEnum.GRUNT.getCost();
        loot = 25;
    }


}
