package txia

import org.junit.Rule
import org.springframework.http.MediaType
import org.springframework.restdocs.RestDocumentation
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

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ContextConfiguration(classes=[Application], initializers = ConfigFileApplicationContextInitializer)
@WebAppConfiguration
class ApiDocumentationHobby extends Specification {

    @Rule
    public final RestDocumentation restDocumentation = new RestDocumentation('build/generated-snippets')

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
        hobbyRepository.save([hobby1, hobby2, hobby3, hobby4])

        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(documentationConfiguration(this.restDocumentation)).build()
    }

    void 'get specific hobby by id'(){
        when:
        ResultActions response = this.mockMvc.perform(get('/hobbies').accept(MediaType.APPLICATION_JSON))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('get-hobby-by-id'))
    }

    void 'get hobby/hobbies by name'(){
        when:
        ResultActions response = mockMvc.perform(get('/hobbies/search/findByName?name=piano').accept(MediaType.APPLICATION_JSON))

        then:
        response.andExpect(status().isOk())
        response.andDo(document('get-hobbies-by-name'))
    }
}
