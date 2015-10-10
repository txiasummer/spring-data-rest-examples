package txia.dao

import groovy.util.logging.Slf4j
import org.springframework.data.rest.core.annotation.HandleBeforeSave
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import txia.domain.entity.Person

@Slf4j
@RepositoryEventHandler(Person.class)
class PersonEventHandler {

    //TODO: fix me. the EventHandler does not work. Password does not get saved

    @HandleBeforeSave
    public void handlePersonSave(Person person){
        log.info "@@ I am in the handlePersonSave method ==> $person"
        person.password = person.firstName + person.lastName + person.age + 'topSecret'
    }
//    {"firstName":"Randy", "lastName":"Davis", "age":33, "username":"rdavis"}
}
