package com.foxbill.pattern.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 *  （话说你不用的，你装载它干啥）
 * 【稍有瑕疵，但是简单】
 *
 *
 * 马士兵：
 *  https://www.bilibili.com/video/BV1o3411F7DC?p=2&vd_source=8239f4e676717b61d3ce4f04d0ddb94a
 * 狂神：
 *  https://www.bilibili.com/video/BV1K54y197iS/?spm_id_from=333.788.recommend_more_video.1&vd_source=8239f4e676717b61d3ce4f04d0ddb94a
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01(){}

    public static Mgr01 getInstance(){
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }
}
