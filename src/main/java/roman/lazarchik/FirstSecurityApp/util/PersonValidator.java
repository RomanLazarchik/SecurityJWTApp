package roman.lazarchik.FirstSecurityApp.util;



import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import roman.lazarchik.FirstSecurityApp.models.Person;
import roman.lazarchik.FirstSecurityApp.services.PersonService;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonValidator implements Validator {

    private final PersonService personService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (personService.findOneByName(person.getUsername()).isPresent()) {
            errors.rejectValue("username", "", "A person with the same name is already registered");
        }
    }
}
