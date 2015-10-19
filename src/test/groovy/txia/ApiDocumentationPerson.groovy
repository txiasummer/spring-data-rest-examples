package txia

import org.junit.Rule
import org.springframework.http.MediaType
import org.springframework.restdocs.RestDocumentation
import sun.security.tools.keytool.Resources_es
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

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import com.fasterxml.jackson.databind.ObjectMapper

@ContextConfiguration(classes = [Application], initializers = ConfigFileApplicationContextInitializer)
@WebAppConfiguration
class ApiDocumentationPerson extends Specification {

    @Rule
    public final RestDocumentation restDocumentation = new RestDocumentation("build/generated-snippets");

    @Resource
    WebApplicationContext context

    @Resource
    PersonRepository personRepository

    @Resource
    ObjectMapper objectMapper

    Person person1, person2, person3, person4, person5

    MockMvc mockMvc

    void setup() {
        person1 = new Person(firstName: 'Chewbacca', lastName: 'Xia', age: 12)
        person2 = new Person(firstName: 'Furrs', lastName: 'Xia', age: 14)
        person3 = new Person(firstName: 'Jameson', lastName: 'Parente', age: 7)
        person4 = new Person(firstName: 'Milli', lastName: 'Brewer', age: 27)
        person5 = new Person(firstName: 'Hooch', lastName: 'Brewer', age: 34)
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(documentationConfiguration(this.restDocumentation)).build();
        personRepository.save([person1, person2, person3, person4, person5])
    }

    void 'get all persons'() {
        when:
        ResultActions response = mockMvc.perform(get('/people'))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('person-list-example'))
    }

    void 'get specific person by id'() {
        when:
        ResultActions response = mockMvc.perform(get("/people/${person3.id}"))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('person-by-id-example'))
    }

    void 'get specific person(s) by lastName'() {
        when:
        ResultActions response = mockMvc.perform(get('/people/search/findByLastName?lastName=Xia'))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('person-list-by-lastname'))
    }

    void 'create a Person record'() {
        when:
        Map<String, String> person = ['firstName': 'Randy', 'lastName': 'Davis', 'age': '33', 'username': 'rdavis']
        ResultActions response = mockMvc.perform(post('/people/').contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(person)))

        then:
        response.andExpect(status().isCreated())
        response.andDo(document('create-person'))
    }

}
