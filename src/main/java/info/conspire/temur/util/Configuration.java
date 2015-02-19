package info.conspire.temur.util;

/**
 * Project Temur
 * @author Temujin
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Handles configuration
 */
public class Configuration {
    private Properties properties;
    private static final Logger logger = LogManager.getLogger(Configuration.class);

    public Configuration(String fileToLoad) {
        try {
            properties = new Properties();
            properties.load(new FileReader(fileToLoad));
        } catch (IOException ioe) {

            logger.error(ioe.getMessage());
        }
    }

    public String getString(String key) {
        return properties.getProperty(key);
    }

    public Integer getInt(String key) {
        return Integer.parseInt(getString(key));
    }
}
