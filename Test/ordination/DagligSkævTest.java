package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkævTest {
    private DagligSkæv dagligSkæv;


    @BeforeEach
    void setUp() {
        dagligSkæv = new DagligSkæv(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 3), null);
    }

    @Test
    void testAddDosis() {
        Dosis d = new Dosis(LocalTime.of(8, 0), 2.0);
        dagligSkæv.addDosis(d);

        assertEquals(1, dagligSkæv.getAlleDosis().size());
        assertEquals(d, dagligSkæv.getAlleDosis().get(0));
    }

    @Test
    void testCreateDosis() {
        dagligSkæv.createDosis(LocalTime.of(12, 0), 1.5);

        assertEquals(1, dagligSkæv.getAlleDosis().size());
        assertEquals(1.5, dagligSkæv.getAlleDosis().get(0).getAntal(), 0.01);
    }

    @Test
    void testDøgnDosis() {
        dagligSkæv.createDosis(LocalTime.of(8, 0), 2);
        dagligSkæv.createDosis(LocalTime.of(12, 0), 1.5);

        assertEquals(3.5, dagligSkæv.døgnDosis(), 0.01);
    }

    @Test
    void testSamletDosis() {
        dagligSkæv.createDosis(LocalTime.of(8, 0), 2.0);
        dagligSkæv.createDosis(LocalTime.of(12, 0), 1.5);

        assertEquals(10.5, dagligSkæv.samletDosis(), 0.01);
    }
}