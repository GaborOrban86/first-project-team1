package hu.progmasters.kozosAbstractok;

public abstract class Unit {
    protected int eletero;
    protected int sebzes;
    protected int koltseg;
    protected int zsakmany;

    public Unit() {
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public int getSebzes() {
        return sebzes;
    }

    public void setSebzes(int sebzes) {
        this.sebzes = sebzes;
    }

    public int getKoltseg() {
        return koltseg;
    }

    public void setKoltseg(int koltseg) {
        this.koltseg = koltseg;
    }

    public int getZsakmany() {
        return zsakmany;
    }

    public void setZsakmany(int zsakmany) {
        this.zsakmany = zsakmany;
    }
}
