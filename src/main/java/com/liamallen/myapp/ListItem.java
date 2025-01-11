package com.liamallen.myapp;

import java.awt.GridLayout;

import javax.swing.*;

public class ListItem extends JPanel {
	
	private JLabel Name;
	private JLabel Description;
	private JLabel DueDate;
	
	public ListItem(String name, String description, String dueMonth, String dueDay, String dueYear) {
		
		Name = new JLabel(name);
		Description = new JLabel(description);
		DueDate = createDueDateJLabel(dueMonth, dueDay, dueYear);
		
		this.setLayout(new GridLayout(3, 1));
		this.add(Name);
		this.add(Description);
		this.add(DueDate);
		
		this.setVisible(true);
	}
	
	public JLabel createDueDateJLabel(String dueMonth, String dueDay, String dueYear) {
		
		JLabel dueDate = new JLabel("Due " + dueMonth + "/" + dueDay + "/" + dueYear);
		return dueDate;
	}

}
