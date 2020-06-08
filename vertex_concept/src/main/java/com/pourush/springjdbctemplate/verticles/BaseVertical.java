package com.pourush.springjdbctemplate.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;

/**
 * Created by pourush.sinha on 09/09/18.
 */
public class BaseVertical extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseVertical.class);

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new BaseVertical());
        System.out.println();
    }

    @Override
    public void start(){
        LOGGER.info("app started");
//        vertx.createHttpServer()
//                .requestHandler(routingContext -> routingContext.response().end("<h1>welcome to vertex intro </h1>"))
//                .listen(8080);

        Router router =Router.router(vertx);
        router.route().handler(StaticHandler.create().setCachingEnabled(false));
        vertx.createHttpServer().requestHandler(router :: accept).listen(8080,asyncResult ->{
            if (asyncResult.succeeded()){
                LOGGER.info("app started succesfuly");
            }else{
                LOGGER.error("app failed to start {}",asyncResult.cause());
            }

        });


        router.route("/api/*").handler(this :: accessControl);
        router.get("/api/v1/products").handler(this :: getAllProducts);

    }

    private void accessControl(RoutingContext routingContext) {
        String client = routingContext.request().headers().get("client");
        if (client ==null || !client.equals("pourush")){
            JsonObject jsonObject = new JsonObject();
            jsonObject.put("error" ,"sab galt hai baba");
            routingContext.response()
                    .setStatusCode(401)
                    .putHeader("content-type" ,"application/json")
                    .end(Json.encodePrettily(jsonObject));

        }else{
            routingContext.response().putHeader("clinet-type","pourush");
            routingContext.next();
        }
    }

    @Override
    public void stop(){
        LOGGER.info("app stopped");

    }

    public void getAllProducts(RoutingContext routingContext){
        LOGGER.info(routingContext.request().headers());
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("name" ,"falanadhimkana")
                .put("age","sweet 18");
        routingContext.response()
                .setStatusCode(200)
                .putHeader("content-type" ,"application/json")
                .end(Json.encodePrettily(jsonObject));
    }
}
