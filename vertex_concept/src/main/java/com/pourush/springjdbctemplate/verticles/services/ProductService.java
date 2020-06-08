package com.pourush.springjdbctemplate.verticles.services;

import io.vertx.core.Future;
import io.vertx.ext.web.RoutingContext;



/**
 * Created by pourush.sinha on 10/09/18.
 */
public class ProductService {

    public Future<String> getAllProducts(RoutingContext routingContext){
        Future<System> future = Future.future();
        future.complete("hi");


    }
}
