package org.factoriaf5.views;

import java.util.List;

import org.factoriaf5.controllers.ToyController;
import org.factoriaf5.dto.BadToyDto;
import org.factoriaf5.dto.GoodToyDto;
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
        // Test adding a good toy
        GoodToyDto goodToyDto = new GoodToyDto("Muñeca", "Mattel", "5+", "Niñas");
        controller.postGoodToy(goodToyDto);

        List<GoodToy> goodToys = controller.getGoodToys();

        assertEquals(1, goodToys.size());
        assertEquals("Muñeca", goodToys.get(0).getTitle());
    }

    @Test
    void testPostBadToy() {
        // Test adding a bad toy
        BadToyDto badToyDto = new BadToyDto("Robot roto", "Mal estado");
        controller.postBadToy(badToyDto);

        List<BadToy> badToys = controller.getBadToys();

        assertEquals(1, badToys.size());
        assertEquals("Robot roto", badToys.get(0).getTitle());
    }

    @Test
    void testDeleteGoodToy() {
        // Test deleting a good toy
        GoodToyDto goodToyDto = new GoodToyDto("Pelota", "Adidas", "3+", "Deportes");
        controller.postGoodToy(goodToyDto);

        List<GoodToy> goodToys = controller.getGoodToys();
        assertEquals(1, goodToys.size());

        controller.deleteGoodToy("B1");
        goodToys = controller.getGoodToys();
        assertTrue(goodToys.isEmpty());
    }

    @Test
    void testDeleteBadToy() {
        // Test deleting a bad toy
        BadToyDto badToyDto = new BadToyDto("Oso viejo", "Desgastado");
        controller.postBadToy(badToyDto);

        List<BadToy> badToys = controller.getBadToys();
        assertEquals(1, badToys.size());

        controller.deleteBadToys("M1");
        badToys = controller.getBadToys();
        assertTrue(badToys.isEmpty());
    }

    @Test
    void testShowAllToys() {
        // Test displaying all toys
        controller.postGoodToy(new GoodToyDto("Carro", "HotWheels", "6+", "Niños"));
        controller.postBadToy(new BadToyDto("Pistola rota", "Defectuosa"));

        List<GoodToy> goodToys = controller.getGoodToys();
        List<BadToy> badToys = controller.getBadToys();

        assertEquals(1, goodToys.size());
        assertEquals(1, badToys.size());
    }
}
