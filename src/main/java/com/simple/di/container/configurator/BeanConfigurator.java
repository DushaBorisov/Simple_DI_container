package com.simple.di.container.configurator;

import javassist.tools.reflect.Reflection;

public interface BeanConfigurator {

    <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass);
    Reflection getScanner();
}
