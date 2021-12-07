package hu.progmasters.kozosAbstractok;


import java.util.ArrayList;
import java.util.List;

public abstract class HarciEgysegek {
    protected List<Unit> kozelharci = new ArrayList<>();
    protected List<Unit> tavolharci = new ArrayList<>();

    public HarciEgysegek() {
    }

    public List<Unit> getKozelharci() {
        return kozelharci;
    }

    public void setKozelharci(List<Unit> kozelharci) {
        this.kozelharci = kozelharci;
    }

    public List<Unit> getTavolharci() {
        return tavolharci;
    }

    public void setTavolharci(List<Unit> tavolharci) {
        this.tavolharci = tavolharci;
    }
}
