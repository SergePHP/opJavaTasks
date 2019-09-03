package opJava.tasks;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import opJava.tasks.Test.CustomPaintComponent;

import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class opJavaTask3 {

	private JFrame frame;
	private JTextField lineStartX;
	private JTextField lineStartY;
	private JTextField lineEndX;
	private JTextField lineEndY;
	private JTable lines;
	private JTextField rectUpX;
	private JTextField rectUpY;
	private JTextField rectDownX;
	private JTextField rectDownY;
	private Rectangle rectangle;
	private JTextArea rectInfo;
	private JPanel panelDrawShapes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opJavaTask3 window = new opJavaTask3();
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
	public opJavaTask3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 681, 1060);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Координаты отрезка:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(25, 13, 194, 16);
		frame.getContentPane().add(lblNewLabel);
		
		lineStartX = new JTextField();
		lineStartX.setBounds(12, 64, 58, 22);
		frame.getContentPane().add(lineStartX);
		lineStartX.setColumns(10);
		
		lineStartY = new JTextField();
		lineStartY.setColumns(10);
		lineStartY.setBounds(82, 64, 58, 22);
		frame.getContentPane().add(lineStartY);
		
		lineEndX = new JTextField();
		lineEndX.setColumns(10);
		lineEndX.setBounds(169, 64, 58, 22);
		frame.getContentPane().add(lineEndX);
		
		lineEndY = new JTextField();
		lineEndY.setColumns(10);
		lineEndY.setBounds(239, 64, 58, 22);
		frame.getContentPane().add(lineEndY);
		
		JLabel lblX1 = new JLabel("x");
		lblX1.setBounds(12, 42, 33, 16);
		frame.getContentPane().add(lblX1);
		
		JLabel lblY1 = new JLabel("y");
		lblY1.setBounds(82, 42, 33, 16);
		frame.getContentPane().add(lblY1);
		
		JLabel lblX2 = new JLabel("x");
		lblX2.setBounds(169, 42, 33, 16);
		frame.getContentPane().add(lblX2);
		
		JLabel lblY2 = new JLabel("y");
		lblY2.setBounds(239, 42, 33, 16);
		frame.getContentPane().add(lblY2);
		
		JButton btnAddLine = new JButton("Добавить отрезок");
		btnAddLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLine();
			}
		});
		btnAddLine.setBounds(12, 99, 285, 25);
		frame.getContentPane().add(btnAddLine);
		
		JButton btnDeleteLine = new JButton("Удалить отрезок");
		btnDeleteLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteLine();
			}
		});
		btnDeleteLine.setBounds(12, 137, 285, 25);
		frame.getContentPane().add(btnDeleteLine);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(315, 15, 333, 147);
		frame.getContentPane().add(scrollPane);
		
		String[] header = {"X", "Y", "X", "Y"};	
		DefaultTableModel model = new DefaultTableModel(header, 0); 	
		lines = new JTable(model);
		lines.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		scrollPane.setViewportView(lines);
		
		JLabel label = new JLabel("Верхний левый угол прямоугольной области:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(12, 185, 345, 16);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("Нижний левый угол прямоугольной области:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(12, 273, 345, 16);
		frame.getContentPane().add(label_2);
		
		rectUpX = new JTextField();
		rectUpX.setColumns(10);
		rectUpX.setBounds(12, 229, 58, 22);
		frame.getContentPane().add(rectUpX);
		
		rectUpY = new JTextField();
		rectUpY.setColumns(10);
		rectUpY.setBounds(82, 229, 58, 22);
		frame.getContentPane().add(rectUpY);
		
		JLabel label_3 = new JLabel("x");
		label_3.setBounds(12, 207, 33, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("y");
		label_4.setBounds(82, 207, 33, 16);
		frame.getContentPane().add(label_4);
		
		rectDownX = new JTextField();
		rectDownX.setColumns(10);
		rectDownX.setBounds(12, 324, 58, 22);
		frame.getContentPane().add(rectDownX);
		
		rectDownY = new JTextField();
		rectDownY.setColumns(10);
		rectDownY.setBounds(82, 324, 58, 22);
		frame.getContentPane().add(rectDownY);
		
		JLabel label_5 = new JLabel("x");
		label_5.setBounds(12, 302, 33, 16);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("y");
		label_6.setBounds(82, 302, 33, 16);
		frame.getContentPane().add(label_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(354, 188, 294, 158);
		frame.getContentPane().add(scrollPane_1);
		
		rectInfo = new JTextArea();
		rectInfo.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane_1.setViewportView(rectInfo);
		
		JButton btnCreateRect = new JButton("Установить координаты прямоугольной области");
		btnCreateRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createRect();
			}
		});
		btnCreateRect.setBounds(12, 359, 636, 37);
		frame.getContentPane().add(btnCreateRect);
		
		JButton btnDrowShapes = new JButton("Отобразить отрезки и прямоугольную область");
		btnDrowShapes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				drawShapes();
			}
		});
		btnDrowShapes.setBounds(12, 429, 636, 37);
		frame.getContentPane().add(btnDrowShapes);
		
		panelDrawShapes = new JPanel();
		panelDrawShapes.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelDrawShapes.setBounds(12, 479, 636, 326);
		frame.getContentPane().add(panelDrawShapes);
		
		JButton btnFindIntersection = new JButton("Отобразить координаты отрезков, пересекающих прямоугольную область");
		btnFindIntersection.setBounds(12, 828, 636, 37);
		frame.getContentPane().add(btnFindIntersection);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(143, 878, 382, 122);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea intersectionInfo = new JTextArea();
		scrollPane_2.setViewportView(intersectionInfo);
	}
	/*
	 * Метод читает введенные значения координат
	 * и возвращает целочисленный массив с координатами
	 */
	private int[] readCoordinates(JTextField x1, JTextField y1,
			JTextField x2, JTextField y2) {
		
		int[] coordinates = new int[4];
		
		try {
			coordinates[0] = Integer.valueOf(x1.getText());
			coordinates[1] = Integer.valueOf(y1.getText());
			coordinates[2] = Integer.valueOf(x2.getText());
			coordinates[3] = Integer.valueOf(y2.getText());
			return coordinates;
			
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Неверно указаны координаты\nДопустимы только целочисленные значения.", 
					"Предупреждение", JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	/*
	 * Метод предназначен для добавления отрезка
	 */
	private void addLine() {
		int[] lineCoord = readCoordinates(lineStartX, lineStartY, 
				lineEndX, lineEndY);
		if(lineCoord != null) {
			DefaultTableModel tableModel = (DefaultTableModel) lines.getModel();
			Vector<String> row = new Vector<>();
			for (int i = 0; i < lineCoord.length; i++) {
				row.add(Integer.toString(lineCoord[i]));
			}
			tableModel.addRow(row);
		}
	}
	/*
	 * Метод предназначен для удаления отрезка
	 */
	private void deleteLine() {
		
		DefaultTableModel tableModel = (DefaultTableModel) lines.getModel();
		int row = lines.getSelectedRow();
		if (row != -1) {
			tableModel.removeRow(row);	
		}
	}
	/*
	 * Метод создает прямоугольник
	 */
	private void createRect(){
		int[] rectCoord = readCoordinates(rectUpX, rectUpY, 
				rectDownX, rectDownY);
		if(rectCoord != null) {
			rectangle = new Rectangle(rectCoord[0], rectCoord[1],
					rectCoord[2], rectCoord[3]);
			rectInfo.setText("");
			rectInfo.setText("Задан прямоугольник с координатами:\nx1="
					+ rectangle.x + ", y1=" + rectangle.y + ","
					+ " x2=" + rectangle.width + ", y2=" + rectangle.height);
		}
	}

	private void drawShapes() {
		
		CPaintComponent customPaintComponent = new CPaintComponent();
		panelDrawShapes.add(customPaintComponent);
	}
	
	static class CPaintComponent extends Component {
			 
		public void paint(Graphics g) {
		 
		 
		  Graphics2D g2d = (Graphics2D)g;
		 
		 
		  int x = 15;
		 
		  int y = 15;
		 
		  int w = getSize().width-15;
		 
		  int h = getSize().height-15;
		 
		 
		  g2d.drawLine(x, y, w, h);
		}
	}
}
