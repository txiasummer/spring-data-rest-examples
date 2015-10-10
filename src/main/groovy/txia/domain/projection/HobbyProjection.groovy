package txia.domain.projection

import txia.domain.entity.Hobby
import org.springframework.data.rest.core.config.Projection

@Projection(name = 'hobbyDetails', types = Hobby)
interface HobbyProjection {
    String getName()
    String getDescription()
}
