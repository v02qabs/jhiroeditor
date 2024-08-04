import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class save_as extends JFrame{
	public save_as(String fname, String get_text){
		this.file = fname;
		this.text = get_text;
	}
	//private String file, text;
	public static void main(String[] args){
		try{
			String  fname = args[1];
			try{
				String text = args[2];
				new save_as(fname ,text);
			}
			catch(Exception error){
				new save_as(fname, null);
			}

		}
		catch(Exception error){
			new save_as(null, fname);
		}
	}
	private void init(){
		setBounds(0,0,900,900);
		setTitle("Hello choose as_save");
		}

}

