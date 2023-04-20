package inc.codeman.spring.SpringDataApp.jpa.impl;

import inc.codeman.spring.SpringDataApp.entity.Person;
import inc.codeman.spring.SpringDataApp.jpa.PersonJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonJPARepositoryImpl implements PersonJPARepository {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Person findById(int id) {
        return entityManager.find(Person.class,id);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }

    @Override
    public Person update(Person person) {
        return entityManager.merge(person);
    }

    @Override
    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    @Override
    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

    @Override
    public List<Person> findByName(String name) {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_by_name", Person.class);
        namedQuery.setParameter("name",name);
        return namedQuery.getResultList();
    }

    @Override
    public List<Person> findByLocation(String location) {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_by_location", Person.class);
        namedQuery.setParameter("location",location);
        return namedQuery.getResultList();
    }

    @Override
    public List<Person> findByNameAndLocation(String name, String location) {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_by_name_and_location", Person.class);
        namedQuery.setParameter("name",name);
        namedQuery.setParameter("location",location);
        return namedQuery.getResultList();
    }
}
