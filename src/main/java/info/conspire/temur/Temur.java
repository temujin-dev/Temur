package info.conspire.temur;


import info.conspire.temur.network.NetworkBootstrap;
import info.conspire.temur.util.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Project Temur
 * @author Temujin
 */
public class Temur {

    private static final Logger logger = LogManager.getLogger(Temur.class);
    private static Configuration config;
    // Entry point.. duh
    public static void main(String[] args) {
        logger.info("Booting up Temur");
        config = new Configuration("src/main/resources/temur.cfg");
        NetworkBootstrap.boot(config.getString("network.host"), config.getInt("network.port"));

    }
}
