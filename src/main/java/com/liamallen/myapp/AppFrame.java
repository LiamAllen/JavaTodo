package com.liamallen.myapp;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
	
	public static GridLayout Layout; 
	public static int GridWidth;
	public static int GridHeight;
	public static int Width;
	public static int Height; 
	
	private JLabel TodoFormTitle;
	private JLabel TodoListTitle;
	
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
	    
	    ListPanel listPanel = new ListPanel();
	    this.add(listPanel);
	    
		//add a FormPanel to the object with label
		TodoFormTitle = new JLabel("Todo Item Form");
	    TodoFormTitle.setFont(new Font("Arial", Font.PLAIN, 30));
	    TodoFormTitle.setSize(300, 30);
	    this.add(TodoFormTitle);
	    
		FormPanel formPanel = new FormPanel();
		this.add(formPanel);
		
		//make the frame visible
		this.setVisible(true);
	}
	
}

