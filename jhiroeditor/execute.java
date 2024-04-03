import java.io.*;
import java.lang.*;
import java.util.*;


class execute{
	public execute(){
		command = command;
	}
	private String command = null;
	
	public void exec(String command){
		try{
			Process p = Runtime.getRuntime().exec(command);
			printInputStream(p.getInputStream());
			printInputStream(p.getErrorStream());
		}
		catch(Exception error){}

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
}

