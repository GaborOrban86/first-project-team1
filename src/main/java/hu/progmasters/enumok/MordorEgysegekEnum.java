package hu.progmasters.enumok;

public enum MordorEgysegekEnum {
    GRUNT(55),URUK_HAI(140),ARCHER(40),CATAPULT(70),BALLISTA(300);

    int cost;

    MordorEgysegekEnum(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
