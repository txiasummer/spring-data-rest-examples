package txia.dao

import txia.domain.Hobby
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@Repository
@RepositoryRestResource(collectionResourceRel='hobbies', path='hobbies')
public interface HobbyRepository extends PagingAndSortingRepository<Hobby, Long> {
    List<Hobby> findByName(@Param('name') String name)
}
