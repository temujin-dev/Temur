package info.conspire.temur;

import info.conspire.temur.network.NetworkBootstrap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Project Temur
 * @author Temujin
 */
public class Temur {

    private static final Logger logger = LogManager.getLogger(Temur.class);

    // Entry point.. duh
    public static void main(String[] args) {
        System.out.println(org.apache.logging.log4j.Logger.class.getResource("/log4j2.xml"));
        logger.info("Booting up Temur");
        NetworkBootstrap.boot();

    }
}
