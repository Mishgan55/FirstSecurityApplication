package khorsun.library.FirstSecurityApplication.repositories;

import khorsun.library.FirstSecurityApplication.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    Optional<Person> findPersonByName(String name);
}
