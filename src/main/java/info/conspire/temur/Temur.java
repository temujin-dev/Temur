package info.conspire.temur;



import info.conspire.temur.network.NetworkBootstrap;
import info.conspire.temur.util.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


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
        bootHibernate();
        NetworkBootstrap.boot(config.getString("network.host"), config.getInt("network.port"));

    }

    public static SessionFactory bootHibernate() {
        try {
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
        catch (HibernateException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }


}
