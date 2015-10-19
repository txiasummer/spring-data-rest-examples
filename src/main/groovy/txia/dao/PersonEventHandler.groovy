package txia.dao

import groovy.util.logging.Slf4j
import org.springframework.data.rest.core.annotation.HandleBeforeCreate
import org.springframework.data.rest.core.annotation.HandleBeforeSave
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.stereotype.Component
import txia.domain.entity.Person

import java.time.LocalDate

@Slf4j
@Component
@RepositoryEventHandler(Person.class)
class PersonEventHandler {

    @HandleBeforeCreate
    public void handlePersonSave(Person person){
        person.password = person.username + (new LocalDate(2015,10,15).toString())
    }
}
