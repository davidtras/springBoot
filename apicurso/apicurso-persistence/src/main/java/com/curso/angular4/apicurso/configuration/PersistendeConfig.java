package com.curso.angular4.apicurso.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.AvailableSettings;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@PropertySource(value = { "classpath:db/db.properties" })
@EnableTransactionManagement
@ComponentScan("com.curso.angular4.apicurso")
public class PersistendeConfig {

//	@Bean
//	@ConfigurationProperties("app.datasource")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}

//	@Bean
//    public DataSource dataSource() {
//        
//		Properties properties = new Properties();
//		properties.setProperty("spring.jpa.database-platform", "org.hibernate.dialect.MySQL5Dialect");
//		properties.setProperty("spring.jpa.properties.hibernate.current_session_context_class", "org.springframework.orm.hibernate4.SpringSessionContext");
//		
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/videos_application");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        dataSource.setConnectionProperties(properties);
//        return dataSource;
//    }
//	
    
    
	@Value("${hibernate.dialect}")
	private String PROPERTY_NAME_HIBERNATE_DIALECT;
    
	@Value("${hibernate.hbm2ddl.auto}")
	private String PROPERTY_NAME_HIBERNATE_HBM2DDL;
    
	@Value("${hibernate.show_sql}")
	private String PROPERTY_NAME_HIBERNATE_SHOW_SQL;
    
	private static final String[] ENTITYMANAGER_PACKAGES_TO_SCAN = {"com.curso.angular4.apicurso"};
	
	@Value("${spring.datasource.url}")
	private String dataSourceUrl;
	
	@Value("${spring.datasource.username}")
	private String dataSourceUserName;
	
	@Value("${spring.datasource.password}")
	private String dataSourcePass;
	
	@Value("${spring.datasource.driverClassName}")
	private String dataSourceDriver;

    @Autowired
    private Environment env;

     @Bean
     public DataSource dataSource() {
    	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
         dataSource.setDriverClassName(dataSourceDriver);
         dataSource.setUrl(dataSourceUrl);
         dataSource.setUsername(dataSourceUserName);
         dataSource.setPassword(dataSourcePass);
         return dataSource;
     }

     @Bean
     public JpaTransactionManager jpaTransactionManager() {
         JpaTransactionManager transactionManager = new JpaTransactionManager();
         transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
         return transactionManager;
     }

    private HibernateJpaVendorAdapter vendorAdaptor() {
         HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
         vendorAdapter.setShowSql(true);
         return vendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

         LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
         entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
         entityManagerFactoryBean.setDataSource(dataSource());
         entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
         entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);             
         entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());

         return entityManagerFactoryBean;
     }

     private Properties jpaHibernateProperties() {

         Properties properties = new Properties();

         properties.put("hibernate.dialect", PROPERTY_NAME_HIBERNATE_DIALECT);
         properties.put("hibernate.hbm2ddl.auto", PROPERTY_NAME_HIBERNATE_HBM2DDL);
         properties.put("hibernate.show_sql", PROPERTY_NAME_HIBERNATE_SHOW_SQL);

         properties.put(AvailableSettings.SCHEMA_GEN_DATABASE_ACTION, "none");
         properties.put(AvailableSettings.USE_CLASS_ENHANCER, "false");      
         return properties;       
     }

     
     
//	@Bean
//	public EntityManagerFactory entityManagerFactory() {
//
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setGenerateDdl(true);
//
//		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//		factory.setJpaVendorAdapter(vendorAdapter);
//		factory.setPackagesToScan("com.curso.angular4.apicurso.entities");
//		factory.setDataSource(dataSource());
//		factory.afterPropertiesSet();
//		factory.setJpaProperties(additionalProperties());
//		return factory.getObject();
//	}
//	
//
//	@Bean
//	public SessionFactory getSessionFactory() {
//	    if (entityManagerFactory().unwrap(SessionFactory.class) == null) {
//	        throw new NullPointerException("factory is not a hibernate factory");
//	    }
//	    return entityManagerFactory().unwrap(SessionFactory.class);
//	}
//
//	Properties additionalProperties() {
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//		properties.setProperty("hibernate.current_session_context_class", "org.hibernate.context.ThreadLocalSessionContext");
//		return properties;
//	}
//	
//	
	
	
	
	
	
	
}
