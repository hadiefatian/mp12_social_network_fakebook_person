package at.refugeescode.mp12_social_network_fakebook_person.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
