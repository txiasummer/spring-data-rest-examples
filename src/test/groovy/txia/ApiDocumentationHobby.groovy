package txia

import org.springframework.restdocs.RestDocumentation
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
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

    public final RestDocumentation restDocumentation = new RestDocumentation("target/generated-snippets")

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
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(documentationConfiguration(this.restDocumentation)).build();

        hobbyRepository.save([hobby1, hobby2, hobby3, hobby4])
    }

    void 'get specific hobby by id'(){
        when:
        MockHttpServletRequestBuilder builder = get("/hobbies")
        ResultActions response = this.mockMvc.perform(builder)

        then:
        response.andExpect(status().isOk())
        response.anDo(document('get-hobby-by-id'))
    }
//
//    void 'get hobby/hobbies by name'(){
//        when:
//        ResultActions response = mockMvc.perform(get('/hobbies/search/findByName?name=piano'))
//
//        then:
//        response.andExpect(status().isOk())
//        response.andDo(document('get-hobbies-by-name'))
//    }
}
