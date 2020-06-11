package main;

import com.google.common.collect.Maps;
import io.dropwizard.lifecycle.Managed;
import lombok.extern.slf4j.Slf4j;
import org.activejpa.enhancer.ActiveJpaAgentLoader;
import org.activejpa.jpa.JPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Map;

/**
 * Created by pourush.sinha on 03/05/19.
 */
@Slf4j
public class ManageResources  implements Managed {
    public void start() throws Exception {
        log.info("Initializing the active jpa module");
        ActiveJpaAgentLoader.instance().loadAgent();
        /*
        * nodes: localhost
  port: 9042
  keyspace: docyard
  dialect: cassandra
  clientLookupClass: com.impetus.kundera.client.cassandra.dsdriver.DSClientFactory
  poolSizeMaxActive: 100
  poolSizeMaxIdle: 100
  poolSizeMinIdle: 100
  poolSizeMaxTotal: 100
  clientPropertyFile: cassandra.properties.xml
  username: ""
  password: ""
  consistencyLevel: QUORUM*/

        Map<String, String> props = Maps.newHashMap();
        props.put("kundera.nodes", "localhost");
        props.put("kundera.port", "9042");
        props.put("kundera.keyspace", "practice_project");
        props.put("kundera.dialect", "cassandra");
        props.put("kundera.client.lookup.class", "com.impetus.kundera.client.cassandra.dsdriver.DSClientFactory");
        props.put("kundera.username", "");
        props.put("kundera.password", "");
       // props.put("kundera.client.property", getClientPropertyFile());
        props.put("kundera.pool.size.max.active", "100");
        props.put("kundera.pool.size.max.idle", "100");
        props.put("kundera.pool.size.min.idle", "100");
        props.put("kundera.pool.size.max.total", "100");
        props.put("consistency.level", "1");
        log.info("Properties to be used for creation of entity manager {}", props.toString());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("docyardPU", props);

        log.info("Registering persistence context to ActiveJPA");
        JPA.instance.addPersistenceUnit("docyardPU", emf, true);

    }

    public void stop() throws Exception {

    }
}
