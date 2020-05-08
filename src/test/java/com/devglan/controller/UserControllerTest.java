package com.devglan.controller;


// this static must add manually !
import static org.junit.Assert.assertNotEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.devglan.model.user.User;
import com.devglan.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;





@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    public WebApplicationContext context;
    public MockMvc mockMvc;

    @Mock
    private UserServiceImpl userServiceImpl;

    User mockUser = new User(1, "Ahmed", "FERCHICHI",
            "ferchichy.ahmed@gmail.com", "password", "typeUser");

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public  void controllerTest () throws Exception {

        Mockito.when(userServiceImpl.findById(Mockito.anyInt())).thenReturn(mockUser);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().is(404)).andReturn();

        String expected = "{id:1,firstName:Ahmed,lastName:FERCHICHI," +
                "email:ferchichy.ahmed@gmail.com,password:password}";

        assertNotEquals(expected, result.getResponse().getContentAsString());

        System.out.println("test controller ");
    }

}
