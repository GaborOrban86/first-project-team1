package hu.progmasters.mordor.units;

import hu.progmasters.enums.MordorUnitsEnum;
import hu.progmasters.markerInterfaces.Melee;
import hu.progmasters.commonAbstracts.Unit;

public class Grunt extends Unit implements Melee {
    public Grunt() {
        hp = 120;
        damage = 15;
        cost = MordorUnitsEnum.GRUNT.getCost();
        loot = 25;
    }


}
