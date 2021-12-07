package hu.progmasters.mordor;

import hu.progmasters.kozosAbstractok.HarciEgysegek;
import hu.progmasters.mordor.ostromgepek.Ballista;
import hu.progmasters.mordor.ostromgepek.Katapult;

import java.util.ArrayList;
import java.util.List;

public class Mordor extends HarciEgysegek {
    private HarciEgysegek harciEgysegek;
    private List<Katapult> katapultList = new ArrayList<>();
    private List<Ballista> ballistaList = new ArrayList<>();

    public Mordor() {
    }

    public HarciEgysegek getHarciEgysegek() {
        return harciEgysegek;
    }

    public void setHarciEgysegek(HarciEgysegek harciEgysegek) {
        this.harciEgysegek = harciEgysegek;
    }

    public List<Katapult> getKatapultList() {
        return katapultList;
    }

    public void setKatapultList(List<Katapult> katapultList) {
        this.katapultList = katapultList;
    }

    public List<Ballista> getBallistaList() {
        return ballistaList;
    }

    public void setBallistaList(List<Ballista> ballistaList) {
        this.ballistaList = ballistaList;
    }
}
