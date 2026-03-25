package com.mytests.spring.springsecurity7test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AdminController.class)
@Import(SecurityConfig.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(roles = "ADMIN")
    void adminRoot_withAdminRole_returnsOkAndBody() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(content().string("admin root"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void adminTest1_withAdminRole_returnsOkAndBody() throws Exception {
        mockMvc.perform(get("/admin/test1"))
                .andExpect(status().isOk())
                .andExpect(content().string("admin test1"));
    }

    @Test
    @WithMockUser(roles = "MASTER")
    void adminRegex_withMasterRole_returnsOkAndBody() throws Exception {
        mockMvc.perform(get("/admin/regex111"))
                .andExpect(status().isOk())
                .andExpect(content().string("admin regex111"));
    }


    @Test
    void adminRoot_withoutAuth_returnsUnauthorized() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = "USER")
    void adminTest1_withUserRole_returnsForbidden() throws Exception {
        mockMvc.perform(get("/admin/test1"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void adminRegex_withAdminRole_returnsForbidden() throws Exception {
        mockMvc.perform(get("/admin/regex111"))
                .andExpect(status().isForbidden());
    }
}
