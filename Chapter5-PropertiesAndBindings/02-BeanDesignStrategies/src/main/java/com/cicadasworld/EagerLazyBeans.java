package com.cicadasworld;

public class EagerLazyBeans {

    public static void main(String[] args) {
        EagerPerson eager = new EagerPerson();
        eager.setFullname("Joe Smith");
        System.out.println(eager.fullnameProperty());

        LazyPerson lazy = new LazyPerson();
        lazy.setFullname("Jack Black");
        System.out.println(lazy.fullnameProperty());
    }
}
