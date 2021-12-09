package hu.progmasters;

import java.util.concurrent.TimeUnit;

public class Battle {
    BattleEngine battleEngine = new BattleEngine();

    public void finalBattle() throws InterruptedException {
        boolean isBattleStillGoing = true;
        while (isBattleStillGoing) {
            battleEngine.mordorBuy();
            battleEngine.gondorBuy();
            battleEngine.surprise();
            battleEngine.mordorAttackCatapult();
            battleEngine.mordorAttackBallista();
            battleEngine.gondorAttackArcher();
            battleEngine.mordorAttackMelee();
            battleEngine.mordorAttackOrkArcher();
            battleEngine.gondorAttackMelee();
            battleEngine.mordor.printArmy();
            battleEngine.gondor.printArmy();
            System.out.println();
            System.out.println("                End of the Round");
            System.out.println();
            TimeUnit.SECONDS.sleep(3);


            if (battleEngine.gondor.getMelee().isEmpty() && battleEngine.gondor.getRanged().isEmpty()
                                                            &&
                    battleEngine.mordor.getMelee().isEmpty() && battleEngine.mordor.getRanged().isEmpty()) {
                System.out.println("All DEAD! EVERYONE LOST!");
                break;
            }

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
