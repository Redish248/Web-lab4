package config.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("repository")
@ComponentScan(basePackages = {"service", "repository", "entity", "controller", "impl"})
@PropertySource("classpath:application.properties")
public class DatabaseConfig {

    @Resource
    private Environment env;

    private static final String PROP_DATABASE_DRIVER = "spring.datasource.driver-class-name";
    private static final String PROP_DATABASE_PASSWORD = "spring.datasource.password";
    private static final String PROP_DATABASE_URL = "spring.datasource.url";
    private static final String PROP_DATABASE_USERNAME = "spring.datasource.username";
    private static final String PROP_HIBERNATE_DIALECT = "spring.jpa.properties.hibernate.dialect";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "spring.jpa.hibernate.ddl-auto";

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROP_DATABASE_PASSWORD));
        dataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
        dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }

    
    public Properties getHibernateProperties(){
        Properties properties = new Properties();
        properties.put("db.hibernate.hbm2ddl.auto", env.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));
        properties.put("db.hibernate.dialect", env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactory.setJpaProperties(getHibernateProperties());
        entityManagerFactory.setPackagesToScan("entity");
        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }
}
