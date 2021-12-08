package hu.progmasters.commonAbstracts;


import java.util.ArrayList;
import java.util.List;

public abstract class BattleUnits {
    protected List<Unit> melee = new ArrayList<>();
    protected List<Unit> ranged = new ArrayList<>();

    public BattleUnits() {
    }

    public List<Unit> getMelee() {
        return melee;
    }

    public void setMelee(List<Unit> melee) {
        this.melee = melee;
    }

    public List<Unit> getRanged() {
        return ranged;
    }

    public void setRanged(List<Unit> ranged) {
        this.ranged = ranged;
    }
}
