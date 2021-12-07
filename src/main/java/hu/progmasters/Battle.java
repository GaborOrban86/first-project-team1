package hu.progmasters;

import hu.progmasters.gondor.Gondor;
import hu.progmasters.gondor.egysegek.Szamszerijasz;
import hu.progmasters.gondor.epuletek.Ijasztorony;
import hu.progmasters.gondor.epuletek.Varfal;
import hu.progmasters.kozosAbstractok.Unit;
import hu.progmasters.mordor.Mordor;
import hu.progmasters.mordor.ostromgepek.Ballista;
import hu.progmasters.mordor.ostromgepek.Katapult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle {
    private Mordor mordor;
    private Gondor gondor;


    public void mordorBallistaAttack() {
        Random random = new Random();
        for (Ballista ballista : mordor.getBallistaList()) {
            int gondorTavolharciSize = gondor.getTavolharci().size();
            int gondorKozelharciSize = gondor.getKozelharci().size();
            if (gondorTavolharciSize != 0) {
                int randomNr = random.nextInt(gondorTavolharciSize);
                Unit gondorTavolharciEgyseg = gondor.getHarciEgysegek().getTavolharci().get(randomNr);
                gondorTavolharciEgyseg.setEletero(gondorTavolharciEgyseg.getEletero() - ballista.getSebzes());
                if (gondorTavolharciEgyseg.getEletero() <= 0) {
                    mordor.setMoney(mordor.getMoney() + gondorTavolharciEgyseg.getZsakmany());
                    gondor.getHarciEgysegek().getTavolharci().remove(gondorTavolharciEgyseg);
                }

            } else {
                if (gondorKozelharciSize != 0) {
                    int randomNr = random.nextInt(gondorKozelharciSize);
                    Unit gondorKozelharciEgyseg = gondor.getHarciEgysegek().getKozelharci().get(randomNr);
                    gondorKozelharciEgyseg.setEletero(gondorKozelharciEgyseg.getEletero() - ballista.getSebzes());
                    if (gondorKozelharciEgyseg.getEletero() <= 0) {
                        mordor.setMoney(mordor.getMoney() + gondorKozelharciEgyseg.getZsakmany());
                        gondor.getHarciEgysegek().getTavolharci().remove(gondorKozelharciEgyseg);
                    }
                } else {
                    break;
                }
            }
        }

    }


    public void mordorKatapultAttack() {
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
}
