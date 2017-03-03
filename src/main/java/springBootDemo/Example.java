package springBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@EnableAutoConfiguration
//@ComponentScan
//@Configuration
@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
 @EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class Example {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}
}
