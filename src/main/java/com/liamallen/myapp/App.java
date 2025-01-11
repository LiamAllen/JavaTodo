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
		AppFrame appFrame = new AppFrame(Width, Height, GridWidth, GridHeight);
		getTodoItemsForConsole();
	}
	
	public static void getTodoItemsForConsole() {
		DataHandler handler = new DataHandler();
		ArrayNode node = handler.readFromFile();
	}

}
