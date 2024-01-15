import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class editor
{
	public editor()
	{
		//new winpanel();
	}
	public static void main(String[] args)
	{
		System.out.println("Hello.\n");
		try{
			System.out.println("args: " + args[0]);
			String filename = args[0];
			new winpanel(filename);
		}
		catch(Exception error)
		{
			System.out.println("引数がnullです。");
			new winpanel(null);
		}

	}
}


class winpanel extends JFrame implements ActionListener
{
	String fname;
	String filename;
	private String get_filename(){
		return this.fname = filename;
	}
	private void set_filename(String file_name){
		this.filename = file_name;
		this.fname = filename;
	}
	

	public winpanel(String filename)
	{
		System.out.println("filename : " + filename);
		if(filename == null)
		{
			System.out.println("引数がnullです。");
		}
		set_filename(filename);
		setBounds(0,0,500,500);
		setTitle("jpad ver 0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		past();
		file_open();
		setVisible(true);
	}
	private void file_open()
	{
		System.out.println("get filename " + fname);
		setTitle("jhiropad: ファイル：" + fname);
		//edit = new JTextArea();		
		try{
			File f = new File(fname);
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			while(line != null){
				System.out.println("k " + line);

				edit.append(line + "\n");
				line = br.readLine();
				
				
			}
			//add(edit);
		}
		catch(Exception error)
		{
			System.out.println("ファイル読み込みエラー");
			System.out.println(error.toString());
		}


			
	}
	
	private JTextArea edit;
	private JButton save;
	private void  past()
	{
		edit = new JTextArea();
		save = new JButton("save");
		save.addActionListener(this);		
		JPanel all_panel = new JPanel();	
		JPanel control_panel = new JPanel();
		GridLayout control = new GridLayout(1,2);	
		GridLayout layout = new GridLayout(2,1);
		control_panel.setLayout(control);
		all_panel.add(control_panel);
		control_panel.add(save);
		all_panel.setLayout(layout);
		
		all_panel.add(control_panel);
		all_panel.add(edit);
		Container  contents = getContentPane();
		contents.add(all_panel);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("typed subject.");
		if(e.getSource() == save)
			save();
		else
			error();

	}
	private void new_file(){
	System.out.println("新規作成");
	setTitle("新規");
	
	}
	
	private void save()
	{
	try{	
		System.out.println("save");
		String sub = edit.getText().toString();
		System.out.println("g : " + sub);
		File save_file = new File(get_filename());
		BufferedWriter writer = new BufferedWriter(new FileWriter(save_file));
		writer.write(sub);
		writer.close();
	}
	catch(Exception error)
	{error();}
	}
	private void error()
	{
		System.out.println("error");
	}
}

