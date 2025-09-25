package ordination;

import org.jspecify.annotations.Nullable;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class DagligFast extends Ordination {
    private Array [] alleDosis = new Array[4];

    public DagligFast(LocalDate startDato, LocalDate slutDato, @Nullable Lægemiddel lægemiddel, Array[] alleDosis) {
        super(startDato, slutDato, lægemiddel);
        this.alleDosis = alleDosis;
    }

    @Override
    public double samletDosis() {
        double dosis = 0;
        double samletDosis = 0;
        Dosis d = new Dosis(null, 0);
        for (int i = 0; i < alleDosis.length; i++) {
            d.equals(alleDosis[i]);
            dosis+=d.getAntal();
            samletDosis += dosis;
            dosis = 0;

        }
        return samletDosis*antalDage();
    }

    @Override
    public double døgnDosis() {
      return samletDosis()/antalDage();
    }

    @Override
    public String getType() {
        return "DagligFast";
    }
}
