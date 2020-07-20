package bookstore.utils;

import bookstore.domain.Author;
import bookstore.domain.Book;
import bookstore.domain.Bookstore;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HybernateUtils {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "Hjrt5579");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.HBM2DDL_AUTO,"create");

            configuration.setProperties(properties);
           configuration.addAnnotatedClass(Author.class);
           configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Bookstore.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory=configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}