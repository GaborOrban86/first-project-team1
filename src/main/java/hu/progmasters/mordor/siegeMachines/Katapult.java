package hu.progmasters.mordor.siegeMachines;

import hu.progmasters.enums.MordorUnitsEnum;
import hu.progmasters.commonAbstracts.SiegeMachines;

public class Katapult extends SiegeMachines {

    public Katapult() {
        damage = 10;
        cost = MordorUnitsEnum.CATAPULT.getCost();
    }
}
