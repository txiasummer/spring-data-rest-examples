package hello.domain

import groovy.transform.Canonical

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Canonical
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id
	String firstName
	String lastName
    Integer age
}