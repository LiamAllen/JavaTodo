package com.liamallen.myapp;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
	
	public static GridLayout Layout; 
	public static int GridWidth;
	public static int GridHeight;
	public static int Width;
	public static int Height; 
	
	private JLabel title;
	
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
		
		title = new JLabel("Todo Item Form");
	    title.setFont(new Font("Arial", Font.PLAIN, 30));
	    title.setSize(300, 30);
	    title.setLocation(300, 30);
	    this.add(title);
		
		//add a FormPanel to the object
		FormPanel formPanel = new FormPanel();
		this.add(formPanel);
		//make the frame visible
		this.setVisible(true);
	}
	
}

