package java_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class BufferImageTest extends JComponent {
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		final int NUM = 10;
		final int IMAGE_WIDTH = 80;
		final int IMAGE_HEIGHT = 80;
		for (int i = 0; i <= NUM; i++) {
			BufferedImage bi = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB + i);
			Graphics g1 = bi.getGraphics();
			// ÉèÖÃ»­±ÊÑÕÉ«
			Color c = new Color(0 + 25 * i, 0 + 25 * i, 0 + 25 * i);
			g1.setColor(c);
			// »æÖÆ¾ØÐÎ
			g1.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
			// ÉèÖÃ»­±ÊÑÕÉ«
			g1.setColor(new Color(255 - 20 * i, 255 - 20 * i, 255 - 20 * i));
			g1.drawString("Hello", 25, 40);
			g2.drawImage(bi, 5 + i * (IMAGE_WIDTH + 5), 5 + i * (IMAGE_HEIGHT / 4 + 5), bi.getWidth(), bi.getHeight(),
					null);
		}

	}

	public static void main(String[] args) {
		JFrame f = new JFrame("BufferedImage");
		f.setSize(300, 300);
		f.setLocation(0, 0);
		f.getContentPane().setLayout(new BorderLayout());

		f.getContentPane().add(new BufferImageTest(), BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}