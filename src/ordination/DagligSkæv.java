package ordination;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DagligSkæv extends Ordination {
    private List<Dosis> alleDosis = new ArrayList<>();

    public DagligSkæv() {
        super();
    }

    public List<Dosis> getAlleDosis() {
        return alleDosis;
    }

    public void addDosis(Dosis dosis) {
        alleDosis.add(dosis);
    }

    public void createDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        alleDosis.add(dosis);
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