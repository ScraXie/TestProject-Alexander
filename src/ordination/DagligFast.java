package ordination;

import org.jspecify.annotations.Nullable;
import java.time.LocalDate;

public class DagligFast extends Ordination {
    private Dosis [] alleDosis = new Dosis[4];

    public DagligFast(LocalDate startDato, LocalDate slutDato, @Nullable Lægemiddel lægemiddel) {
        super(startDato, slutDato, lægemiddel);

    }

    public void setAlleDosis(Dosis[] alleDosis) {
        this.alleDosis = alleDosis;
    }

    public Dosis[] getAlleDosis() {
        return alleDosis;
    }

    @Override
    public double samletDosis() {
        return døgnDosis() * antalDage();
    }

    @Override
    public double døgnDosis() {
        double sum = 0;
        for (Dosis dosis : alleDosis) {
            if (dosis != null) {
                sum += dosis.getAntal();
            }
        }
        return sum;
    }

    @Override
    public String getType() {
        return "DagligFast";
    }


}
