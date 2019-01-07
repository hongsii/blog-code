package io.github.hongsii.jpaunderscoretest.domain;

import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String zipCode;

	public Address() {}
	public Address(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Address)) {
			return false;
		}
		Address address = (Address) o;
		return Objects.equals(zipCode, address.zipCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(zipCode);
	}
}
