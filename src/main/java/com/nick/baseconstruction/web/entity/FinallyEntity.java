package com.nick.baseconstruction.web.entity;

public class FinallyEntity {

    public static void main(String[] args) {
        FinallyEntity finallyEntity =new FinallyEntity();

        int go = finallyEntity.go();
        System.out.println(go);
    }

    public int go() {
        int a = 0;
        try {
            System.out.println("try");
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return a;
        } finally {
            System.out.println("finally");
            return 1;
        }
    }

}
