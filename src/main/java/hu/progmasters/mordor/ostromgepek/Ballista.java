package hu.progmasters.mordor.ostromgepek;

import hu.progmasters.enumok.MordorUnitsEnum;
import hu.progmasters.kozosAbstractok.SiegeMachines;

public class Ballista extends SiegeMachines {
    public Ballista() {
        damage = 50;
        cost = MordorUnitsEnum.BALLISTA.getCost();
    }


}

