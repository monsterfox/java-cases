package com.foxbill.interview.collection;

public class Test {
    public static void main(String[] args) {
        String s = new String("abc");
        boolean equals = s.equals(new String());
        System.out.println(equals);

        Integer i = new Integer(20);
        int i1 = i.parstInt("25");
        System.out.println(i1);
    }
}
