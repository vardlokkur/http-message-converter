package com.blogspot.vardlokkur.httpmessageconverter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(TeamDetailsController.class)
public class TeamDetailsControllerExpectations {

    private static final MediaType XLS_TYPE = MediaType.valueOf("application/vnd.ms-excel");

    @Autowired
    private MockMvc mvc;

    @Test
    public void readRaw() throws Exception {
        mvc.perform(get("/teams/1/").accept(APPLICATION_JSON))
           // .andDo(print())
           .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
           .andExpect(jsonPath("$.members").isArray());
    }

    @Test
    public void readXls() throws Exception {
        mvc.perform(get("/teams/1/").accept(XLS_TYPE))
           // .andDo(print())
        .andExpect(content().contentType(XLS_TYPE));
    }

}
