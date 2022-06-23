package com.yadren.ecommerce.model;

public class Category {
    int id;
    String title;
    Boolean selected = false;

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
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
