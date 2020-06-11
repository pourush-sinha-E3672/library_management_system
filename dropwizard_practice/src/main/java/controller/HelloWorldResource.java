package controller;

/**
 * Created by pourush.sinha on 17/09/18.
 */
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Splitter;
import daodto.Saying;
import org.eclipse.jetty.util.MultiMap;
import org.glassfish.jersey.server.internal.routing.RoutingContext;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@Context UriInfo ui) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
       // MultivaluedMap<String, String> nameMap= uriInfo.getPathParameters();
      //  Map<String, String> properties = Splitter.on("&").withKeyValueSeparator("=").split(name);
        ObjectMapper mapper = new ObjectMapper();
        Saying map = mapper.convertValue(queryParams,Saying.class);


        System.out.println(map);
        //final String value = String.format(template, name);
        return new Saying(counter.incrementAndGet(), "");
    }
}
