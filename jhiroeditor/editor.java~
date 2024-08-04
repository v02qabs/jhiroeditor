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


class winpanel extends JFrame
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
	private static void printInputStream(InputStream is) throws IOException {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			for(;;){
				String line;
				line = br.readLine();
				if(line == null) break;
				System.out.println(line);
			}
			br.close();
		}
		catch(Exception error){
			System.out.println("command exec error: " + error.toString());
		}
	}
	
	private JTextArea edit;
	private JButton save, new_files_button, open_file_button;
	private void  past()
	{
		edit = new JTextArea();
		edit.setFont(new Font("Arial", Font.PLAIN, 16));
		  JScrollPane scrollpane = new JScrollPane(edit);
    scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		JMenuBar menubar = new JMenuBar();		
		JMenu file_menu = new JMenu("ファイル")	;
		JMenu perl_exec = new JMenu("実行");
		menubar.add(file_menu);
		menubar.add(perl_exec);
		JMenuItem open_file_button = new JMenuItem("開く");
		JMenuItem ExecPerl = new JMenuItem("Perlファイルの実行");
		JMenuItem Java_EXEC = new JMenuItem("Javaプログラムの構成＆実行");
		file_menu.add(open_file_button);
		
		perl_exec.add(ExecPerl);
		perl_exec.add(Java_EXEC);
		Java_EXEC.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println ("Java プログラムの構成と実行");
				new jexec().initalized_file(fname);
			}
		});
		ExecPerl.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("Perl " + get_filename() + " を実行します。");
				try{
					Process pro = Runtime.getRuntime().exec("perl " + "./" + get_filename() );
					pro.waitFor();
					printInputStream(pro.getInputStream());
					printInputStream(pro.getErrorStream());
				}
				catch(Exception error)
				{
					System.out.println("error " + error.toString());
				}

			}
		});
		open_file_button.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("開く");
					open();
				}
		});
		JMenuItem save = new JMenuItem("保存");
		file_menu.add(save);
		save.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("保存");
					as_save();
				}
		});
		
		JMenuItem override_menu = new JMenuItem("上書き保存");
		file_menu.add(override_menu);
		override_menu.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("上書き保存");
					save();
				}
		});
		JMenuItem new_file_button = new JMenuItem("新規");
		file_menu.add(new_file_button);
		new_file_button.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("新規");
					new_file();
				}
		});
		JMenuItem overwrite = new JMenuItem("名前をつけて保存");
		file_menu.add(overwrite);
		overwrite.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("名前を付けて保存");
				as_save();
			}
		});
		JMenuItem finish_app = new JMenuItem("終了");
		file_menu.add(finish_app);
		finish_app.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("finish.");
				System.exit(0);
			}
		});

		JPanel all_panel = new JPanel();
		setJMenuBar(menubar);
			
		JPanel control_panel = new JPanel();
		GridLayout control = new GridLayout(3,1);
		GridLayout layout = new GridLayout(1,2);
		control_panel.setLayout(control);
		all_panel.setLayout(layout);
		
		all_panel.add(scrollpane);
		Container  contents = getContentPane();
		contents.add(all_panel);
	}
	private void as_save(){
			System.out.println("as save.");
			String getString = edit.getText().toString();
			System.out.println(getString);
			try{
				getString = edit.getText().toString();
				//Process p = Runtime.getRuntime().exec("java fchooser . " + getString);
				new stream_cons().start_command("java fchooser " , "./" , getString);
				
			}
			catch(Exception error){
					System.out.println("error : " + error.toString());
			}

		}
		
	private void open(){
			System.out.println("open");
			String os;
			try{
				System.out.println("os name: " + System.getProperty("os.name"));
				os = System.getProperty("os.name");
				
				if(os.equals("Linux")){
					//Process r =  Runtime.getRuntime().exec("java -jar /usr/share/java/fchooser.jar .");
					new execute().exec("java -jar /usr/share/java/fchooser.jar .");
				}
				else{
					Process rc = Runtime.getRuntime().exec("java -jar c:/jhiroeditor/fchooser.jar .");
				}
			}catch(Exception error)
			{
				System.out.println("Runtime error");
			}
		
	}
	
	private void new_file(){
		System.out.println("新規作成");
		setTitle("新規");
		set_filename(null);
		//edit = new JTextArea();
		edit.setText("");
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
		catch(java.lang.NullPointerException no_found_file)
		{
			System.out.println("not found_file.");
			new FilenameNull().initalized_frame();
		}
		catch(IOException ioerror)
		{
			System.out.println("IOException error");
		}
	}

	private void error()
	{
		System.out.println("error");
	}
	
}

class jexec extends JFrame{
	public jexec(){}
	public void initalized_file(String fname){
		System.out.println("構成");
		setSize(600,600);
		setLayout(null);
		JLabel java_file_label = new JLabel();
		java_file_label.setBounds(10,10,300,30);
		java_file_label.setText("開いているファイル名：" + new File(fname).getAbsolutePath());
		add(java_file_label);
		System.out.println("開いているファイル名：" + new File(fname).getAbsolutePath());
		//バイナリコードの生成先を指定する
		JLabel bin_code_label = new JLabel("スクリプト生成先: ");
		bin_code_label.setBounds(10,10,300,30);
		add(bin_code_label);
		JButton code_make_to_file_button = new JButton("生成先");
		code_make_to_file_button.setBounds(10+300, 10,300,30);
		code_make_to_file_button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
			}
		}
		);
		add(code_make_to_file_button);
		setVisible(true);
		
	}
}

class FilenameNull extends JFrame{
	public FilenameNull(){
	}
	public void initalized_frame(){
		System.out.println("file is null name.");
		try{
			Process file_chooser = Runtime.getRuntime().exec("java fchooser .");
		}
		catch(Exception error){
			System.out.println("exec error");
		}

	}
}


