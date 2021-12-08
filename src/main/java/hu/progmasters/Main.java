package hu.progmasters;

import hu.progmasters.gondor.Gondor;
import hu.progmasters.gondor.egysegek.Soldier;
import hu.progmasters.gondor.egysegek.Szamszerijasz;
import hu.progmasters.kozosAbstractok.HarciEgysegek;
import hu.progmasters.mordor.Mordor;

public class Main {
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        System.out.println(soldier.getEletero());
        Szamszerijasz szamszerijasz = new Szamszerijasz();
        Gondor gondor = new Gondor (1000);
        gondor.getTavolharci().add(new Szamszerijasz());
        gondor.printArmy();

    }
}
