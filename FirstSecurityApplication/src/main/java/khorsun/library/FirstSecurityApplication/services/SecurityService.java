package khorsun.library.FirstSecurityApplication.services;

import khorsun.library.FirstSecurityApplication.models.Person;
import khorsun.library.FirstSecurityApplication.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    private final PasswordEncoder passwordEncoder;
    private final PersonRepository personRepository;
    @Autowired
    public SecurityService(PasswordEncoder passwordEncoder, PersonRepository personRepository) {
        this.passwordEncoder = passwordEncoder;
        this.personRepository = personRepository;
    }

    public void registration(Person person){
         person.setPassword(passwordEncoder.encode(person.getPassword()));
         personRepository.save(person);
    }
}
