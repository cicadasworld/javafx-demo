package com.cicadasworld;

import javafx.beans.InvalidationListener;

public class MyInvalidationListener {

    public static void main(String[] args) {
        final Person male = new Person();
        male.setFullname("Joe Smith");
        male.setEmployed(true);
        System.out.println(male);
        InvalidationListener listener = observable -> System.out.println(male);
        male.fullnameProperty().addListener(listener);
        male.setFullname("Joseph Smith");
        male.fullnameProperty().removeListener(listener);
        male.setFullname("Joseph Smithers");
    }
}
