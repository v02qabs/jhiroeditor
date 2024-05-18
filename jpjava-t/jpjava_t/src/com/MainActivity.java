package com;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;


class MainActivity extends JFrame{
	public MainActivity(){
	}
	public void Frame(){
		setTitle("jptest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea area = new JTextArea();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(area);
		setBounds(0,0,900,900);
		add(panel);
		setVisible(true);
	}
}

