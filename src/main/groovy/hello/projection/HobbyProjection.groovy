package hello.projection

import hello.domain.Hobby
import org.springframework.data.rest.core.config.Projection

@Projection(name = 'hobbyDetails', types = Hobby)
interface HobbyProjection {
    String getName()
    String getDescription()
}
