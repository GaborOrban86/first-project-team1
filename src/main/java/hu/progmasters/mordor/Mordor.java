package hu.progmasters.mordor;

import hu.progmasters.commonAbstracts.BattleUnits;
import hu.progmasters.mordor.siegeMachines.Ballista;
import hu.progmasters.mordor.siegeMachines.Catapult;

import java.util.ArrayList;
import java.util.List;

public class Mordor extends BattleUnits {
    private List<Catapult> catapultList = new ArrayList<>();
    private List<Ballista> ballistaList = new ArrayList<>();
    private int money;

    public Mordor(int money) {
        this.money = money;
        setRanged(new ArrayList<>());
        setMelee(new ArrayList<>());
    }

    public void printArmy(){
        System.out.println("Mordor's armies:");
        System.out.println("    Number of melee units: " + getMelee().size());
        System.out.println("    Number of ranged units: " + getRanged().size());
        System.out.println("    Number of siege weapons: " + (catapultList.size() + ballistaList.size()));
        System.out.println("    Resources: " + getMoney());
        System.out.println();
    }

    public List<Catapult> getCatapultList() {
        return catapultList;
    }

    public void setCatapultList(List<Catapult> catapultList) {
        this.catapultList = catapultList;
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
