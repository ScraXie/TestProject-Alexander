package ordination;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DagligFast extends Ordination {
    private Array [] alleDosis = new Array[4];



    @Override
    public double samletDosis() {
        double dosis = 0;
        Dosis d = new Dosis(null, 0);
        for (int i = 0; i < alleDosis.length; i++) {
            d.equals(alleDosis[i]);
            dosis+=d.getAntal();

        }
        return dosis*antalDage();
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
