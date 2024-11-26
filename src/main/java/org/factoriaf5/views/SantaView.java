package org.factoriaf5.views;

import java.io.File;
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

    public static void showGoodToys() {
        List<GoodToy> goodToys = controller.getGoodToys();
        for (GoodToy goodToy : goodToys) {
            System.out.println(goodToy.toString());
        }
    }

    public static void showBadToys() {
        List<BadToy> badToys = controller.getBadToys();
        for (BadToy badToy : badToys) {
            System.out.println(badToy.toString());
        }
    }


    private static void saveToysListToCSV() {
        while (true) {
            System.out.println("Please, enter file name for creating .csv file");
            String filename = scanner.next();

            // Check if file exists
            File file = new File(filename);
            if (file.exists()) {
                System.out.println("File already exists. Do you want to overwrite it? (yes/no/exit to Santa menu)");
                String choice = scanner.next();

                if (choice.equalsIgnoreCase("yes")) {
                    // Overwrite the file
                    try {
                        controller.exportToCsvFile(filename);
                        System.out.println("File saved successfully: " + filename);
                    } catch (Exception e) {
                        System.err.println("Error saving file: " + e.getMessage());
                    }
                    return; // Exit after saving to Santa menu
                    
                } else if (choice.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    System.out.println("Please provide a different file name.");
                }
            } else {

                // File does not exist, create and save it
                try {
                    controller.exportToCsvFile(filename);
                    System.out.println("File saved successfully: " + filename);
                } catch (Exception e) {
                    System.err.println("Error saving file: " + e.getMessage());
                }
                break; // Exit after saving
            }
        }

        System.out.println("Returning to Santa menu...");
        index();
    }

    public static void ClouseSession() {
        System.out.println("\nSesión cerrada correctamente.");
        MainView.index();
    }
        
}