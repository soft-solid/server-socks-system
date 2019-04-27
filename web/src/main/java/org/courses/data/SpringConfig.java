package org.courses.data;

import org.courses.data.DAO.NamedDao;
import org.courses.data.DAO.UnNamedDao;
import org.courses.data.DAO.hbm.*;
import org.courses.domain.hbm.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class SpringConfig {
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("dialect", "org.hibernate.dialect.SQLiteDialect");
        hibernateProperties.setProperty("connection.pool_size", "1");
        hibernateProperties.setProperty("show_sql", "true");
        hibernateProperties.setProperty("format_sql", "true");
        hibernateProperties.setProperty("hibernate.jdbc.batch_size", "30");
        return hibernateProperties;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public DriverManagerDataSource configurableDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:test.db");
        return dataSource;
    }

    @Bean
    public DataSource dataSource() {
        return configurableDataSource();
    }

    @Bean (name="localSessionFactoryBean")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setAnnotatedClasses(
                Manufacture.class,
                Material.class,
                SocksType.class,
                Socks.class,
                Composition.class,
                Storage.class);
        return sessionFactory;
    }

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory factory) {
        this.sessionFactory = factory;
    }

    @Bean
    public NamedDao<SocksType, Integer> typeDao() {
        return new TypeDao(sessionFactory);
    }

    @Bean
    public NamedDao<Material, Integer> materialDao() {
        return new MaterialDao(sessionFactory);
    }

    @Bean
    public NamedDao<Manufacture, Integer> manufactureDao() {
        return new ManufactureDao(sessionFactory);
    }

    @Bean
    public UnNamedDao<Socks, Integer> socksDao() {
        return new SocksDao(sessionFactory);
    }

    @Bean
    public UnNamedDao<Storage, Integer> storageDao() {
        return  new StorageDao(sessionFactory);
    }
}
