package com.CrystalGames.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"com.CrystalGames.backend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private final static String database_url="jdbc:h2:tcp://localhost/~/crystalgames";
	private final static String database_driver="org.h2.Driver";
	private final static String database_dialect="org.hibernate.dialect.H2Dialect";			
	private final static String database_username="sa";
	private final static String database_password="";
	
	
	@Bean("dataSource")		// Providing dataSource bean
	public DataSource getDataSource()    //provides the connection information of the DB	
	{
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(database_driver);
		dataSource.setUrl(database_url);
		dataSource.setUsername(database_username);
		dataSource.setPassword(database_password);
		return dataSource;
	}
	
	// providing bean for session factory
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource)	;
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.CrystalGames.backend.dto");
		return builder.buildSessionFactory();
	}
	
	// All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect",database_dialect);
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.format_sql","true");
		properties.put("hibernate.hbm2ddl.auto","update");		// creates table when required
		return properties;
	}
	
	// Transaction Manager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
}
