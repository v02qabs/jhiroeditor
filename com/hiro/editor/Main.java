package com.hiro.editor;

import javax.swing.*;


class Main extends JFrame{
	public static void main(String[] args){
		System.out.println("Hello editor.");
		new Main().initwindow();
		}
		public Main(){
			
			}
		private void initwindow(){
			setBounds(0,0,900,900);
			setTitle("Hello Editor");
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
}
