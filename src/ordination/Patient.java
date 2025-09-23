package ordination;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private final String cprNr;
    private final String navn;
    private final double vægt;
    // link Patient --> 0..* Ordination
    private final List<Ordination> ordinationer = new ArrayList<>();

    public Patient(String cprNr, String navn, double vægt) {
        this.cprNr = cprNr;
        this.navn = navn;
        this.vægt = vægt;
    }

    public double getVægt() {
        return vægt;
    }

    public String getCprNr() {
        return cprNr;
    }

    public String getNavn() {
        return navn;
    }

    public List<Ordination> getOrdinationer() {
        return ordinationer;
    }

    public void addOrdination (Ordination ordination) {
        ordinationer.add(ordination);
    }

    public void removeOrdination (Ordination ordination) {
        ordinationer.remove(ordination);
    }

    @Override
    public String toString() {
        return navn + "  " + cprNr;
    }
}
