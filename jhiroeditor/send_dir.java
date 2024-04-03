import java.io.*;


class send_dir{
	public send_dir(String path){
		this.p = path;
		write_dir();
	}
	private String p = null;
	private String home_dir = System.getProperty("user.home");
	private BufferedWriter writer_dir_class;
	private void write_dir(){
		try{
			System.out.println("home : " + home_dir);
			new filegs().setFile(p);
			System.out.println("Set p : " + p);
			writer_dir_class = new BufferedWriter(new FileWriter(new File(home_dir + "/write_dir.txt")));
			writer_dir_class.write(p);
			writer_dir_class.close();
		}
		catch(Exception error)
		{
			System.out.println (error.toString());
		}

	}
}
