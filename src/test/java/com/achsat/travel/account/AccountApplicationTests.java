package com.achsat.travel.account;

import com.achsat.travel.account.controller.AccountController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testFetchAccount1() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/account/1")).andExpect(status().isOk());
	}

}
