package io.github.hongsii.jpaunderscoretest.repository;

import io.github.hongsii.jpaunderscoretest.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByAddress_ZipCode(String zipCode);
}
