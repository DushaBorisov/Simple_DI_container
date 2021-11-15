package com.simple.di.container.context;

import com.simple.di.container.factory.BeanFactory;
import com.simple.di.container.postprocessor.BeanPostProcessor;
import lombok.Setter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    @Setter
    private BeanFactory beanFactory;
    private final Map<Class, Object> beanMap = new ConcurrentHashMap<>();

    public ApplicationContext() {

    }

    public <T> T getBean(Class<T> clazz) {
        if (beanMap.containsKey(clazz)) {
            return (T) beanMap.get(clazz);
        }

        T bean = beanFactory.getBean(clazz);

        beanMap.put(clazz, bean);
        return bean;
    }

    private void callPostProcessors(Object bean) {

    }
}
