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
        dagligFast = new DagligFast(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 3), null);
        Dosis[] doser = new Dosis[4];
        doser[0] = new Dosis(LocalTime.of(8, 0), 1.0);
        doser[1] = new Dosis(LocalTime.of(12, 0), 2.0);
        doser[2] = new Dosis(LocalTime.of(18, 0), 1.5);
        doser[3] = new Dosis(LocalTime.of(23, 0), 0.5);
        dagligFast.setAlleDosis(doser);
    }

    @Test
    void testDøgnDosis() {
        assertEquals(5.0, dagligFast.døgnDosis(), 0.0001);
    }

    @Test
    void testSamletDosis() {
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
}