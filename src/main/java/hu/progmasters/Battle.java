package hu.progmasters;

public class Battle {
    BattleEngine battleEngine = new BattleEngine();

    public void finalBattle() {
        boolean tartACsata = true;
        while (tartACsata) {
            battleEngine.mordorBuy();
            battleEngine.gondorBuy();
            battleEngine.mordorAttackKatapult();
            battleEngine.mordorAttackBallista();
            battleEngine.gondorAttackArcher();
            battleEngine.mordorAttackKozelharci();
            battleEngine.mordorAttackOrkArcher();
            battleEngine.gondorAttackKozelharci();
            battleEngine.mordor.printArmy();
            battleEngine.gondor.printArmy();

            if (battleEngine.mordor.getMelee().isEmpty() && battleEngine.mordor.getRanged().isEmpty()) {
                System.out.println("Gondor nyert!");
                tartACsata = false;
            }

            if (battleEngine.gondor.getMelee().isEmpty() && battleEngine.gondor.getRanged().isEmpty()) {
                System.out.println("Mordor nyert!");
                tartACsata = false;
            }
        }
    }

}
