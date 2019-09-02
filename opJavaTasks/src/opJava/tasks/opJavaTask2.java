package opJava.tasks;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class opJavaTask2 {

	private JFrame frame;
	private JTextField rowsMatrix1;
	private JTextField colsMatrix1;
	private JTextField loRangeMatrix1;
	private JTextField hiRangeMatrix1;
	private JTable matrix1;
	private JButton btnClearMatrix1;
	private JScrollPane scrollPane;
	private JTextField rowsMatrix2;
	private JTextField colsMatrix2;
	private JButton btnSetSizeMatrix2;
	private JTextField loRangeMatrix2;
	private JTextField hiRangeMatrix2;
	private JButton btnPopulateMatrix2;
	private JButton btnClearMatrix2;
	private JLabel label_1;
	private JLabel label_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable matrix2;
	private JScrollPane scrollPane_1;
	private JRadioButton rdAdd;
	private JRadioButton rdSub;
	private JRadioButton rdMult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opJavaTask2 window = new opJavaTask2();
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
	public opJavaTask2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 814, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Матрица 1"));
		panel.setBounds(12, 13, 379, 409);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		rowsMatrix1 = new JTextField();
		rowsMatrix1.setBounds(12, 46, 59, 22);
		panel.add(rowsMatrix1);
		rowsMatrix1.setColumns(10);
		
		colsMatrix1 = new JTextField();
		colsMatrix1.setBounds(12, 81, 59, 22);
		panel.add(colsMatrix1);
		colsMatrix1.setColumns(10);
		
		JButton btnSetSizeMatrix1 = new JButton("Установить");
		btnSetSizeMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMatrixSize(matrix1, rowsMatrix1, colsMatrix1);
			}
		});
		btnSetSizeMatrix1.setBounds(83, 45, 103, 58);
		panel.add(btnSetSizeMatrix1);
		
		loRangeMatrix1 = new JTextField();
		loRangeMatrix1.setText("0");
		loRangeMatrix1.setBounds(198, 46, 59, 22);
		panel.add(loRangeMatrix1);
		loRangeMatrix1.setColumns(10);
		
		hiRangeMatrix1 = new JTextField();
		hiRangeMatrix1.setText("0");
		hiRangeMatrix1.setBounds(198, 81, 59, 22);
		panel.add(hiRangeMatrix1);
		hiRangeMatrix1.setColumns(10);
		
		JButton btnPopulateMatrix1 = new JButton("Заполнить");
		btnPopulateMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateMatrix(matrix1, loRangeMatrix1, hiRangeMatrix1);
			}
		});
		btnPopulateMatrix1.setBounds(269, 45, 97, 58);
		panel.add(btnPopulateMatrix1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 116, 353, 239);
		panel.add(scrollPane);
		
		matrix1 = new JTable();
		
		DefaultTableModel dtm = new DefaultTableModel(3, 3) {
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		matrix1.setModel(dtm);

		matrix1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		matrix1.setRowHeight(50);
		matrix1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(matrix1);
		rowsMatrix1.setText(Integer.toString(matrix1.getRowCount()));
		colsMatrix1.setText(Integer.toString(matrix1.getColumnCount()));
		
		btnClearMatrix1 = new JButton("Очистить");
		btnClearMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearMatrix(matrix1);
			}
		});
		btnClearMatrix1.setBounds(136, 368, 97, 25);
		panel.add(btnClearMatrix1);
		
		JLabel lblNewLabel = new JLabel("Размер матрицы");
		lblNewLabel.setBounds(12, 23, 119, 16);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("Значения матрицы");
		label.setBounds(198, 23, 119, 16);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Матрица 2"));
		panel_1.setBounds(403, 13, 379, 409);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		rowsMatrix2 = new JTextField();
		rowsMatrix2.setColumns(10);
		rowsMatrix2.setBounds(12, 46, 59, 22);
		panel_1.add(rowsMatrix2);
		
		colsMatrix2 = new JTextField();
		colsMatrix2.setColumns(10);
		colsMatrix2.setBounds(12, 81, 59, 22);
		panel_1.add(colsMatrix2);
		
		btnSetSizeMatrix2 = new JButton("Установить");
		btnSetSizeMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMatrixSize(matrix2, rowsMatrix2, colsMatrix2);
			}
		});
		btnSetSizeMatrix2.setBounds(83, 45, 103, 58);
		panel_1.add(btnSetSizeMatrix2);
		
		loRangeMatrix2 = new JTextField();
		loRangeMatrix2.setText("0");
		loRangeMatrix2.setColumns(10);
		loRangeMatrix2.setBounds(198, 46, 59, 22);
		panel_1.add(loRangeMatrix2);
		
		hiRangeMatrix2 = new JTextField();
		hiRangeMatrix2.setText("0");
		hiRangeMatrix2.setColumns(10);
		hiRangeMatrix2.setBounds(198, 81, 59, 22);
		panel_1.add(hiRangeMatrix2);
		
		btnPopulateMatrix2 = new JButton("Заполнить");
		btnPopulateMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateMatrix(matrix2, loRangeMatrix2, hiRangeMatrix2);
			}
		});
		btnPopulateMatrix2.setBounds(269, 45, 97, 58);
		panel_1.add(btnPopulateMatrix2);
		
		btnClearMatrix2 = new JButton("Очистить");
		btnClearMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearMatrix(matrix2);
			}
		});
		btnClearMatrix2.setBounds(136, 368, 97, 25);
		panel_1.add(btnClearMatrix2);
		
		label_1 = new JLabel("Размер матрицы");
		label_1.setBounds(12, 23, 119, 16);
		panel_1.add(label_1);
		
		label_2 = new JLabel("Значения матрицы");
		label_2.setBounds(198, 23, 119, 16);
		panel_1.add(label_2);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 116, 354, 239);
		panel_1.add(scrollPane_1);
		
		matrix2 = new JTable();
		
		DefaultTableModel dtm2 = new DefaultTableModel(3, 3) {
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		matrix2.setModel(dtm2);
		
		matrix2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		matrix2.setRowHeight(50);
		matrix2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scrollPane_1.setViewportView(matrix2);
		
		colsMatrix2.setText(Integer.toString(matrix2.getColumnCount()));
		rowsMatrix2.setText(Integer.toString(matrix2.getRowCount()));
		
		rdAdd = new JRadioButton("Сложение матриц");
		rdAdd.setSelected(true);
		buttonGroup.add(rdAdd);
		rdAdd.setBounds(336, 431, 168, 25);
		frame.getContentPane().add(rdAdd);
		
		rdSub = new JRadioButton("Вычитание матриц");
		buttonGroup.add(rdSub);
		rdSub.setBounds(336, 461, 168, 25);
		frame.getContentPane().add(rdSub);
		
		rdMult = new JRadioButton("Умножение матриц");
		buttonGroup.add(rdMult);
		rdMult.setBounds(336, 491, 168, 25);
		frame.getContentPane().add(rdMult);
		
		JButton btnPerformOperation = new JButton("Выполнить выбранное действие над матрицами");
		btnPerformOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdAdd.isSelected()) {
					addMatrix(matrix1, matrix2);
					
				} else if (rdSub.isSelected()) {
					subMatrix();
					
				} else {
					multMatrix();
				}
			}
		});
		btnPerformOperation.setBounds(244, 525, 342, 39);
		frame.getContentPane().add(btnPerformOperation);
	}
	private void alignTableCells(JTable matrix){

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		TableModel tm = matrix.getModel();
		
        for (int i = 0; i < tm.getColumnCount(); i++)
        {
        	matrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
	}
	private void populateMatrix(JTable matrix, JTextField low, JTextField high) {
		
		int x = 0;
		int y = 0;

		Random random = new Random();
		
		try {
			x = Integer.valueOf(low.getText());
			y = Integer.valueOf(high.getText());

			alignTableCells(matrix);
			
			DefaultTableModel tableModel = (DefaultTableModel) matrix.getModel();
			
			int currentRows = tableModel.getRowCount();
			tableModel.setRowCount(0);
			
			if (x == 0 && y == 0) {
				for (int i = 0; i < currentRows; i++) {
					Vector<Integer> row = new Vector<Integer>();
					for (int j = 0; j < matrix.getColumnCount(); j++) {
						int rand = random.nextInt(99);
						row.add(rand);
						}
					tableModel.addRow(row);					
					}
				return;
			} else if ((y - x) < (matrix.getRowCount() * matrix.getColumnCount()))
				throw new Exception();

			for (int i = 0; i < currentRows; i++) {
				Vector<Integer> row = new Vector<Integer>();
				for (int j = 0; j < matrix.getColumnCount(); j++) {
					if(x <= y) {
						row.add(x);
						x++;
					}
				}
				tableModel.addRow(row);
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Неверно указаны значения диапазона.", 
					"Предупреждение", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}
	private void setMatrixSize(JTable matrix, JTextField rows, JTextField cols) {
		
		int x = 0;
		int y = 0;
		try {
			x = Integer.valueOf(cols.getText());
			y = Integer.valueOf(rows.getText());
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Неверно указано количество строк/столцов\nДопустимы только целочисленные значения", 
					"Предупреждение", JOptionPane.WARNING_MESSAGE);
		}
		
			DefaultTableModel tableModel = (DefaultTableModel) matrix.getModel();
			
			tableModel.setRowCount(0);
			
			tableModel.setColumnCount(x);
			tableModel.setRowCount(y);
	}
	private void clearMatrix(JTable matrix) {
		
		DefaultTableModel tableModel = (DefaultTableModel) matrix.getModel();
		
		int currentRowCount = tableModel.getRowCount();
		tableModel.setRowCount(0);
		tableModel.setRowCount(currentRowCount);
	}
	/*
	 *  Метод для исправления размера матрицы
	 *  для операций сложения и вычитания
	 */
	private void changeSizeForAddSub(JTable matrix, int x, int y) {
		
		DefaultTableModel tableModel = (DefaultTableModel) matrix.getModel();
		
		tableModel.setRowCount(0);
		tableModel.setColumnCount(x);
		
		for (int i = 0; i < y; i++) {
			Vector<Integer> row = new Vector<Integer>();
			for (int j = 0; j < x; j++) {
				row.add(0);
				}
			tableModel.addRow(row);					
		}
		alignTableCells(matrix);
	}
	/*
	 *  Метод для исправления размера
	 *  матрицы для операции умножения
	 */
	private void changeSizeForMult(JTable matrix, int x, int y) {
		
		DefaultTableModel tableModel = (DefaultTableModel) matrix.getModel();
		
		tableModel.setRowCount(0);
		tableModel.setColumnCount(x);
		
		for (int i = 0; i < y; i++) {
			Vector<Integer> row = new Vector<Integer>();
			for (int j = 0; j < x; j++) {
				row.add(0);
				}
			tableModel.addRow(row);					
		}
		alignTableCells(matrix);
	}
	private void wrongSizeDialog() {
		
		final ButtonGroup buttonGroup_1 = new ButtonGroup();
		final JDialog dialog = new JDialog(frame, "Ошибка размерности", true);
		dialog.setLayout(null);
		dialog.setBounds(100, 100, 292, 253);
		
		JRadioButton rdMatrix1 = new JRadioButton("Матрица 1");
		rdMatrix1.setSelected(true);
		buttonGroup_1.add(rdMatrix1);
		rdMatrix1.setBounds(89, 98, 127, 25);
		dialog.getContentPane().add(rdMatrix1);
		
		JRadioButton rdMatrix2 = new JRadioButton("Матрица 2");
		buttonGroup_1.add(rdMatrix2);
		rdMatrix2.setBounds(89, 128, 127, 25);
		dialog.getContentPane().add(rdMatrix2);
		
		JButton btnRepair = new JButton("Исправить");
		btnRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdMatrix1.isSelected()) {
					if (rdAdd.isSelected() || rdSub.isSelected()) {
						changeSizeForAddSub(matrix1, matrix2.getColumnCount(), matrix2.getRowCount());
					} else {
						changeSizeForMult(matrix1, matrix2.getRowCount(), matrix1.getRowCount());
					}
				} else {
					if (rdAdd.isSelected() || rdSub.isSelected()) {
						changeSizeForAddSub(matrix2, matrix1.getColumnCount(), matrix1.getRowCount());
					} else {
						changeSizeForMult(matrix2, matrix2.getColumnCount(), matrix1.getColumnCount());
					}
				}
				dialog.dispose();
			}
		});
		btnRepair.setBounds(12, 162, 97, 25);
		dialog.getContentPane().add(btnRepair);
		
		JButton btnCancel = new JButton("Отмена");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		btnCancel.setBounds(163, 162, 97, 25);
		dialog.getContentPane().add(btnCancel);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("Для выполнения выбранной операции неверно указана размерность матрицы\r\n\r\nВы хотите исправить размерность?");
		textPane.setBounds(12, 13, 248, 72);
		dialog.getContentPane().add(textPane);
		dialog.setVisible(true);
	}
	private void showResult(JTable matrix) {
		
		matrix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		matrix.setRowHeight(50);
		matrix.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		final JDialog dialog = new JDialog(frame, "Результат выполнения операции", true);
		dialog.setLayout(null);
		dialog.setBounds(100, 100, 394, 360);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 351, 249);
		dialog.getContentPane().add(scrollPane);

		alignTableCells(matrix);
		scrollPane.setViewportView(matrix);

		JButton btnOk = new JButton("Готово");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		btnOk.setBounds(136, 275, 97, 25);
		dialog.getContentPane().add(btnOk);
		dialog.setVisible(true);
	}
/*
 * ----------------------------------------------------------------------------
 */
	private void addMatrix(JTable matrix1, JTable matrix2){
		
	if (matrix1.getRowCount() != matrix2.getRowCount() ||
				matrix1.getColumnCount() != matrix2.getColumnCount()) {
		
			wrongSizeDialog();
			return;
		}
		
		JTable resultMatrix = new JTable();
		DefaultTableModel tableModel = (DefaultTableModel) resultMatrix.getModel();
		
		tableModel.setRowCount(0);
		tableModel.setColumnCount(matrix1.getColumnCount());
		
		for (int i = 0; i < matrix1.getRowCount(); i++) {
			Vector<Integer> row = new Vector<Integer>();
			for (int j = 0; j < matrix1.getColumnCount(); j++) {
				row.add(Integer.valueOf(matrix1.getValueAt(i, j).toString()) + 
						Integer.valueOf(matrix2.getValueAt(i, j).toString()));
				}
			tableModel.addRow(row);					
		}
		showResult(resultMatrix);
	}
	private void subMatrix() {
		
		JTable tempMatrix = new JTable();
		DefaultTableModel tableModel = (DefaultTableModel) tempMatrix.getModel();
		
		tableModel.setRowCount(0);
		tableModel.setColumnCount(matrix2.getColumnCount());
		
		for (int i = 0; i < matrix2.getRowCount(); i++) {
			Vector<Integer> row = new Vector<Integer>();
			for (int j = 0; j < matrix2.getColumnCount(); j++) {
				row.add((-1) * Integer.valueOf(matrix2.getValueAt(i, j).toString()));
				}
			tableModel.addRow(row);					
		}
		addMatrix(matrix1, tempMatrix);
	}
	private void multMatrix() {
		
		if (matrix1.getColumnCount() != matrix2.getRowCount()) {
			wrongSizeDialog();
			return;
		}
		JTable resultMatrix = new JTable();
		DefaultTableModel tableModel = (DefaultTableModel) resultMatrix.getModel();
		
		tableModel.setRowCount(0);
		tableModel.setColumnCount(matrix2.getColumnCount());
		
		for (int i = 0; i < matrix1.getRowCount(); i++) {
			Vector<Integer> row = new Vector<Integer>();
			for (int j = 0; j < matrix2.getColumnCount(); j++) {
				int item = 0;
				for (int k = 0; k < matrix2.getRowCount(); k++) {
						item += Integer.valueOf(matrix1.getValueAt(i, k).toString()) * 
								Integer.valueOf(matrix2.getValueAt(k, j).toString());
				}
				row.add(item);
				}
			tableModel.addRow(row);					
		}
		showResult(resultMatrix);

	}
}
