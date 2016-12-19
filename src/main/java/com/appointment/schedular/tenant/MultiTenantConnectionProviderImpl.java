package com.appointment.schedular.tenant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.appointment.schedular.dao.master.TenantDao;
import com.appointment.schedular.model.master.Tenant;

/**
 * @author Dhyanandra
 *
 */

@SuppressWarnings("serial")
@Component
@PropertySource("classpath:application.properties")
public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl implements ApplicationListener<ContextRefreshedEvent> {

   @Autowired
   private Environment springEnvironment;
   
   @Autowired
   private TenantDao tenantDao;
   
   @Autowired
   DataSource masterDataSource;
   
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

   private DataSource constructDataSource(String dbName) {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(springEnvironment.getProperty("tenant.datasource.classname",
              "com.mysql.jdbc.Driver"));
      dataSource.setUrl(springEnvironment.getProperty("tenant.datasource.url", 
              "jdbc:mysql://localhost:3307/") + dbName +"?createDatabaseIfNotExist=true");
      dataSource.setUsername(springEnvironment.getProperty("tenant.datasource.user", "root"));
      dataSource.setPassword(springEnvironment.getProperty("tenant.datasource.password", "root"));
      try {
         dataSource.getConnection().createStatement().execute("CREATE DATABASE IF NOT EXISTS " + dbName);
         //dataSource.getConnection().createStatement().
      } catch (Exception ex) {
         System.out.println(ex);
      }
      return dataSource;
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
