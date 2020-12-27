package com.cicadasworld;

public class MyChangeListener {

    public static void main(String[] args) {
        final Person male = new Person();
        male.setFullname("Joe Smith");
        male.setEmployed(true);
        System.out.println(male);

        male.fullnameProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(observable.getValue());
            System.out.println("oldValue = " + oldValue);
            System.out.println("newValue = " + newValue);
            System.out.println(male);
        });
        male.setFullname("Joseph Smith");
    }
}
