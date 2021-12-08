package hu.progmasters.mordor.ostromgepek;

import hu.progmasters.enumok.MordorUnitsEnum;
import hu.progmasters.kozosAbstractok.SiegeMachines;

public class Katapult extends SiegeMachines {

    public Katapult() {
        damage = 10;
        cost = MordorUnitsEnum.CATAPULT.getCost();
    }
}
