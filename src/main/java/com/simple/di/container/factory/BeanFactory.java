package com.simple.di.container.factory;

import com.simple.di.container.annotation.Inject;
import com.simple.di.container.configuration.Configuration;
import com.simple.di.container.configuration.JavaConfiguration;
import com.simple.di.container.configurator.BeanConfigurator;
import com.simple.di.container.configurator.JavaBeanConfigurator;
import com.simple.di.container.context.ApplicationContext;
import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeanFactory {

    private final Configuration configuration;

    @Getter
    private final BeanConfigurator beanConfigurator;
    private ApplicationContext applicationContext;

    public BeanFactory(ApplicationContext applicationContext) {
        configuration = new JavaConfiguration();
        beanConfigurator = new JavaBeanConfigurator(configuration.getPackageToScan(), configuration.getInterfaceToImplementations());
        this.applicationContext = applicationContext;
    }

    @SneakyThrows
    public <T> T getBean(Class<T> clazz) {
        Class<? extends T> implementationClass = clazz;
        if (implementationClass.isInterface()) {
            implementationClass = beanConfigurator.getImplementationClass(clazz);
        }

        T bean = implementationClass.getDeclaredConstructor().newInstance();

        List<Field> fields = Arrays.stream(implementationClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Inject.class))
                .collect(Collectors.toList());

        for (Field field : fields) {
            field.setAccessible(true);
            field.set(bean, applicationContext.getBean(field.getType()));
        }

        return bean;
    }
}
