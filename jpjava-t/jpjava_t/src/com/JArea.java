package com;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;


class JArea extends JTextArea{
	public void show(String message){
		System.out.println(message);
	}
	public JArea(){
	}
	public void settings(){
		setBounds(0,0,500,500);
		addKeyListener(new KeyListener(){
   @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("yy");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("yy");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("yy");
    }

		});
		
		}
		
}

