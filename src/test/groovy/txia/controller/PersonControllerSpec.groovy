package txia.controller

import spock.lang.Specification
import txia.dao.PersonRepository
import txia.domain.entity.Person
import txia.domain.resource.PersonResource
import txia.service.PersonService


class PersonControllerSpec extends Specification {

    PersonController controller
    Person person1, person2

    void setup(){
        controller = new PersonController()
        controller.personRepository = Mock(PersonRepository)
        controller.personService = Mock(PersonService)
    }

    void 'get person by lastname'(){
        given:
        String lastName = 'Xia'
        person1 = new Person(id: 1, firstName: 'Chewbacca', lastName: 'Xia', username: 'cxia', age: 12)
        person2 = new Person(id: 2, firstName: 'Furrs', lastName: 'Xia', username: 'fxia', age: 29)
        PersonResource personResource1 = new PersonResource(id: person1.id, firstName: person1.firstName, lastName: person1.lastName, userName: person1.username, age: person1.age, isAdult: false)
        PersonResource personResource2 = new PersonResource(id: person2.id, firstName: person2.firstName, lastName: person2.lastName, userName: person2.username, age: person2.age, isAdult: true)
        controller.personRepository.findByLastName(lastName) >> [person1, person2]
        controller.personService.isAdult(person1) >> false
        controller.personService.isAdult(person2) >> true

        when:
        List<PersonResource> result = controller.getByLastName(lastName)

        then:
        result.size() == 2
        result.contains(personResource1)
        result.contains(personResource2)
    }

}
