package java_web_programming;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class SimpleWebBrowser extends JFrame{
	private static final long serialVersionUID = 1L;

	private JTextField urlField = new JTextField();
	private JButton goButton = new JButton("×ªµ½");
	private JEditorPane editorPane = new JEditorPane();

	public SimpleWebBrowser(String title){
		super(title);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(new Color(255, 255, 255));
		panel.add(new JLabel("URLµØÖ·"),BorderLayout.WEST);
		panel.add(urlField, BorderLayout.CENTER);
		panel.add(goButton, BorderLayout.EAST);

		add(panel,BorderLayout.NORTH);
		add(new JScrollPane(editorPane),BorderLayout.CENTER);
		editorPane.setEditable(false);

		ActionListener actionListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					URL url = new URL(urlField.getText().trim());
					editorPane.setPage(url);
				}catch(IOException ioex){
					ioex.printStackTrace();
				}
			}
		};//actionListener
		urlField.addActionListener(actionListener);
		goButton.addActionListener(actionListener);

		editorPane.addHyperlinkListener(new HyperlinkListener() {
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				try{
					URL url = e.getURL();
					urlField.setText(url.toString());
					editorPane.setPage(url);
				}catch(IOException ioex){
					ioex.printStackTrace();
				}
			}
		});//addHyperlinkListener
	}

	//²âÊÔ
	public static void main(String[] args) {
		final int WIDTH = 512;
		final int HEIGHT = 350;
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SimpleWebBrowser swb = new SimpleWebBrowser("Simple Web Browers");
				swb.setSize(WIDTH,HEIGHT);
				swb.setVisible(true);
				swb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}