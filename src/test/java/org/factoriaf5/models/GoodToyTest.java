package org.factoriaf5.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GoodToyTest {
 private GoodToy goodToy;

    @BeforeEach
    void setUp() {
        // Initialize a GoodToy object before each test
        goodToy = new GoodToy("Juguete educativo", true, "Fisher-Price", "3+", "Educativo");
    }

    @Test
    void testSetBrand() {
        // Verify initial brand
        assertEquals("Fisher-Price", goodToy.getBrand());

        // Set a new brand
        goodToy.setBrand("Lego");

        // Verify updated brand
        assertEquals("Lego", goodToy.getBrand());
    }

    @Test
    void testSetTargetAge() {
        // Verify initial target age
        assertEquals("3+", goodToy.getTargetAge());

        // Set a new target age
        goodToy.setTargetAge("6+");

        // Verify updated target age
        assertEquals("6+", goodToy.getTargetAge());
    }

    @Test
    void testSetCategory() {
        // Verify initial category
        assertEquals("Educativo", goodToy.getCategory());

        // Set a new category
        goodToy.setCategory("Construcción");

        // Verify updated category
        assertEquals("Construcción", goodToy.getCategory());
    }

    @Test
    void testToString() {
        // Expected format of toString
        String expected = "B1. Título: Juguete educativo, Marca: Fisher-Price, Edad Recomendada: 3+, Categoria: Educativo";

        // Verify toString output
        assertEquals(expected, goodToy.toString());
    }

    @Test
    void testToStringWithCustomId() {
        // Create a GoodToy with a custom ID
        GoodToy customGoodToy = new GoodToy("B100", "Juego de mesa", true, "Hasbro", "8+", "Familia");

        // Expected format of toString with custom ID
        String expected = "B100. Título: Juego de mesa, Marca: Hasbro, Edad Recomendada: 8+, Categoria: Familia";

        // Verify toString output
        assertEquals(expected, customGoodToy.toString());
    }
}
