package txia.domain.processor

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.Link
import org.springframework.hateoas.Resource
import org.springframework.hateoas.ResourceProcessor
import org.springframework.stereotype.Component
import txia.domain.entity.Person
import txia.service.PersonService

@Slf4j
@Component
class PersonProcessor implements ResourceProcessor<Resource<Person>>{

    @Autowired
    PersonService personService

    @Override
    public Resource<Person> process(Resource<Person> resource) {
        resource.content.isAdult = personService.isAdult(resource.content)

        //you can add a custom hyperlink
        resource.add(new Link('http://docs.spring.io/spring-data/rest/docs/current/reference/html/', 'added-link'))

        log.info '@@ resource.content.isAdult ==> ${resource.content}'

        return resource
    }

}
