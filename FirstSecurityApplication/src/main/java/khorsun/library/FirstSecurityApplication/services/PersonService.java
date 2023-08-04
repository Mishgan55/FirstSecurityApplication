package khorsun.library.FirstSecurityApplication.services;

import khorsun.library.FirstSecurityApplication.models.Person;
import khorsun.library.FirstSecurityApplication.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> findByName(String name){
       return personRepository.findPersonByName(name);
    }
}
