package controller;

import ordination.Dosis;
import ordination.Lægemiddel;
import ordination.Ordination;
import ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    @BeforeEach
    void setUp() {
        Controller.setStorage(new Storage());

    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgnLetAlexanderAcetylsalicylsyre() {
        // arrange
        Patient alex = new Patient("110502-9993", "Alexander Nielsen", 20);
        Lægemiddel acetylsalicylsyre = new Lægemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");

        // act
        double dosis =  Controller.anbefaletDosisPrDøgn(alex, acetylsalicylsyre);

        // assert
        assertEquals(2, dosis, 0.01);
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgnLetAlexanderParcetamol() {
        // arrange
        Patient alex = new Patient("110502-9993", "Alexander Nielsen", 20);
        Lægemiddel paracetamol = new Lægemiddel("Paracetamol", 1, 1.5, 2, "Ml");

        // act
        double dosis =  Controller.anbefaletDosisPrDøgn(alex, paracetamol);

        // assert
        assertEquals(20, dosis, 0.01);
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgnLetAlexanderFucidin() {
        // arrange
        Patient alex = new Patient("110502-9993", "Alexander Nielsen", 20);
        Lægemiddel fucidin = new Lægemiddel("Fucidin", 0.025, 0.025,
                0.025, "Styk");

        // act
        double dosis =  Controller.anbefaletDosisPrDøgn(alex, fucidin);

        // assert
        assertEquals(0.5, dosis, 0.01);
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgnLetAlexanderMethotrexate() {
        // arrange
        Patient alex = new Patient("110502-9993", "Alexander Nielsen", 20);
        Lægemiddel methotrexate = Controller.opretLægemiddel(
                "Methotrexate", 0.01, 0.015,
                0.02, "Styk");

        // act
        double dosis =  Controller.anbefaletDosisPrDøgn(alex, methotrexate);

        // assert
        assertEquals(0.2, dosis, 1);
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgnTungVictoriaAcetylsalicylsyre() {
        // arrange
        Patient vic = new Patient("02-12-02-9992", "Victoria Svendson", 128.5);
        Lægemiddel acetylsalicylsyre = Controller.opretLægemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");

        // act
        double dosis =  Controller.anbefaletDosisPrDøgn(vic, acetylsalicylsyre);

        // assert
        assertEquals(20.56, dosis, 0.01);
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgnTungVictoriaParacetamol() {
        // arrange
        Patient vic = new Patient("02-12-02-9992", "Victoria Svendson", 128.5);
        Lægemiddel paracetamol = Controller.opretLægemiddel("Paracetamol", 1, 1.5, 2, "Ml");

        // act
        double dosis =  Controller.anbefaletDosisPrDøgn(vic, paracetamol);

        // assert
        assertEquals(257, dosis, 0.01);
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgnTungVictoriaFucidin() {
        // arrange
        Patient vic = new Patient("02-12-02-9992", "Victoria Svendson", 128.5);
        Lægemiddel fucidin = Controller.opretLægemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk");

        // act
        double dosis =  Controller.anbefaletDosisPrDøgn(vic, fucidin);

        // assert
        assertEquals(3.2125, dosis, 0.01);
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgnTungVictoriaMethotrexate() {
        // arrange
        Patient vic = new Patient("02-12-02-9992", "Victoria Svendson", 128.5);
        Lægemiddel methotrexate = Controller.opretLægemiddel("Methotrexate", 0.01, 0.015, 0.02, "Styk");

        // act
        double dosis =  Controller.anbefaletDosisPrDøgn(vic, methotrexate);

        // assert
        assertEquals(2.57, dosis, 0.01);
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgnNormalJaneAcetylsalicylsyre() {
        // arrange
        Patient jane = new Patient("121256-0512", "Jane Jensen", 63.4);
        Lægemiddel acetylsalicylsyre = Controller.opretLægemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");

        // act
        double dosis =  Controller.anbefaletDosisPrDøgn(jane, acetylsalicylsyre);

        // assert
        assertEquals(9.51, dosis, 0.01);
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgnNormalJaneParacetamol() {
        // arrange
        Patient jane = new Patient("121256-0512", "Jane Jensen", 63.4);
        Lægemiddel paracetamol = Controller.opretLægemiddel("Paracetamol", 1, 1.5, 2, "Ml");

        // act
        double dosis =  Controller.anbefaletDosisPrDøgn(jane, paracetamol);

        // assert
        assertEquals(95.1, dosis, 0.01);
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgnNormalJaneFucidin() {
        // arrange
        Patient jane = new Patient("121256-0512", "Jane Jensen", 63.4);
        Lægemiddel fucidin = Controller.opretLægemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk");

        // act
        double dosis =  Controller.anbefaletDosisPrDøgn(jane, fucidin);

        // assert
        assertEquals(1.585, dosis, 0.01);
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgnNormalJaneMethotrexate() {
        // arrange
        Patient jane = new Patient("121256-0512", "Jane Jensen", 63.4);
        Lægemiddel methotrexate = Controller.opretLægemiddel("Methotrexate", 0.01, 0.015, 0.02, "Styk");

        // act
        double dosis =  Controller.anbefaletDosisPrDøgn(jane, methotrexate);

        // assert
        assertEquals(0.951, dosis, 0.01);
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel0Til25Acetylsalicylsyre() {
        // arrange
        Patient alex = Controller.opretPatient("10101010", "Alexander Nielsen", 20);
        Lægemiddel acetylsalicylsyre = Controller.opretLægemiddel("Acetylsalicylsyre"
                , 0.01, 0.015, 0.02, "Styk");
        Ordination alexOrd = Controller.opretPNOrdination(LocalDate.parse("2020-01-12"),
                LocalDate.parse("2020-01-13"), alex, acetylsalicylsyre, 3);

        // act
        int antal = Controller.antalOrdinationerPrVægtPrLægemiddel(0, 25, acetylsalicylsyre);

        // assert
        assertEquals(1, antal);
    }
    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel0Til25Paracetamol() {
        // arrange
        Lægemiddel paracetamol = Controller.opretLægemiddel("Paracetamol"
                , 0.01, 0.015, 0.02, "Styk");
        Patient alex = Controller.opretPatient("10101010", "Alexander Nielsen", 20);

        // act
        int antal = Controller.antalOrdinationerPrVægtPrLægemiddel(0, 25, paracetamol);

        // assert
        assertEquals(0, antal);
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel0Til25Fucidin() {
        // arrange
        Lægemiddel fucidin = Controller.opretLægemiddel("Fucidin"
                , 0.01, 0.015, 0.02, "Styk");
        Patient alex = Controller.opretPatient("10101010", "Alexander Nielsen", 20);


        // act
        int antal = Controller.antalOrdinationerPrVægtPrLægemiddel(0, 25, fucidin);

        // assert
        assertEquals(0, antal);
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel0Til25Methotrexate() {
        // arrange
        Lægemiddel methotrexate = Controller.opretLægemiddel("Methotrexate"
                , 0.01, 0.015, 0.02, "Styk");
        Patient alex = Controller.opretPatient("10101010", "Alexander Nielsen", 20);

        // act
        int antal = Controller.antalOrdinationerPrVægtPrLægemiddel(0, 25, methotrexate);

        // assert
        assertEquals(0, antal);
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel26Til119Acetylsalicylsyre() {
        // arrange
        Lægemiddel acetylsalicylsyre = Controller.opretLægemiddel("Acetylsalicylsyre"
                , 0.01, 0.015, 0.02, "Styk");
        Patient jane = Controller.opretPatient("10101010", "jane", 63.4);
        Ordination janeOrd = Controller.opretPNOrdination(LocalDate.parse("2020-01-12"),
                LocalDate.parse("2020-01-13"), jane, acetylsalicylsyre, 3);

        // act
        int antal = Controller.antalOrdinationerPrVægtPrLægemiddel(26, 119, acetylsalicylsyre);

        // assert
        assertEquals(1, antal);
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel26Til119Paracetamol() {
        // arrange
        Lægemiddel paracetamol = Controller.opretLægemiddel("Paracetamol"
                , 0.01, 0.015, 0.02, "Styk");
        Patient jane = Controller.opretPatient("10101010", "Jane", 63.4);
        Ordination alexOrd = Controller.opretPNOrdination(LocalDate.parse("2020-01-12"),
                LocalDate.parse("2020-01-13"), jane, paracetamol, 3);
        Ordination alexOrd2 = Controller.opretPNOrdination(LocalDate.parse("2020-01-12"),
                LocalDate.parse("2020-01-19"), jane, paracetamol, 3);

        // act
        int antal = Controller.antalOrdinationerPrVægtPrLægemiddel(26, 119, paracetamol);

        // assert
        assertEquals(2, antal);
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel26Til119Fucidin() {
        // arrange
        Lægemiddel fucidin = Controller.opretLægemiddel("Fucidin"
                , 0.01, 0.015, 0.02, "Styk");
        Patient alex = Controller.opretPatient("10101010", "Alexander Nielsen", 70);
        Ordination ord = Controller.opretPNOrdination(LocalDate.parse("2020-01-12"),
                LocalDate.parse("2020-01-19"), alex, fucidin, 3);

        // act
        int antal = Controller.antalOrdinationerPrVægtPrLægemiddel(26, 119, fucidin);

        // assert
        assertEquals(1, antal);
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel26Til119Methotrexate() {
        // arrange
        Lægemiddel methotrexate = Controller.opretLægemiddel("Methotrexate"
                , 0.01, 0.015, 0.02, "Styk");
        Patient alex = Controller.opretPatient("10101010", "Alexander Nielsen", 20);

        // act
        int antal = Controller.antalOrdinationerPrVægtPrLægemiddel(0, 25, methotrexate);

        // assert
        assertEquals(0, antal);
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel120Til300Acetylsalicylsyre() {
        // arrange
        Lægemiddel acetylsalicylsyre = Controller.opretLægemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        Patient alex = Controller.opretPatient("10101010", "Alexander Nielsen", 20);
        // act
        int antal = Controller.antalOrdinationerPrVægtPrLægemiddel(120, 300, acetylsalicylsyre);

        // assert
        assertEquals(0, antal);
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel120Til300Paracetamol() {
        // arrange
        Lægemiddel paracetamol = Controller.opretLægemiddel("Paracetamol", 0.01, 0.015, 0.02, "Styk");
        Patient alex = Controller.opretPatient("10101010", "Alexander Nielsen", 20);

        // act
        int antal = Controller.antalOrdinationerPrVægtPrLægemiddel(0, 25, paracetamol);

        // assert
        assertEquals(0, antal);
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel120Til300Fucidin() {
        // arrange
        Lægemiddel fucidin = Controller.opretLægemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk");
        Patient vic = Controller.opretPatient("10101010", "Victoria", 128.5);
        Ordination ord = Controller.opretPNOrdination(LocalDate.parse("2020-01-12"),
                LocalDate.parse("2020-01-19"), vic, fucidin, 3);
        // act
        int antal = Controller.antalOrdinationerPrVægtPrLægemiddel(120, 300, fucidin);

        // assert
        assertEquals(1, antal);
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel120Til300Methotrexate() {
        // arrange
        Lægemiddel methotrexate = Controller.opretLægemiddel("Methotrexate", 0.01, 0.015, 0.02, "Styk");
        Patient alex = Controller.opretPatient("10101010", "Alexander Nielsen", 20);

        // act
        int antal = Controller.antalOrdinationerPrVægtPrLægemiddel(120, 300, methotrexate);

        // assert
        assertEquals(0, antal);
    }
}