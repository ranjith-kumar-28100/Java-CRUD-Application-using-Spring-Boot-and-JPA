package inc.codeman.spring.SpringDataApp.jpa;

import inc.codeman.spring.SpringDataApp.entity.Person;

import java.util.List;

public interface PersonJPARepository {
    Person findById(int id);
    void deleteById(int id);
    Person update (Person person);
    Person insert (Person person);
    List<Person> findAll();
    List<Person> findByName(String name);
    List<Person> findByLocation(String location);
    List<Person> findByNameAndLocation(String name, String location);
}
