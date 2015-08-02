package txia.service

import txia.domain.Person

interface PersonService {
    Boolean isAdult(Person person)
}
