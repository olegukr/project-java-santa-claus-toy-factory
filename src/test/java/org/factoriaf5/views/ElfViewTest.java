package org.factoriaf5.views;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.factoriaf5.controllers.ToyController;
import org.factoriaf5.models.BadToy;
import org.factoriaf5.models.GoodToy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

    
public class ElfViewTest {

    private ToyController controller;

    @BeforeEach
    void setUp() {
        // Initialize ToyController before each test
        controller = new ToyController();
    }

    @Test
    void testPostGoodToy() {

        // Simulate user input for adding a good toy
        // String simulatedInput = "1\n1\nMuñeca\nMattel\n5+\nEducativo\n4\n3\n";
        String simulatedInput = """
            1
            1
            Muñeca
            Mattel
            5+
            Educativo
            4
            3
            """;

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Redirect System.out to capture outputs
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method
        ElfView.index();

        // Verify the toy was added
        List<GoodToy> goodToys = controller.getGoodToys();

        assertEquals(2, goodToys.size());

        assertEquals("Muñeca", goodToys.get(1).getTitle());
        assertEquals("Mattel", goodToys.get(1).getBrand());
        assertEquals("5+", goodToys.get(1).getTargetAge());
        assertEquals("Educativo", goodToys.get(1).getCategory());

        // Verify the output
        String output = outputStream.toString();
        assertTrue(output.contains("Ingrese el título:"));
        assertTrue(output.contains("Ingrese la marca:"));
        assertTrue(output.contains("Ingrese la edad recomendada:"));
        assertTrue(output.contains("Ingrese la categoria:"));
    }

    @Test
    void testPostBadToy() {

        // String simulatedInput = "1\n2\nPelota\nDeportes\n4\n3\n"; 
        // Input to exit menu after the success message
        String simulatedInput = """
                1
                2
                Pelota
                Defectuosa
                4
                3
                """;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Redirect System.out to capture outputs
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method
        ElfView.index();

        List<BadToy> badToys = controller.getBadToys();

        assertEquals(2, badToys.size());
        assertEquals("Pelota", badToys.get(1).getTitle());
        assertEquals("Defectuosa", badToys.get(1).getContent());

    }

    @Test
    void testDeleteGoodToy() {

        // String simulatedInput = "4\n3\n"; // Input to exit menu after the success message

        // // Test deleting a good toy
        // GoodToyDto goodToyDto = new GoodToyDto("Pelota", "Adidas", "3+", "Deportes");
        // controller.postGoodToy(goodToyDto);


        String simulatedInput = """
            1
            1
            Muñeca
            Mattel
            5+
            Educativo
            4
            3
            """;


        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Redirect System.out to capture outputs
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method
        ElfView.index();

        List<GoodToy> goodToys = controller.getGoodToys();
        assertEquals(2, goodToys.size());

        controller.deleteGoodToy("B1");
        goodToys = controller.getGoodToys();
        assertEquals(1,goodToys.size());
    }

    @Test
    void testDeleteGoodToyFromMenu() {

        // String simulatedInput = "4\n3\n"; // Input to exit menu after the success message

        // // Test deleting a good toy
        // GoodToyDto goodToyDto = new GoodToyDto("Pelota", "Adidas", "3+", "Deportes");
        // controller.postGoodToy(goodToyDto);


        String simulatedInput = """
            1
            1
            Muñeca
            Mattel
            5+
            Educativo
            3
            B1
            4
            3
            """;


        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Redirect System.out to capture outputs
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method
        ElfView.index();

        List<GoodToy> goodToys = controller.getGoodToys();
        // assertEquals(2, goodToys.size());

        // controller.deleteGoodToy("B1");
        goodToys = controller.getGoodToys();
        assertEquals(1,goodToys.size());
    }

    @Test
    void testShowGoodToys() {

                // Simulate user input for adding a good toy
        // String simulatedInput = "1\n1\nMuñeca\nMattel\n5+\nEducativo\n4\n3\n";
        String simulatedInput = """
            1
            1
            Muñeca
            Mattel
            5+
            Educativo
            4
            3
            """;

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Redirect System.out to capture outputs
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method
        ElfView.index();


        // Call the method
        ElfView.showGoodToys();

        // Verify the output contains the good toy details
        String output = outputStream.toString();
        assertTrue(output.contains("Título: Muñeca"));
        assertTrue(output.contains("Marca: Mattel"));
        assertTrue(output.contains("Edad Recomendada: 5+"));
        assertTrue(output.contains("ategoria: Educativo"));
    }

    @Test
    void testShowBadToys() {

        // String simulatedInput = "1\n2\nPelota\nDeportes\n4\n3\n"; 
        // Input to exit menu after the success message
        String simulatedInput = """
                1
                2
                Pelota
                Defectuosa
                4
                3
                """;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Redirect System.out to capture outputs
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method
        ElfView.index();


        // Call the method
        ElfView.showBadToys();

        // Verify the output contains the bad toy details
        String output = outputStream.toString();
        assertTrue(output.contains("Título: Pelota"));
        assertTrue(output.contains("Contenido: Defectuosa"));

    }



}
