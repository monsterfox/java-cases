package com.foxbill.interview.collection;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        /*
        ArrayList的默认初识容量是0，
        但当第一个元素被添加时，会扩充到DEFAULT_CAPACITY（默认容量=10）
         */
        ArrayList list = new ArrayList();
        showListCapacity(list);

        list.add(0);
        showListCapacity(list);

        /*
            了解如何扩容
            扩容的大小，是 capacity>>1，一般是之前容量的一半。
         */
        int capacity = 11;
        for (int i = 1; i < capacity; i++) {
            list.add(i);
            showListCapacity(list);
        }

        /*
            删除元素
         */
        list.remove(1);

        Object o;
        String s;
    }

    /**
     * 打印ArrayList的剩余容量
     *         使用反射来完成此任务，首先获得容量，然后减去实际大小
     * @param list
     */
    public static void showListCapacity(List list) {
        try {
            Field field = list.getClass().getDeclaredField("elementData");
            field.setAccessible(true);
            int cap = Array.getLength(field.get(list));
            System.out.println("The capacity: " + cap);
            System.out.println("The size: " + list.size());
            System.out.println("The remaining capacity: " + (cap - list.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
