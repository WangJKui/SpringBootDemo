package com.wjk.boot.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileTest {
	@Test
	public void contextLoads() {
	}

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	/**
	 * 在每次测试执行前构建mvc环境
	 */
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	/**
	 * 测试上传文件
	 */
	@Test
	public void whenUploadFileSuccess() {
		try {
			String result =  mockMvc.perform(
					MockMvcRequestBuilders
					.fileUpload("/file")
					.file(
							new MockMultipartFile("file", "test.txt", ",multipart/form-data", "hello upload".getBytes("UTF-8"))
							)
					).andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn().getResponse().getContentAsString();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
