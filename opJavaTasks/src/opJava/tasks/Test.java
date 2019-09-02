package opJava.tasks;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class Test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 579, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(69, 30, 282, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(69, 422, 282, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(62, 95, 400, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		CustomPaintComponent customPaintComponent = new CustomPaintComponent();
		panel.add(customPaintComponent);
		 
//		int frameWidth = 300;
//		 
//		int frameHeight = 300;
//		 
//		frame.setSize(445, 480);
		 
		frame.setVisible(true);
		 
		  }
		 
		 /**
		  * To draw on the screen, it is first necessary to subclass a Component 
		  * and override its paint() method. The paint() method is automatically called 
		  * by the windowing system whenever component's area needs to be repainted.
		  */
		  static class CustomPaintComponent extends Component {
		 
		public void paint(Graphics g) {
		 
		  // Retrieve the graphics context; this object is used to paint shapes
		 
		  Graphics2D g2d = (Graphics2D)g;
		 
		  // Draw an oval that fills the window
		 
		  int x = 0;
		 
		  int y = 0;
		 
		  int w = getSize().width-1;
		 
		  int h = getSize().height-1;
		 
		  /**
		    * The coordinate system of a graphics context is such that the origin is at the 
		    * northwest corner and x-axis increases toward the right while the y-axis increases 
		    * toward the bottom.
		    */
		 
		  g2d.drawLine(x, y, w, h);
		 
		  // to draw a filled oval use : g2d.fillOval(x, y, w, h) instead
		 
		  g2d.drawOval(x, y, w, h);
		 
		  // to draw a filled rectangle use : g2d.fillRect(x, y, w, h) instead
		 
		  g2d.drawRect(x, y, w, h);
		 
		  // A start angle of 0 represents a 3 o'clock position, 90 represents a 12 o'clock position,
		 
		  // and -90 (or 270) represents a 6 o'clock position
		 
		  int startAngle = 45;
		 
		  int arcAngle = -60;
		 
		  // to draw a filled arc use : g2d.fillArc(x, y, w, h, startAngle, arcAngle) instead
		 
		  g2d.drawArc(x, y, w/2, h/2, startAngle, arcAngle);
		 
		  // to draw a filled round rectangle use : g2d.fillRoundRect(x, y, w, h, arcWidth, arcHeight) instead
		 
		  g2d.drawRoundRect(x, y, w, h, w/2, h/2);
		 
		  Polygon polygon = new Polygon();
		 
		  polygon.addPoint(w/4, h/2);
		 
		  polygon.addPoint(0, h/2);
		 
		  polygon.addPoint(w/4, 3*h/4);
		 
		  polygon.addPoint(w/2, 3*h/4);
		 
		  // Add more points...
		 
		  // to draw a filled round rectangle use : g2d.fillPolygon(polygon) instead
		 
		  g2d.fillPolygon(polygon);
		 
		}
		  }
}
