package roman.lazarchik.FirstSecurityApp.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roman.lazarchik.FirstSecurityApp.models.Person;
import roman.lazarchik.FirstSecurityApp.repositories.PeopleRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Transactional(readOnly = true)
public class RegistrationService {
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(Person person) {
        String encode = passwordEncoder.encode(person.getPassword());
        person.setPassword(encode);
        person.setRole("ROLE_USER");

        peopleRepository.save(person);
    }
}
