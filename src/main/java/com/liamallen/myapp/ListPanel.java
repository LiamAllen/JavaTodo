package com.liamallen.myapp;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class ListPanel extends JPanel {

	private ArrayNode TodoList;
	private DataHandler handler;
	
	public ListPanel() {
		
		getListItems();
		this.setLayout(new GridLayout((TodoList.size() / 2), (TodoList.size() / 2), 2, 2));
		this.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		
		for (JsonNode elementNode : TodoList) {
			//System.out.println(elementNode.get("Name").asText());
			String name = elementNode.get("Name").asText();
			String des = elementNode.get("Description").asText();
			String month = elementNode.get("DueDateTime").get("Month").asText();
			String day = elementNode.get("DueDateTime").get("Day").asText();
			String year = elementNode.get("DueDateTime").get("Year").asText();
			
			ListItem listItem = new ListItem(name, des, month, day, year);
			listItem.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
			listItem.setVisible(true);
			this.add(listItem);
		}
	}
	
	private void getListItems() {
		handler = new DataHandler();
		TodoList = handler.readFromFile();
		
	}
}
