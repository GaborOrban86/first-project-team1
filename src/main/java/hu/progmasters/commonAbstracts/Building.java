package hu.progmasters.commonAbstracts;

public abstract class Building {
    public int hp;
    public int cost;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
