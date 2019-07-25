package com.demo.theory;
/**
 * java8不支持参数-XX:PermSize=10M -XX:MaxPermSize=10M 改用了元空间代替
 * 此代码忽略上述参数
 * 改为参数：-XX:MetaspaceSize=20M -XX:MaxMetaspaceSize=20M 会看到元空间一直增长。
 * -Xmx50m
 */

import java.util.ArrayList;
import java.util.List;

public class NonHeapConstantDemo {
    static String  base = "string";

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }

//        List<String> list = new ArrayList<String>();
//        for (int i=0;i< Integer.MAX_VALUE;i++){
//            String str = base + base;
//            base = str;
//            list.add(str.intern());
//        }
    }
}
