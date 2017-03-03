package springBootDemo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * hibernate配置
 * @author wjx
 * 2017年3月3日 下午3:18:03
 */

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	@Value("${hibernate.driver}")
	private String driver;

	@Value("${hibernate.password}")
	private String password;

	@Value("${hibernate.url}")
	private String url;

	@Value("${hibernate.username}")
	private String user;

	@Value("${hibernate.dialect}")
	private String dialect;

	@Value("${hibernate.packagesToScan}")
	private String folder;
	
	@Value("${hibernate.show_sql}")
	private boolean show_sql;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private boolean hbm2ddl;

	@Bean
	public DataSource buildDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName(driver);
		source.setUrl(url);
		source.setUsername(user);
		source.setPassword(password);
		return source;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean session = new LocalSessionFactoryBean();
		session.setDataSource(buildDataSource());
		session.setPackagesToScan(folder);
		Properties hibernate = new Properties();
		hibernate.put("hibernate.dialect",      dialect);
		hibernate.put("hibernate.show_sql",     show_sql);
		hibernate.put("hibernate.hbm2ddl.auto", hbm2ddl);
		session.setHibernateProperties(hibernate);
		return session;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager m = new HibernateTransactionManager();
		m.setSessionFactory(sessionFactory().getObject());
		return m;
	}
}
