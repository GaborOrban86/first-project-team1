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
            int gondorTavolharciSize = gondor.getTavolharci().size();
            int gondorKozelharciSize = gondor.getKozelharci().size();
            if (gondorTavolharciSize != 0) {
                int randomNr = random.nextInt(gondorTavolharciSize);
                Unit gondorTavolharciEgyseg = gondor.getTavolharci().get(randomNr);
                gondorTavolharciEgyseg.setEletero(
                        (int) (gondorTavolharciEgyseg.getEletero() - ballista.getSebzes() * (1 - gondor.wallProtection())));
                if (gondorTavolharciEgyseg.getEletero() <= 0) {
                    mordor.setMoney(mordor.getMoney() + gondorTavolharciEgyseg.getZsakmany());
                    gondor.getTavolharci().remove(gondorTavolharciEgyseg);
                }

            } else {
                if (gondorKozelharciSize != 0) {
                    int randomNr = random.nextInt(gondorKozelharciSize);
                    Unit gondorKozelharciEgyseg = gondor.getKozelharci().get(randomNr);
                    gondorKozelharciEgyseg.setEletero(
                            (int) (gondorKozelharciEgyseg.getEletero() - ballista.getSebzes() * (1 - gondor.wallProtection())));
                    if (gondorKozelharciEgyseg.getEletero() <= 0) {
                        mordor.setMoney(mordor.getMoney() + gondorKozelharciEgyseg.getZsakmany());
                        gondor.getTavolharci().remove(gondorKozelharciEgyseg);
                    }
                } else {
                    break;
                }
            }
        }

    }

    public void mordorAttackKozelharci() {
        Random random = new Random();
        for (Unit mordorKozel : mordor.getKozelharci()) {
            int gondorKozelharciSize = gondor.getKozelharci().size();
            int gondorTavolharciSize = gondor.getTavolharci().size();
            if (gondorKozelharciSize != 0) {
                int randomNr = random.nextInt(gondorKozelharciSize);
                Unit gondorKozelharciEgyseg = gondor.getKozelharci().get(randomNr);
                gondorKozelharciEgyseg.setEletero(
                        (int) (gondorKozelharciEgyseg.getEletero() - mordorKozel.getSebzes() * (1 - gondor.wallProtection())));
                if (gondorKozelharciEgyseg.getEletero() <= 0) {
                    mordor.setMoney(mordor.getMoney() + gondorKozelharciEgyseg.getZsakmany());
                    gondor.getTavolharci().remove(gondorKozelharciEgyseg);
                }
            } else {
                if (gondorTavolharciSize != 0) {
                    int randomNr = random.nextInt(gondorTavolharciSize);
                    Unit gondorTavolharciEgyseg = gondor.getTavolharci().get(randomNr);
                    gondorTavolharciEgyseg.setEletero(
                            (int) (gondorTavolharciEgyseg.getEletero() - mordorKozel.getSebzes() * (1 - gondor.wallProtection())));
                    if (gondorTavolharciEgyseg.getEletero() <= 0) {
                        mordor.setMoney(mordor.getMoney() + gondorTavolharciEgyseg.getZsakmany());
                        gondor.getTavolharci().remove(gondorTavolharciEgyseg);
                    }
                } else {
                    break;
                }
            }
        }

    }

    public void mordorAttackOrkArcher() {
        Random random = new Random();
        for (Unit orkIjasz : mordor.getTavolharci()) {
            int gondorTavolharciSize = gondor.getTavolharci().size();
            int gondorKozelharciSize = gondor.getKozelharci().size();
            if (gondorTavolharciSize != 0) {
                int randomNr = random.nextInt(gondorTavolharciSize);
                Unit gondorTavolharciEgyseg = gondor.getTavolharci().get(randomNr);
                gondorTavolharciEgyseg.setEletero(
                        (int) (gondorTavolharciEgyseg.getEletero() - orkIjasz.getSebzes() * (1 - gondor.wallProtection())));
                if (gondorTavolharciEgyseg.getEletero() <= 0) {
                    mordor.setMoney(mordor.getMoney() + gondorTavolharciEgyseg.getZsakmany());
                    gondor.getTavolharci().remove(gondorTavolharciEgyseg);
                }

            } else {
                if (gondorKozelharciSize != 0) {
                    int randomNr = random.nextInt(gondorKozelharciSize);
                    Unit gondorKozelharciEgyseg = gondor.getKozelharci().get(randomNr);
                    gondorKozelharciEgyseg.setEletero(
                            (int) (gondorKozelharciEgyseg.getEletero() - orkIjasz.getSebzes() * (1 - gondor.wallProtection())));
                    if (gondorKozelharciEgyseg.getEletero() <= 0) {
                        mordor.setMoney(mordor.getMoney() + gondorKozelharciEgyseg.getZsakmany());
                        gondor.getTavolharci().remove(gondorKozelharciEgyseg);
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
            int ijasztoronySzam = gondor.getIjasztoronyList().size();
            int varfalSzam = gondor.getVarfalList().size();
            int buildingNr = ijasztoronySzam + varfalSzam;
            int randomNr = random.nextInt(buildingNr);
            if (randomNr > ijasztoronySzam) {
                randomNr = randomNr - ijasztoronySzam - 1;
                Varfal varfal = gondor.getVarfalList().get(randomNr);
                int ujeletero = varfal.eletero - katapult.getSebzes();
                varfal.setEletero(ujeletero);
            } else {
                Ijasztorony ijasztorony = gondor.getIjasztoronyList().get(randomNr);
                int ujeletero = ijasztorony.eletero - katapult.getSebzes();
                ijasztorony.setEletero(ujeletero);
            }
        }
        List<Ijasztorony> toDelete = new ArrayList<>();
        for (Ijasztorony ijasztorony : gondor.getIjasztoronyList()) {
            if (ijasztorony.getEletero() <= 0) {
                toDelete.add(ijasztorony);
            }
        }
        gondor.getIjasztoronyList().removeAll(toDelete);

        List<Varfal> toDeleteVarfal = new ArrayList<>();
        for (Varfal varfal : gondor.getVarfalList()) {
            if ((varfal.getEletero() <= 0)) {
                toDeleteVarfal.add(varfal);
            }
        }
        gondor.getVarfalList().removeAll(toDeleteVarfal);
    }

    public void gondorAttackKozelharci() {
        Random random = new Random();
        for (Unit gondorKozelharci : gondor.getKozelharci()) {
            int mordorKozelharciSize = mordor.getKozelharci().size();
            int mordorTavolharciSize = mordor.getTavolharci().size();
            if (mordorKozelharciSize != 0) {
                int randomNr = random.nextInt(mordorKozelharciSize);
                Unit mordorKozelharciEgyseg = mordor.getKozelharci().get(randomNr);
                mordorKozelharciEgyseg.setEletero(
                        mordorKozelharciEgyseg.getEletero() - gondorKozelharci.getSebzes());
                if (mordorKozelharciEgyseg.getEletero() <= 0) {
                    gondor.setMoney(gondor.getMoney() + mordorKozelharciEgyseg.getZsakmany());
                    mordor.getTavolharci().remove(mordorKozelharciEgyseg);
                }
            } else {
                if (mordorTavolharciSize != 0) {
                    int randomNr = random.nextInt(mordorTavolharciSize);
                    Unit mordorTavolharciEgyseg = mordor.getTavolharci().get(randomNr);
                    mordorTavolharciEgyseg.setEletero(
                            mordorTavolharciEgyseg.getEletero() - gondorKozelharci.getSebzes());
                    if (mordorTavolharciEgyseg.getEletero() <= 0) {
                        gondor.setMoney(gondor.getMoney() + mordorTavolharciEgyseg.getZsakmany());
                        mordor.getTavolharci().remove(mordorTavolharciEgyseg);
                    }

                } else {
                    break;
                }
            }
        }
    }

    public void gondorAttackArcher() {
        Random random = new Random();
        for (Unit gondorIjasz : gondor.getTavolharci()) {
            int mordorTavolharciSize = mordor.getTavolharci().size();
            int mordorKozelharciSize = mordor.getKozelharci().size();
            if (mordorTavolharciSize != 0) {
                int randomNr = random.nextInt(mordorTavolharciSize);
                Unit mordorTavolharciEgyseg = mordor.getTavolharci().get(randomNr);
                mordorTavolharciEgyseg.setEletero(
                        (int) (mordorTavolharciEgyseg.getEletero() - gondorIjasz.getSebzes() * (1 + gondor.ijasztoronyBonuszSebzes())));
                if (mordorTavolharciEgyseg.getEletero() <= 0) {
                    gondor.setMoney(gondor.getMoney() + mordorTavolharciEgyseg.getZsakmany());
                    mordor.getTavolharci().remove(mordorTavolharciEgyseg);
                }

            } else {
                if (mordorKozelharciSize != 0) {
                    int randomNr = random.nextInt(mordorKozelharciSize);
                    Unit mordorKozelharciEgyseg = mordor.getKozelharci().get(randomNr);
                    mordorKozelharciEgyseg.setEletero(
                            (int) (mordorKozelharciEgyseg.getEletero() - gondorIjasz.getSebzes() * (1 + gondor.ijasztoronyBonuszSebzes())));
                    if (mordorKozelharciEgyseg.getEletero() <= 0) {
                        gondor.setMoney(gondor.getMoney() + mordorKozelharciEgyseg.getZsakmany());
                        mordor.getTavolharci().remove(mordorKozelharciEgyseg);
                    }
                } else {
                    break;
                }
            }
        }

    }

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
                                mordor.getKozelharci().add(new Ork());
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
                                mordor.getKozelharci().add(new Troll());
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
                                mordor.getTavolharci().add(new Orkijasz());
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
                                gondor.getKozelharci().add(new Soldier());
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
                                gondor.getKozelharci().add(new Lovag());
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
                                gondor.getTavolharci().add(new Szamszerijasz());
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
                                gondor.getVarfalList().add(new Varfal());
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
                                gondor.getIjasztoronyList().add(new Ijasztorony());
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
