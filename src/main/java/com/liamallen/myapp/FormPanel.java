package com.liamallen.myapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.awt.*;

public class FormPanel extends JPanel implements ActionListener{

    // Components of the Form
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel description;
    private JTextArea tdescription;
    private JLabel duedate;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JButton sub;
    
    private DataHandler handler;
    
    private String dates[]
            = { "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31" };
        private String months[]
            = { "Jan", "feb", "Mar", "Apr",
                "May", "Jun", "July", "Aug",
                "Sup", "Oct", "Nov", "Dec" };
        private String years[]
            = { "1995", "1996", "1997", "1998",
                "1999", "2000", "2001", "2002",
                "2003", "2004", "2005", "2006",
                "2007", "2008", "2009", "2010",
                "2011", "2012", "2013", "2014",
                "2015", "2016", "2017", "2018",
                "2019", "2020", "2021", "2022",
                "2023", "2024", "2025", "2026",
                "2027", "2028", "2029", "2030",
                "2031", "2032", "2033", "2034",
                "2035", "2036", "2037", "2038"};
    
	public FormPanel() {
		// TODO Auto-generated constructor stub
		 this.setLayout(new FlowLayout());
	 
	     //create and add Name label and text field
	     name = new JLabel("Name");
	     name.setFont(new Font("Arial", Font.PLAIN, 20));
	     name.setSize(100, 20);
	     name.setLocation(100, 100);
	     this.add(name);
	 
	     tname = new JTextField(20);
	     tname.setFont(new Font("Arial", Font.PLAIN, 15));
	     tname.setLocation(200, 100);
	     this.add(tname);
	     
	     //create and add description label and text field
	     description = new JLabel("Desription");
	     description.setFont(new Font("Arial", Font.PLAIN, 20));
	     description.setSize(100, 20);
	     description.setLocation(100, 100);
	     this.add(description);
	 
	     tdescription = new JTextArea("Description", 5, 30);
	     tdescription.setFont(new Font("Arial", Font.PLAIN, 15));
	     tdescription.setLocation(200, 100);
	     this.add(tdescription);
	     
	     //create and add due date selectorand label
	     duedate= new JLabel("Task Due Date");
	     duedate.setFont(new Font("Arial", Font.PLAIN, 20));
	     duedate.setSize(100, 20);
	     duedate.setLocation(100, 250);
	     this.add(duedate);
	 
	     date = new JComboBox(dates);
	     date.setFont(new Font("Arial", Font.PLAIN, 15));
	     date.setSize(50, 20);
	     date.setLocation(200, 250);
	     this.add(date);
	 
	     month = new JComboBox(months);
	     month.setFont(new Font("Arial", Font.PLAIN, 15));
	     month.setSize(60, 20);
	     month.setLocation(250, 250);
	     this.add(month);
	 
	     year = new JComboBox(years);
	     year.setFont(new Font("Arial", Font.PLAIN, 15));
	     year.setSize(60, 20);
	     year.setLocation(320, 250);
	     this.add(year);
	     
	     //create and add submit button
	     sub = new JButton("Submit");
	     sub.setFont(new Font("Arial", Font.PLAIN, 15));
	     sub.setSize(100, 20);
	     sub.setLocation(150, 450);
	     sub.addActionListener(this);
	     this.add(sub);

	     this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		handler = new DataHandler();
		
		if (e.getSource() == sub) {
			ObjectNode todoItem = handler.createTodoItem(handler.createNewUUID() , tname.getText(), tdescription.getText(), handler.createDateTime(months[month.getSelectedIndex()], dates[date.getSelectedIndex()], years[year.getSelectedIndex()]));
			handler.appendToFile(todoItem);
        } else {
        	System.out.println("Someting went wrong");
        }
    }
 

}
