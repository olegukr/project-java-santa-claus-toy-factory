package org.factoriaf5.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.factoriaf5.models.GoodToy;

public class GoodToyDatabase implements IDatabase<GoodToy>{
    private List<GoodToy> goodToys;

    public GoodToyDatabase() {
        initDB();
    }

    @Override
    public List<GoodToy> getToys() {
        return goodToys;
    }
    
    @Override
    public void save(GoodToy toy) {
        goodToys.add(toy);
        System.out.println("good Toy added");
    }

    @Override
    public void delete(GoodToy toy) {
        goodToys.remove(toy);
        System.out.println("good Toy removed");
    }
    private void initDB() {
        this.goodToys = new ArrayList<>(Arrays.asList(
                new GoodToy("B1", "Batman", true, "lego", "12", "construction")));
    }
}
