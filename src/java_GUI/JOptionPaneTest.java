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
		
		int option = JOptionPane.showConfirmDialog(f, "Are you OK��");
		if (JOptionPane.OK_OPTION == option) {
			String answer = JOptionPane.showInputDialog(f, "������yes���������OK");
			if ("yes".equals(answer))
				JOptionPane.showMessageDialog(f, "�������OK,���Ÿɣ�");
		}else if(JOptionPane.CANCEL_OPTION == option){
			JOptionPane.showMessageDialog(f, "��Ϣһ���!");
		}
		else{
			JOptionPane.showMessageDialog(f, "����!");
		}
	}
}
