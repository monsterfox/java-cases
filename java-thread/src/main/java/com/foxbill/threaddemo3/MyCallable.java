package com.foxbill.threaddemo3;

import java.util.concurrent.Callable;

/**
 * 实现多线程的方式三：通过 Callable 和 FutureTask 创建线程。
 *   1. 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。

     2. 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。

     3. 使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。

     4. 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。
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
