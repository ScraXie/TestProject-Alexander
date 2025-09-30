package ordination;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PNTest {
    private PN opretPN() {
        Lægemiddel paracetamol = new Lægemiddel("Paracetamol", 1, 1.5, 2, "mg");
        PN nyPn = new PN(LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 5), paracetamol, 2);
        return nyPn;
    }

    @Test
    void anvendDosis() {
        // arrange
        Lægemiddel paracetamol = new Lægemiddel("Paracetamol", 1, 1.5, 2, "mg");
        PN pn = new PN(LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 5), paracetamol, 2);

        // act
        pn.anvendDosis(LocalDate.of(2023, 9, 1));
        pn.anvendDosis(LocalDate.of(2023, 9, 2));
        int antal = pn.antalGangeAnvendt();

        // assert
        assertEquals(2, antal);
    }

    @Test
    void antalGangeAnvendt() {
        // arrange
        Lægemiddel paracetamol = new Lægemiddel("Paracetamol", 1, 1.5, 2, "mg");
        PN pn = new PN(LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 5), paracetamol, 2);

        // act
        pn.anvendDosis(LocalDate.of(2023, 9, 1));
        pn.anvendDosis(LocalDate.of(2023, 9, 2));
        pn.anvendDosis(LocalDate.of(2023, 9, 4));
        int antal = pn.antalGangeAnvendt();

        // assert
        assertEquals(3, antal);
    }

    @Test
    void samletDosis2EnhederPrGang() {
        // arrange
        Lægemiddel paracetamol = new Lægemiddel("Paracetamol", 1, 1.5, 2, "mg");
        PN pn = new PN(LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 5), paracetamol, 2);

        // act
        pn.anvendDosis(LocalDate.of(2023, 9, 1));
        pn.anvendDosis(LocalDate.of(2023, 9, 2));
        double samlet = pn.samletDosis();

        // assert
        assertEquals(4.0, samlet, 0.001);
    }

    @Test
    void døgnDosis() {
        // arrange
        Lægemiddel paracetamol = new Lægemiddel("Paracetamol", 1, 1.5, 2, "mg");
        PN pn = new PN(LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 5), paracetamol, 2);

        // act
        pn.anvendDosis(LocalDate.of(2023, 9, 1));
        pn.anvendDosis(LocalDate.of(2023, 9, 2));
        double døgnDosis = pn.døgnDosis();

        // assert
        assertEquals(0.8, døgnDosis, 0.001);
    }
}