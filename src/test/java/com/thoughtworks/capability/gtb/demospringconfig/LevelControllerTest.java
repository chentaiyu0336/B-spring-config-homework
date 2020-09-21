package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class LevelControllerTest {
    @Autowired
    private LevelController levelController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test1() throws Exception {
        ReflectionTestUtils.setField(levelController,"levelNumber",0);
        mockMvc.perform(get("/level")).andExpect(jsonPath("$",is("basic")));
    }

    @Test
    public void test2() throws Exception {
        ReflectionTestUtils.setField(levelController,"levelNumber",1);
        mockMvc.perform(get("/level")).andExpect(jsonPath("$",is("advanced")));
    }

    @Test
    public void test3() throws Exception {
        ReflectionTestUtils.setField(levelController,"levelNumber",2);
        mockMvc.perform(get("/level")).andExpect(jsonPath("$",is("advanced")));
    }
}
