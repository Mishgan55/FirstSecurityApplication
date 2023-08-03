package khorsun.library.FirstSecurityApplication.services;

import khorsun.library.FirstSecurityApplication.models.Person;
import khorsun.library.FirstSecurityApplication.repositories.PersonRepository;
import khorsun.library.FirstSecurityApplication.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findPersonByName(username);
        if (person.isEmpty())
            throw new UsernameNotFoundException("Invalid Login");

        return new PersonDetails(person.get());
    }
}
