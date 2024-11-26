package org.factoriaf5.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BadToyTest {

    
    private BadToy badToy;

    @BeforeEach
    void setUp() {
        // Initialize a BadToy object before each test
        badToy = new BadToy("Muñeca rota", false, "Mal estado");
    }

    @Test
    void testSetContent() {
        // Verify initial content
        assertEquals("Mal estado", badToy.getContent());

        // Set new content
        badToy.setContent("Desgastado");

        // Verify updated content
        assertEquals("Desgastado", badToy.getContent());
    }

    @Test
    void testToString() {
        // Expected format of toString
        String expected = "M1. Título: Muñeca rota, Contenido: Mal estado";

        // Verify toString output
        assertEquals(expected, badToy.toString());
    }

    @Test
    void testToStringWithCustomId() {
        // Create a BadToy with a custom ID
        BadToy customBadToy = new BadToy("M100", "Juguete roto", false, "Muy dañado");

        // Expected format of toString with custom ID
        String expected = "M100. Título: Juguete roto, Contenido: Muy dañado";

        // Verify toString output
        assertEquals(expected, customBadToy.toString());
    }
}
