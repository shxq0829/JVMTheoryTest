package com.demo.theory;
/**
 * Java堆溢出
 * run参数：-Xms20m -Xmx20m
 */

import java.util.ArrayList;
import java.util.List;

public class HeapOOMDemo {
    private static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
