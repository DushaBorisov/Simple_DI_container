package com.simple.di.container.configurator;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaBeanConfigurator implements BeanConfigurator {

    @Getter
    private final Reflections scanner;
    private final Map<Class, Class> interfaceToImplementation;

    public JavaBeanConfigurator(String packageToScan, Map<Class, Class> interfaceToImplementation) {
        this.scanner = new Reflections(packageToScan);
        this.interfaceToImplementation = interfaceToImplementation;
    }

    @Override
    public <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass) {
        if (interfaceToImplementation.containsKey(interfaceClass))
            return interfaceToImplementation.get(interfaceClass);

        Set<Class<? extends T>> implementationClasses = scanner.getSubTypesOf(interfaceClass);
        if (implementationClasses.size() != 1) {
            throw new RuntimeException("Interface has 0 or more than 1 implementations");
        }
        return implementationClasses.stream().findFirst().get();
    }
}
