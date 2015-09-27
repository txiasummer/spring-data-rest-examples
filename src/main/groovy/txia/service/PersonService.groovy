package txia.service

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service
import txia.domain.Person

@Slf4j
@Service
class PersonServiceImpl implements PersonService {

    Boolean isAdult(Person person){
        log.info "@@ age ==> ${person.age}"
        return (person.age >= 21)
    }
}

interface PersonService {
    Boolean isAdult(Person person)
}