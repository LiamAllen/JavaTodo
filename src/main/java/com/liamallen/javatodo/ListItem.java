package com.liamallen.javatodo;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class ListItem extends JPanel implements ActionListener{
	
	private String Id;
	private JLabel Name;
	private JTextArea Description;
	private JLabel DueDate;
	private JButton Delete;
	
	private DataHandler handler;
	
	public ListItem(String id, String name, String description, String dueMonth, String dueDay, String dueYear) {
		Id = id;
		Name = new JLabel(name);
		Description = new JTextArea();
		Description.setText(description);
		Description.setLineWrap(true);
		Description.setEditable(false);
		DueDate = createDueDateJLabel(dueMonth, dueDay, dueYear);
		
		Delete = new JButton("Delete");
	    Delete.setFont(new Font("Arial", Font.PLAIN, 15));
	    Delete.setSize(100, 20);
	    Delete.setLocation(150, 450);
	    Delete.addActionListener(this);
	    
		this.setLayout(new GridLayout(3, 1));
		this.add(Name);
		this.add(Description);
		this.add(DueDate);
		this.add(Delete);
		
		this.setVisible(true);
	}
	
	public JLabel createDueDateJLabel(String dueMonth, String dueDay, String dueYear) {
		
		JLabel dueDate = new JLabel("Due " + dueMonth + "/" + dueDay + "/" + dueYear);
		return dueDate;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		handler = new DataHandler();
		
		if (e.getSource() == Delete) {
			//handle button click here
			handler.deleteFromFile(this.Id);
        } else {
        	System.out.println("Someting went wrong");
        }
    }

}
