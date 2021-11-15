package com.simple.di.container.configuration;

import java.util.Map;

public interface Configuration {

    String getPackageToScan();

    Map<Class, Class> getInterfaceToImplementations();
}
