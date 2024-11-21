package org.factoriaf5.views;

import java.util.List;

import org.factoriaf5.controllers.ToyController;
import org.factoriaf5.dto.BadToyDto;
import org.factoriaf5.dto.GoodToyDto;
import org.factoriaf5.models.BadToy;
import org.factoriaf5.models.GoodToy;


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
        if (option == 2) showAllToys();
        if (option == 3) deleteToy();
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
        System.out.print(menuChild + " ");

        int option = scanner.nextInt();

        if (option == 1) postGoodToy();
        if (option == 2) postBadToy();
    }
        
    private static void postBadToy() {
        System.out.println("-----------------------------------------");
        System.out.println("Ingrese el título:");
        String title = scanner.next();
        System.out.println("Ingrese la contenido: ");
        String content = scanner.next();

        controller.postBadToy(new BadToyDto(title, content));
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

    private static void showAllToys() {
        showGoodToys();
        showBadToys();
    }

    private static void deleteToy() {
        System.out.println("Ingrese el identificador del juguete a eliminar: ");
        String index = scanner.next();
        if (index.startsWith("B")) {
            controller.deleteGoodToy(index);
            System.out.println("Juguete eliminado con éxito");

        } else if (index.startsWith("M")) {
            controller.deleteBadToys(index);
            System.out.println("Juguete eliminado con éxito");
        } else {
            System.out.println("No existe tal identificador de juguete");
        }
        index();
    }


    public static void ClouseSession() {
        System.out.println("\nSesión cerrada correctamente.");
        MainView.index();
    }

    public static void addToyResponse() {
        System.out.println("Juguete añadido con éxito");
        index();
    }
}
