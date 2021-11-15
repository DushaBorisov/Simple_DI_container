package com.simple.di.container.configuration;

import com.simple.di.container.test.service.Delivery;
import com.simple.di.container.test.service.impl.AircraftDelivery;
import com.simple.di.container.test.service.impl.CarDelivery;

import java.util.Map;

public class JavaConfiguration implements Configuration {
    @Override
    public String getPackageToScan() {
        return "com.simple.di.container";
    }

    @Override
    public Map<Class, Class> getInterfaceToImplementations() {
        return Map.of(Delivery.class, CarDelivery.class);
    }
}
