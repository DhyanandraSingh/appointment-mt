/**
 * 
 */
package com.appointment.schedular.configuration;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Dhyanandra
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.appointment.schedular.tenant")
@EnableJpaRepositories(
        entityManagerFactoryRef = "tenantEntityManager",
        transactionManagerRef = "tenantTransactionManager",
        basePackages = {"com.appointment.schedular.dao.tenant"})
@PropertySource("classpath:application.properties")
public class TenantDatabaseConfig {

   @Autowired
   private Environment springEnvironment;

   @Bean
   public JpaVendorAdapter jpaVendorAdapter() {
      return new HibernateJpaVendorAdapter();
   }

   @Bean(name = "tenantEntityManager")
   public LocalContainerEntityManagerFactoryBean entityManagerFactory(
										   DataSource dataSource,
								           MultiTenantConnectionProvider connectionProvider,
								           CurrentTenantIdentifierResolver tenantResolver) {
      LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
      
      emfBean.setDataSource(dataSource);
      emfBean.setPackagesToScan("com.appointment.schedular.model.tenant");
      emfBean.setJpaVendorAdapter(jpaVendorAdapter());
      
      Map<String, Object> properties = new HashMap<>();
      properties.put(org.hibernate.cfg.Environment.MULTI_TENANT, MultiTenancyStrategy.DATABASE);
      properties.put(org.hibernate.cfg.Environment.MULTI_TENANT_CONNECTION_PROVIDER, connectionProvider);
      properties.put(org.hibernate.cfg.Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, tenantResolver);
      properties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
      properties.put("hibernate.dialect", springEnvironment.getProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"));
      properties.put("hibernate.show_sql", springEnvironment.getProperty("hibernate.show_sql", "true"));
      properties.put("hibernate.format_sql", springEnvironment.getProperty("hibernate.format_sql", "true"));
      properties.put("hibernate.hbm2ddl.auto", springEnvironment.getProperty("hibernate.hbm2ddl.auto", "update"));
      
      emfBean.setJpaPropertyMap(properties);
      return emfBean;
   }

   @Bean(name = "tenantTransactionManager")
   public JpaTransactionManager transactionManager(EntityManagerFactory tenantEntityManager) {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(tenantEntityManager);
      return transactionManager;
   }
}