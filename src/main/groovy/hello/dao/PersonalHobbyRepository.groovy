package hello.dao

import hello.domain.PersonalHobby
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel='personalHobbies', path='personalHobbies')
interface PersonalHobbyRepository extends PagingAndSortingRepository<PersonalHobby, Long>{

    @Query("from PersonalHobby where person.id = :personId")
    List<PersonalHobby> findByPersonId(@Param('personId') Long personId)

    @Query("from PersonalHobby where hobby.id = :hobbyId")
    List<PersonalHobby> findByHobbyId(@Param('hobbyId') Long hobbyId)

    @Query("from PersonalHobby where hobby.name = :hobbyName")
    List<PersonalHobby> findByHobbyName(@Param('hobbyName') String hobbyName)
}
