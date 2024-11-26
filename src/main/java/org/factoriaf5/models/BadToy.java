package org.factoriaf5.models;

import org.factoriaf5.dto.BadToyDto;
import org.factoriaf5.dto.GoodToyDto;

public class BadToy extends Toy {

    private static int badToyCounter = 1;
    private String content;
    protected boolean isGoodToy;

    public BadToy(String title, boolean isGoodToy, String content) {
        super(title, isGoodToy);
        this.content = content;
        this.id = generateId();
    }

    public BadToy(String id, String title, boolean isGoodToy, String content) {
        super(id, title, isGoodToy);
        this.content = content;
    }

    public BadToy(BadToyDto badToyDto) {
    this(badToyDto.title(), false, badToyDto.content());
    }

    private String generateId() {
        return "M" + (badToyCounter++);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return  id + "." +
                " Título: " + title +
                ", Contenido: " + content;
    }

}
