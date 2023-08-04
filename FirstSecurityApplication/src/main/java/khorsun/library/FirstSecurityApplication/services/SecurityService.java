package khorsun.library.FirstSecurityApplication.services;

import khorsun.library.FirstSecurityApplication.models.Person;
import khorsun.library.FirstSecurityApplication.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    private final PersonRepository personRepository;
    @Autowired
    public SecurityService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void registration(Person person){
         personRepository.save(person);
    }
}
