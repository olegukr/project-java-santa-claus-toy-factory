package org.factoriaf5.views;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class SantaViewTest {

    @Test
    void testShowGoodToys() {

                // Simulate user input for adding a good toy
        // String simulatedInput = "1\n1\nMuñeca\nMattel\n5+\nEducativo\n4\n3\n";
        String simulatedInput = """
            1
            1
            4
            3
            """;

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Redirect System.out to capture outputs
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method
        SantaView.index();


        // Call the method
        SantaView.showGoodToys();

        // Verify the output contains the good toy details
        String output = outputStream.toString();
        assertTrue(output.contains("Título: Batman"));
        assertTrue(output.contains("Marca: lego"));
        assertTrue(output.contains("Edad Recomendada: 12"));
        assertTrue(output.contains("Categoria: construction"));
    }

    @Test
    void testShowBadToys() {

        // String simulatedInput = "1\n2\nPelota\nDeportes\n4\n3\n"; 
        // Input to exit menu after the success message
        String simulatedInput = """
                1
                2
                4
                3
                """;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Redirect System.out to capture outputs
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method
        SantaView.index();


        // Call the method
        SantaView.showBadToys();

        // Verify the output contains the bad toy details
        String output = outputStream.toString();
        assertTrue(output.contains("Título: Mystery Box 5x5"));
        assertTrue(output.contains("Contenido: carbón"));

    }
}
