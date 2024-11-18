package org.factoriaf5.controllers;

import org.factoriaf5.views.MainView;

public final class MainController {

    public MainController() {
        index();
    }

    public void index() {
        // responde con una vista
        MainView.index();
    }

}
