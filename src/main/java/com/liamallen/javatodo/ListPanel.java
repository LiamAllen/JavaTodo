package com.liamallen.javatodo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ListPanel extends JPanel{

	private ArrayNode TodoList;
	private DataHandler handler;
	
	public ListPanel() {
		
		getListItems();
		
		if (TodoList.size() > 1) {
			this.setLayout(new GridLayout((TodoList.size() / 2), (TodoList.size() / 2), 2, 2));
		} else if (TodoList.size() == 1) {
			this.setLayout(new GridLayout(1, 1, 2, 2));
		} else {
			this.setLayout(new GridLayout(1, 1, 2, 2));
		}
		
		this.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		
		for (JsonNode elementNode : TodoList) {
			//System.out.println(elementNode.get("Name").asText());
			String id = elementNode.get("Id").asText();
			String name = elementNode.get("Name").asText();
			String des = elementNode.get("Description").asText();
			String month = elementNode.get("DueDateTime").get("Month").asText();
			String day = elementNode.get("DueDateTime").get("Day").asText();
			String year = elementNode.get("DueDateTime").get("Year").asText();
			
			ListItem listItem = new ListItem(id, name, des, month, day, year);
			listItem.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
			listItem.setVisible(true);
			this.add(listItem);
		}
	}
	
	public void getListItems() {
		handler = new DataHandler();
		TodoList = handler.readFromFile();
		
	}
}
