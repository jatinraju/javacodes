package com.eg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.model.Person;
import com.eg.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo prepo;

	public Person addPerson(Person p) {
		prepo.save(p);
		return p;
	}

	public Person getById(int pid) {
		Optional<Person> op = prepo.findById(pid);
		if (op.isEmpty()) {
			return null;
		}
		return op.get();
	}

	public Person deletePerson(int pid) {
		Person p = getById(pid);
		if (p == null) {
			return null;
		}
		prepo.deleteById(p.getPid());
		return p;
	}

	public List<Person> getAllPersons() {
		List<Person> plist = prepo.findAll();
		return plist;
	}

	public Person updatePerson(int pid, Person p) {
		Person per = getById(pid);
		if (per == null) {
			return null;
		}
		per.setPname(p.getPname());
		per.getAddress().setStreet(p.getAddress().getStreet());
		per.getAddress().setCity(p.getAddress().getCity());

		prepo.save(per);
		return per;
	}

}
