package hu.progmasters;

import hu.progmasters.gondor.Gondor;
import hu.progmasters.gondor.epuletek.Ijasztorony;
import hu.progmasters.gondor.epuletek.Varfal;
import hu.progmasters.mordor.Mordor;
import hu.progmasters.mordor.ostromgepek.Katapult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle {
    private Mordor mordor;
    private Gondor gondor;

    public void katapultAttack() {
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

        List<Varfal> toDeleteVarfal =new ArrayList<>();
        for (Varfal varfal : gondor.getVarfalList()) {
            if ((varfal.getEletero()<=0)) {
                toDeleteVarfal.add(varfal);
            }
        }
        gondor.getVarfalList().removeAll(toDeleteVarfal);
    }
}
