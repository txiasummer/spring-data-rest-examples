package hello

import hello.dao.HobbyRepository
import hello.domain.Hobby
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

    MockMvc mockMvc

    void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(documentationConfiguration()).build();
        hobbyRepository.save([
                new Hobby(id: 1, name: 'piano', description: 'playing the piano'),
                new Hobby(id: 2, name: 'running', description: 'running'),
                new Hobby(id: 3, name: 'reading', description: 'reading literature'),
                new Hobby(id: 4, name: 'soccer', description: 'playing soccer')
        ])
    }

    void 'get specific hobby by id'(){
        when:
        ResultActions response = mockMvc.perform(get('/hobbies/1'))

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
