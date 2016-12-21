package com.appointment.schedular.tenant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
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
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
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
public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl
		implements ApplicationListener<ContextRefreshedEvent>, ServiceRegistryAwareService {

	@Autowired
	private Environment springEnvironment;

	@Autowired
	private TenantDao tenantDao;

	@Autowired
	@Qualifier("tenantDataSource")
	DataSource dataSource;

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

	@Override
	public void injectServices(ServiceRegistryImplementor serviceRegistry) {
		Map lSettings = serviceRegistry.getService(ConfigurationService.class).getSettings();
		DataSource localDs = (DataSource) lSettings.get("hibernate.connection.datasource");
		dataSource = localDs;
	}

	private DataSource constructDataSource(String dbName) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(
				springEnvironment.getProperty("tenant.datasource.classname", "com.mysql.jdbc.Driver"));
		dataSource.setUrl(
				springEnvironment.getProperty("tenant.datasource.url") + dbName + "?createDatabaseIfNotExist=true");
		dataSource.setUsername(springEnvironment.getProperty("tenant.datasource.user", "root"));
		dataSource.setPassword(springEnvironment.getProperty("tenant.datasource.password", "root"));
		
		dynamicEntityManagerFactory(dataSource);
		
		return dataSource;
	}

	public LocalContainerEntityManagerFactoryBean dynamicEntityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setPackagesToScan(new String[] { "com.appointment.schedular.model.tenant" });
		entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
		entityManagerFactoryBean.setPersistenceUnitName(dataSource.toString());
		entityManagerFactoryBean.afterPropertiesSet();
		return entityManagerFactoryBean;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect",
				springEnvironment.getProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"));
		properties.put("hibernate.show_sql", springEnvironment.getProperty("hibernate.show_sql", "true"));
		properties.put("hibernate.format_sql", springEnvironment.getProperty("hibernate.format_sql", "true"));
		properties.put("hibernate.hbm2ddl.auto", springEnvironment.getProperty("hibernate.hbm2ddl.auto", "update"));
		return properties;
	}

	@Override
	protected DataSource selectAnyDataSource() {
		return dataSource;
	}

	@Override
	protected DataSource selectDataSource(String key) {
		return map.get(key);
	}

	public void addTenant(String tenantKey) {
		map.put(tenantKey, constructDataSource(tenantKey));
	}
}
