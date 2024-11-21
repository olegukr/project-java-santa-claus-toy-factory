/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.factoriaf5.repository;

import java.util.List;

import org.factoriaf5.db.IDatabase;
import org.factoriaf5.models.BadToy;
import org.factoriaf5.models.GoodToy;
import org.factoriaf5.singletons.BadToyDatabaseSingleton;
import org.factoriaf5.singletons.GoodToyDatabaseSingleton;

@SuppressWarnings("rawtypes")
public class ToyRepository {

    private IDatabase db;

    public void setDB(String type) {
        // setter injection
        if ("good_toy".equals(type))
            this.db = GoodToyDatabaseSingleton.getInstance();

        if ("bad_toy".equals(type))
            this.db = BadToyDatabaseSingleton.getInstance();
    }

    @SuppressWarnings("unchecked")
    public void saveGoodToy(GoodToy toy) {
        db.save(toy);
    }

    @SuppressWarnings("unchecked")
    public void saveBadToy(BadToy toy) {
        db.save(toy);
    }

    @SuppressWarnings("unchecked")
    public List<GoodToy> getGoodToys() {
        return db.getToys();
    }

    @SuppressWarnings("unchecked")
    public List<BadToy> getBadToys() {
        return db.getToys();
    }

    public GoodToy getGoodToyById(String indexString) {
        for (GoodToy  toy : getGoodToys()) {
            if (toy.getId().equals(indexString)) {
                return toy;
            }
        }
        return null;
    }

    public BadToy getBadToyById(String indexString) {
        for (BadToy  toy : getBadToys()) {
            if (toy.getId().equals(indexString)) {
                return toy;
            }
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public void removeGoodToy(GoodToy toy) {
        db.delete(toy);
    }

    @SuppressWarnings("unchecked")
    public void removeBadToy(BadToy toy) {
        db.delete(toy);
    }
}



