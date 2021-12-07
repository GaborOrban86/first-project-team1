package hu.progmasters.gondor;

import hu.progmasters.gondor.egysegek.Szamszerijasz;
import hu.progmasters.gondor.epuletek.Ijasztorony;
import hu.progmasters.gondor.epuletek.Varfal;
import hu.progmasters.kozosAbstractok.HarciEgysegek;

import java.util.ArrayList;
import java.util.List;

public class Gondor extends HarciEgysegek {
    private HarciEgysegek harciEgysegek;
    private List<Ijasztorony> ijasztoronyList = new ArrayList<>();
    private List<Varfal> varfalList = new ArrayList<>();
    private int money;



    public Gondor(int money) {
        List<Szamszerijasz> szamszerijaszList = new ArrayList<>();
        harciEgysegek.getTavolharci().addAll(szamszerijaszList);
        this.money = money;
    }

    public void printArmy() {
        System.out.println("Gondor's defenses:");
        System.out.println("    Number of melee units: " + harciEgysegek.getKozelharci().size());
        System.out.println("    Number of ranged units: " + harciEgysegek.getTavolharci().size());
        System.out.println("    Number of buildings: " + (ijasztoronyList.size() + varfalList.size()));
        System.out.println("        Protection percentage: " + (wallProtection() * 100));
        System.out.println("        Ranged damage bonus percentage: " + (ijasztoronyBonuszSebzes() * 100));
        System.out.println("    Resources: " + getMoney());

    }

    public double wallProtection() {
        double result = varfalList.size() * 0.05;
        if (result >= 0.5) {
            result = 0.5;
        }
        return result;
    }

    public double ijasztoronyBonuszSebzes(){
        return ijasztoronyList.size() * 0.10;
    }

    public HarciEgysegek getHarciEgysegek() {
        return harciEgysegek;
    }

    public void setHarciEgysegek(HarciEgysegek harciEgysegek) {
        this.harciEgysegek = harciEgysegek;
    }

    public List<Ijasztorony> getIjasztoronyList() {
        return ijasztoronyList;
    }

    public void setIjasztoronyList(List<Ijasztorony> ijasztoronyList) {
        this.ijasztoronyList = ijasztoronyList;
    }

    public List<Varfal> getVarfalList() {
        return varfalList;
    }

    public void setVarfalList(List<Varfal> varfalList) {
        this.varfalList = varfalList;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
