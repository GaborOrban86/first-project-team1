package hu.progmasters.gondor.egysegek;

import hu.progmasters.enumok.GondorEgysegekEnum;
import hu.progmasters.jelolointerfacek.Kozelharci;
import hu.progmasters.kozosAbstractok.Unit;

public class Lovag extends Unit implements Kozelharci {
    public Lovag() {
        eletero = 250;
        sebzes = 20;
        koltseg = GondorEgysegekEnum.KNIGHT.getCost();
        zsakmany = 60;
    }


}
