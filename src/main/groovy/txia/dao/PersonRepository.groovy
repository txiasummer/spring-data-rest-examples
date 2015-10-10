package txia.dao

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Repository
import txia.domain.entity.Person

@Repository
@RepositoryRestResource(collectionResourceRel='people', path='people')
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	List<Person> findByLastName(@Param('lastName') String lastName)

	List<Person> findByBirthDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Param('birthDate') Date birthDate)
}