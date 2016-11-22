package springBootDemo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import springBootDemo.domain.Person;

@Service
public class PersonService {
	private static Map<Integer,Person> map=new HashMap<>();
	static {
		map.put(1,new Person(1,"zhangsan"));
		map.put(2,new Person(2,"lisi"));
	}
	public Person getById(int id){
		return map.get(id);
	}
}
