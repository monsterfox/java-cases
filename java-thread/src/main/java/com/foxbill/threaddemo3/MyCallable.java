package com.foxbill.threaddemo3;

import java.util.concurrent.Callable;

/**
 * 实现多线程的方式三：实现接口Callable<T>
 *     可以返回值
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("跟女孩表白" + i);
        }
        //返回值就表示线程运行完毕之后的结果
        return "答应";
    }
}
