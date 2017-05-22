package com.balaji.json;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	private static String jsonString = "{\n" + 
			"  \"_links\" : {\n" + 
			"    \"self\" : {\n" + 
			"      \"href\" : \"http://localhost:8080/people{?page,size,sort}\",\n" + 
			"      \"templated\" : true\n" + 
			"    },\n" + 
			"    \"search\" : {\n" + 
			"      \"href\" : \"http://localhost:8080/people/search\"\n" + 
			"    }\n" + 
			"  },\n" + 
			"  \"_embedded\" : {\n" + 
			"    \"persons\" : [ {\n" + 
			"      \"firstName\" : \"Frodo\",\n" + 
			"      \"lastName\" : \"Baggins\",\n" + 
			"      \"_links\" : {\n" + 
			"        \"self\" : {\n" + 
			"          \"href\" : \"http://localhost:8080/people/1\"\n" + 
			"        }\n" + 
			"      }\n" + 
			"    } ]\n" + 
			"  },\n" + 
			"  \"page\" : {\n" + 
			"    \"size\" : 20,\n" + 
			"    \"totalElements\" : 1,\n" + 
			"    \"totalPages\" : 1,\n" + 
			"    \"number\" : 0\n" + 
			"  }\n" + 
			"}";
	
	public static void main(String args[]) {
		System.out.println(jsonString);
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			//Person person = objectMapper.readValue(jsonString, Person.class);
			//System.out.println(person.getFirstName());
			
			//List<Person> persons = objectMapper.readValue(jsonString, new TypeReference<List<Person>>(){});
			//System.out.println(persons.get(0).getFirstName());
			
			JsonNode json = objectMapper.readTree(jsonString);
			
			JsonNode persons = json.findValue("persons");
			
			if(persons.isArray()) {
				for(JsonNode jsonNode : persons) {
					Person person = objectMapper.treeToValue(jsonNode, Person.class);
					System.out.println(person.getFirstName());
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
