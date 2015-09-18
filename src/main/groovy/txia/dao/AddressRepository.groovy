package txia.dao

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import txia.domain.Address

@Repository
@RepositoryRestResource(collectionResourceRel='addresses', path='addresses')
interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
}
