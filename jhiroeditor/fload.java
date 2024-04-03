import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

class fload{
	String fname;
	public fload(String f){
		fname = f;
		popup();
	}
	public fload(){}
	private void popup(){
		System.out.println("開く予定のファイル:" + fname);
		System.out.print("アクション：");
		System.out.println("hirotakeditor.jar : " + fname);
		/*try{
			Process process  = Runtime.getRuntime().exec("java editor " + fname);
		}catch(Exception error){}*/
		select_action();
	}
	private void select_action(){
		JFrame main_frame = new JFrame("アクションを選択");
		main_frame.setLayout(null);
		main_frame.setBounds(0,0,600,600);
		main_frame.setVisible(true);
		JLabel open_file_label = new JLabel("開く予定のファイル：" + fname);
		open_file_label.setBounds(0,0,600,30);
		JButton editor_action = new JButton("エディターで開く");
		editor_action.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("エディターで開く");
				try{
					Process p = Runtime.getRuntime().exec("java -jar /usr/share/java/editor.jar " + fname);
				}
				catch(Exception error)
				{}
			}
		});
		editor_action.setBounds(0,0+30,200,30);
		JButton send_locale = new JButton("ディレクトリーの位置を送信");
		send_locale.setBounds(200,30,200,30);
		send_locale.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("ディレクトリの位置情報送信。");
				System.out.println("ディレクトリの位置 : " + new File(fname).getAbsolutePath());
			}
		});
		JButton Image_viewer_open = new JButton("イメージビューアーで開く");
		Image_viewer_open.setBounds(0,30*2, 200,30);
		JButton browser_open_file = new JButton("ブラウザーで開く");
		browser_open_file.setBounds(200,30*2,200,30);
		main_frame.add(open_file_label);
		main_frame.add(editor_action);
		//main_frame.add(send_locale);
		main_frame.add(Image_viewer_open);
		main_frame.add(browser_open_file);

	}

}
















