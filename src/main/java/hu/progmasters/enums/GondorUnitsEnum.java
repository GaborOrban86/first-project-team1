package hu.progmasters.enums;

public enum GondorUnitsEnum {
    FOOTMAN(50),KNIGHT(150),CROSSBOWMAN(40),WALL(75),TOWER(75);

    final int cost;

    GondorUnitsEnum(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
