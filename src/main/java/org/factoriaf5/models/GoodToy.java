package org.factoriaf5.models;

public class GoodToy extends Toy {
    private static int goodToyCounter = 1;
    private String brand;
    private String targetAge;
    private String category;
   
    

    public GoodToy(String title, boolean isGoodToy, String brand, String targetAge, String category) {
        super(title, isGoodToy);
        this.brand = brand;
        this.targetAge = targetAge;
        this.category = category;
        this.id = generateId();
    }

    public GoodToy(String id, String title, boolean isGoodToy, String brand, String targetAge, String category) {
        super(id, title, isGoodToy);
        this.brand = brand;
        this.targetAge = targetAge;
        this.category = category;
    }
    private String generateId() {
        return "B" + (goodToyCounter++);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTargetAge() {
        return targetAge;
    }

    public void setTargetAge(String targetAge) {
        this.targetAge = targetAge;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return  id + "." +
                " Título: " + title +
                ", Marca: " + brand +
                ", Edad Recomendada: " + targetAge +
                ", Categoria: " + category;
    }
}

