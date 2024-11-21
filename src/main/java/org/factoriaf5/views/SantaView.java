package org.factoriaf5.views;

import java.util.List;

import org.factoriaf5.controllers.ToyController;
import org.factoriaf5.models.BadToy;
import org.factoriaf5.models.GoodToy;

public class SantaView extends View{

    
        private static final ToyController controller = new ToyController();
        
        static void index() {

            // Santa menu

            String menuSanta = """
                -----------------------------------------
                Gestor de juguetes (Tipo de sesión: Santa)
                1. Ver lista de juguetes niños buenos
                2. Ver lista de juguetes niños malos
                3. Guargar lista de todos los juguetes (.csv)
                4. Cerrar sesión
                Seleccione una opción: """;
    
            System.out.print(menuSanta + " ");
    
            int option = scanner.nextInt();
    
            if (option == 1) showGoodToys();
            if (option == 2) showBadToys();
            if (option == 3) saveToysListToCSV();
            if (option == 4) ClouseSession();
        }

    private static void showGoodToys() {
        List<GoodToy> goodToys = controller.getGoodToys();
        for (GoodToy goodToy : goodToys) {
            System.out.println(goodToy.toString());
        }
    }

    private static void showBadToys() {
        List<BadToy> badToys = controller.getBadToys();
        for (BadToy badToy : badToys) {
            System.out.println(badToy.toString());
        }
    }


    private static void saveToysListToCSV() {
        System.out.println("saveToysListToCSV(). Not supported yet.");
    }

    public static void ClouseSession() {
        System.out.println("\nSesión cerrada correctamente.");
        MainView.index();
    }
        
}