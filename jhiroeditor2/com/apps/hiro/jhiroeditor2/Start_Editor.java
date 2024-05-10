package com.apps.hiro.jhiroeditor2;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;


class Start_Editor{
	public Start_Editor(){}
	public void start_editor(String fname){
		System.out.println("open : " + fname);
		JFrame Main_Frame = Main_Frame();
		Main_Frame.setVisible(true);
	}
	private JFrame Main_Frame(){
		JFrame Main = new JFrame();
		Main.setBounds(0,0,900,900);
		Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel main_panel = Main_Panel();
		Main.add(main_panel);
		return Main;
	}
	private JPanel Main_Panel()
	{
		JPanel panel = new JPanel();
		JTextArea area = new JTextArea();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(area);
		return panel;
	}

}
