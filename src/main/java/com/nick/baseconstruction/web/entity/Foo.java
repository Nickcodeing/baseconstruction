package com.nick.baseconstruction.web.entity;

public class Foo {

     Integer i;

     int j;

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.go();
    }

    public void go(){
        i=j;
        System.out.println(i);
        System.out.println(j);
    }
}
