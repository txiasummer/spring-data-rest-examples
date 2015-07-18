package txia.projection

import txia.domain.PersonalHobby
import org.springframework.data.rest.core.config.Projection

@Projection(name = 'personalHobbyDetails', types = PersonalHobby)
interface PersonalHobbyProjection {
    PersonProjection getPerson()
    HobbyProjection getHobby()
}
