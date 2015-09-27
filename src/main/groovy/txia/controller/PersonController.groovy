package txia.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import txia.dao.PersonRepository
import txia.domain.Person
import txia.resource.PersonResource

import javax.annotation.Resource

@RestController
@RequestMapping('people')
class PersonController {

    @Resource
    PersonRepository personRepository

    @RequestMapping(value = '/getByLastName', method = RequestMethod.GET)
    public List<PersonResource> getByLastName(@RequestParam(value = 'lastName', required = false) String lastName) {
        List<Person> personList = personRepository.findByLastName(lastName)
        List<PersonResource> personResourceList = new ArrayList<PersonResource>()
        personList.each {
            PersonResource personResource = new PersonResource(id: it.id, firstName: it.firstName, lastName: it.lastName, userName: it.username, age: it.age, isAdult: it.isAdult)
            personResourceList.add(personResource)
        }
        return personResourceList
    }
}
