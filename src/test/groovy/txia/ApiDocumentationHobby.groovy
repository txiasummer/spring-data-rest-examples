package txia

import txia.dao.HobbyRepository
import txia.domain.entity.Hobby
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
class ApiDocumentationHobby extends Specification {

    @Resource
    WebApplicationContext context

    @Resource
    HobbyRepository hobbyRepository

    Hobby hobby1, hobby2, hobby3, hobby4

    MockMvc mockMvc

    void setup(){
        hobby1 = new Hobby(name: 'piano', description: 'playing the piano')
        hobby2 = new Hobby(name: 'running', description: 'running')
        hobby3 = new Hobby(name: 'reading', description: 'reading literature')
        hobby4 = new Hobby(name: 'soccer', description: 'playing soccer')
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(documentationConfiguration()).build();
        hobbyRepository.save([hobby1, hobby2, hobby3, hobby4])
    }

    void 'get specific hobby by id'(){
        when:
        ResultActions response = mockMvc.perform(get("/hobbies/${hobby1.id}"))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('get-hobby-by-id'))
    }

    void 'get hobby/hobbies by name'(){
        when:
        ResultActions response = mockMvc.perform(get('/hobbies/search/findByName?name=piano'))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('get-hobbies-by-name'))
    }
}
