package hu.progmasters;

public class Battle {
    BattleEngine battleEngine = new BattleEngine();

    public void finalBattle() {
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
    }
}
