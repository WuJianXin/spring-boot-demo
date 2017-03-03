package springBootDemo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springBootDemo.domain.Person;

@Repository
public class PersonDao {
	@Autowired
	private SessionFactory sf;
	
	public Person getById(int id){
		return sf.getCurrentSession().get(Person.class, id);
	}
}
