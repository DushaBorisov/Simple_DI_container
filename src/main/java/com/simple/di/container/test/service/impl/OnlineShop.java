package com.simple.di.container.test.service.impl;

import com.simple.di.container.test.model.Product;
import com.simple.di.container.test.service.Shop;

public class OnlineShop implements Shop {
    @Override
    public void buyProduct(Product product) {
        System.out.println(String.format("Product with name: %s bought", product.getName()));
    }
}
