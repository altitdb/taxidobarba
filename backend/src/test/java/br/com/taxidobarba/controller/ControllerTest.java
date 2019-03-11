package br.com.taxidobarba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class ControllerTest {

	@Autowired
	protected MockMvc mockMvc;
	@Autowired
	protected ObjectMapper mapper;
	@Autowired
	protected WebApplicationContext webApplicationContext;

	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
}
