package org.example.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Pepsi implements InitializingBean, DisposableBean {
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pepsi{" + "price=" + price + '}';
    }

    @PostConstruct
    public void start(){
        System.out.println("init method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //init
        System.out.println("taking pepsi=:init");
    }

    @PreDestroy
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }
}
