package txia.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical
import org.springframework.format.annotation.DateTimeFormat

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Transient
import java.time.LocalDate

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

//	@JsonIgnore
	String password

	@Transient
	@JsonProperty('isAdult')
	Boolean isAdult

	/* TODO: get the folloiwng error if I used LocalDate
	* Caused by: org.h2.jdbc.JdbcSQLException: Hexadecimal string contains non-hex character: "1985-10-07"; SQL statement:
	* insert into person(id, first_name, last_name, age, username, password, birth_date) values(100, 'Mickey', 'Mouse', 21, 'username100', 'password100', '1985-10-07') -- (100, 'Mickey', 'Mouse', 21, 'username100', 'password100', '1985-10-07') [90004-188]
	*
	* @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	* LocalDate birthDate
	*
	* */
	Date birthDate
}