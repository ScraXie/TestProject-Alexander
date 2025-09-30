package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest {
    private DagligFast dagligFast;

    @BeforeEach
    void setUp() {
        dagligFast = new DagligFast(
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 1, 3), // 3 dage
                null
        );

        Dosis[] doser = new Dosis[4];
        doser[0] = new Dosis(LocalTime.of(8, 0), 1.0);  // morgen
        doser[1] = new Dosis(LocalTime.of(12, 0), 2.0); // middag
        doser[2] = new Dosis(LocalTime.of(18, 0), 1.5); // aften
        doser[3] = new Dosis(LocalTime.of(23, 0), 0.5); // nat

        dagligFast.setAlleDosis(doser);
    }

    @Test
    void testGetAlleDosis() {
        assertEquals(4, dagligFast.getAlleDosis().length);
        assertEquals(1.0, dagligFast.getAlleDosis()[0].getAntal(), 0.0001);
    }

    @Test
    void testDøgnDosis() {
        // Sum = 1.0 + 2.0 + 1.5 + 0.5 = 5.0
        assertEquals(5.0, dagligFast.døgnDosis(), 0.0001);
    }

    @Test
    void testSamletDosis() {
        // 5.0 per dag * 3 dage = 15.0
        assertEquals(15.0, dagligFast.samletDosis(), 0.0001);
    }

    @Test
    void testSamletDosisMedNulDoser() {
        dagligFast.setAlleDosis(new Dosis[]{
                new Dosis(LocalTime.of(8, 0), 0),
                new Dosis(LocalTime.of(12, 0), 0),
                new Dosis(LocalTime.of(18, 0), 0),
                new Dosis(LocalTime.of(23, 0), 0)
        });

        assertEquals(0.0, dagligFast.samletDosis(), 0.0001);
    }

    @Test
    void testGetType() {
        assertEquals("DagligFast", dagligFast.getType());
    }
}