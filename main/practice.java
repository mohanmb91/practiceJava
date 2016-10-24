	package main;

	import java.awt.Color;
	import java.awt.GradientPaint;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.geom.Line2D;
	import java.awt.geom.Point2D;
	import java.awt.geom.Rectangle2D;

	import javax.swing.JFrame;
	import javax.swing.JPanel;

	public class practice extends JPanel {

	  public practice() {
	  }

	  public void paint(Graphics g) {
	    Graphics2D g2D = (Graphics2D) g;

	    Point2D.Float p1 = new Point2D.Float(150.f, 75.f);
	    Point2D.Float p2 = new Point2D.Float(250.f, 75.f);
	    float width = 300;
	    float height = 50;
	    GradientPaint g1 = new GradientPaint(p1, Color.WHITE, p2, Color.DARK_GRAY,
	        true);
	    Rectangle2D.Float rect1 = new Rectangle2D.Float(p1.x - 100, p1.y - 25,
	        width, height);
	    g2D.setPaint(g1);
	    g2D.fill(rect1);
	    g2D.setPaint(Color.PINK);
	    g2D.draw(rect1);
	    g2D.draw(new Line2D.Float(p1, p2));

	  }

	  public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(new practice());

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(200, 200);
	    frame.setVisible(true);
	  }
	}