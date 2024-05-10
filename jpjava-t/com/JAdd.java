package com;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;


class JAdd extends JPanel{
	public void show(String message){
		System.out.println(message);
	}
	public JAdd(){
	}
	public void settings(){
		setBounds(0,0,400,400);
		JTextArea area = new JTextArea();
		area.setLayout(new BoxLayout(area, BoxLayout.X_AXIS));
		add(area);
		
			
			
	}
}

