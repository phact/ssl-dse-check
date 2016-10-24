package com.phact;

import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;

/**
 * Created by sebastianestevez on 10/24/16.
 *
 */

public class SSLDSECheck {

    public static void main(String args[]) {
        String contactPoints=null;
        String truststore=null;
        if (args.length >=2){
            contactPoints = args[0];
            truststore= args[1];
        }else{
            System.out.println("please provide your contact points and truststore path");
            System.out.println("I.E. java -jar target/ssl-dse-check-1.0-SNAPSHOT.jar localhost /tmp/truststore.client ");
        }

        if(TestUCE()){
            DSECluster cluster = new DSECluster(contactPoints, truststore);
        }
        else{
            System.out.println("You do not have JCE installed.");
            System.out.println("Your java version: "+ System.getProperty("java.version"));
            System.out.println("Your java home is: " + System.getProperty("java.home"));
        }
    }

    private static boolean TestUCE() {
        boolean jceOn = false;
        try {
            jceOn = Cipher.getMaxAllowedKeyLength("AES") >= 256;
            System.out.println("Unlimited cryptography enabled: " + jceOn);
        } catch(NoSuchAlgorithmException e){
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
        }
        return jceOn;

    }

}
