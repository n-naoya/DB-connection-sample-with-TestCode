package com.example.server;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UserControllerTest {

    private UserRepositoryStub userRepo;
    private MockMvc mockController;

    @Before
    public void setup() {
        userRepo = new UserRepositoryStub();
        UserController userController = new UserController(userRepo);
        mockController = standaloneSetup(userController).build();
    }

    @Test
    public void status_of_getAll_method_is_ok() throws Exception {
        mockController.perform(get("/api/users"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAll_method_of_Repo_was_called() throws Exception {
        assertThat(false, equalTo(userRepo.getAllWasCalled));


        mockController.perform(get("/api/users"));


        assertThat(true, equalTo(userRepo.getAllWasCalled));
    }

    @Test
    public void status_of_get_is_ok() throws Exception {
        mockController.perform(get("/api/users/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void get_method_of_Repo_was_called() throws Exception {
        assertThat(false, equalTo(userRepo.getWasCalled));


        mockController.perform(get("/api/users/1"));


        assertThat(true, equalTo(userRepo.getWasCalled));
    }
}
