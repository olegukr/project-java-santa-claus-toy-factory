package org.factoriaf5.views;

import org.factoriaf5.controllers.ToyController;

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
        System.out.println("showGoodToys(). Not supported yet.");
    }

    private static void showBadToys() {
        System.out.println("showBadToys(). Not supported yet.");
    }

    private static void saveToysListToCSV() {
        System.out.println("saveToysListToCSV(). Not supported yet.");
    }

    public static void ClouseSession() {
        System.out.println("\nSesión cerrada correctamente.");
        MainView.index();
    }
        
}