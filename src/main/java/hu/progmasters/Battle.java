package hu.progmasters;

import hu.progmasters.enumok.GondorEgysegekEnum;
import hu.progmasters.enumok.MordorEgysegekEnum;
import hu.progmasters.gondor.Gondor;
import hu.progmasters.kozosAbstractok.Unit;
import hu.progmasters.mordor.Mordor;
import hu.progmasters.mordor.egysegek.Ork;
import hu.progmasters.mordor.egysegek.Orkijasz;

import java.util.Scanner;

public class Battle {
    BattleEngine battleEngine = new BattleEngine();

    public void mordorMenu() {
        System.out.println("1): recruit/build: " + MordorEgysegekEnum.GRUNT + " " + MordorEgysegekEnum.GRUNT.getCost());
        System.out.println("2): recruit/build: " + MordorEgysegekEnum.URUK_HAI + " " + MordorEgysegekEnum.URUK_HAI.getCost());
        System.out.println("3): recruit/build: " + MordorEgysegekEnum.ARCHER + " " + MordorEgysegekEnum.ARCHER.getCost());
        System.out.println("4): recruit/build: " + MordorEgysegekEnum.CATAPULT + " " + MordorEgysegekEnum.CATAPULT.getCost());
        System.out.println("5): recruit/build: " + MordorEgysegekEnum.BALLISTA + " " + MordorEgysegekEnum.BALLISTA.getCost());
        System.out.println("6): FINISH" );
        System.out.println("7): QUIT" );
        System.out.println("Please select an option!");
    }


    public void gondorMenu() {
        System.out.println("1): recruit/build: " + GondorEgysegekEnum.FOOTMAN + " " + GondorEgysegekEnum.FOOTMAN.getCost());
        System.out.println("2): recruit/build: " + GondorEgysegekEnum.KNIGHT + " " + GondorEgysegekEnum.KNIGHT.getCost());
        System.out.println("3): recruit/build: " + GondorEgysegekEnum.CROSSBOWMAN + " " + GondorEgysegekEnum.CROSSBOWMAN.getCost());
        System.out.println("4): recruit/build: " + GondorEgysegekEnum.WALL + " " + GondorEgysegekEnum.WALL.getCost());
        System.out.println("5): recruit/build: " + GondorEgysegekEnum.TOWER + " " + GondorEgysegekEnum.TOWER.getCost());
        System.out.println("6): FINISH" );
        System.out.println("7): QUIT" );
        System.out.println("Please select an option!");
    }

    public boolean mordorEnoughMoney(int option, int amount){
        int cost = MordorEgysegekEnum.values()[option-1].getCost();
        return cost*amount <= battleEngine.mordor.getMoney();
    }

    public boolean gondorEnoughMoney(int option, int amount){
        int cost = GondorEgysegekEnum.values()[option-1].getCost();
        return cost*amount <= battleEngine.gondor.getMoney();
    }


    public void mordorBuy(){
        Scanner scanner=new Scanner(System.in);
        int option= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the quantity to recruit/build!");
        int amount= scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1:
                if (mordorEnoughMoney(option,amount)) {

            }
        }

    }
}
