package com.blogspot.vardlokkur.httpmessageconverter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(TeamDetailsController.class)
public class TeamDetailsControllerExpectations {

    @Autowired
    private MockMvc mvc;
    
    @Test
    public void readRaw() throws Exception {
        mvc.perform(get("/teams/1/").accept(MediaType.APPLICATION_JSON))
           .andDo(print());
    }

    @Test
    public void readXls() throws Exception {
        mvc.perform(get("/teams/1/").accept(MediaType.valueOf("application/vnd.ms-excel")))
           .andDo(print());
    }

}
