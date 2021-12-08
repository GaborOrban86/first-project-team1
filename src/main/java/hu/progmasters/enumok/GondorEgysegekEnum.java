package hu.progmasters.enumok;

public enum GondorEgysegekEnum {
    FOOTMAN(50),KNIGHT(150),CROSSBOWMAN(40),WALL(75),TOWER(75);

    int cost;

    GondorEgysegekEnum(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
