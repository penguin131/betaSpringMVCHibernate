package edu.school21.cinema.config;

//import edu.school21.cinema.services.ImageFileService;
//import org.hibernate.jpa.HibernatePersistenceProvider;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//import java.util.Properties;

//@Configuration
//@EnableTransactionManagement
//@ComponentScan("edu.school21.cinema.models")
//@PropertySource("classpath:WEB-INF/application.properties")
//@EnableJpaRepositories("edu.school21.cinema.repositories")
public class CinemaConfig {

//    private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
//    private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
//    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";
//    private static final String PROP_DRIVER_CLASS_NAME = "org.postgresql.Driver";
//
//    @Resource
//    private Environment env;
//
//    @Bean
//    public DataSource postgresqlDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(PROP_DRIVER_CLASS_NAME);
//        dataSource.setUrl(env.getProperty("database.url"));
//        dataSource.setUsername(env.getProperty("database.username"));
//        dataSource.setPassword(env.getProperty("database.password"));
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(postgresqlDataSource());
//        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty("edu.school21.cinema.models"));
//        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
//        return entityManagerFactoryBean;
//    }
//
//    private Properties getHibernateProperties() {
//        Properties properties = new Properties();
//        properties.put(PROP_HIBERNATE_DIALECT, env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
//        properties.put(PROP_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
//        properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));
//        return properties;
//    }
//
//    @Bean
//    public ImageFileService imageFileService() {
//        return new ImageFileService();
//    }
//
//    public String getFileStoragePath() {
//        return this.env.getProperty("storage.path");
//    }
}
