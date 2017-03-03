package springBootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springBootDemo.domain.Person;
import springBootDemo.service.PersonService;

/**
 * 控制器
 * @author wjx
 * 2017年3月3日 下午3:29:32
 *
 */
@RestController
public class PersonController {
	@Autowired
	private PersonService srv;

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}


	@RequestMapping("/person-{id}")
	public Person getPerson(@PathVariable int id) {
		return srv.getById(id);
	}
}
