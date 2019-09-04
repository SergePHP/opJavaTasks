package opJava.tasks;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test {

	private JFrame frame;
	private JTextField textField;
	private JPanel panel;

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
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();

		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(12, 479, 636, 326);
		panel.setLayout(null);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		frame.getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("Draw");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PanelWithRectangle panelDrawShapes = new PanelWithRectangle();
				panelDrawShapes.setLocation(0, 0);
				panelDrawShapes.setSize(new Dimension(500, 500));
				panel.add(panelDrawShapes);
				panelDrawShapes.repaint();
				
			}
		});
		frame.getContentPane().add(btnNewButton_1, BorderLayout.EAST);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.WEST);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.SOUTH);
		
//		CustomPaintComponent customPaintComponent = new CustomPaintComponent();
//		panel.add(customPaintComponent);
		
		frame.setVisible(true);
		 
		  }
		 
		 /**
		  * To draw on the screen, it is first necessary to subclass a Component 
		  * and override its paint() method. The paint() method is automatically called 
		  * by the windowing system whenever component's area needs to be repainted.
		  */
	public class PanelWithRectangle extends JPanel {

	    public PanelWithRectangle() {
	        //setPreferredSize(new Dimension(200,100));
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g); 
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.draw(new Rectangle2D.Double(10, 10, 200, 250));
	    }
	}
	
		static class CustomPaintComponent extends Component {
		 
		public void paint(Graphics g) {
			

		 
		  // Retrieve the graphics context; this object is used to paint shapes
		 
		  Graphics2D g2d = (Graphics2D)g;
		 
		  // Draw an oval that fills the window
		 
		  int x = 15;
		 
		  int y = 15;
		 
		  int w = getSize().width-15;
		 
		  int h = getSize().height-15;
		 
		  /**
		    * The coordinate system of a graphics context is such that the origin is at the 
		    * northwest corner and x-axis increases toward the right while the y-axis increases 
		    * toward the bottom.
		    */
		 
		  g2d.drawLine(x, y, w, h);
		 
		  // to draw a filled oval use : g2d.fillOval(x, y, w, h) instead
		 
//		  g2d.drawOval(x, y, w, h);
//		 
//		  // to draw a filled rectangle use : g2d.fillRect(x, y, w, h) instead
//		 
//		  g2d.drawRect(x, y, w, h);
//		 
//		  // A start angle of 0 represents a 3 o'clock position, 90 represents a 12 o'clock position,
//		 
//		  // and -90 (or 270) represents a 6 o'clock position
//		 
//		  int startAngle = 45;
//		 
//		  int arcAngle = -60;
//		 
//		  // to draw a filled arc use : g2d.fillArc(x, y, w, h, startAngle, arcAngle) instead
//		 
//		  g2d.drawArc(x, y, w/2, h/2, startAngle, arcAngle);
//		 
//		  // to draw a filled round rectangle use : g2d.fillRoundRect(x, y, w, h, arcWidth, arcHeight) instead
//		 
//		  g2d.drawRoundRect(x, y, w, h, w/2, h/2);
//		 
//		  Polygon polygon = new Polygon();
//		 
//		  polygon.addPoint(w/4, h/2);
//		 
//		  polygon.addPoint(0, h/2);
//		 
//		  polygon.addPoint(w/4, 3*h/4);
//		 
//		  polygon.addPoint(w/2, 3*h/4);
//		 
//		  // Add more points...
//		 
//		  // to draw a filled round rectangle use : g2d.fillPolygon(polygon) instead
//		 
//		  g2d.fillPolygon(polygon);
		 
		}
		  }
}
