package hu.progmasters.kozosAbstractok;

import hu.progmasters.jelolointerfacek.Kozelharci;
import hu.progmasters.jelolointerfacek.Tavolharci;

import java.util.ArrayList;
import java.util.List;

public abstract class HarciEgysegek {
    protected List<Kozelharci> kozelharci = new ArrayList<>();
    protected List<Tavolharci> tavolharci = new ArrayList<>();

    public HarciEgysegek() {
    }

    public List<Kozelharci> getKozelharci() {
        return kozelharci;
    }

    public void setKozelharci(List<Kozelharci> kozelharci) {
        this.kozelharci = kozelharci;
    }

    public List<Tavolharci> getTavolharci() {
        return tavolharci;
    }

    public void setTavolharci(List<Tavolharci> tavolharci) {
        this.tavolharci = tavolharci;
    }
}
