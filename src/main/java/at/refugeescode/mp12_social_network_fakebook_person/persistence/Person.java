package at.refugeescode.mp12_social_network_fakebook_person.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // If you have a collection : EAGER
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Person> friends = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }


    public Person() {
    }

    public Person(String name, List<Person> friends) {
        this.name = name;
        this.friends = friends;
    }
}
