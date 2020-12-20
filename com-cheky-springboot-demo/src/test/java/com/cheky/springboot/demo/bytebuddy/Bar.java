package com.cheky.springboot.demo.bytebuddy;

//import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.BindingPriority;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

/**
 * @author Cheky
 * @date 2020-12-20
 */
public class Bar{
    @BindingPriority(3) //这里优先级 高于 下面的2，所以会被动态优先返回
    public static String sayHelloBar() {
        return "Holla in Bar!";
    }

    @BindingPriority(2)
    public static String sayBar() {
        return "bar";
    }
}
