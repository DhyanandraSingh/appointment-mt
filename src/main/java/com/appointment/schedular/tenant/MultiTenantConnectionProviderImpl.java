package com.appointment.schedular.tenant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hibernate.service.spi.ServiceRegistryAwareService;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import com.appointment.schedular.configuration.TenantDatabaseConfig;
import com.appointment.schedular.dao.master.TenantDao;
import com.appointment.schedular.model.master.Tenant;

/**
 * @author Dhyanandra
 *
 */

@SuppressWarnings("serial")
@Component
@PropertySource("classpath:application.properties")
public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl implements ApplicationListener<ContextRefreshedEvent>,ServiceRegistryAwareService {

   @Autowired
   private Environment springEnvironment;
   
   @Autowired
   private TenantDao tenantDao;
   
   @Autowired
   @Qualifier("tenantDataSource")
   DataSource masterDataSource;
   
   @Autowired
   MultiTenantConnectionProvider connectionProvider;
   
   @Autowired
   CurrentTenantIdentifierResolver tenantResolver;
   
   @Autowired
   TenantDatabaseConfig tenantDatabaseConfig;
   
 /*  @Autowired
   LocalContainerEntityManagerFactoryBean emfBean;*/
   
   private final Map<String, DataSource> map = new HashMap<>();

   @Override
   public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
      init();
   }

   private void init() {
      List<Tenant> tenants = tenantDao.findAll();
      for (Tenant tenant : tenants) {
         map.put(tenant.getTenantKey(), constructDataSource(tenant.getTenantKey()));
      }
   }

   //@Autowired
   //@Qualifier("dataSource1")
   private DataSource constructDataSource(String dbName) {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(springEnvironment.getProperty("tenant.datasource.classname"));
      dataSource.setUrl(springEnvironment.getProperty("tenant.datasource.url") + dbName+"?createDatabaseIfNotExist=true");
      dataSource.setUsername(springEnvironment.getProperty("tenant.datasource.user"));
      dataSource.setPassword(springEnvironment.getProperty("tenant.datasource.password"));
     
      entityManagerFactory(dataSource,connectionProvider, tenantResolver);
         
     
      return dataSource;
   }
   
  // @Autowired
  // @Qualifier("tenantEntityManager")
   public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
           MultiTenantConnectionProvider connectionProvider,
           CurrentTenantIdentifierResolver tenantResolver) {
      LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
      emfBean.setDataSource(dataSource);
      emfBean.setPackagesToScan("com.appointment.schedular.model.tenant");
      emfBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
      emfBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
      Map<String, Object> properties = new HashMap<>();
      properties.put(org.hibernate.cfg.Environment.MULTI_TENANT, MultiTenancyStrategy.DATABASE);
      properties.put(org.hibernate.cfg.Environment.MULTI_TENANT_CONNECTION_PROVIDER, connectionProvider);
      properties.put(org.hibernate.cfg.Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, tenantResolver);
      properties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        properties.put("hibernate.dialect", springEnvironment.getProperty("hibernate.dialect"
              , "org.hibernate.dialect.MySQLDialect"));
      properties.put("hibernate.show_sql", springEnvironment.getProperty("hibernate.show_sql"
              , "true"));
      properties.put("hibernate.format_sql", springEnvironment.getProperty("hibernate.format_sql"
              , "true"));
      properties.put("hibernate.hbm2ddl.auto", springEnvironment.getProperty("hibernate.hbm2ddl.auto"
              , "update"));
      emfBean.setJpaPropertyMap(properties);
      emfBean.setPersistenceUnitName(dataSource.toString());
      emfBean.afterPropertiesSet();
      //emfBean.setEntityManagerFactoryInterface((EntityMana)emfBean);
      //emfBean.setBeanName("srgsrohtak");
      return emfBean;
   }
   
  // @Autowired
   public JpaTransactionManager transactionManager(EntityManagerFactory tenantEntityManager) {
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(tenantEntityManager);
	      transactionManager.afterPropertiesSet();
	      return transactionManager;
   }
   
   @Override
   public void injectServices(ServiceRegistryImplementor serviceRegistry) {
       Map lSettings = serviceRegistry.getService(ConfigurationService.class).getSettings();
       DataSource localDs =  (DataSource) lSettings.get("hibernate.connection.datasource");
       masterDataSource = localDs;
   }
  
   @Override
   protected DataSource selectAnyDataSource() {
      return masterDataSource;
   }

   @Override
   protected DataSource selectDataSource(String key) {
      return map.get(key);
   }

   public void addTenant(String tenantKey) {
      
      map.put(tenantKey, constructDataSource(tenantKey));
   }
}
