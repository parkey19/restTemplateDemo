package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RestApplicationTests {
	RestTemplate restTemplate;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before
    public void setUp() {

        restTemplate = new RestTemplate();

    }
	
//	@Test
//	public void contextLoads() {
//	
//	}
	
//	@Test
//	public void testGet() {
//		String url ="https://httpbin.org/get";
//		
//		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
//		String result = response.getBody();
//		logger.info("result ::::::::::::::: {}" ,result);
//		assertThat(result, containsString("https://httpbin.org/get"));
//			
//	}
	
	@Test
	public void testPost() throws JSONException {
		String url ="https://httpbin.org/post";
		
		JSONObject json = new JSONObject();
		json.put("name", "park");
		json.put("age", 18);
		
		String requestJson = "{\"queriedQuestion\":\"Is there pain in your hand?\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
		ResponseEntity<URL> response = restTemplate.exchange(url, HttpMethod.POST, entity, URL.class);
		URL result = response.getBody();
		assertThat(result.getUrl(), is("https://httpbin.org/post"));
		logger.info("result #### {}" ,result);
			
	}

}
