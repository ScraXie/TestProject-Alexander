package ordination;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PN extends Ordination{
    private double antalEnheder;
    private List<LocalDate> datoerForAnvendelse = new ArrayList<>();

    public PN(double antalEnheder) {
        this.antalEnheder = antalEnheder;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    /**
     * Registrer datoen for en anvendt dosis.
     */
    public void anvendDosis(LocalDate dato) {
        datoerForAnvendelse.add(dato);
    }

    /** Returner antal gange ordinationen er anvendt. */
    public int antalGangeAnvendt() {
        return datoerForAnvendelse.size();
    }

    @Override
    public double samletDosis() {
        return antalGangeAnvendt() * getAntalEnheder();
    }

    @Override
    public double døgnDosis() {
        return samletDosis() / (antalDage());
    }

    @Override
    public String getType() {
        return "PN";
    }
}
