package ordination;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PNTest {
    private PN opretPN() {
        Lægemiddel paracetamol = new Lægemiddel("Paracetamol", 1, 1.5, 2, "mg");
        PN pn = new PN(LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 5), paracetamol, 2);
        return pn;
    }

    @Test
    void anvendDosis() {
        PN pn = opretPN();
        pn.anvendDosis(LocalDate.of(2023, 9, 1));
        pn.anvendDosis(LocalDate.of(2023, 9, 2));

        assertEquals(2, pn.antalGangeAnvendt(), "Der bør være registreret 2 doser.");
    }

    @Test
    void antalGangeAnvendt() {
        PN pn = opretPN();
        pn.anvendDosis(LocalDate.of(2023, 9, 1));
        pn.anvendDosis(LocalDate.of(2023, 9, 2));
        pn.anvendDosis(LocalDate.of(2023, 9, 4));

        assertEquals(3, pn.antalGangeAnvendt(), "Forventet 3 registreringer af dosis.");
    }

    @Test
    void samletDosis() {
        PN pn = opretPN();
        pn.anvendDosis(LocalDate.of(2023, 9, 1));
        pn.anvendDosis(LocalDate.of(2023, 9, 2));

        // 2 enheder pr gang × 2 gange = 4.0
        assertEquals(4.0, pn.samletDosis(), 0.001, "Samlet dosis bør være 4.0");
    }

    @Test
    void døgnDosis() {
        PN pn = opretPN();
        pn.anvendDosis(LocalDate.of(2023, 9, 1));
        pn.anvendDosis(LocalDate.of(2023, 9, 2));

        // samlet dosis = 4.0, antal dage = 5 (1. sep - 5. sep inkl.)
        assertEquals(0.8, pn.døgnDosis(), 0.001, "Døgndosis bør være 0.8");
    }
}