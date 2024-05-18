package com;

import java.io.*;
import it.sauronsoftware.ftp4j.*;
import java.net.*;
import java.util.*;


class Jftpg
{
	public static void main(String[] args)
	{
		System.out.println("Hello Jftp");
		try
		{
			System.out.print("コマンドを入力してください。：");
			Scanner scan_command = new Scan(System.in);			
			String string_command = scan_command.next();
			System.out.print("パスを入力せよ：");
			Scanner scan_path = new Scanner(System.in);
			String string_path = scan_path.next();
			String option_command = string_command;
			String file_path_name = string_path;
			System.out.println("オプション：" + option_command + "\n" + "ファイル名もしくは、ファイルディレクトリ：" + file_path_name);
			if(option_command.equals("add") || file_path_name.equals("."))
			{
				System.out.println("add files or add paths");
				File file_path = new File(file_path_name);
				if(file_path.isFile())
				{
					System.out.println("this is file.");
					new Jftpg().log(file_path);
				}
				else if(file_path.isDirectory())
				{
					System.out.println("this is dir.");
					File[] lists = file_path.listFiles();
					if(lists == null)
					{
						return;
					}
					for(File file : lists)
					{
							if(!file.exists())
							continue;
							else if (file.isFile())
							{
									new Jftpg().log(file);
							}
					}	
				}
			}
			else if(option_command.equals("push") || file_path_name.equals(null))
			{
				System.out.println("push files.");
				new Jftpg().read_logs();
			}
			else if(option_command.equals("init") || file_path_name.equals(null))
			{
				System.out.println("init log files...");
				new Jftpg().inits();
			}

			if(option_command.equals("create") || file_path_name.equals(null))
			{
				System.out.println("create dir to server");

				new Jftpg().CreateFile();

			}
			if(option_command.equals("user") || file_path_name.equals(null))
			{
				
				new Jftpg().user();
				
			}
			if(option_command.equals("user_init") || file_path_name.equals(null))
			{
				System.out.println("user_init");
				new Jftpg().user_init();
			}


		
		}catch(Exception error)
		{
			System.out.println("java Jftpg add <file_path or file_name> \n" + "java Jftpg push");
		}
		
	
	}
	private void user_init()
	{
		System.out.println("delete file login.txt");
		new File(System.getProperty("user.home") + "/login.txt").delete();
		System.out.println("done");
	}

	private void CreateFile()
	{
		System.out.println("mkdir");
		Scanner scan_mkdir = new Scanner(System.in);
		String mkdir_command = scan_mkdir.next();
		try{
			FTPClient client = new FTPClient();
			client.connect(get_host_name());
			client.login(get_user_name(), get_pass_id());
			client.createDirectory(mkdir_command);
			client.disconnect(true);
		}
		catch(Exception error)
		{
			System.out.println("can't create dir");
		}
	}

			
		
	private String get_host_name()
	{
		try
		{
			System.out.println("get Pass");
			File f = new File(System.getProperty("user.home") + "/login.txt");
			BufferedReader br =new BufferedReader(new FileReader(f));
			String line = br.readLine();
			String split_line[] = line.split(",");
			System.out.println("hostname " + split_line[0]);
			return split_line[0];
		}
		catch(Exception error)
		{
			System.out.println("error");
		}
		return get_host_name();	
	}
	private String get_user_name()
	{
		System.out.println("user name");
		try
		{

			File f = new File(System.getProperty("user.home") + "/login.txt");
			BufferedReader br =new BufferedReader(new FileReader(f));
			String line = br.readLine();
			String split_line[] = line.split(",");
			System.out.println("user_name " + split_line[1]);
			return split_line[1];
		}
		catch(Exception error)
		{
			System.out.println("error");
		}
		return get_user_name();
	}
	private String get_pass_id()
	{

		System.out.println("pass id ");
		try
		{

			File f = new File(System.getProperty("user.home") + "/login.txt");
			BufferedReader br =new BufferedReader(new FileReader(f));
			String line = br.readLine();
			String split_line[] = line.split(",");
			System.out.println("user_name " + split_line[2]);
			return split_line[2];
		}
		catch(Exception error)
		{
			System.out.println("error");
		}
		return get_pass_id();
				
	}

	private void user()
	{
		System.out.println("write the user, pass and host");
		try
		{

		Scanner scan_user = new Scanner(System.in);
		System.out.println("user name");
		String user_name = scan_user.next();
		System.out.println("pass");
		Scanner scan_pass = new Scanner(System.in);
		String pass_id = scan_pass.next();
		Scanner scan_hostname = new Scanner(System.in);
		System.out.println("hostname");
		String host_name = scan_hostname.next();
		File f = new File(System.getProperty("user.home") + "/login.txt");
		System.out.println(System.getProperty("user.home"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write(host_name+",");
		bw.write(user_name + ",");
		bw.write(pass_id + ",");
		bw.close();
		}
		catch(Exception error)
		{
			System.out.println("error");
		}

	}

	private void inits()
	{
		System.out.println("delete files..");
		new File(home + log).delete();
	}

	private void read_logs()
	{
		System.out.println("log file read now...");
		login();
		System.out.println("login ok.");
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(home + log));
			String line;
			while((line=br.readLine()) != null)
			{
				System.out.println(line);
				uploads(line);
			}
			
		}

		catch(Exception error)
		{
			System.out.println("read error" + error.toString());
		}

	}
	FTPClient client;
	private void login()
	{
	try
	{	client = new FTPClient();
	       client.connect(get_host_name());
       		client.login(get_user_name(),get_pass_id());
		System.out.println("server dir: ");
       		Scanner scan_dir = new Scanner(System.in);
       		String dir = scan_dir.next();
		client.changeDirectory(dir);
	}catch(Exception error)
	{
		System.out.println("login error" + error.toString());
	}
	}



 	private void now_dir()
 	{
 	}
 		
	private void uploads(String line)
	{
	try{
		now_dir();

		client.upload(new File(line));
		
	}catch(Exception error)
	{
		System.out.println("upload error" + error.toString());
	}
	}




	String home = System.getProperty("user.home");
	String log = "/log.txt";
	File log_file = new File(home + log);
	private void log(File file_name)
	{
		System.out.println(file_name);
		try
		{
		
			BufferedWriter bw = new BufferedWriter(new FileWriter(log_file, true));
			bw.write(file_name + "\n");
			bw.close();
		}
		catch(Exception error)
		{
			System.out.println("Writer error : " + error.toString());
		}
	}
	

}

