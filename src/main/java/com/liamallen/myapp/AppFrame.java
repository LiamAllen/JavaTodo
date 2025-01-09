package com.liamallen.myapp;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
	
	public static GridLayout Layout; 
	public static int GridWidth;
	public static int GridHeight;
	public static int Width;
	public static int Height; 
	
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
		
		//add a label to the object
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		JButton button = new JButton("Submit");
		JLabel label = new JLabel("Enter text into the text field, then click 'submit'. ");
		
		this.add(label);
		this.add(scrollPane);
		this.add(button);
		
		//make the frame visible
		this.setVisible(true);
	}
	
	public static void addComponents() {


	}
}
