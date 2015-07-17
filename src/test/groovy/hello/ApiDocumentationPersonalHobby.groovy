package hello

import hello.dao.HobbyRepository
import hello.dao.PersonRepository
import hello.dao.PersonalHobbyRepository
import hello.domain.Hobby
import hello.domain.Person
import hello.domain.PersonalHobby
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

@ContextConfiguration(classes=[Application], initializers = ConfigFileApplicationContextInitializer)
@WebAppConfiguration
class ApiDocumentationPersonalHobby extends Specification {

    @Resource
    WebApplicationContext context

    @Resource
    PersonRepository personRepository

    @Resource
    HobbyRepository hobbyRepository

    @Resource
    PersonalHobbyRepository personalHobbyRepository

    MockMvc mockMvc

    void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(documentationConfiguration()).build();

        Person person1 = new Person(id: 1, firstName: 'Chewbacca', lastName: 'Xia', age: 12)
        Person person2 = new Person(id: 2, firstName: 'Furrs', lastName: 'Xia', age: 14)
        Person person3 = new Person(id: 3, firstName: 'Jameson', lastName: 'Parente', age: 7)
        personRepository.save([person1, person2, person3])

        Hobby hobby1 = new Hobby(id: 1, name: 'piano', description: 'playing the piano')
        Hobby hobby2 = new Hobby(id: 2, name: 'running', description: 'running')
        Hobby hobby3 = new Hobby(id: 3, name: 'reading', description: 'reading literature')
        Hobby hobby4 = new Hobby(id: 4, name: 'soccer', description: 'playing soccer')
        hobbyRepository.save([hobby1, hobby2, hobby3, hobby4])

        PersonalHobby personalHobby1 = new PersonalHobby(id: 1, person: person1, hobby: hobby1)
        PersonalHobby personalHobby2 = new PersonalHobby(id: 2, person: person1, hobby: hobby2)
        PersonalHobby personalHobby3 = new PersonalHobby(id: 3, person: person1, hobby: hobby3)
        PersonalHobby personalHobby4 = new PersonalHobby(id: 4, person: person1, hobby: hobby4)
        PersonalHobby personalHobby5 = new PersonalHobby(id: 5, person: person2, hobby: hobby3)
        PersonalHobby personalHobby6 = new PersonalHobby(id: 6, person: person3, hobby: hobby2)
        personalHobbyRepository.save([personalHobby1, personalHobby2, personalHobby3, personalHobby4, personalHobby5, personalHobby6])
    }

    void 'get all personal hobbies'(){
        when:
        ResultActions response = mockMvc.perform(get('/personalHobbies'))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('get-all-personalhobbies'))
    }

    void 'get personal hobby/hobbies by hobby name'(){
        when:
        ResultActions response = mockMvc.perform(get('/personalHobbies/search/findByHobbyName?hobbyName=running'))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('get-personalhobbies-by-name'))
    }

    void 'get personal hobby/hobbies by hobby id'(){
        when:
        ResultActions response = mockMvc.perform(get('/personalHobbies/search/findByHobbyId?hobbyId=3'))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('get-personalhobbies-by-hobbyid'))
    }

    void 'get personal hobby/hobbies by person id'(){
        when:
        ResultActions response = mockMvc.perform(get('/personalHobbies/search/findByPersonId?personId=1'))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('get-personalhobbies-by-personid'))
    }

}
