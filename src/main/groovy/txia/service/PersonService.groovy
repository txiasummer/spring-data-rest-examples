package txia.service

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service
import txia.domain.Person

@Service
interface PersonService {
    Boolean isAdult(Person person)
}

@Slf4j
class PersonServiceImpl implements PersonService {

    Boolean isAdult(Person person){
        log.info "@@ age ==> ${person.age}"
        return (person.age >= 21)
    }

}