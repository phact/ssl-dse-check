package com.phact;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * Created by sebastianestevez on 10/24/16.
 */
public class DSECluster {
    public DSECluster(String contactPoints, String truststore) {
        Cluster cluster = null;
        try {
            System.setProperty("javax.net.ssl.trustStore", truststore);
            System.out.println("Using trustStore:"+truststore);
            System.out.println("on contactPoint:"+contactPoints);

            cluster = Cluster.builder()                                                    // (1)
                    .addContactPoint(contactPoints)
                    .withSSL()
                    .build();

            Session session = cluster.connect();                                           // (2)

            System.out.println("Succesfully connected to " + cluster.getClusterName());

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (cluster != null) cluster.close();                                          // (5)
        }
    }
}
