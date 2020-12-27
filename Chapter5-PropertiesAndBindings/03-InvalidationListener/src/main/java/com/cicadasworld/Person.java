package com.cicadasworld;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// javafx bean
public class Person {

    private final StringProperty fullname =
            new SimpleStringProperty(this, "fullname", "");
    private final BooleanProperty employed =
            new SimpleBooleanProperty(this, "employed", false);

    public StringProperty fullnameProperty() {
        return fullname;
    }

    public BooleanProperty employedProperty() {
        return employed;
    }

    public String getFullname() {
        return fullname.get();
    }

    public void setFullname(String fullname) {
        this.fullname.set(fullname);
    }

    public boolean isEmployed() {
        return employed.get();
    }

    public void setEmployed(boolean employed) {
        this.employed.set(employed);
    }

    @Override
    public String toString() {
        return getFullname() + " is " + (isEmployed() ? "" : "not") + "employed";
    }
}
