package com.foxbill.interview.collection;

import java.util.LinkedList;
import java.util.TreeMap;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        /*
        插入快，也是相对的，如果插入到指定位置（即add(int index,Object element)），要把元素插入到这个指定的位置，需要先找到index位置的元素，才能修改其前后元素的相关指针。只有插入到哨兵位（队头，队尾），速度是最快的。
         */
        linkedList.add(9,10);

    }
}
