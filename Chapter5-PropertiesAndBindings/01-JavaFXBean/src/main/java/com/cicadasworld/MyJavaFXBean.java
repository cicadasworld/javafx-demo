package com.cicadasworld;

public class MyJavaFXBean {

    public static void main(String[] args) {
        Person male = new Person();
        male.setFullname("Joe Smith");
        System.out.println(male);

        Person female = new Person();
        female.setFullname("Susan Brown");
        female.setEmployed(true);
        System.out.println(female);

        System.out.println(female.fullnameProperty());
        System.out.println(female.fullnameProperty().getBean());
        System.out.println(female.fullnameProperty().getName());

        System.out.println(female.employedProperty());
        System.out.println(female.employedProperty().getBean());
        System.out.println(female.employedProperty().getName());
    }
}
