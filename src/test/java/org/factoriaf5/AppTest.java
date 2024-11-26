package org.factoriaf5;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void testMainMethodOutputsExpectedText() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String simulatedInput = "4\n3\n"; // Input to exit menu after the success message
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            // Run the main method
            App.main(new String[]{});

            // Verify output contains expected text
            String outputExp = """
                    Iniciar sesión de trabajo como:
                    1. Elfo
                    2. Santa Claus
                    3. Salir
                    Seleccione una opción: """;
                

            String output = outputStream.toString();

            assertTrue(output.contains(outputExp));
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }
}

