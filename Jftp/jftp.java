import java.io.*;
import org.apache.commons.net.ftp.*;

class jftp
{
	public static void main(String[] args)
	{
		System.out.println("Hello jftp.");
		try{
			String args0 = args[0];
			System.out.println("args0: " + args0);
			try{
				String args1 = args[1];
				new jftp().command(args0, args1);
			}
			catch(Exception error){
				System.out.println("args1 = null");
				new jftp().command(args0, null);

			}

		}
		catch(Exception error){
			String args1 = null;
			System.out.println("args was null");
		}

	}
	private void command(String args0, String args1){
		System.out.println(args0 + " , " + args1);
		if(args0.equals("hello") || args1.equals(null))
		{
					System.out.println("Hello Worlds.");
		}
		if(args0.equals("settings") || args1.equals("account"))
		{	
			new account_new();
		
		}
		if(args0.equals(

		else if(args0.equals("add") || args1.equals(".")){
			new _add();
		}
		else if(args0.equals("push") || args1.equals(null))
		{
			System.out.println("push");
			new _push();
		}


	}

}

