package io.github.hongsii.jpaunderscoretest.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String addressZip; // 테스트를 위한 컬럼
	@Embedded
	private Address address;

	public Person(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}
}
