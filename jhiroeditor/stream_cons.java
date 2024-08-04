import java.io.*;
import java.lang.*;

class stream_cons{
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
	public void start_command(String command, String fname , String text){
		

					try{
					Process pro = Runtime.getRuntime().exec(command + " " + fname  + " " + text );
					pro.waitFor();
					printInputStream(pro.getInputStream());
					printInputStream(pro.getErrorStream());
				}
				catch(Exception error){
					System.out.println("error " + error.toString());
				}

	}
}

