import java.io.*;
import java.lang.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class viewports extends JFrame{
	public viewports(){
		init();
	}
	public static void main(String[] args)
	{
		System.out.println("hello");
		new viewports();
	}

	private void init(){
		setBounds(0,0,600,600);
		setTitle("viewports");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parts();
		setVisible(true);
	}
	private void parts(){
		JTextArea text = new JTextArea();
		DefaultListModel model = new DefaultListModel();
		model.addElement("item");
		JList lists = new JList(model);
		lists.setBounds(0,0,100,30);
		
		text.setViewportView(lists);
		add(text);
	}
}





