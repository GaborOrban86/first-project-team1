package hu.progmasters;

import hu.progmasters.enumok.GondorEgysegekEnum;
import hu.progmasters.enumok.MordorEgysegekEnum;
import hu.progmasters.gondor.Gondor;
import hu.progmasters.gondor.egysegek.Lovag;
import hu.progmasters.gondor.egysegek.Soldier;
import hu.progmasters.gondor.egysegek.Szamszerijasz;
import hu.progmasters.gondor.epuletek.Ijasztorony;
import hu.progmasters.gondor.epuletek.Varfal;
import hu.progmasters.kozosAbstractok.Unit;
import hu.progmasters.mordor.Mordor;
import hu.progmasters.mordor.egysegek.Ork;
import hu.progmasters.mordor.egysegek.Orkijasz;
import hu.progmasters.mordor.egysegek.Troll;
import hu.progmasters.mordor.ostromgepek.Ballista;
import hu.progmasters.mordor.ostromgepek.Katapult;

import java.util.Scanner;

import static java.lang.System.exit;

public class Battle {
    BattleEngine battleEngine = new BattleEngine();

    public void mordorMenu() {
        System.out.println("1): recruit/build: " + MordorEgysegekEnum.GRUNT + " " + MordorEgysegekEnum.GRUNT.getCost());
        System.out.println("2): recruit/build: " + MordorEgysegekEnum.URUK_HAI + " " + MordorEgysegekEnum.URUK_HAI.getCost());
        System.out.println("3): recruit/build: " + MordorEgysegekEnum.ARCHER + " " + MordorEgysegekEnum.ARCHER.getCost());
        System.out.println("4): recruit/build: " + MordorEgysegekEnum.CATAPULT + " " + MordorEgysegekEnum.CATAPULT.getCost());
        System.out.println("5): recruit/build: " + MordorEgysegekEnum.BALLISTA + " " + MordorEgysegekEnum.BALLISTA.getCost());
        System.out.println("6): FINISH");
        System.out.println("7): QUIT");
        System.out.println("Please select an option!");
    }


    public void gondorMenu() {
        System.out.println("1): recruit/build: " + GondorEgysegekEnum.FOOTMAN + " " + GondorEgysegekEnum.FOOTMAN.getCost());
        System.out.println("2): recruit/build: " + GondorEgysegekEnum.KNIGHT + " " + GondorEgysegekEnum.KNIGHT.getCost());
        System.out.println("3): recruit/build: " + GondorEgysegekEnum.CROSSBOWMAN + " " + GondorEgysegekEnum.CROSSBOWMAN.getCost());
        System.out.println("4): recruit/build: " + GondorEgysegekEnum.WALL + " " + GondorEgysegekEnum.WALL.getCost());
        System.out.println("5): recruit/build: " + GondorEgysegekEnum.TOWER + " " + GondorEgysegekEnum.TOWER.getCost());
        System.out.println("6): FINISH");
        System.out.println("7): QUIT");
        System.out.println("Please select an option!");
    }

    public int mordorAllCost(int option, int amount) {
        int cost = MordorEgysegekEnum.values()[option - 1].getCost();
        return cost * amount;
    }

    public int gondorAllCost(int option, int amount) {
        int cost = GondorEgysegekEnum.values()[option - 1].getCost();
        return cost * amount;
    }


    public void mordorBuy() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the quantity to recruit/build!");
        int amount = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                if (mordorAllCost(option,amount) <= battleEngine.mordor.getMoney()) {
                    for (int i = 0; i < amount; i++) {
                        battleEngine.mordor.getKozelharci().add(new Ork());
                        battleEngine.mordor.setMoney(battleEngine.mordor.getMoney() - mordorAllCost(option,amount));
                    }
                    System.out.println("Unit(s) successfully added to army.");
                } else {
                    System.out.println("Not enough resources.");
                }
                break;

            case 2:
                if (mordorAllCost(option,amount) <= battleEngine.mordor.getMoney()) {
                    for (int i = 0; i < amount; i++) {
                        battleEngine.mordor.getKozelharci().add(new Troll());
                        battleEngine.mordor.setMoney(battleEngine.mordor.getMoney() - mordorAllCost(option,amount));
                    }
                    System.out.println("Unit(s) successfully added to army.");
                } else {
                    System.out.println("Not enough resources.");
                }
                break;
            case 3:
                if (mordorAllCost(option,amount) <= battleEngine.mordor.getMoney()) {
                    for (int i = 0; i < amount; i++) {
                        battleEngine.mordor.getTavolharci().add(new Orkijasz());
                        battleEngine.mordor.setMoney(battleEngine.mordor.getMoney() - mordorAllCost(option,amount));
                    }
                    System.out.println("Unit(s) successfully added to army.");
                } else {
                    System.out.println("Not enough resources.");
                }
                break;
            case 4:
                if (mordorAllCost(option,amount) <= battleEngine.mordor.getMoney()) {
                    for (int i = 0; i < amount; i++) {
                        battleEngine.mordor.getKatapultList().add(new Katapult());
                        battleEngine.mordor.setMoney(battleEngine.mordor.getMoney() - mordorAllCost(option,amount));
                    }
                    System.out.println("Unit(s) successfully added to army.");
                } else {
                    System.out.println("Not enough resources.");
                }
                break;
            case 5:
                if (mordorAllCost(option,amount) <= battleEngine.mordor.getMoney()) {
                    for (int i = 0; i < amount; i++) {
                        battleEngine.mordor.getBallistaList().add(new Ballista());
                        battleEngine.mordor.setMoney(battleEngine.mordor.getMoney() - mordorAllCost(option,amount));
                    }
                    System.out.println("Unit(s) successfully added to army.");
                } else {
                    System.out.println("Not enough resources.");
                }
                break;
            case 6:
                break;
            case 7:
                System.out.println("Gondor WINS!!!");
                System.exit(0);
            default:
                System.out.println("Numbers between 1-7");
                mordorBuy();
        }
    }

    public void gondorBuy() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the quantity to recruit/build!");
        int amount = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                if (gondorAllCost(option,amount) <= battleEngine.gondor.getMoney()) {
                    for (int i = 0; i < amount; i++) {
                        battleEngine.gondor.getKozelharci().add(new Soldier());
                        battleEngine.gondor.setMoney(battleEngine.gondor.getMoney() - gondorAllCost(option,amount));
                    }
                    System.out.println("Unit(s) successfully added to army.");
                } else {
                    System.out.println("Not enough resources.");
                }
                break;

            case 2:
                if (gondorAllCost(option,amount) <= battleEngine.gondor.getMoney()) {
                    for (int i = 0; i < amount; i++) {
                        battleEngine.gondor.getKozelharci().add(new Lovag());
                        battleEngine.gondor.setMoney(battleEngine.gondor.getMoney() - gondorAllCost(option,amount));
                    }
                    System.out.println("Unit(s) successfully added to army.");
                } else {
                    System.out.println("Not enough resources.");
                }
                break;
            case 3:
                if (gondorAllCost(option,amount) <= battleEngine.gondor.getMoney()) {
                    for (int i = 0; i < amount; i++) {
                        battleEngine.gondor.getTavolharci().add(new Szamszerijasz());
                        battleEngine.gondor.setMoney(battleEngine.gondor.getMoney() - gondorAllCost(option,amount));
                    }
                    System.out.println("Unit(s) successfully added to army.");
                } else {
                    System.out.println("Not enough resources.");
                }
                break;
            case 4:
                if (gondorAllCost(option,amount) <= battleEngine.gondor.getMoney()) {
                    for (int i = 0; i < amount; i++) {
                        battleEngine.gondor.getVarfalList().add(new Varfal());
                        battleEngine.gondor.setMoney(battleEngine.gondor.getMoney() - gondorAllCost(option,amount));
                    }
                    System.out.println("Unit(s) successfully added to army.");
                } else {
                    System.out.println("Not enough resources.");
                }
                break;
            case 5:
                if (gondorAllCost(option,amount) <= battleEngine.gondor.getMoney()) {
                    for (int i = 0; i < amount; i++) {
                        battleEngine.gondor.getIjasztoronyList().add(new Ijasztorony());
                        battleEngine.gondor.setMoney(battleEngine.gondor.getMoney() - gondorAllCost(option,amount));
                    }
                    System.out.println("Unit(s) successfully added to army.");
                } else {
                    System.out.println("Not enough resources.");
                }
                break;
            case 6:
                break;
            case 7:
                System.out.println("Mordor WINS!!!");
                System.exit(0);
            default:
                System.out.println("Numbers between 1-7");
                gondorBuy();
        }
    }


}
