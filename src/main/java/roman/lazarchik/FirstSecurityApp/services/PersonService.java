package roman.lazarchik.FirstSecurityApp.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roman.lazarchik.FirstSecurityApp.models.Person;
import roman.lazarchik.FirstSecurityApp.repositories.PeopleRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PeopleRepository userRepository;

    public Optional<Person> findOneByName(String name) {
        return userRepository.findByUsername(name).stream().findAny();
    }

}
