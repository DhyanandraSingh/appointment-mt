
package com.appointment.schedular.configuration;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * @author Dhyanandra
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.appointment.schedular.dao.master",
        entityManagerFactoryRef = "masterEntityManager",
        transactionManagerRef = "masterTransactionManager"
)
@PropertySource("classpath:application.properties")
public class MasterDatabaseConfig {

   @Autowired
   private Environment springEnvironment;

   @Bean(name="masterDataSource")
   public DataSource masterDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(springEnvironment.getProperty("master.datasource.classname"));
      dataSource.setUrl(springEnvironment.getProperty("master.datasource.url") + "?createDatabaseIfNotExist=true");
      dataSource.setUsername(springEnvironment.getProperty("master.datasource.user"));
      dataSource.setPassword(springEnvironment.getProperty("master.datasource.password"));
      return dataSource;
   }
   
   @Bean(name = "masterEntityManager")
   @Primary
   public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory() {
      LocalContainerEntityManagerFactoryBean entityManagerFactoryBean 
              = new LocalContainerEntityManagerFactoryBean();
      entityManagerFactoryBean.setDataSource(masterDataSource());
      entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
      entityManagerFactoryBean.setPackagesToScan(new String[]{"com.appointment.schedular.model.master"});
      entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
      entityManagerFactoryBean.setPersistenceUnitName("master");
      return entityManagerFactoryBean;
   }

   private Properties getHibernateProperties() {
      Properties properties = new Properties();
      properties.put("hibernate.dialect", springEnvironment.getProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect"));
      properties.put("hibernate.show_sql", springEnvironment.getProperty("hibernate.show_sql", "true"));
      properties.put("hibernate.format_sql", springEnvironment.getProperty("hibernate.format_sql", "true"));
      properties.put("hibernate.hbm2ddl.auto", springEnvironment.getProperty("hibernate.hbm2ddl.auto", "update"));
      return properties;
   }

   @Bean(name = "masterTransactionManager")
   public JpaTransactionManager transactionManager(EntityManagerFactory masterEntityManager) {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(masterEntityManager);
      return transactionManager;
   }
}
