package hu.progmasters;

public class Battle {
    BattleEngine battleEngine = new BattleEngine();

    public void finalBattle() {
        battleEngine.mordorBuy();
        battleEngine.gondor.printArmy();
        battleEngine.gondorMenu();
        battleEngine.gondorBuy();
        battleEngine.mordorAttackKatapult();
        battleEngine.mordorAttackBallista();
        battleEngine.gondorAttackArcher();
        battleEngine.mordorAttackKozelharci();
        battleEngine.mordorAttackOrkArcher();
        battleEngine.gondorAttackKozelharci();
    }

}
