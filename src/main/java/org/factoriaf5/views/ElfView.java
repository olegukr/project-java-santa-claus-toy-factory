package org.factoriaf5.views;

import org.factoriaf5.controllers.ToyController;
import org.factoriaf5.dto.GoodToyDto;
import static org.factoriaf5.views.View.scanner;

public class ElfView extends View {

    private static final ToyController controller = new ToyController();
    
    public static void index() {
        
        // Elf menu
        String menuElf = """
            -----------------------------------------
            Gestor de juguetes (Tipo de sesión: Elfo)
            1. Añadir juguete
            2. Ver todos los juguetes
            3. Eliminar juguete
            4. Cerrar sesión
            Seleccione una opción: """;
        System.out.print(menuElf + " ");

        int option = scanner.nextInt();

        if (option == 1) selectChild();
        if (option == 4) ClouseSession();
    }  

    public static void selectChild() {
        // menuChild
        String menuChild =  """
            -----------------------------------------
            Para niño ...:
            1. Bueno
            2. Malo
            Seleccione una opción: """;
        System.out.println(menuChild + " ");

        int option = scanner.nextInt();

        if (option == 1) postGoodToy();
    }

    public static void postGoodToy() {
        System.out.println("-----------------------------------------");
        System.out.println("Ingrese el título:");
        String title = scanner.next();
        System.out.println("Ingrese la marca:");
        String brand = scanner.next();
        System.out.println("Ingrese la edad recomendada:");
        int age = scanner.nextInt();
        System.out.println("Ingrese la categoria:");
        String category = scanner.next();

        // Dto - Data Transfert Object
        controller.postGoodToy(new GoodToyDto(title, brand, age, category));
    }

    public static void ClouseSession() {
        HomeView.index();
     }

    public static void addToyResponse() {
        System.out.println("Juguete añadido con éxito");
        index();
    }
}
