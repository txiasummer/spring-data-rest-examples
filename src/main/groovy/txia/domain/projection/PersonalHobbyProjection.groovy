package txia.domain.projection

import org.springframework.beans.factory.annotation.Value
import txia.domain.entity.PersonalHobby
import org.springframework.data.rest.core.config.Projection

@Projection(name = 'personalHobbyDetails', types = PersonalHobby)
interface PersonalHobbyProjection {
    PersonProjection getPerson()
    HobbyProjection getHobby()

    @Value('#{target.id}')
    Long getId()
}
