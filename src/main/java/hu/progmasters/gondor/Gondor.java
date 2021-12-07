package hu.progmasters.gondor;

import hu.progmasters.gondor.epuletek.Ijasztorony;
import hu.progmasters.gondor.epuletek.Varfal;
import hu.progmasters.kozosAbstractok.HarciEgysegek;

import java.util.ArrayList;
import java.util.List;

public class Gondor extends HarciEgysegek {
   private HarciEgysegek harciEgysegek;
   private List<Ijasztorony> ijasztoronyList = new ArrayList<>();
   private List<Varfal> varfalList = new ArrayList<>();


    public Gondor() {
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
}
