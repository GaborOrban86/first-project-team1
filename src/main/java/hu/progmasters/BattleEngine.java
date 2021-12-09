package hu.progmasters;

import hu.progmasters.enums.GondorUnitsEnum;
import hu.progmasters.enums.MordorUnitsEnum;
import hu.progmasters.gondor.Gondor;
import hu.progmasters.gondor.units.Knight;
import hu.progmasters.gondor.units.Footman;
import hu.progmasters.gondor.units.Crossbowman;
import hu.progmasters.gondor.buildings.Tower;
import hu.progmasters.gondor.buildings.Wall;
import hu.progmasters.commonAbstracts.Unit;
import hu.progmasters.mordor.Mordor;
import hu.progmasters.mordor.units.Grunt;
import hu.progmasters.mordor.units.Archer;
import hu.progmasters.mordor.units.UrukHai;
import hu.progmasters.mordor.siegeMachines.Ballista;
import hu.progmasters.mordor.siegeMachines.Catapult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleEngine {
    protected Mordor mordor = new Mordor();
    protected Gondor gondor = new Gondor();

    public BattleEngine() {
    }

    public BattleEngine(Mordor mordor, Gondor gondor) {
        this.mordor = mordor;
        this.gondor = gondor;
    }

    public void mordorAttackBallista() {
        Random random = new Random();
        for (Ballista ballista : mordor.getBallistaList()) {
            int gondorRangedSize = gondor.getRanged().size();
            int gondorMeleeSize = gondor.getMelee().size();
            if (gondorRangedSize != 0) {
                int randomNr = random.nextInt(gondorRangedSize);
                Unit gondorRangedUnit = gondor.getRanged().get(randomNr);
                gondorRangedUnit.setHp(
                        (int) (gondorRangedUnit.getHp() - ballista.getDamage() * (1 - gondor.wallProtection())));
                if (gondorRangedUnit.getHp() <= 0) {
                    mordor.setMoney(mordor.getMoney() + gondorRangedUnit.getLoot());
                    gondor.getRanged().remove(gondorRangedUnit);
                }

            } else {
                if (gondorMeleeSize != 0) {
                    int randomNr = random.nextInt(gondorMeleeSize);
                    Unit gondorMeleeUnit = gondor.getMelee().get(randomNr);
                    gondorMeleeUnit.setHp(
                            (int) (gondorMeleeUnit.getHp() - ballista.getDamage() * (1 - gondor.wallProtection())));
                    if (gondorMeleeUnit.getHp() <= 0) {
                        mordor.setMoney(mordor.getMoney() + gondorMeleeUnit.getLoot());
                        gondor.getMelee().remove(gondorMeleeUnit);
                    }
                } else {
                    break;
                }
            }
        }

    }

    public void mordorAttackMelee() {
        Random random = new Random();
        for (Unit mordorOrk : mordor.getMelee()) {
            int gondorMeleeSize = gondor.getMelee().size();
            int gondorRangedSize = gondor.getRanged().size();
            if (gondorMeleeSize != 0) {
                int randomNr = random.nextInt(gondorMeleeSize);
                Unit gondorMeleeUnit = gondor.getMelee().get(randomNr);
                gondorMeleeUnit.setHp(
                        (int) (gondorMeleeUnit.getHp() - mordorOrk.getDamage() * (1 - gondor.wallProtection())));
                if (gondorMeleeUnit.getHp() <= 0) {
                    mordor.setMoney(mordor.getMoney() + gondorMeleeUnit.getLoot());
                    gondor.getMelee().remove(gondorMeleeUnit);
                }
            } else {
                if (gondorRangedSize != 0) {
                    int randomNr = random.nextInt(gondorRangedSize);
                    Unit gondorRangedUnit = gondor.getRanged().get(randomNr);
                    gondorRangedUnit.setHp(
                            (int) (gondorRangedUnit.getHp() - mordorOrk.getDamage() * (1 - gondor.wallProtection())));
                    System.out.println(gondorRangedUnit.getHp());
                    if (gondorRangedUnit.getHp() <= 0) {
                        mordor.setMoney(mordor.getMoney() + gondorRangedUnit.getLoot());
                        gondor.getRanged().remove(gondorRangedUnit);
                    }
                } else {
                    break;
                }
            }
        }

    }

    public void mordorAttackOrkArcher() {
        Random random = new Random();
        for (Unit orkArcher : mordor.getRanged()) {
            int gondorRangedSize = gondor.getRanged().size();
            int gondorMeleeSize = gondor.getMelee().size();
            if (gondorRangedSize != 0) {
                int randomNr = random.nextInt(gondorRangedSize);
                Unit gondorRangedUnit = gondor.getRanged().get(randomNr);
                gondorRangedUnit.setHp(
                        (int) (gondorRangedUnit.getHp() - orkArcher.getDamage() * (1 - gondor.wallProtection())));
                if (gondorRangedUnit.getHp() <= 0) {
                    mordor.setMoney(mordor.getMoney() + gondorRangedUnit.getLoot());
                    gondor.getRanged().remove(gondorRangedUnit);
                }

            } else {
                if (gondorMeleeSize != 0) {
                    int randomNr = random.nextInt(gondorMeleeSize);
                    Unit gondorMeleeUnit = gondor.getMelee().get(randomNr);
                    gondorMeleeUnit.setHp(
                            (int) (gondorMeleeUnit.getHp() - orkArcher.getDamage() * (1 - gondor.wallProtection())));
                    if (gondorMeleeUnit.getHp() <= 0) {
                        mordor.setMoney(mordor.getMoney() + gondorMeleeUnit.getLoot());
                        gondor.getMelee().remove(gondorMeleeUnit);
                    }
                } else {
                    break;
                }
            }
        }

    }

    public void mordorAttackCatapult() {
        Random random = new Random();
        for (Catapult catapult : mordor.getCatapultList()) {
            int towerNumber = gondor.getTowerList().size();
            int wallNumber = gondor.getWallList().size();
            int buildingNr = towerNumber + wallNumber;
            if (buildingNr == 0) {
                break;
            }
            int randomNrIndex = random.nextInt(buildingNr);
            if (randomNrIndex > towerNumber - 1) {
                randomNrIndex = randomNrIndex - towerNumber;
                Wall wall = gondor.getWallList().get(randomNrIndex);
                int newHp = wall.hp - catapult.getDamage();
                wall.setHp(newHp);
            } else {
                Tower tower = gondor.getTowerList().get(randomNrIndex);
                int newHP = tower.hp - catapult.getDamage();
                tower.setHp(newHP);
            }
        }
        List<Tower> toDelete = new ArrayList<>();
        for (Tower tower : gondor.getTowerList()) {
            if (tower.getHp() <= 0) {
                toDelete.add(tower);
            }
        }
        gondor.getTowerList().removeAll(toDelete);

        List<Wall> toDeleteWall = new ArrayList<>();
        for (Wall wall : gondor.getWallList()) {
            if ((wall.getHp() <= 0)) {
                toDeleteWall.add(wall);
            }
        }
        gondor.getWallList().removeAll(toDeleteWall);
    }

    public void gondorAttackMelee() {
        Random random = new Random();
        for (Unit gondorMelee : gondor.getMelee()) {
            int mordorMeleeSize = mordor.getMelee().size();
            int mordorRangedSize = mordor.getRanged().size();
            if (mordorMeleeSize != 0) {
                int randomNr = random.nextInt(mordorMeleeSize);
                Unit mordorMeleeUnit = mordor.getMelee().get(randomNr);
                mordorMeleeUnit.setHp(
                        mordorMeleeUnit.getHp() - gondorMelee.getDamage());
                if (mordorMeleeUnit.getHp() <= 0) {
                    gondor.setMoney(gondor.getMoney() + mordorMeleeUnit.getLoot());
                    mordor.getMelee().remove(mordorMeleeUnit);
                }
            } else {
                if (mordorRangedSize != 0) {
                    int randomNr = random.nextInt(mordorRangedSize);
                    Unit mordorRangedUnit = mordor.getRanged().get(randomNr);
                    mordorRangedUnit.setHp(
                            mordorRangedUnit.getHp() - gondorMelee.getDamage());
                    if (mordorRangedUnit.getHp() <= 0) {
                        gondor.setMoney(gondor.getMoney() + mordorRangedUnit.getLoot());
                        mordor.getRanged().remove(mordorRangedUnit);
                    }

                } else {
                    break;
                }
            }
        }
    }

    public void gondorAttackArcher() {
        Random random = new Random();
        for (Unit gondorArcher : gondor.getRanged()) {
            int mordorRangedSize = mordor.getRanged().size();
            int mordorMeleeSize = mordor.getMelee().size();
            if (mordorRangedSize != 0) {
                int randomNr = random.nextInt(mordorRangedSize);
                Unit mordorRangedUnit = mordor.getRanged().get(randomNr);
                mordorRangedUnit.setHp(
                        (int) (mordorRangedUnit.getHp() - gondorArcher.getDamage() * (1 + gondor.TowerBonusDamage())));
                if (mordorRangedUnit.getHp() <= 0) {
                    gondor.setMoney(gondor.getMoney() + mordorRangedUnit.getLoot());
                    mordor.getRanged().remove(mordorRangedUnit);
                }

            } else {
                if (mordorMeleeSize != 0) {
                    int randomNr = random.nextInt(mordorMeleeSize);
                    Unit mordorMeleeUnit = mordor.getMelee().get(randomNr);
                    mordorMeleeUnit.setHp(
                            (int) (mordorMeleeUnit.getHp() - gondorArcher.getDamage() * (1 + gondor.TowerBonusDamage())));
                    if (mordorMeleeUnit.getHp() <= 0) {
                        gondor.setMoney(gondor.getMoney() + mordorMeleeUnit.getLoot());
                        mordor.getMelee().remove(mordorMeleeUnit);
                    }
                } else {
                    break;
                }
            }
        }

    }

    public void mordorMenu() {
        System.out.println("1): recruit/build: " + MordorUnitsEnum.GRUNT + " " + MordorUnitsEnum.GRUNT.getCost());
        System.out.println("2): recruit/build: " + MordorUnitsEnum.URUK_HAI + " " + MordorUnitsEnum.URUK_HAI.getCost());
        System.out.println("3): recruit/build: " + MordorUnitsEnum.ARCHER + " " + MordorUnitsEnum.ARCHER.getCost());
        System.out.println("4): recruit/build: " + MordorUnitsEnum.CATAPULT + " " + MordorUnitsEnum.CATAPULT.getCost());
        System.out.println("5): recruit/build: " + MordorUnitsEnum.BALLISTA + " " + MordorUnitsEnum.BALLISTA.getCost());
        System.out.println("6): FINISH");
        System.out.println("7): QUIT");
        System.out.println("Please select an option!");
    }


    public void gondorMenu() {
        System.out.println("1): recruit/build: " + GondorUnitsEnum.FOOTMAN + " " + GondorUnitsEnum.FOOTMAN.getCost());
        System.out.println("2): recruit/build: " + GondorUnitsEnum.KNIGHT + " " + GondorUnitsEnum.KNIGHT.getCost());
        System.out.println("3): recruit/build: " + GondorUnitsEnum.CROSSBOWMAN + " " + GondorUnitsEnum.CROSSBOWMAN.getCost());
        System.out.println("4): recruit/build: " + GondorUnitsEnum.WALL + " " + GondorUnitsEnum.WALL.getCost());
        System.out.println("5): recruit/build: " + GondorUnitsEnum.TOWER + " " + GondorUnitsEnum.TOWER.getCost());
        System.out.println("6): FINISH");
        System.out.println("7): QUIT");
        System.out.println("Please select an option!");
    }

    public int mordorAllCost(int option, int amount) {
        int cost = MordorUnitsEnum.values()[option - 1].getCost();
        return cost * amount;
    }

    public int gondorAllCost(int option, int amount) {
        int cost = GondorUnitsEnum.values()[option - 1].getCost();
        return cost * amount;
    }


    public void mordorBuy() {
        int option;
        Scanner scanner = new Scanner(System.in);
        do {
            mordor.printArmy();
            mordorMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 7) {
                System.exit(0);
            }
            if (option == 6) {
                break;
            }
            if (option > 7 || option < 1) {
                System.out.println("Give numbers between 1-7");
                continue;
            }
            System.out.println("Please enter the quantity to recruit/build!");
            int amount = scanner.nextInt();
            scanner.nextLine();
            int currentMoney = mordor.getMoney();
            switch (option) {
                case 1:
                    if (mordorAllCost(option, amount) <= mordor.getMoney()) {
                        for (int i = 0; i < amount; i++) {
                            mordor.getMelee().add(new Grunt());
                        }
                        mordor.setMoney(mordor.getMoney() - mordorAllCost(option, amount));
                    }
                    break;

                case 2:
                    if (mordorAllCost(option, amount) <= mordor.getMoney()) {
                        for (int i = 0; i < amount; i++) {
                            mordor.getMelee().add(new UrukHai());
                        }
                        mordor.setMoney(mordor.getMoney() - mordorAllCost(option, amount));

                    }
                    break;
                case 3:
                    if (mordorAllCost(option, amount) <= mordor.getMoney()) {
                        for (int i = 0; i < amount; i++) {
                            mordor.getRanged().add(new Archer());
                        }
                        mordor.setMoney(mordor.getMoney() - mordorAllCost(option, amount));
                    }
                    break;
                case 4:
                    if (mordorAllCost(option, amount) <= mordor.getMoney()) {
                        for (int i = 0; i < amount; i++) {
                            mordor.getCatapultList().add(new Catapult());
                        }
                        mordor.setMoney(mordor.getMoney() - mordorAllCost(option, amount));
                    }
                    break;
                case 5:
                    if (mordorAllCost(option, amount) <= mordor.getMoney()) {
                        for (int i = 0; i < amount; i++) {
                            mordor.getBallistaList().add(new Ballista());
                        }
                        mordor.setMoney(mordor.getMoney() - mordorAllCost(option, amount));
                    }
                    break;
            }
            if (currentMoney == mordor.getMoney()) {
                System.out.println("Not enough resources.");
            } else {
                System.out.println("Unit(s) successfully added to army.");
            }

        } while (option != 6);              //tudjuk hogy csúnya.

    }

    public void gondorBuy() {
        int option;
        Scanner scanner = new Scanner(System.in);
        do {
            gondor.printArmy();
            gondorMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 7) {
                System.exit(0);
            }
            if (option == 6) {
                break;
            }
            if (option > 7 || option < 1) {
                System.out.println("Give numbers between 1-7");
                continue;
            }
            System.out.println("Please enter the quantity to recruit/build!");
            int amount = scanner.nextInt();
            scanner.nextLine();
            int currentMoney = gondor.getMoney();
            switch (option) {
                case 1:
                    if (gondorAllCost(option, amount) <= gondor.getMoney()) {
                        for (int i = 0; i < amount; i++) {
                            gondor.getMelee().add(new Footman());
                        }
                        gondor.setMoney(gondor.getMoney() - gondorAllCost(option, amount));
                    }
                    break;

                case 2:
                    if (gondorAllCost(option, amount) <= gondor.getMoney()) {
                        for (int i = 0; i < amount; i++) {
                            gondor.getMelee().add(new Knight());
                        }
                        gondor.setMoney(gondor.getMoney() - gondorAllCost(option, amount));
                    }
                    break;
                case 3:
                    if (gondorAllCost(option, amount) <= gondor.getMoney()) {
                        for (int i = 0; i < amount; i++) {
                            gondor.getRanged().add(new Crossbowman());
                        }
                        gondor.setMoney(gondor.getMoney() - gondorAllCost(option, amount));
                    }
                    break;
                case 4:
                    if (gondorAllCost(option, amount) <= gondor.getMoney()) {
                        for (int i = 0; i < amount; i++) {
                            gondor.getWallList().add(new Wall());
                        }
                        gondor.setMoney(gondor.getMoney() - gondorAllCost(option, amount));
                    }
                    break;
                case 5:
                    if (gondorAllCost(option, amount) <= gondor.getMoney()) {
                        for (int i = 0; i < amount; i++) {
                            gondor.getTowerList().add(new Tower());
                        }
                        gondor.setMoney(gondor.getMoney() - gondorAllCost(option, amount));
                    }
                    break;
            }
            if (currentMoney == gondor.getMoney()) {
                System.out.println("Not enough resources.");
            } else {
                System.out.println("Unit(s) successfully added to army.");
            }

        } while (option != 6);
    }

    public Mordor getMordor() {
        return mordor;
    }

    public void setMordor(Mordor mordor) {
        this.mordor = mordor;
    }

    public Gondor getGondor() {
        return gondor;
    }

    public void setGondor(Gondor gondor) {
        this.gondor = gondor;
    }


    public void surprise() {
        try {
            System.out.println("         ___ . .  _                                                                                             \n" +
                    "\"T$$$P\"   |  |_| |_                                                                                             \n" +
                    " :$$$     |  | | |_                                                                                             \n" +
                    " :$$$                                                      \"T$$$$$$$b.                                          \n" +
                    " :$$$     .g$$$$$p.   T$$$$b.    T$$$$$bp.                   BUG    \"Tb      T$b      T$P   .g$P^^T$$  ,gP^^T$$ \n" +
                    "  $$$    d^\"     \"^b   $$  \"Tb    $$    \"Tb    .s^s. :sssp   $$$     :$; T$$P $^b.     $   dP\"     `T :$P    `T\n" +
                    "  :$$   dP         Tb  $$   :$;   $$      Tb  d'   `b $      $$$     :$;  $$  $ `Tp    $  d$           Tbp.   \n" +
                    "  :$$  :$;         :$; $$   :$;   $$      :$; T.   .P $^^    $$$    .dP   $$  $   ^b.  $ :$;            \"T$$p.  \n" +
                    "  $$$  :$;         :$; $$...dP    $$      :$;  `^s^' .$.     $$$...dP\"    $$  $    `Tp $ :$;     \"T$$      \"T$b \n" +
                    "  $$$   Tb.       ,dP  $$\"\"\"Tb    $$      dP \"\"$\"\"$\" \"$\"$^^  $$$\"\"T$b     $$  $      ^b$  T$       T$ ;      $$;\n" +
                    "  $$$    Tp._   _,gP   $$   `Tb.  $$    ,dP    $  $...$ $..  $$$   T$b    :$  $       `$   Tb.     :$ T.    ,dP \n" +
                    "  $$$;    \"^$$$$$^\"   d$$     `T.d$$$$$P^\"     $  $\"\"\"$ $\"\", $$$    T$b  d$$bd$b      d$b   \"^TbsssP\" 'T$bgd$P  \n" +
                    "  $$$b.____.dP                                 $ .$. .$.$ss,d$$$b.   T$b.                                       \n" +
                    ".d$$$$$$$$$$P  bug                                                    `T$b.");
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


    }


}
