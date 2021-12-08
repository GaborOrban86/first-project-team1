package hu.progmasters;

public class Battle {
    BattleEngine battleEngine = new BattleEngine();

    public void finalBattle() {
        boolean isBattleStillGoing = true;
        while (isBattleStillGoing) {
            battleEngine.mordorBuy();
            battleEngine.gondorBuy();
            battleEngine.mordorAttackKatapult();
            battleEngine.mordorAttackBallista();
            battleEngine.gondorAttackArcher();
            battleEngine.mordorAttackMelee();
            battleEngine.mordorAttackOrkArcher();
            battleEngine.gondorAttackMelee();
            battleEngine.mordor.printArmy();
            battleEngine.gondor.printArmy();

            if (battleEngine.mordor.getMelee().isEmpty() && battleEngine.mordor.getRanged().isEmpty()) {
                System.out.println("Gondor won!");
                isBattleStillGoing = false;
            }

            if (battleEngine.gondor.getMelee().isEmpty() && battleEngine.gondor.getRanged().isEmpty()) {
                System.out.println("Mordor won!");
                isBattleStillGoing = false;
            }
        }
    }

}
