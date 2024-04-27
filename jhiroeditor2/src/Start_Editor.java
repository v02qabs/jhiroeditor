import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;


class Start_Editor{
	public Start_Editor(){}
	public void start_editor(String fname){
		System.out.println("open : " + fname);
		JFrame Main_Frame = Main_Panel();
		Main_Frame.setVisible(true);
	}
	private JFrame Main_Panel(){
		JFrame Main = new JFrame();
		Main.setBounds(0,0,900,900);
		return Main;
	}
}

