package com.cheky.springboot.demo.bytebuddy;

import lombok.SneakyThrows;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
//import org.assertj.core.internal.bytebuddy.ByteBuddy;
//import org.assertj.core.internal.bytebuddy.dynamic.DynamicType;
//import org.assertj.core.internal.bytebuddy.dynamic.loading.ClassLoadingStrategy;
//import org.assertj.core.internal.bytebuddy.dynamic.loading.ClassReloadingStrategy;
//import org.assertj.core.internal.bytebuddy.implementation.FixedValue;
//import org.assertj.core.internal.bytebuddy.implementation.MethodDelegation;
//import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static net.bytebuddy.matcher.ElementMatchers.*;

//import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.*;

/**
 * @author Cheky
 * @date 2020-12-20
 *
 * 测试动态生成与动态反射
 */
public class ByteBuddyTest {

    @SneakyThrows
    @Test
    public void testAutoGenerateClass() {
        DynamicType.Unloaded unloadedType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.isToString())
                .intercept(FixedValue.value("Hello World ByteBuddy!"))
                .make();
        Class<?> dynamicType = unloadedType.load(getClass()
                .getClassLoader())
                .getLoaded();

        assert dynamicType.getDeclaredConstructor().newInstance().toString() == "Hello World ByteBuddy!";
    }

    /**
     * 把调用的方法sayHelloFoo 代理指向 Bar的相同返回类型的方法sayHelloBar
     */
    @SneakyThrows
    @Test
    public void testResultOfMethodFromAnotherMethod() {
        String r = new ByteBuddy()
                .subclass(Foo.class)
                .method(named("sayHelloFoo")
                        .and(isDeclaredBy(Foo.class)
                                .and(returns(String.class))))
                .intercept(MethodDelegation.to(Bar.class))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .getDeclaredConstructor()
                .newInstance()
                .sayHelloFoo();

        assert r == Bar.sayHelloBar();
    }

    @SneakyThrows
    @Test
    public void testAutoGenerateMethodAndField(){
        Class<?> type = new ByteBuddy()
                .subclass(Object.class)
                .name("MyClassName")
                .defineMethod("custom", String.class, Modifier.PUBLIC)
                .intercept(MethodDelegation.to(Bar.class))
                .defineField("x", String.class, Modifier.PUBLIC)
                .make()
                .load(
                        getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

        Method m = type.getDeclaredMethod("custom", null);
        assert m.invoke(type.getDeclaredConstructor().newInstance()) == Bar.sayHelloBar();
        assert type.getDeclaredField("x") != null;
    }

    @Test
    public void testRedefineResultOfMethod(){
        ByteBuddyAgent.install();
        new ByteBuddy()
                .redefine(Foo.class)
                .method(named("sayHelloFoo"))
                .intercept(FixedValue.value("Hello Foo Redefined"))
                .make()
                .load(
                        Foo.class.getClassLoader(),
                        ClassReloadingStrategy.fromInstalledAgent());

        Foo f = new Foo();

        assert f.sayHelloFoo() == "Hello Foo Redefined";
    }
}
