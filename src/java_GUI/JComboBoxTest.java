/**
 * Drop-down box
 */

package java_GUI;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class JComboBoxTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		JFrame f = new JFrame("下拉框");
		f.setSize(400, 300);
		f.setLocation(580, 240);
		f.setLayout(null);

		//下拉框出现的条目
		String[] fruits = new String[] {"苹果","香蕉","柑橘","西瓜"};
		JComboBox cb = new JComboBox(fruits);
		cb.setBounds(50, 50, 80, 30);
		f.add(cb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
