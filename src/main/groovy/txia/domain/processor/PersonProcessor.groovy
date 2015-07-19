package txia.domain.processor

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.Link
import org.springframework.hateoas.Resource
import org.springframework.hateoas.ResourceProcessor
import org.springframework.stereotype.Component
import txia.domain.Person
import txia.service.PersonServiceImpl

@Slf4j
@Component
class PersonProcessor implements ResourceProcessor<Resource<Person>>{

    @Autowired
    PersonServiceImpl personService

    @Override
    public Resource<Person> process(Resource<Person> resource) {
        resource.content.isAdult = personService.isAdult(resource.content.age)
        resource.add(new Link("http://localhost:8080/people", "added-link"))
        log.info "@@ resource.content.isAdult ==> ${resource.content.isAdult}"

        return resource
    }

}
