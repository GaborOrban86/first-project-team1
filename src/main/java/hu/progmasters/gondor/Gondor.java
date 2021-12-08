package hu.progmasters.gondor;

import hu.progmasters.gondor.epuletek.Tower;
import hu.progmasters.gondor.epuletek.Wall;
import hu.progmasters.kozosAbstractok.BattleUnits;

import java.util.ArrayList;
import java.util.List;

public class Gondor extends BattleUnits {
    private List<Tower> towerList = new ArrayList<>();
    private List<Wall> wallList = new ArrayList<>();
    private int money;


    public Gondor(int money) {

        setRanged(new ArrayList<>());
        setMelee(new ArrayList<>());
        this.money = money;
    }

    public void printArmy() {
        System.out.println("Gondor's defenses:");
        System.out.println("    Number of melee units: " + getMelee().size());
        System.out.println("    Number of ranged units: " + getRanged().size());
        System.out.println("    Number of buildings: " + (towerList.size() + wallList.size()));
        System.out.println("        Protection percentage: " + (wallProtection() * 100));
        System.out.println("        Ranged damage bonus percentage: " + (TowerBonusDamage() * 100));
        System.out.println("    Resources: " + getMoney());
        System.out.println();
    }

    public double wallProtection() {
        double result = wallList.size() * 0.05;
        if (result >= 0.5) {
            result = 0.5;
        }
        return result;
    }

    public double TowerBonusDamage() {
        return towerList.size() * 0.10;
    }



    public List<Tower> getTowerList() {
        return towerList;
    }

    public void setIjasztoronyList(List<Tower> towerList) {
        this.towerList = towerList;
    }

    public List<Wall> getWallList() {
        return wallList;
    }

    public void setVarfalList(List<Wall> wallList) {
        this.wallList = wallList;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
