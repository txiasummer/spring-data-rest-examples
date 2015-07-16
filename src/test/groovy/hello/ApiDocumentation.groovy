package hello

import org.springframework.boot.test.ConfigFileApplicationContextInitializer
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification
import javax.annotation.Resource
import static org.springframework.restdocs.RestDocumentation.documentationConfiguration
import static org.springframework.restdocs.RestDocumentation.document
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ContextConfiguration(classes = [Application], initializers = ConfigFileApplicationContextInitializer)
@WebAppConfiguration
class ApiDocumentation extends Specification {

    @Resource
    WebApplicationContext context

    @Resource
    PersonRepository personRepository

    MockMvc mockMvc

    void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(documentationConfiguration()).build();
        Person person1 = new Person(id: 1, firstName: 'Chewbacca', lastName: 'Xia')
        Person person2 = new Person(id: 2, firstName: 'Furrs', lastName: 'Xia')
        Person person3 = new Person(id: 3, firstName: 'Jameson', lastName: 'Parente')
        Person person4 = new Person(id: 4, firstName: 'Milli', lastName: 'Brewer')
        Person person5 = new Person(id: 5, firstName: 'Hooch', lastName: 'Brewer')

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
