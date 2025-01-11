package com.liamallen.javatodo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame implements ActionListener{
	
	public static GridLayout Layout; 
	public static int GridWidth;
	public static int GridHeight;
	public static int Width;
	public static int Height; 
	
	public ListPanel listPanel;
	
	private JLabel TodoFormTitle;
	private JLabel TodoListTitle;
	private JButton refresh;
	private JTextArea infoPanel;
	private String info = "Welcome to JavaTodo! Take a look at the 'todo list' section to view your todo items. "
			+ "You can also create todo list items using the 'todo form' section. Finally,"
			+ "you can check items of your list by clicking the 'delete' button under the desired item."
			+ "please email liamallen.lp+support@gmail.com for any issues or concerns regarding this app.";
			
	
	public AppFrame(int width, int height, int gridWidth, int gridHeight) {
		
		Width = width;
		Height = height;
		GridWidth = gridWidth;
		GridHeight = gridHeight; 
		
		//set the width and height of the GridLayout object and assign it as the layout manager of the JFrame
		Layout = new GridLayout(GridHeight, GridWidth);
		this.setLayout(Layout);
		
		//set the JFrame size and close operation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		
		//add ListPanel to the object with label
		TodoListTitle = new JLabel("Todo Items");
	    TodoListTitle.setFont(new Font("Arial", Font.PLAIN, 30));
	    TodoListTitle.setSize(300, 30);
	    this.add(TodoListTitle);
	    
	    listPanel = new ListPanel();
	    this.add(listPanel);
	    
		//add a FormPanel to the object with label
		TodoFormTitle = new JLabel("Todo Item Form");
	    TodoFormTitle.setFont(new Font("Arial", Font.PLAIN, 30));
	    TodoFormTitle.setSize(300, 30);
	    this.add(TodoFormTitle);
	    
		FormPanel formPanel = new FormPanel();
		this.add(formPanel);
		
	    //add refresh button
		refresh = new JButton("refresh");
	    refresh.setFont(new Font("Arial", Font.PLAIN, 15));
	    refresh.setSize(100, 20);
	    refresh.setLocation(150, 450);
	    refresh.addActionListener(this);
	    
	    this.add(refresh);
	    
	    //add info panel
	    infoPanel = new JTextArea();
	    infoPanel.setText(info);
	    infoPanel.setEditable(false);
	    infoPanel.setFont(new Font("Arial", Font.PLAIN, 25));
	    infoPanel.setLineWrap(true);
	    this.add(infoPanel);
		
		//make the frame visible
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == refresh) {
			App.createAppFrame();
			this.dispose();
        } else {
        	System.out.println("Someting went wrong");
        }
	}
}

