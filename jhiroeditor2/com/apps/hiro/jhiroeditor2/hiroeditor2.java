package  com.apps.hiro.jhiroeditor2;

import java.io.*;
import java.util.*;

class hiroeditor{
	public hiroeditor(){}
	public static void main(String[] args){
		System.out.println(args[0]);
		String fname = args[0];
		new hiroeditor().init(fname);
	}
	public void init(String fname){
		new Start_Editor().start_editor(fname);

	}
}
