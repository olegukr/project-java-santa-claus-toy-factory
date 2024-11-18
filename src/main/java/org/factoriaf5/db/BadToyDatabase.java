package org.factoriaf5.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.factoriaf5.models.BadToy;

public class BadToyDatabase implements IDatabase<BadToy>{
    private List<BadToy> badToys;

    public BadToyDatabase() {
        initDB();
    }

    @Override
    public List<BadToy> getToys() {
        return badToys;
    }

    @Override
    public void save(BadToy toy) {
        badToys.add(toy);
        System.out.println("bad toy added");
    }

    private void initDB() {
        this.badToys = new ArrayList<>(Arrays.asList(
                new BadToy("M1", "Mystery Box 5x5", false, "carbón")));
    }

}
