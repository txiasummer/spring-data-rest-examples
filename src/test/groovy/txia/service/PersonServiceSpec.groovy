package txia.service

import spock.lang.Specification
import txia.domain.entity.Person

class PersonServiceSpec extends Specification {
    Person oldPerson, youngPerson, child
    PersonServiceImpl service

    void setup(){
        oldPerson = new Person(id: 1, firstName: 'Walter', lastName: 'White', age: 52)
        youngPerson = new Person(id: 2, firstName: 'Jesse', lastName: 'Pinkman', age: 25)
        child = new Person(id: 3, firstName: 'Drew', lastName: 'Sharp', age: 11)

        service = new PersonServiceImpl()
    }

    void 'determine whether person is adult by age'(){
        expect:
        service.isAdult(oldPerson)
        service.isAdult(youngPerson)
        !service.isAdult(child)
    }
}
