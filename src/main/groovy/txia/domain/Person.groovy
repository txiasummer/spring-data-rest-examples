package txia.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Transient

@Entity
@Canonical
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id

	String firstName

	String lastName

    Integer age

	String username

	@JsonIgnore
	String password

	@Transient
	@JsonProperty('isAdult')
	Boolean isAdult

}