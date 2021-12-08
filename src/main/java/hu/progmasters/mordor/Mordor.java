package hu.progmasters.mordor;

import hu.progmasters.kozosAbstractok.HarciEgysegek;
import hu.progmasters.mordor.ostromgepek.Ballista;
import hu.progmasters.mordor.ostromgepek.Katapult;

import java.util.ArrayList;
import java.util.List;

public class Mordor extends HarciEgysegek {
    private List<Katapult> katapultList = new ArrayList<>();
    private List<Ballista> ballistaList = new ArrayList<>();
    private int money;

    public Mordor(int money) {
        this.money = money;
        setTavolharci(new ArrayList<>());
        setKozelharci(new ArrayList<>());
    }

    public void printArmy(){
        System.out.println("Mordor's armies:");
        System.out.println("    Number of melee units: " + getKozelharci().size());
        System.out.println("    Number of ranged units: " + getTavolharci().size());
        System.out.println("    Number of siege weapons: " + (katapultList.size() + ballistaList.size()));
        System.out.println("    Resources: " + getMoney());
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
