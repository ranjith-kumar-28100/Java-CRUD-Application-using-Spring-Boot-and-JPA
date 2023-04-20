package inc.codeman.spring.SpringDataApp;

import inc.codeman.spring.SpringDataApp.dao.PersonJdbcDAO;
import inc.codeman.spring.SpringDataApp.entity.Person;
import inc.codeman.spring.SpringDataApp.jpa.PersonJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class SpringJPADataAppApplication implements CommandLineRunner {

	@Autowired
	private PersonJPARepository personJPARepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(SpringJPADataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Entity with id 10001 {}",personJPARepository.findById(10001));
		logger.info("Updating the entity with id 10001 ==> {}",personJPARepository.update(new Person(10001,"Mathey","Haryana",Date.from(Instant.now()))));
		logger.info("Inserting new entity {}",personJPARepository.insert(new Person("Mass Maha Dev","London",Date.from(Instant.now()))));
		personJPARepository.deleteById(1);
		logger.info("Entity with id 1 is deleted");
		logger.info("All Persons {}",personJPARepository.findAll());
		logger.info("Persons with name Mathey {}",personJPARepository.findByName("Mathey"));
		logger.info("Persons in location Amsterdam {}",personJPARepository.findByLocation("Amsterdam"));
		logger.info("Persons in Amsterdam with name Johny {}",personJPARepository.findByNameAndLocation("Johny","Amsterdam"));
	}
}
