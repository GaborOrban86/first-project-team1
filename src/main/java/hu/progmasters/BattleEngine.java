package hu.progmasters;

import hu.progmasters.enumok.GondorUnitsEnum;
import hu.progmasters.enumok.MordorUnitsEnum;
import hu.progmasters.gondor.Gondor;
import hu.progmasters.gondor.egysegek.Knight;
import hu.progmasters.gondor.egysegek.Soldier;
import hu.progmasters.gondor.egysegek.Crossbowman;
import hu.progmasters.gondor.epuletek.Tower;
import hu.progmasters.gondor.epuletek.Wall;
import hu.progmasters.kozosAbstractok.Unit;
import hu.progmasters.mordor.Mordor;
import hu.progmasters.mordor.egysegek.Grunt;
import hu.progmasters.mordor.egysegek.Archer;
import hu.progmasters.mordor.egysegek.UrukHai;
import hu.progmasters.mordor.ostromgepek.Ballista;
import hu.progmasters.mordor.ostromgepek.Katapult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleEngine {
    protected Mordor mordor = new Mordor(5000);
    protected Gondor gondor = new Gondor(5000);

    public BattleEngine() {
    }

    public BattleEngine(Mordor mordor, Gondor gondor) {
        this.mordor = mordor;
        this.gondor = gondor;
    }

    public void mordorAttackBallista() {
        Random random = new Random();
        for (Ballista ballista : mordor.getBallistaList()) {
            int gondorTavolharciSize = gondor.getRanged().size();
            int gondorKozelharciSize = gondor.getMelee().size();
            if (gondorTavolharciSize != 0) {
                int randomNr = random.nextInt(gondorTavolharciSize);
                Unit gondorTavolharciEgyseg = gondor.getRanged().get(randomNr);
                gondorTavolharciEgyseg.setHp(
                        (int) (gondorTavolharciEgyseg.getHp() - ballista.getDamage() * (1 - gondor.wallProtection())));
                if (gondorTavolharciEgyseg.getHp() <= 0) {
                    mordor.setMoney(mordor.getMoney() + gondorTavolharciEgyseg.getLoot());
                    gondor.getRanged().remove(gondorTavolharciEgyseg);
                }

            } else {
                if (gondorKozelharciSize != 0) {
                    int randomNr = random.nextInt(gondorKozelharciSize);
                    Unit gondorKozelharciEgyseg = gondor.getMelee().get(randomNr);
                    gondorKozelharciEgyseg.setHp(
                            (int) (gondorKozelharciEgyseg.getHp() - ballista.getDamage() * (1 - gondor.wallProtection())));
                    if (gondorKozelharciEgyseg.getHp() <= 0) {
                        mordor.setMoney(mordor.getMoney() + gondorKozelharciEgyseg.getLoot());
                        gondor.getMelee().remove(gondorKozelharciEgyseg);
                    }
                } else {
                    break;
                }
            }
        }

    }

    public void mordorAttackKozelharci() {
        Random random = new Random();
        for (Unit mordorKozel : mordor.getMelee()) {
            int gondorKozelharciSize = gondor.getMelee().size();
            int gondorTavolharciSize = gondor.getRanged().size();
            if (gondorKozelharciSize != 0) {
                int randomNr = random.nextInt(gondorKozelharciSize);
                Unit gondorKozelharciEgyseg = gondor.getMelee().get(randomNr);
                gondorKozelharciEgyseg.setHp(
                        (int) (gondorKozelharciEgyseg.getHp() - mordorKozel.getDamage() * (1 - gondor.wallProtection())));
                if (gondorKozelharciEgyseg.getHp() <= 0) {
                    mordor.setMoney(mordor.getMoney() + gondorKozelharciEgyseg.getLoot());
                    gondor.getMelee().remove(gondorKozelharciEgyseg);
                }
            } else {
                if (gondorTavolharciSize != 0) {
                    int randomNr = random.nextInt(gondorTavolharciSize);
                    Unit gondorTavolharciEgyseg = gondor.getRanged().get(randomNr);
                    gondorTavolharciEgyseg.setHp(
                            (int) (gondorTavolharciEgyseg.getHp() - mordorKozel.getDamage() * (1 - gondor.wallProtection())));
                    if (gondorTavolharciEgyseg.getHp() <= 0) {
                        mordor.setMoney(mordor.getMoney() + gondorTavolharciEgyseg.getLoot());
                        gondor.getRanged().remove(gondorTavolharciEgyseg);
                    }
                } else {
                    break;
                }
            }
        }

    }

    public void mordorAttackOrkArcher() {
        Random random = new Random();
        for (Unit orkIjasz : mordor.getRanged()) {
            int gondorTavolharciSize = gondor.getRanged().size();
            int gondorKozelharciSize = gondor.getMelee().size();
            if (gondorTavolharciSize != 0) {
                int randomNr = random.nextInt(gondorTavolharciSize);
                Unit gondorTavolharciEgyseg = gondor.getRanged().get(randomNr);
                gondorTavolharciEgyseg.setHp(
                        (int) (gondorTavolharciEgyseg.getHp() - orkIjasz.getDamage() * (1 - gondor.wallProtection())));
                if (gondorTavolharciEgyseg.getHp() <= 0) {
                    mordor.setMoney(mordor.getMoney() + gondorTavolharciEgyseg.getLoot());
                    gondor.getRanged().remove(gondorTavolharciEgyseg);
                }

            } else {
                if (gondorKozelharciSize != 0) {
                    int randomNr = random.nextInt(gondorKozelharciSize);
                    Unit gondorKozelharciEgyseg = gondor.getMelee().get(randomNr);
                    gondorKozelharciEgyseg.setHp(
                            (int) (gondorKozelharciEgyseg.getHp() - orkIjasz.getDamage() * (1 - gondor.wallProtection())));
                    if (gondorKozelharciEgyseg.getHp() <= 0) {
                        mordor.setMoney(mordor.getMoney() + gondorKozelharciEgyseg.getLoot());
                        gondor.getMelee().remove(gondorKozelharciEgyseg);
                    }
                } else {
                    break;
                }
            }
        }

    }

    public void mordorAttackKatapult() {
        Random random = new Random();
        for (Katapult katapult : mordor.getKatapultList()) {
            int ijasztoronySzam = gondor.getTowerList().size();
            int varfalSzam = gondor.getWallList().size();
            int buildingNr = ijasztoronySzam + varfalSzam;
            int randomNr = random.nextInt(buildingNr);
            if (randomNr > ijasztoronySzam) {
                randomNr = randomNr - ijasztoronySzam - 1;
                Wall wall = gondor.getWallList().get(randomNr);
                int ujeletero = wall.hp - katapult.getDamage();
                wall.setHp(ujeletero);
            } else {
                Tower tower = gondor.getTowerList().get(randomNr);
                int ujeletero = tower.hp - katapult.getDamage();
                tower.setHp(ujeletero);
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

    public void gondorAttackKozelharci() {
        Random random = new Random();
        for (Unit gondorKozelharci : gondor.getMelee()) {
            int mordorKozelharciSize = mordor.getMelee().size();
            int mordorTavolharciSize = mordor.getRanged().size();
            if (mordorKozelharciSize != 0) {
                int randomNr = random.nextInt(mordorKozelharciSize);
                Unit mordorKozelharciEgyseg = mordor.getMelee().get(randomNr);
                mordorKozelharciEgyseg.setHp(
                        mordorKozelharciEgyseg.getHp() - gondorKozelharci.getDamage());
                if (mordorKozelharciEgyseg.getHp() <= 0) {
                    gondor.setMoney(gondor.getMoney() + mordorKozelharciEgyseg.getLoot());
                    mordor.getMelee().remove(mordorKozelharciEgyseg);
                }
            } else {
                if (mordorTavolharciSize != 0) {
                    int randomNr = random.nextInt(mordorTavolharciSize);
                    Unit mordorTavolharciEgyseg = mordor.getRanged().get(randomNr);
                    mordorTavolharciEgyseg.setHp(
                            mordorTavolharciEgyseg.getHp() - gondorKozelharci.getDamage());
                    if (mordorTavolharciEgyseg.getHp() <= 0) {
                        gondor.setMoney(gondor.getMoney() + mordorTavolharciEgyseg.getLoot());
                        mordor.getRanged().remove(mordorTavolharciEgyseg);
                    }

                } else {
                    break;
                }
            }
        }
    }

    public void gondorAttackArcher() {
        Random random = new Random();
        for (Unit gondorIjasz : gondor.getRanged()) {
            int mordorTavolharciSize = mordor.getRanged().size();
            int mordorKozelharciSize = mordor.getMelee().size();
            if (mordorTavolharciSize != 0) {
                int randomNr = random.nextInt(mordorTavolharciSize);
                Unit mordorTavolharciEgyseg = mordor.getRanged().get(randomNr);
                mordorTavolharciEgyseg.setHp(
                        (int) (mordorTavolharciEgyseg.getHp() - gondorIjasz.getDamage() * (1 + gondor.TowerBonusDamage())));
                if (mordorTavolharciEgyseg.getHp() <= 0) {
                    gondor.setMoney(gondor.getMoney() + mordorTavolharciEgyseg.getLoot());
                    mordor.getRanged().remove(mordorTavolharciEgyseg);
                }

            } else {
                if (mordorKozelharciSize != 0) {
                    int randomNr = random.nextInt(mordorKozelharciSize);
                    Unit mordorKozelharciEgyseg = mordor.getMelee().get(randomNr);
                    mordorKozelharciEgyseg.setHp(
                            (int) (mordorKozelharciEgyseg.getHp() - gondorIjasz.getDamage() * (1 + gondor.TowerBonusDamage())));
                    if (mordorKozelharciEgyseg.getHp() <= 0) {
                        gondor.setMoney(gondor.getMoney() + mordorKozelharciEgyseg.getLoot());
                        mordor.getMelee().remove(mordorKozelharciEgyseg);
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
        mordor.printArmy();
        mordorMenu();
        option = scanner.nextInt();
        scanner.nextLine();
        while (option != 6) {
            if (option == 7) {
                System.exit(0);
            }
            if (option > 7 || option < 1) {
                System.out.println("Give numbers between 1-7");
            } else {
                System.out.println("Please enter the quantity to recruit/build!");
                int amount = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        if (mordorAllCost(option, amount) <= mordor.getMoney()) {
                            for (int i = 0; i < amount; i++) {
                                mordor.getMelee().add(new Grunt());
                            }
                            mordor.setMoney(mordor.getMoney() - mordorAllCost(option, amount));
                            System.out.println("Unit(s) successfully added to army.");
                        } else {
                            System.out.println("Not enough resources.");
                        }
                        break;

                    case 2:
                        if (mordorAllCost(option, amount) <= mordor.getMoney()) {
                            for (int i = 0; i < amount; i++) {
                                mordor.getMelee().add(new UrukHai());
                            }
                            mordor.setMoney(mordor.getMoney() - mordorAllCost(option, amount));
                            System.out.println("Unit(s) successfully added to army.");
                        } else {
                            System.out.println("Not enough resources.");
                        }
                        break;
                    case 3:
                        if (mordorAllCost(option, amount) <= mordor.getMoney()) {
                            for (int i = 0; i < amount; i++) {
                                mordor.getRanged().add(new Archer());
                            }
                            mordor.setMoney(mordor.getMoney() - mordorAllCost(option, amount));
                            System.out.println("Unit(s) successfully added to army.");
                        } else {
                            System.out.println("Not enough resources.");
                        }
                        break;
                    case 4:
                        if (mordorAllCost(option, amount) <= mordor.getMoney()) {
                            for (int i = 0; i < amount; i++) {
                                mordor.getKatapultList().add(new Katapult());
                            }
                            mordor.setMoney(mordor.getMoney() - mordorAllCost(option, amount));
                            System.out.println("Unit(s) successfully added to army.");
                        } else {
                            System.out.println("Not enough resources.");
                        }
                        break;
                    case 5:
                        if (mordorAllCost(option, amount) <= mordor.getMoney()) {
                            for (int i = 0; i < amount; i++) {
                                mordor.getBallistaList().add(new Ballista());
                            }
                            mordor.setMoney(mordor.getMoney() - mordorAllCost(option, amount));
                            System.out.println("Unit(s) successfully added to army.");
                        } else {
                            System.out.println("Not enough resources.");
                        }
                        break;
                }
            }
            mordor.printArmy();
            mordorMenu();
            option = scanner.nextInt();
            scanner.nextLine();
        }

    }

    public void gondorBuy() {
        int option;
        Scanner scanner = new Scanner(System.in);
        gondor.printArmy();
        gondorMenu();
        option = scanner.nextInt();
        scanner.nextLine();
        while (option != 6) {
            if (option == 7) {
                System.exit(0);
            }
            if (option > 7 || option < 1) {
                System.out.println("Give numbers between 1-7");
            } else {
                System.out.println("Please enter the quantity to recruit/build!");
                int amount = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        if (gondorAllCost(option, amount) <= gondor.getMoney()) {
                            for (int i = 0; i < amount; i++) {
                                gondor.getMelee().add(new Soldier());
                            }
                            gondor.setMoney(gondor.getMoney() - gondorAllCost(option, amount));
                            System.out.println("Unit(s) successfully added to army.");
                        } else {
                            System.out.println("Not enough resources.");
                        }
                        break;

                    case 2:
                        if (gondorAllCost(option, amount) <= gondor.getMoney()) {
                            for (int i = 0; i < amount; i++) {
                                gondor.getMelee().add(new Knight());
                            }
                            gondor.setMoney(gondor.getMoney() - gondorAllCost(option, amount));
                            System.out.println("Unit(s) successfully added to army.");
                        } else {
                            System.out.println("Not enough resources.");
                        }
                        break;
                    case 3:
                        if (gondorAllCost(option, amount) <= gondor.getMoney()) {
                            for (int i = 0; i < amount; i++) {
                                gondor.getRanged().add(new Crossbowman());
                            }
                            gondor.setMoney(gondor.getMoney() - gondorAllCost(option, amount));
                            System.out.println("Unit(s) successfully added to army.");
                        } else {
                            System.out.println("Not enough resources.");
                        }
                        break;
                    case 4:
                        if (gondorAllCost(option, amount) <= gondor.getMoney()) {
                            for (int i = 0; i < amount; i++) {
                                gondor.getWallList().add(new Wall());
                            }
                            gondor.setMoney(gondor.getMoney() - gondorAllCost(option, amount));
                            System.out.println("Unit(s) successfully added to army.");
                        } else {
                            System.out.println("Not enough resources.");
                        }
                        break;
                    case 5:
                        if (gondorAllCost(option, amount) <= gondor.getMoney()) {
                            for (int i = 0; i < amount; i++) {
                                gondor.getTowerList().add(new Tower());
                            }
                            gondor.setMoney(gondor.getMoney() - gondorAllCost(option, amount));
                            System.out.println("Unit(s) successfully added to army.");
                        } else {
                            System.out.println("Not enough resources.");
                        }
                        break;
                }
            }
            gondor.printArmy();
            gondorMenu();
            option = scanner.nextInt();
            scanner.nextLine();

        }
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
}
