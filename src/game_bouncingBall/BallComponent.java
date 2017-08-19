package game_bouncingBall;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/*
 * The component that draws the balls.
 * @version 1.34 2012-01-26
 * @author Cay Horstmann
 */

public class BallComponent extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 650;
	private static final int DEFAULT_HEIGHT = 650;

	List<Ball> balls = new ArrayList<>();

	/**
	 * Add a ball to the component.
	 * @param b the ball to add
	 */
	public void add(Ball b) {
		balls.add(b);
	}

	/**
	 * Paint the component
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//erase background
		Graphics2D g2 = (Graphics2D) g;
		for(Ball b:balls) {
			g2.fill(b.getShape());
		}
	}

	public Dimension getPreferrendSize() {
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}
