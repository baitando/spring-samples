package de.baitando.spring.samples.explicitconfig.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMethodInterceptor implements MethodInterceptor {

    private Object instance;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getReturnType() == CglibDemoService.class) {
            if (instance == null) {
                instance = methodProxy.invokeSuper(o, objects);
            }
            return instance;
        } else {
            return methodProxy.invokeSuper(o, objects);
        }
    }
}
