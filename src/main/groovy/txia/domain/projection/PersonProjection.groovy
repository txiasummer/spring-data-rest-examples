package txia.domain.projection

import org.springframework.beans.factory.annotation.Value
import org.springframework.data.rest.core.config.Projection
import txia.domain.Person

@Projection(name = 'personDetails', types = Person)
interface PersonProjection {
    String getFirstName()

    String getLastName()

    Integer getAge()

    String getIsAdult()

    @Value('#{target.firstName} #{target.lastName}')
    String getFullName()
}
