package txia.service

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service
import txia.domain.entity.Person

@Slf4j
@Service
class PersonServiceImpl implements PersonService {

    Boolean isAdult(Person person){
        return (person.age >= 21)
    }
}

interface PersonService {
    Boolean isAdult(Person person)
}