package txia

import org.springframework.restdocs.RestDocumentation
import txia.dao.HobbyRepository
import txia.dao.PersonRepository
import txia.dao.PersonalHobbyRepository
import txia.domain.entity.Hobby
import txia.domain.entity.Person
import txia.domain.entity.PersonalHobby
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ContextConfiguration(classes=[Application], initializers = ConfigFileApplicationContextInitializer)
@WebAppConfiguration
class ApiDocumentationPersonalHobby extends Specification {

//    public final RestDocumentation restDocumentation = new RestDocumentation("target/generated-snippets")
//
//    @Resource
//    WebApplicationContext context
//
//    @Resource
//    PersonRepository personRepository
//
//    @Resource
//    HobbyRepository hobbyRepository
//
//    @Resource
//    PersonalHobbyRepository personalHobbyRepository
//
//    Person person1, person2, person3
//    Hobby hobby1, hobby2, hobby3, hobby4
//    PersonalHobby personalHobby1, personalHobby2, personalHobby3, personalHobby4, personalHobby5, personalHobby6
//
//    MockMvc mockMvc
//
//    void setup(){
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(documentationConfiguration(this.restDocumentation)).build();
//
//        person1 = new Person(firstName: 'Chewbacca', lastName: 'Xia', age: 12)
//        person2 = new Person(firstName: 'Furrs', lastName: 'Xia', age: 14)
//        person3 = new Person(firstName: 'Jameson', lastName: 'Parente', age: 7)
//        personRepository.save([person1, person2, person3])
//
//        hobby1 = new Hobby(name: 'piano', description: 'playing the piano')
//        hobby2 = new Hobby(name: 'running', description: 'running')
//        hobby3 = new Hobby(name: 'reading', description: 'reading literature')
//        hobby4 = new Hobby(name: 'soccer', description: 'playing soccer')
//        hobbyRepository.save([hobby1, hobby2, hobby3, hobby4])
//
//        personalHobby1 = new PersonalHobby(person: person1, hobby: hobby1)
//        personalHobby2 = new PersonalHobby(person: person1, hobby: hobby2)
//        personalHobby3 = new PersonalHobby(person: person1, hobby: hobby3)
//        personalHobby4 = new PersonalHobby(person: person1, hobby: hobby4)
//        personalHobby5 = new PersonalHobby(person: person2, hobby: hobby3)
//        personalHobby6 = new PersonalHobby(person: person3, hobby: hobby2)
//        personalHobbyRepository.save([personalHobby1, personalHobby2, personalHobby3, personalHobby4, personalHobby5, personalHobby6])
//    }
//
//    void 'get all personal hobbies'(){
//        when:
//        ResultActions response = mockMvc.perform(get('/personalHobbies'))
//
//        then:
//        response.andExpect(status().isOk())
//        response.andDo(document('get-all-personalhobbies'))
//    }
//
//    void 'get all personal hobbies with details'(){
//        when:
//        ResultActions response = mockMvc.perform(get('/personalHobbies?projection=personalHobbyDetails'))
//
//        then:
//        response.andExpect(status().isOk())
//        response.andDo(document('get-all-personalhobbies-with-details'))
//    }
//
//    void 'get personal hobby/hobbies by hobby name'(){
//        when:
//        ResultActions response = mockMvc.perform(get('/personalHobbies/search/findByHobbyName?hobbyName=running'))
//
//        then:
//        response.andExpect(status().isOk())
//        response.andDo(document('get-personalhobbies-by-name'))
//    }
//
//    void 'get personal hobby/hobbies by hobby id'(){
//        when:
//        ResultActions response = mockMvc.perform(get("/personalHobbies/search/findByHobbyId?hobbyId=${hobby3.id}"))
//
//        then:
//        response.andExpect(status().isOk())
//        response.andDo(document('get-personalhobbies-by-hobbyid'))
//    }
//
//    void 'get personal hobby/hobbies by person id'(){
//        when:
//        ResultActions response = mockMvc.perform(get("/personalHobbies/search/findByPersonId?personId=${person1.id}"))
//
//        then:
//        response.andExpect(status().isOk())
//        response.andDo(document('get-personalhobbies-by-personid'))
//    }

}
