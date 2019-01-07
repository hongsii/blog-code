package io.github.hongsii.jpaunderscoretest.repository;


import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.hongsii.jpaunderscoretest.domain.Address;
import io.github.hongsii.jpaunderscoretest.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void ZipCode로_사람_조회() {
		personRepository.saveAll(asList(
				new Person(new Address("11111")),
				new Person(new Address("99999"))
		));

		Person savedPerson = personRepository.findByAddress_ZipCode("99999");

		assertThat(savedPerson.getAddress()).isEqualTo(new Address("99999"));
	}
}
