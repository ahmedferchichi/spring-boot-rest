package com.devglan.model.thematic;

public class ThamaticDto {

    private int id;
    private String title;

    public ThamaticDto() {
    }

    public ThamaticDto(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
