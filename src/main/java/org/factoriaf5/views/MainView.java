package org.factoriaf5.views;

public class MainView extends View{

    public static void index() {

    String menuMain = """
        Iniciar sesión de trabajo como:
        1. Elfo
        2. Santa Claus
        3. Salir
        Seleccione una opción: """;
    System.out.print(menuMain + " ");

    int option = scanner.nextInt();

    if (option == 1) ElfView.index();
    if (option == 2) SantaView.index();
    if (option == 3) quit();
    }

    public static void quit() {
        scanner.close();
    }
}