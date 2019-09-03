package opJava.tasks;

import java.awt.EventQueue;
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
import javax.swing.SwingConstants;
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
	private JLabel label_3;
	private JLabel label_4;
	private Boolean matrix1Populated = false;
	private Boolean matrix2Populated = false;

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
		frame.setBounds(100, 100, 924, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Матрица 1"));
		panel.setBounds(12, 13, 440, 409);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		rowsMatrix1 = new JTextField();
		rowsMatrix1.setBounds(74, 49, 59, 22);
		panel.add(rowsMatrix1);
		rowsMatrix1.setColumns(10);
		
		colsMatrix1 = new JTextField();
		colsMatrix1.setBounds(74, 84, 59, 22);
		panel.add(colsMatrix1);
		colsMatrix1.setColumns(10);
		
		JButton btnSetSizeMatrix1 = new JButton("Установить");
		/*
		 * Обработчик нажатия кнопки
		 * изменения размера матрицы
		 */
		btnSetSizeMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMatrixSize(matrix1, rowsMatrix1, colsMatrix1);
			}
		});
		btnSetSizeMatrix1.setBounds(145, 48, 103, 58);
		panel.add(btnSetSizeMatrix1);
		
		loRangeMatrix1 = new JTextField();
		loRangeMatrix1.setText("0");
		loRangeMatrix1.setBounds(260, 49, 59, 22);
		panel.add(loRangeMatrix1);
		loRangeMatrix1.setColumns(10);
		
		hiRangeMatrix1 = new JTextField();
		hiRangeMatrix1.setText("0");
		hiRangeMatrix1.setBounds(260, 84, 59, 22);
		panel.add(hiRangeMatrix1);
		hiRangeMatrix1.setColumns(10);
		
		JButton btnPopulateMatrix1 = new JButton("Заполнить");
		/*
		 * Обработчик нажатия кнопки
		 * заполнения матрицы значениями
		 */
		btnPopulateMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matrix1Populated = populateMatrix(matrix1, loRangeMatrix1, hiRangeMatrix1);
			}
		});
		btnPopulateMatrix1.setBounds(331, 48, 97, 58);
		panel.add(btnPopulateMatrix1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 119, 415, 239);
		panel.add(scrollPane);
		
		matrix1 = new JTable();
		/*
		 * Отключаю возможность редактирования 
		 * матрицы №1 из интерфейса 
		 */
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
		/*
		 * Обработчик нажатия кнопки
		 * очистить матрицу
		 */
		btnClearMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearMatrix(matrix1);
				matrix1Populated = false;
			}
		});
		btnClearMatrix1.setBounds(161, 371, 97, 25);
		panel.add(btnClearMatrix1);
		
		JLabel lblNewLabel = new JLabel("Размер матрицы");
		lblNewLabel.setBounds(74, 26, 119, 16);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("Значения матрицы");
		label.setBounds(260, 26, 119, 16);
		panel.add(label);
		
		label_3 = new JLabel("Строк");
		label_3.setBounds(34, 49, 34, 16);
		panel.add(label_3);
		
		label_4 = new JLabel("Столбцов");
		label_4.setBounds(12, 84, 56, 16);
		panel.add(label_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Матрица 2"));
		panel_1.setBounds(453, 13, 440, 409);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		rowsMatrix2 = new JTextField();
		rowsMatrix2.setColumns(10);
		rowsMatrix2.setBounds(74, 49, 59, 22);
		panel_1.add(rowsMatrix2);
		
		colsMatrix2 = new JTextField();
		colsMatrix2.setColumns(10);
		colsMatrix2.setBounds(74, 84, 59, 22);
		panel_1.add(colsMatrix2);
		
		btnSetSizeMatrix2 = new JButton("Установить");
		/*
		 * Обработчик нажатия кнопки
		 * изменения размера матрицы
		 */
		btnSetSizeMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMatrixSize(matrix2, rowsMatrix2, colsMatrix2);
			}
		});
		btnSetSizeMatrix2.setBounds(145, 48, 103, 58);
		panel_1.add(btnSetSizeMatrix2);
		
		loRangeMatrix2 = new JTextField();
		loRangeMatrix2.setText("0");
		loRangeMatrix2.setColumns(10);
		loRangeMatrix2.setBounds(260, 49, 59, 22);
		panel_1.add(loRangeMatrix2);
		
		hiRangeMatrix2 = new JTextField();
		hiRangeMatrix2.setText("0");
		hiRangeMatrix2.setColumns(10);
		hiRangeMatrix2.setBounds(260, 84, 59, 22);
		panel_1.add(hiRangeMatrix2);
		
		btnPopulateMatrix2 = new JButton("Заполнить");
		/*
		 * Обработчик нажатия кнопки
		 * заполнения матрицы значениями
		 */
		btnPopulateMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matrix2Populated = populateMatrix(matrix2, loRangeMatrix2, hiRangeMatrix2);
			}
		});
		btnPopulateMatrix2.setBounds(331, 48, 97, 58);
		panel_1.add(btnPopulateMatrix2);
		
		btnClearMatrix2 = new JButton("Очистить");
		/*
		 * Обработчик нажатия кнопки
		 * очистить матрицу
		 */
		btnClearMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearMatrix(matrix2);
				matrix2Populated = false;
			}
		});
		btnClearMatrix2.setBounds(170, 371, 97, 25);
		panel_1.add(btnClearMatrix2);
		
		label_1 = new JLabel("Размер матрицы");
		label_1.setBounds(74, 26, 119, 16);
		panel_1.add(label_1);
		
		label_2 = new JLabel("Значения матрицы");
		label_2.setBounds(260, 26, 119, 16);
		panel_1.add(label_2);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 119, 416, 239);
		panel_1.add(scrollPane_1);
		
		matrix2 = new JTable();
		
		/*
		 * Отключаю возможность редактирования 
		 * матрицы №2 из интерфейса 
		 */
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Строк");
		lblNewLabel_1.setBounds(34, 52, 34, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Столбцов");
		lblNewLabel_2.setBounds(12, 87, 56, 16);
		panel_1.add(lblNewLabel_2);
		
		rdAdd = new JRadioButton("Сложение матриц");
		rdAdd.setSelected(true);
		buttonGroup.add(rdAdd);
		rdAdd.setBounds(380, 435, 168, 25);
		frame.getContentPane().add(rdAdd);
		
		rdSub = new JRadioButton("Вычитание матриц");
		buttonGroup.add(rdSub);
		rdSub.setBounds(380, 465, 168, 25);
		frame.getContentPane().add(rdSub);
		
		rdMult = new JRadioButton("Умножение матриц");
		buttonGroup.add(rdMult);
		rdMult.setBounds(380, 495, 168, 25);
		frame.getContentPane().add(rdMult);
		
		JButton btnPerformOperation = new JButton("Выполнить выбранное действие над матрицами");
		btnPerformOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Проверка, заполнены ли таблицы значениями
				 * Если нет, вывожу предупреждение
				 */
				if (!matrix1Populated || !matrix2Populated) {
					JOptionPane.showMessageDialog(null, "Для выполнения операции необходимо\nзаполнить матрицы значениями.", 
							"Предупреждение", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if (rdAdd.isSelected()) {
					/*
					 * Выполнить операцию сложения матриц
					 */
					addMatrix(matrix1, matrix2);
					
				} else if (rdSub.isSelected()) {
					/*
					 * Выполнить операцию вычитания матриц
					 */
					subMatrix();
					
				} else {
					/*
					 * Выполнить операцию умножения матриц
					 */
					multMatrix();
				}
			}
		});
		btnPerformOperation.setBounds(288, 529, 342, 39);
		frame.getContentPane().add(btnPerformOperation);
	}
	/*
	 * Метод выравнивает текст в ячейке
	 * таблицы по центру 
	 */
	private void alignTableCells(JTable matrix){

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		TableModel tm = matrix.getModel();
		
        for (int i = 0; i < tm.getColumnCount(); i++)
        {
        	matrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
	}
	/*
	 * Метод заполняет матрицу значениями
	 * Если заполнить удалось, возвращает true,
	 * в обратно случае возвращает false
	 */
	private Boolean populateMatrix(JTable matrix, JTextField low, JTextField high) {
		
		int x = 0;
		int y = 0;

		Random random = new Random();
		
		try {
			x = Integer.valueOf(low.getText());
			y = Integer.valueOf(high.getText());

			alignTableCells(matrix);
			
			DefaultTableModel tableModel = (DefaultTableModel) matrix.getModel();
			
			int currentRows = tableModel.getRowCount();
			
			/*
			 * Если указаны значения диапазона 0 - 0,
			 * то матрица заполняется произвольными
			 * значениями в диапазоне от 0 до 99
			 */
			
			if (x == 0 && y == 0) {
				tableModel.setRowCount(0);
				for (int i = 0; i < currentRows; i++) {
					Vector<Integer> row = new Vector<Integer>();
					for (int j = 0; j < matrix.getColumnCount(); j++) {
						int rand = random.nextInt(99);
						row.add(rand);
						}
					tableModel.addRow(row);					
					}
				return true;
			} else if ((y - x) < (currentRows * matrix.getColumnCount()))
				throw new Exception();

			/*
			 *  Если диапазон указан, заполнить
			 *  значениями в указанном диапазоне
			 */
			tableModel.setRowCount(0);
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
			return true;
			/*
			 * В случае, если поле для ввода значений
			 * диапазона пустое или указанного диапазона
			 * недостаточно для заполнения матрицы
			 * генерируется исключение и выводится предупреждение 
			 */
		} catch (Exception e1) {
			/*
			 * Диалог с предупреждением
			 */
			JOptionPane.showMessageDialog(null, "Неверно указаны значения диапазона.", 
					"Предупреждение", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	/*
	 * Метод устанавливает размер матрицы
	 */
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
	/*
	 * Метод очищает указанную матрицу
	 */
	private void clearMatrix(JTable matrix) {
		
		DefaultTableModel tableModel = (DefaultTableModel) matrix.getModel();
		
		int currentRowCount = tableModel.getRowCount();
		tableModel.setRowCount(0);
		tableModel.setRowCount(currentRowCount);
	}
	/*
	 *  Метод для исправления размера матрицы
	 */
	private void changeSize(JTable matrix, int x, int y) {
		
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
	 * Метод выводит диалог с предупреждением
	 * о несоответствии размеров матриц для
	 * выбранной операции и предлагает исправить
	 * выбранную матрицу
	 */
	private void wrongSizeDialog() {
		
		final ButtonGroup buttonGroup_1 = new ButtonGroup();
		final JDialog dialog = new JDialog(frame, "Ошибка размерности", true);
		dialog.getContentPane().setLayout(null);
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
						/*
						 * Вызываем метод исправления размера матрицы
						 * для операций сложения и вычитания
						 * для первой матрицы
						 */
						changeSize(matrix1, matrix2.getColumnCount(), matrix2.getRowCount());
					} else {
						/*
						 * Вызываем метод исправления размера матрицы
						 * для операции умножения для первой матрицы
						 */
						changeSize(matrix1, matrix2.getRowCount(), matrix1.getRowCount());
					}
				} else {
					if (rdAdd.isSelected() || rdSub.isSelected()) {
						/*
						 * Вызываем метод исправления размера матрицы
						 * для операций сложения и вычитания
						 * для второй матрицы
						 */
						changeSize(matrix2, matrix1.getColumnCount(), matrix1.getRowCount());
					} else {
						/*
						 * Вызываем метод исправления размера матрицы
						 * для операции умножения для второй матрицы
						 */
						changeSize(matrix2, matrix2.getColumnCount(), matrix1.getColumnCount());
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
	/*
	 * Метод выводит диалог с 
	 * результирующей матрицей
	 */
	private void showResult(JTable matrix) {
		
		matrix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		matrix.setRowHeight(50);
		matrix.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		final JDialog dialog = new JDialog(frame, "Результат выполнения операции", true);
		dialog.getContentPane().setLayout(null);
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
	 * Метод выполняет операцию сложения матриц
	 */
	private void addMatrix(JTable matrix1, JTable matrix2){
		
		/*
		 * Проверяю размерность, если размерность неверная
		 * вывожу диалог с предупреждением и предложением
		 * исправить размер для выбранной операции 
		 */

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
		/*
		 * Вывожу диалог с результирующей таблицей
		 */
		showResult(resultMatrix);
	}
	/*
	 * Метод выполняет операцию вычитания матриц
	 */
	private void subMatrix() {
		
		/*
		 * Создаю временную таблицу и заполняю
		 * значениями таблицы №2 умноженными на -1
		 */
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
		/*
		 * Выполняю операцию сложения для 
		 * таблицы №1 и временной таблицы
		 */
		addMatrix(matrix1, tempMatrix);
	}
	/*
	 * Метод выполняет операцию умножения матриц
	 */
	private void multMatrix() {
		
		/*
		 * Проверяю размерность, если размерность неверная
		 * вывожу диалог с предупреждением и предложением
		 * исправить размер для выбранной операции 
		 */
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
		/*
		 * Вывожу диалог с результирующей таблицей
		 */
		showResult(resultMatrix);

	}
}
