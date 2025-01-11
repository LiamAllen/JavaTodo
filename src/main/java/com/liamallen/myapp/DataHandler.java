package com.liamallen.myapp;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class DataHandler {

	public static String filePath = "todos.json"; 
	public static String emptyName = "No todo Items were Found";
	public static String emptyDescription = "";
	public static String emptyId = "empty";
	
	public DataHandler() {
		
	}
	
	public static String createNewUUID() {
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString();
		
		return uuidString;
	}
	
	public static ObjectNode createTodoItem(String id, String name, String description, ObjectNode dueDateTime) {

		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode object = objectMapper.createObjectNode();
		object.put("Id", id);
		object.put("Name", name);
		object.put("Description", description);
		object.put("DueDateTime", dueDateTime);
		
		return object;
		
	}
	
	public static ObjectNode createTodoItem(String id, String name, String description) {

		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode object = objectMapper.createObjectNode();
		object.put("Id", id);
		object.put("Name", name);
		object.put("Description", description);
		
		return object;
		
	}
	
	public static ObjectNode createDateTime(String month, String day, String year) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode object = objectMapper.createObjectNode();
		object.put("Month", month);
		object.put("Day", day);
		object.put("Year", year);
		
		return object;
	}
	
	public static ArrayNode readFromFile() {
		//try to read json data from file
		try {
			//read json data from file
			byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(jsonData);
			if(rootNode == null) {
				ArrayNode emptyNodeArray = objectMapper.createArrayNode();
				JsonNode emptyNode = createTodoItem(emptyId, emptyName, emptyDescription);
				emptyNodeArray.add(emptyNode);
				
				return emptyNodeArray;
				
			} else {
				System.out.println(objectMapper.writeValueAsString(rootNode));
				return (ArrayNode) rootNode;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void appendToFile(ObjectNode todo) {
		
		try {
			//read existing json data
			byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(jsonData);
			//if rootNode is null, create a new arrayNode and add todo item to it.
			if (rootNode == null) { 
				ArrayNode newArray = objectMapper.createArrayNode();
				newArray.add(todo);
				rootNode = newArray; 
			} else { //if rootNode is not null, check if it is an array
				if(rootNode.isArray()) {
					((ArrayNode) rootNode).add(todo);
				} else {
					//create a new array and add the existing and new objects
					ArrayNode newArray = objectMapper.createArrayNode();
					newArray.add(rootNode);
					newArray.add(todo);
					rootNode = newArray; 
				}
			}
			//write updated JSON to file
			try (FileWriter fileWriter = new FileWriter(filePath)) {
				objectMapper.writeValue(fileWriter, rootNode);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}