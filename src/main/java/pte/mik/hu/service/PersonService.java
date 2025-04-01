package pte.mik.hu.service;
import pte.mik.hu.model.Person;
import pte.mik.hu.repository.PersonRepository;

import java.util.List;

public class PersonService implements ClientService<Person> {
    private final PersonRepository personRepository = new PersonRepository();

    @Override
    public void register(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> listAll() {
        return personRepository.listAll();
    }

}
