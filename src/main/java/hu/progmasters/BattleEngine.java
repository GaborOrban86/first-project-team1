package hu.progmasters;

import hu.progmasters.gondor.Gondor;
import hu.progmasters.gondor.epuletek.Ijasztorony;
import hu.progmasters.gondor.epuletek.Varfal;
import hu.progmasters.kozosAbstractok.Unit;
import hu.progmasters.mordor.Mordor;
import hu.progmasters.mordor.ostromgepek.Ballista;
import hu.progmasters.mordor.ostromgepek.Katapult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleEngine {
    protected Mordor mordor;
    protected Gondor gondor;

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
