package hu.progmasters.mordor.siegeMachines;

import hu.progmasters.enums.MordorUnitsEnum;
import hu.progmasters.commonAbstracts.SiegeMachines;

public class Ballista extends SiegeMachines {
    public Ballista() {
        damage = 50;
        cost = MordorUnitsEnum.BALLISTA.getCost();
    }


}

