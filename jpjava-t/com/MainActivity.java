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
		
		JAdd add_p = new JAdd();
		add_p.setLayout(new BoxLayout(add_p, BoxLayout.X_AXIS));
		add(add_p);
		setBounds(0,0,900,900);
		
		setVisible(true);
	}
}

