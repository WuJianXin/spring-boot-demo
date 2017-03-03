package springBootDemo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootDemo.dao.PersonDao;
import springBootDemo.domain.Person;

@Service
@Transactional
public class PersonService {
	@Autowired
	private PersonDao dao;
	
	public Person getById(int id){
		return dao.getById(id);
	}
}
