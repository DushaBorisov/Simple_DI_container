package com.simple.di.container.test.service.impl;

import com.simple.di.container.test.model.Product;
import com.simple.di.container.test.service.Delivery;

public class AircraftDelivery implements Delivery {
    @Override
    public void deliveryToClient(Product product) {
        System.out.println("Product will be deliver to client by aircraft");
    }
}
