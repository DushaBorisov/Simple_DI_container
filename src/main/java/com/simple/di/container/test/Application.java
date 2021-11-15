package com.simple.di.container.test;

import com.simple.di.container.context.ApplicationContext;
import com.simple.di.container.factory.BeanFactory;

public class Application {

    public ApplicationContext run() {
        ApplicationContext context = new ApplicationContext();
        BeanFactory beanFactory = new BeanFactory(context);
        context.setBeanFactory(beanFactory);

        return context;
    }

    public static void main(String[] args) {
        Application application = new Application();
        ApplicationContext context = application.run();

        ProductBuyHelper productBuyHelper = context.getBean(ProductBuyHelper.class);
        productBuyHelper.getProduct();
    }
}
