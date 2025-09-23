package ordination;

import java.util.ArrayList;
import java.util.List;

public class DagligSkæv extends Ordination {
    private List<Dosis> alleDosis = new ArrayList<>();

    public DagligSkæv(List<Dosis> alleDosis) {
        this.alleDosis = alleDosis;
    }

    public List<Dosis> getAlleDosis() {
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
            sum += dosis.getAntal();
        }
        return sum;
    }

    @Override
    public String getType() {
        return "Daglig skæv";
    }
}