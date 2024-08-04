import java.io.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;


public class fchooser extends JFrame implements ListSelectionListener
{	//String  path;
	public static void main(String[] args)
	{
		System.out.println("Hello");
		
		try{
			String path = args[0];
			String getText = args[1];
			new fchooser(path, getText);
			System.out.println(path + " / " + getText);
		
		}
		catch(Exception error){
			String path = args[1];
			new fchooser(path, null);
		}
		
	}
	public String  string;
	public void set_String(String setText){
			string = setText;
			
	}

	public String get_String(){
			 string = get_String();
			return string;
	}
	
	public fchooser(String path, String getText)
	{
		init(path, getText);
		set_String(getText);
	}
	JPanel all_panel, control_panel;
	JList list1;
	DefaultListModel model;
	GridLayout layout;
	String gpath;
	private void setPath(String path1)
	{
		this.gpath = path1;
	}
	private String getPath()
	{
		return this.gpath;
	}
	private JTextField file_url;
	private void write_dir(){
		String home = System.getProperty("user.home");
		System.out.println("get hoem : " + home);
		try{
			File f = new File(home + "/init_send_dir.txt");
			FileWriter fw = new FileWriter(f,false);
			fw.write(getPath());
			fw.close();
		}
		catch(Exception error){
				System.out.println("error : " + error.toString());
		}
		
		
	}
	
	private void init(String path, String getText)
	{
		setPath(path);
		System.setProperty("user.dir", path);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,800,800);
		control_panel = new JPanel();
		control_panel.setLayout(new BorderLayout());
		JButton send_dir_button= new JButton("send dir");
		send_dir_button.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			System.out.println("getPath : " + getPath());
			System.out.println("text " +  getText);
			new send_dir(getPath()) ;
			new stream_cons().start_command("java ", " saves", getText);
		}});
		file_url = new JTextField();
		control_panel.add(file_url, BorderLayout.NORTH);
		control_panel.add(send_dir_button, BorderLayout.NORTH);
		list1 = new JList();
		JScrollPane scrollpane = new JScrollPane(list1);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		list1.addListSelectionListener(this);
		model = new DefaultListModel();
		list1.setModel(model);
		all_panel = new JPanel();
		all_panel.add(scrollpane);
		
		
		Container content = getContentPane();
		content.setLayout(new BorderLayout());

		content.add(control_panel, BorderLayout.NORTH);
		content.add(all_panel , BorderLayout.CENTER);
		Files(path);
		setVisible(true);
	}
	File ldf;
	File now;
	private void Junp()
	{
		System.out.println("go to .");
	}

	private void Files(String path)
	{
		//System.out.println("ok.");
		now = new File(path);
		File[] list = now.listFiles();
		if(list == null)
			return ;
		System.setProperty("user.dir","/home/takesue090");
		model.addElement(new File(path).getAbsolutePath() + "/..");
		
		for(File f : list)
		{
			if(f.isDirectory())
			{
				System.out.println("[e] : " + f.getAbsolutePath());
				model.addElement(f.getAbsolutePath());
				list1.setModel(model);
				//setPath(f.getAbsolutePath());
				
			}
			else{
				System.out.println("[f] : " + f.getAbsolutePath());
				model.addElement(f.getAbsolutePath());
				list1.setModel(model);
				//load_text(f.getAbsolutePath());
			}

		}
	}
	private void load_text(String fnames){
		System.out.println("open file: " + fnames);
		try{ 
			String os = System.getProperty("os.name");
			if(os.equals("Linux")){
			
				new fload(fnames);
			}
			else{
				Process p = Runtime.getRuntime().
					exec("java -jar c:/jhiroeditor/editor.jar " + fnames);
			}
		}
		catch(Exception error){ 
			System.out.println("opening error");
		}
	}
	private String Object;

	private void setString(String objs)
	{
		this.Object = objs;
	}
	private String getString()
	{
		return this.Object;
	}

	private int a=0;
	private String[] dirpp = new String[100];
	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		if(e.getValueIsAdjusting())
		{
			try
		{
			System.out.println("ok.");
			System.out.println("get selection : " + list1.getSelectedValue().toString());
			file_url.setText(list1.getSelectedValue().toString());
			File f = new File(list1.getSelectedValue().toString());
			if(f.isDirectory()){
				System.out.println("is dir.");
				setPath(f.getAbsolutePath());
				model.clear();
				repaint();
				Files(f.getAbsolutePath());
			}else if(f.isFile())
			{
				try{
					System.out.println("[z]: " + f.getAbsolutePath());
					load_text(list1.getSelectedValue().toString());
				}
				catch(Exception error){
					System.out.println("opening error");
				}
			}
		}
		catch(Exception error)
		{}
		}


	
	}
}
	
			
