package java_GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOptionPaneTest {
	public static void main(String[] args) {	 
		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 240);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		int option = JOptionPane.showConfirmDialog(f, "Are you OK？");
		if (JOptionPane.OK_OPTION == option) {
			String answer = JOptionPane.showInputDialog(f, "请输入yes，表明你很OK");
			if ("yes".equals(answer))
				JOptionPane.showMessageDialog(f, "由于你很OK,接着干！");
		}else if(JOptionPane.CANCEL_OPTION == option){
			JOptionPane.showMessageDialog(f, "休息一会儿!");
		}
		else{
			JOptionPane.showMessageDialog(f, "开饭!");
		}
	}
}
