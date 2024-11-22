package org.factoriaf5.controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.factoriaf5.models.BadToy;
import org.factoriaf5.models.GoodToy;

import com.opencsv.CSVWriter;

public class ExportToFileCSV {
    
    public static void exportToCsv(List<GoodToy> goodToys, List<BadToy> badToys, String fileName) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            // Write header
            String[] header = {"ID", "Title", "IsGoodToy", "Brand", "TargetAge", "Category", "Content"};
            writer.writeNext(header);

            // Write GoodToys
            for (GoodToy toy : goodToys) {
                String[] row = {
                        toy.getId(),
                        toy.getTitle(),
                        String.valueOf(toy.getIsGoodToy()),
                        toy.getBrand(),
                        toy.getTargetAge(),
                        toy.getCategory(),
                        "" // Empty column for Content
                };
                writer.writeNext(row);
            }

            // Write BadToys
            for (BadToy toy : badToys) {
                String[] row = {
                        toy.getId(),
                        toy.getTitle(),
                        String.valueOf(toy.getIsGoodToy()),
                        "", // Empty column for Brand
                        "", // Empty column for TargetAge
                        "", // Empty column for Category
                        toy.getContent()
                };
                writer.writeNext(row);
            }

        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }
    }
}
