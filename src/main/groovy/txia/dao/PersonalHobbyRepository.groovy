package txia.dao

import txia.domain.entity.PersonalHobby
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import txia.domain.projection.PersonalHobbyProjection

@Repository
//TODO: having the "excerptProjection=PersonalHobbyProjection" causes the cascade deletes to fail. Need to fix this
@RepositoryRestResource(collectionResourceRel='personalHobbies', path='personalHobbies')
interface PersonalHobbyRepository extends PagingAndSortingRepository<PersonalHobby, Long>{

    @Query("from PersonalHobby where person.id = :personId")
    List<PersonalHobby> findByPersonId(@Param('personId') Long personId)

    @Query("from PersonalHobby where hobby.id = :hobbyId")
    List<PersonalHobby> findByHobbyId(@Param('hobbyId') Long hobbyId)

    @Query("from PersonalHobby where hobby.name = :hobbyName")
    List<PersonalHobby> findByHobbyName(@Param('hobbyName') String hobbyName)
}
