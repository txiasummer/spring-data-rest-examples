package txia

import txia.dao.PersonRepository
import txia.domain.entity.Person
import org.springframework.boot.test.ConfigFileApplicationContextInitializer
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import javax.annotation.Resource

import static org.springframework.restdocs.RestDocumentation.document
import static org.springframework.restdocs.RestDocumentation.documentationConfiguration
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ContextConfiguration(classes = [Application], initializers = ConfigFileApplicationContextInitializer)
@WebAppConfiguration
class ApiDocumentationPerson extends Specification {

    @Resource
    WebApplicationContext context

    @Resource
    PersonRepository personRepository

    Person person1, person2, person3, person4, person5

    MockMvc mockMvc

    void setup(){
        person1 = new Person(firstName: 'Chewbacca', lastName: 'Xia', age: 12)
        person2 = new Person(firstName: 'Furrs', lastName: 'Xia', age: 14)
        person3 = new Person(firstName: 'Jameson', lastName: 'Parente', age: 7)
        person4 = new Person(firstName: 'Milli', lastName: 'Brewer', age: 27)
        person5 = new Person(firstName: 'Hooch', lastName: 'Brewer', age: 34)
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(documentationConfiguration()).build();
        personRepository.save([person1, person2, person3, person4, person5])
    }

    void 'get all persons'(){
        when:
        ResultActions response = mockMvc.perform(get('/people'))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('person-list-example'))
    }

    void 'get specific person by id'(){
        when:
        ResultActions response = mockMvc.perform(get("/people/${person3.id}"))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('person-by-id-example'))
    }

    void 'get specific person(s) by lastName'(){
        when:
        ResultActions response = mockMvc.perform(get('/people/search/findByLastName?lastName=Xia'))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('person-list-by-lastname'))
    }

    //TODO: need to fix this test
    void 'create a Person record'(){
        when:
        Person testPerson = new Person(firstName:'Randy', lastName:'Davis', age:33, username:'rdavis')
        ResultActions response = mockMvc.perform(post('/people/', testPerson))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('create-person'))
    }

}
