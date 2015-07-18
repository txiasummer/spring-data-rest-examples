package txia.projection

import txia.domain.Person
import org.springframework.data.rest.core.config.Projection

@Projection(name = 'personDetails', types = Person)
interface PersonProjection {
    String getFirstName()
    String getLastName()
    Integer getAge()
}
