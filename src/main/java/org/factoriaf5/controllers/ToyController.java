package org.factoriaf5.controllers;

import java.util.List;

import org.factoriaf5.dto.BadToyDto;
import org.factoriaf5.dto.GoodToyDto;
import org.factoriaf5.models.BadToy;
import org.factoriaf5.models.GoodToy;
import org.factoriaf5.repository.ToyRepository;
import org.factoriaf5.singletons.ToyRepositorySingleton;
import org.factoriaf5.views.ElfView;

public class ToyController {

    private final ToyRepository repository;

    public ToyController() {
        this.repository = ToyRepositorySingleton.getInstance();
    }

    public void postGoodToy(GoodToyDto goodToyDto) {
        // hará algo con el repositorio
        // si todo ha ido bien devolverá la respuesta
        GoodToy toy = new GoodToy(goodToyDto.title(), true, goodToyDto.brand(), goodToyDto.recommendedAge(), goodToyDto.category());
        repository.setDB("good_toy");
        repository.saveGoodToy(toy);
        ElfView.addToyResponse();
    }

    public void postBadToy(BadToyDto badToyDto) {
        BadToy toy = new BadToy(badToyDto.title(), false, badToyDto.content());
        repository.setDB("bad_toy");
        repository.saveBadToy(toy);
        ElfView.addToyResponse();
    }

    public List<GoodToy> getGoodToys() {
        repository.setDB("good_toy");
        List<GoodToy> goodToys = repository.getGoodToys();
        return goodToys;
    }

    public List<BadToy> getBadToys() {
        repository.setDB("bad_toy");
        List<BadToy> badToys = repository.getBadToys();
        return badToys;
    }

    public void deleteGoodToy(String indexString) {
        repository.setDB("good_toy");
        GoodToy toy =  repository.getGoodToyById(indexString);
        repository.removeGoodToy(toy);
    }

    public void deleteBadToys(String indexString) {
        
        repository.setDB("bad_toy");
        BadToy toy = repository.getBadToyById(indexString);
        repository.removeBadToy(toy);
    }

    public BadToy getBadToyById(List<BadToy> badToys, String id) {
        for (BadToy toy : badToys) {
            if (toy.getId().equals(id)) {
                return toy;
            }
        }
        return null;
    }

    public void exportToCsvFile(String filename) {
        ExportToFileCSV.exportToCsv( getGoodToys(), getBadToys(), filename);
    }


}


