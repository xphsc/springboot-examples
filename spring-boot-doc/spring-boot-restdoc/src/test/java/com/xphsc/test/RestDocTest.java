package com.xphsc.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xphsc.restdocs.RestDocApplication;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.snippet.Attributes;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RestDocApplication.class)
@WebAppConfiguration
public class RestDocTest {
    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(documentationConfiguration(restDocumentation)
                )
                .build();
    }

    @Test
    public void index() throws Exception {
        ResultActions resultActions = mockMvc.perform(RestDocumentationRequestBuilders.get("/")).andExpect(status().isOk())
                .andDo(document("index-links", links(
                                linkWithRel("carapi:cars").description("The <<cars,Car resources>>"),
                                linkWithRel("curies").description("Curies for documentation"),
                                linkWithRel("profile").description("The ALPS profile for the service")
                        ),
                        responseFields(fieldWithPath("_links").description("<<index-links-links,Links>> to other resources"))
                ));
    }


    @Test
    public void cars() throws Exception {
        final ResultActions resultActions = mockMvc.perform(RestDocumentationRequestBuilders.get("/cars")).andExpect(status().isOk())
                .andDo(document("car-list", links(
                                linkWithRel("self").ignored(),
                                linkWithRel("profile").description("The ALPS profile for the service"),
                                linkWithRel("curies").ignored()
                        ),
                        responseFields(
                                fieldWithPath("_embedded.carapi:cars").description("A list of <<cars, Car resources>>"),
                                fieldWithPath("_links").description("<<cars-links,Links>> to other resources")
                        )

                ));
    }

    @Test
    public void createCar() throws Exception {

        Map<String, Object> car = new HashMap<>();
        car.put("id", 1);
        car.put("id_car", 1);
        car.put("id_user", 1);
        car.put("is_default", true);
        car.put("created_at", new Date());
        car.put("brand", "Peugeot");
        car.put("model", "206");

        mockMvc.perform(post("/cars")
                .content(objectMapper.writeValueAsString(car)))
                .andExpect(status().isCreated())
                .andDo(document("car-create",
                        requestFields(
                                fieldWithPath("id").description("id of your car"),
                                fieldWithPath("id_car").description("another id of your car"),
                                fieldWithPath("id_user").description("id of the user"),
                                fieldWithPath("is_default").description("is this the default car?"),
                                fieldWithPath("created_at").description("creation date"),
                                fieldWithPath("brand").description("Brand of your car"),
                                fieldWithPath("model").description("Model of your car")
                                        .attributes(Attributes.key("constraints").value("must provide a `name` property")))));
    }

}
