package br.com.aftermidnight.petcare.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.aftermidnight.petcare.model.Cliente;
import br.com.aftermidnight.petcare.repository.Clientes;

@Configuration
@ComponentScan(basePackageClasses = Clientes.class)
@EnableJpaRepositories(basePackageClasses = Clientes.class, enableDefaultTransactions = false, repositoryImplementationPostfix="Impl")
@EnableTransactionManagement
public class JPAConfig {
	

	@Profile("local")
	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		dataSourceLookup.setResourceRef(true);
		System.out.println("dataSourceLookup: "+ dataSourceLookup.getDataSource("jdbc/petcareDB"));
		return dataSourceLookup.getDataSource("jdbc/petcareDB");
	}
	
//	@Profile("prod")
//	@Bean
//	public DataSource dataSourceHeroku() throws URISyntaxException {
//		URI jdbUri = new URI(System.getenv("JAWSDB_URL"));
//
//	    String username = jdbUri.getUserInfo().split(":")[0];
//	    String password = jdbUri.getUserInfo().split(":")[1];
//	    String port = String.valueOf(jdbUri.getPort());
//	    String jdbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port + jdbUri.getPath();
//	    
//	    BasicDataSource dataSource = new BasicDataSource();
//	    dataSource.setUrl(jdbUrl);
//	    dataSource.setUsername(username);
//	    dataSource.setPassword(password);
//	    dataSource.setInitialSize(10);
//	    return dataSource;
//	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		System.out.println("testeeee");
		return adapter;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setJpaVendorAdapter(jpaVendorAdapter);
		factory.setPackagesToScan(Cliente.class.getPackage().getName());
//		factory.setMappingResources("sql/consultas-nativas.xml");
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
	
	
	
}