package org.factoriaf5.views;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.factoriaf5.controllers.ToyController;
import org.factoriaf5.dto.BadToyDto;
import org.factoriaf5.dto.GoodToyDto;
import org.factoriaf5.models.BadToy;
import org.factoriaf5.models.GoodToy;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        // Simulate user input to navigate the menu in addToyResponse
        String simulatedInput = "4\n3\n"; // Input to exit menu after the success message
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Test adding a good toy
        GoodToyDto goodToyDto = new GoodToyDto("Muñeca", "Mattel", "5+", "Niñas");
        controller.postGoodToy(goodToyDto);

        // Simulate addToyResponse menu behavior
        // ElfView.addToyResponse(); // This will print "Juguete añadido con éxito" and call index()

        List<GoodToy> goodToys = controller.getGoodToys();

        assertEquals(2, goodToys.size());
        assertEquals("Muñeca", goodToys.get(1).getTitle());
        assertEquals("Mattel", goodToys.get(1).getBrand());
        assertEquals("5+", goodToys.get(1).getTargetAge());
        assertEquals("Niñas", goodToys.get(1).getCategory());


    }

    @Test
    void testPostBadToy() {

        String simulatedInput = "4\n3\n"; // Input to exit menu after the success message
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Test adding a bad toy
        BadToyDto badToyDto = new BadToyDto("Robot roto", "Mal estado");
        controller.postBadToy(badToyDto);

        List<BadToy> badToys = controller.getBadToys();

        assertEquals(2, badToys.size());
        assertEquals("Robot roto", badToys.get(1).getTitle());
    }

    @Test
    void testDeleteGoodToy() {

        String simulatedInput = "4\n3\n"; // Input to exit menu after the success message
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Test deleting a good toy
        GoodToyDto goodToyDto = new GoodToyDto("Pelota", "Adidas", "3+", "Deportes");
        controller.postGoodToy(goodToyDto);

        List<GoodToy> goodToys = controller.getGoodToys();
        assertEquals(2, goodToys.size());

        controller.deleteGoodToy("B1");
        goodToys = controller.getGoodToys();
        assertEquals(1,goodToys.size());
    }

}
