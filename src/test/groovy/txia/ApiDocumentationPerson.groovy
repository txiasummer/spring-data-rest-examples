package txia

import txia.dao.PersonRepository
import txia.domain.Person
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ContextConfiguration(classes = [Application], initializers = ConfigFileApplicationContextInitializer)
@WebAppConfiguration
class ApiDocumentationPerson extends Specification {

    @Resource
    WebApplicationContext context

    @Resource
    PersonRepository personRepository

    MockMvc mockMvc

    void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(documentationConfiguration()).build();
        personRepository.save([
                new Person(id: 1, firstName: 'Chewbacca', lastName: 'Xia', age: 12),
                new Person(id: 2, firstName: 'Furrs', lastName: 'Xia', age: 14),
                new Person(id: 3, firstName: 'Jameson', lastName: 'Parente', age: 7),
                new Person(id: 4, firstName: 'Milli', lastName: 'Brewer', age: 27),
                new Person(id: 5, firstName: 'Hooch', lastName: 'Brewer', age: 34)
        ])
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
        ResultActions response = mockMvc.perform(get('/people/1'))

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

}
