package com.nick.baseconstruction.web.entity;


public class Entity {
    public byte getA() {
        return a;
    }

    public void setA(byte a) {
        this.a = a;
    }

    public short getB() {
        return b;
    }

    public void setB(short b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public long getD() {
        return d;
    }

    public void setD(long d) {
        this.d = d;
    }

    public float getE() {
        return e;
    }

    public void setE(float e) {
        this.e = e;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public boolean isG() {
        return g;
    }

    public void setG(boolean g) {
        this.g = g;
    }

    public char getH() {
        return h;
    }

    public void setH(char h) {
        this.h = h;
    }

    private byte a;

     private short b;

     private int c;

     private long d;

     private float e;

     private double f;

     private boolean g;

     private char h;

    public static void main(String[] args) {
        Entity entity = new Entity();
        System.out.println(entity.getA());
        System.out.println(entity.getB());
        System.out.println(entity.getC());
        System.out.println(entity.getD());
        System.out.println(entity.getE());
        System.out.println(entity.getF());
        System.out.println(entity.h);
        System.out.println(entity.isG());

    }


}
