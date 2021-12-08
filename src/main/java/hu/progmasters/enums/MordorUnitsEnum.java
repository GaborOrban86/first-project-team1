package hu.progmasters.enums;

public enum MordorUnitsEnum {
    GRUNT(55),URUK_HAI(140),ARCHER(40),CATAPULT(70),BALLISTA(300);

    final int cost;

    MordorUnitsEnum(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
