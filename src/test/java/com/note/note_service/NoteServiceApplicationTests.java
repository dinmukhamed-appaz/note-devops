package com.note.note_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class NoteServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void root() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string("Note service is running"));
	}

	@Test
	void healthz() throws Exception {
		mockMvc.perform(get("/healthz"))
				.andExpect(status().isOk())
				.andExpect(content().string("OK"));
	}

	@Test
	void getNotes() throws Exception {
		mockMvc.perform(get("/notes"))
				.andExpect(status().isOk());
	}

	@Test
	void createNote() throws Exception {
		mockMvc.perform(post("/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"title\":\"Buy milk\",\"content\":\"2 liters\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("Buy milk"))
				.andExpect(jsonPath("$.content").value("2 liters"));
	}

	@Test
	void deleteNote() throws Exception {
		mockMvc.perform(post("/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"title\":\"Temp\",\"content\":\"to delete\"}"))
				.andExpect(status().isOk());

		mockMvc.perform(delete("/delete/0"))
				.andExpect(status().isOk());
	}
}