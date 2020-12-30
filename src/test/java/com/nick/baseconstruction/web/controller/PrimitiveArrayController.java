package com.nick.baseconstruction.web.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrimitiveArrayController {


    @Test
    public void method(){
        int[] a = new int[2];

        System.out.println(a[0]);
        System.out.println(a.length);
    }

    @Test
    public void method1(){
        List<Integer> list = new ArrayList<Integer>(10);
        System.out.println(list.size());
        list.add(1);
        list.add(2);
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list.size());
        System.out.println(list);
    }
}
