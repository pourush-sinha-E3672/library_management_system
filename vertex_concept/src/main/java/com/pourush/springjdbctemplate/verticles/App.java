package com.pourush.springjdbctemplate.verticles;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;



/**
 * Created by pourush.sinha on 09/09/18.
 */
public class App extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void start(){
        LOGGER.info("app started");

    }

    @Override
    public void stop(){
        LOGGER.info("app stopped");

    }

    public static void main(String[] args) {
//        Vertx vertx = Vertx.vertx();
//        vertx.deployVerticle(new App());
        String jsonString = "{\"name\":\"Pourush\"}";
        JsonObject jsonObject = new JsonObject(jsonString);
        jsonObject.put("location","Utsav");
        System.out.println(jsonObject);
        Myitem myitem = new Myitem();
        myitem.name = "falanadhimkana";
        myitem.description = "some description";
        jsonObject.put("Myitem",jsonObject.mapFrom(myitem));
        System.out.println(jsonObject);
    }
}


class Myitem{
    public String name;
    public String description;
}
