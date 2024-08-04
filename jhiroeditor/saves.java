import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import  javax.swing.*;

class saves extends JFrame{
	public saves(String gtext){
		get_text(gtext);
	}
	public static void main(String[] args){
		new saves(args[0]);
	}
	public void get_text(String GetText){
		try{
			setBounds(0,0,900,900);
			setLayout(null);
			setTitle("Hello Save new");
			JLabel save_fname_label = new JLabel("ファイル名：");
			save_fname_label.setBounds(0,0,100,30);
			JTextField fname_field = new JTextField();
			fname_field.setBounds(110,0,100,30);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 			
			JButton button = new JButton("save");
			button.setBounds(0,40,100,30);
			button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
			try{
			String line;
			System.out.println("getText : " + GetText);
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(get_dir() + "/" + fname_field.getText().toString())));
			bw.write(GetText);
			bw.close();
			}
			catch(Exception error){
				System.out.println("save error "+ error.toString());
			}
			}});
		
			add(save_fname_label);
			add(fname_field);
			add(button);
			setVisible(true);
		}
		catch(Exception error){
			System.out.println("error : " + error.toString());
		}
	}
	private String get_dir(){
		String dir = null;

		try{
			BufferedReader br = new BufferedReader(new FileReader(new File("/home/takesue/write_dir.txt")));
			dir = br.readLine();
			return dir;
		}
		catch(Exception error){
			System.out.println("error : " + error.toString());
		}
		return dir;
	}
}
