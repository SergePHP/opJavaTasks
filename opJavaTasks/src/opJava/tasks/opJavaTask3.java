package opJava.tasks;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;

public class opJavaTask3 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		
		textField = new JTextField();
		textField.setBounds(12, 64, 58, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 64, 58, 22);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(169, 64, 58, 22);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(239, 64, 58, 22);
		frame.getContentPane().add(textField_3);
		
		JLabel lblXY = new JLabel("x");
		lblXY.setBounds(12, 42, 33, 16);
		frame.getContentPane().add(lblXY);
		
		JLabel lblY = new JLabel("y");
		lblY.setBounds(82, 42, 33, 16);
		frame.getContentPane().add(lblY);
		
		JLabel label_1 = new JLabel("x");
		label_1.setBounds(169, 42, 33, 16);
		frame.getContentPane().add(label_1);
		
		JLabel lblY_1 = new JLabel("y");
		lblY_1.setBounds(239, 42, 33, 16);
		frame.getContentPane().add(lblY_1);
		
		JButton btnNewButton = new JButton("Добавить отрезок");
		btnNewButton.setBounds(12, 99, 285, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Удалить отрезок");
		button.setBounds(12, 137, 285, 25);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(315, 15, 333, 147);
		frame.getContentPane().add(scrollPane);
		
		String[] header = {"X", "Y", "X", "Y"};	
		DefaultTableModel model = new DefaultTableModel(header, 6); 	
		table = new JTable(model);


		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Верхний левый угол прямоугольной области:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(12, 185, 377, 16);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("Нижний левый угол прямоугольной области:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(12, 273, 377, 16);
		frame.getContentPane().add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(12, 229, 58, 22);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(82, 229, 58, 22);
		frame.getContentPane().add(textField_5);
		
		JLabel label_3 = new JLabel("x");
		label_3.setBounds(12, 207, 33, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("y");
		label_4.setBounds(82, 207, 33, 16);
		frame.getContentPane().add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(12, 324, 58, 22);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(82, 324, 58, 22);
		frame.getContentPane().add(textField_7);
		
		JLabel label_5 = new JLabel("x");
		label_5.setBounds(12, 302, 33, 16);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("y");
		label_6.setBounds(82, 302, 33, 16);
		frame.getContentPane().add(label_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(369, 188, 279, 158);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JButton button_1 = new JButton("Установить координаты прямоугольной области");
		button_1.setBounds(12, 359, 636, 37);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Отобразить отрезки и прямоугольную область");
		button_2.setBounds(12, 429, 636, 37);
		frame.getContentPane().add(button_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(12, 479, 636, 326);
		frame.getContentPane().add(panel);
		
		JButton button_3 = new JButton("Отобразить координаты отрезков, пересекающих прямоугольную область");
		button_3.setBounds(12, 828, 636, 37);
		frame.getContentPane().add(button_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(143, 878, 382, 122);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_2.setViewportView(textArea_1);
	}
}
