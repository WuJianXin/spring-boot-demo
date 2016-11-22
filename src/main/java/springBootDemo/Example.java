package springBootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springBootDemo.domain.Person;
import springBootDemo.service.PersonService;

@RestController
//@EnableAutoConfiguration
 @SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
//@ComponentScan
public class Example {

	@Autowired
	private PersonService srv;

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}

	@RequestMapping("/person-{id}")
	public Person getPerson(@PathVariable int id) {
		return srv.getById(id);
	}
}
