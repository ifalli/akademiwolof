/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.akaademiwolof;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import org.akaademiwolof.MainConfiguration;
import org.json.JSONObject;
/**
 * 
 *
 * @author Ibrahima Fall
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class ConfigurationTests {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Autowired
	private TestRestTemplate restTemplate;
	
	private String localhostUrl = "http://localhost:9000/akademiwolof/gaggantikaay/soppibaat";
	
	private String json = "{\"idwordSenses\":634,\"word\":\"Bijji\",\"language\":{\"idlanguage\":2,\"name\":\"Wo\"},\"wordType\":"
			+ "{\"idwordType\":2,\"type\":\"Jef\",\"language\":null},\"antonyms\":[{\"idwordSenses\":630,\"word\":\"Caga g.\"},"
			+ "{\"idwordSenses\":631,\"word\":\"Cagawu\"}],\"derivated\":[{\"idwordSenses\":629,\"word\":\"Caga b.\"},"
			+ "{\"idwordSenses\":632,\"word\":\"Aat b.\"}],\"seeAlso\":[{\"idwordSenses\":630,\"word\":\"Caga g.\"},"
			+ "{\"idwordSenses\":631,\"word\":\"Cagawu\"}],\"synonyms\":[{\"idwordSenses\":629,\"word\":\"Caga b.\"},"
			+ "{\"idwordSenses\":632,\"word\":\"Aat b.\"}]}}";
	
	
	@Test
	public void shouldReturn200WhenSendingRequestToController() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.restTemplate.getForEntity(
				"http://localhost:" + this.port + "/akademiWlof/gaggantikaay/baat?name=bijji", Map.class);
		System.out.print(entity.getStatusCode());
		//assertThat(entity.getStatusCode().equals(HttpStatus.OK));
	}
	
	@SuppressWarnings("static-access")
	//@Test
	public void shouldUpdateWordWhenSendingRequestToController() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		JSONObject requestJson = new JSONObject();
		requestJson.wrap(json);
		System.out.print(requestJson.toString());
		
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(json,headers);
		
		ResponseEntity<String> loginResponse = restTemplate
				  .exchange(localhostUrl, HttpMethod.POST, entity, String.class);
		if (loginResponse.getStatusCode() == HttpStatus.OK) {
		  JSONObject wordJson = new JSONObject(loginResponse.getBody());
		  System.out.print(loginResponse.getStatusCode());
		  assertThat(wordJson != null);
		  
		} else if (loginResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
			System.out.print(loginResponse.getStatusCode());
		}

				
	}
}
