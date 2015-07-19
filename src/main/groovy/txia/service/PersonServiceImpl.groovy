package txia.service

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

@Slf4j
@Service
class PersonServiceImpl implements PersonService {

    Boolean isAdult(Integer age){
        log.info "@@ age ==> $age"
        return (age >= 21)
    }

}
