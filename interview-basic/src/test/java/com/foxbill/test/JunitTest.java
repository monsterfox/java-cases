package com.foxbill.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitTest {
    //在@Test之前运行
    @Before
    public void before(){
        System.out.println("before");
    }

    @Test
    public void test(){
        System.out.println("test");
    }

    //在@Test之后运行
    @After
    public void after(){
        System.out.println("after");
    }
}
