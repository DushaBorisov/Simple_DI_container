package com.simple.di.container.test;

import com.simple.di.container.annotation.Inject;
import com.simple.di.container.annotation.PostConstruct;
import com.simple.di.container.test.model.Product;
import com.simple.di.container.test.service.Delivery;
import com.simple.di.container.test.service.Shop;

public class ProductBuyHelper {

    @Inject
    private Shop shop;

    @Inject
    private Delivery delivery;

    @PostConstruct
    public void postConstruct() {
        System.out.println("ProductBuyHelper has been initialized!");
    }

    public void getProduct() {
        Product product = new Product("TV", 7000);
        shop.buyProduct(product);
        delivery.deliveryToClient(product);
    }
}
