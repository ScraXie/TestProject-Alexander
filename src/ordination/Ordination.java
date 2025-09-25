package ordination;

import org.jspecify.annotations.Nullable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Ordination {
    private LocalDate startDato;
    private LocalDate slutDato;
    // link Ordination --> 0..1 Lægemiddel
    private @Nullable Lægemiddel lægemiddel;

    public Ordination(LocalDate startDato, LocalDate slutDato, @Nullable Lægemiddel lægemiddel) {
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.lægemiddel = lægemiddel;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public @Nullable Lægemiddel getLægemiddel() {
        return lægemiddel;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public void setLægemiddel(@Nullable Lægemiddel lægemiddel) {
        this.lægemiddel = lægemiddel;
    }

    /**
     * Returner antal hele dage mellem startdato og slutdato
     * (begge dage inklusive).
     */
    public int antalDage() {
        return (int) ChronoUnit.DAYS.between(startDato, slutDato) + 1;
    }

    @Override
    public String toString() {
        return startDato.toString();
    }

    /** Returner den totale dosis, der er givet i den periode, ordinationen er gyldig. */
    public abstract double samletDosis();

    /** Returner den gennemsnitlige dosis givet per dag. */
    public abstract double døgnDosis();

    /** Returner ordinationstypen som en String. */
    public abstract String getType();
}
