package hu.progmasters.mordor.siegeMachines;

import hu.progmasters.enums.MordorUnitsEnum;
import hu.progmasters.commonAbstracts.SiegeMachines;

public class Catapult extends SiegeMachines {

    public Catapult() {
        damage = 10;
        cost = MordorUnitsEnum.CATAPULT.getCost();
    }
}
