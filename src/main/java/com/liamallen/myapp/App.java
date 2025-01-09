package com.liamallen.myapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class App {

	public static int Width = 1920;
	public static int Height = 1080;
	public static int GridWidth = 3;
	public static int GridHeight = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AppFrame appFrame = new AppFrame(Width, Height, GridWidth, GridHeight);
		addTodoItem();
		getTodoItems();
	}
	
	public static void addTodoItem() {
		
		DataHandler handler = new DataHandler();
		ObjectNode dateTime = handler.createDateTime(2, 11, 2003, 5, 30);
		String uuid = handler.createNewUUID();
		ObjectNode todo = handler.createTodoItem(uuid, "Todo", "My Todo Description", dateTime);
		handler.appendToFile(todo);
	}
	
	public static void getTodoItems() {
		DataHandler handler = new DataHandler();
		ArrayNode node = handler.readFromFile();
	}

}
