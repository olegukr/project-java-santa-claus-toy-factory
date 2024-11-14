package org.factoriaf5.views;

import java.util.Scanner;

public class HomeView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void index() {
        // start menu

        String menuMain = """
            Iniciar sesión de trabajo como:
            1. Elfo
            2. Santa Claus
            3. Salir
            Seleccione una opción: """;
        System.out.print(menuMain + " ");
        // System.out.print("Seleccione una opción: ");
        int option = scanner.nextInt();

        if (option == 1) ElfView.index();
        if (option == 3) quit();
    }

    public static void quit() {
        scanner.close();
    }
    
}
