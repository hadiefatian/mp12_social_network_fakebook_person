package at.refugeescode.mp12_social_network_fakebook_person.endpoint;

import at.refugeescode.mp12_social_network_fakebook_person.persistence.Person;
import at.refugeescode.mp12_social_network_fakebook_person.persistence.PersonRepository;
import org.apache.el.stream.Stream;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonsEndpoint {

    private PersonRepository personRepository;

    public PersonsEndpoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    Person add(@RequestBody Person person) {
       return personRepository.save(person);
    }

    @GetMapping
    List<Person> findall() {
        return personRepository.findAll();
    }

    @PutMapping("/{id1}/friend/{id2}")
    Person addFriends(@PathVariable Long id1, @PathVariable Long id2) {
        Optional<Person> person = personRepository.findById(id1);
        Optional<Person> friend = personRepository.findById(id2);
        if (person.isPresent() && friend.isPresent()) {
            person.get().getFriends().add(friend.get());
            personRepository.save(person.get());
        }
        return person.get();
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    Person removeFriends(@PathVariable Long id1, @PathVariable Long id2) {
        Optional<Person> person = personRepository.findById(id1);
        Optional<Person> friend = personRepository.findById(id2);
        if (person.isPresent() && friend.isPresent()) {
            person.get().getFriends().remove(friend.get());
            personRepository.save(person.get());
        }
        return person.get();
    }

}
