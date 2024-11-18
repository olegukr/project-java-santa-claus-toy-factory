package org.factoriaf5.controllers;

import org.factoriaf5.dto.BadToyDto;
import org.factoriaf5.dto.GoodToyDto;
import org.factoriaf5.repository.ToyRepository;
import org.factoriaf5.views.ElfView;

public class ToyController {

    private final ToyRepository repository;

    public ToyController() {
        this.repository = new ToyRepository();
    }

    public void postGoodToy(GoodToyDto goodToyDto) {
        ElfView.addToyResponse();
    }

    public void postBadToy(BadToyDto badToyDto) {
        ElfView.addToyResponse();
    }

}


