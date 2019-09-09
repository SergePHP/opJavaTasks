package opJava.tasks;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
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
	private Rectangle2D rectangle;
	private JTextArea rectInfo;
	private JPanel panelDrawShapes;
	
	private double xСoeff = 1;
	private double yCoeff = 1;
	
	private int xMax = 0;
	private int yMax = 0;

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
		panelDrawShapes.setLayout(null);
		frame.getContentPane().add(panelDrawShapes);
		
		JButton btnFindIntersection = new JButton("Отобразить координаты отрезков, пересекающих прямоугольную область");
		btnFindIntersection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isIntersect(20, 20, 140, 120);
			}
		});
		btnFindIntersection.setBounds(12, 828, 636, 37);
		frame.getContentPane().add(btnFindIntersection);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(143, 878, 382, 122);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea intersectionInfo = new JTextArea();
		scrollPane_2.setViewportView(intersectionInfo);
	}
	private boolean isIntersect(double x1, double y1, double x2, double y2) {
		
		double x3 = rectangle.getMinX();
		double y3 = rectangle.getMinY();
		double x4 = rectangle.getMaxX();
		double y4 = rectangle.getMinY();
		
		double k1 = 0.0;
		double k2 = 0.0;
		
		double b1 = 0.0;
		double b2 = 0.0;
		
		if(x1 >= x2) {
			double temp = x1;
			x1 = x2;
			x2 = temp;
			temp = y1;
			y1 = y2;
			y2 = temp;
		}
		if(x3 >= x4) {
			double temp = x3;
			x3 = x4;
			x4 = temp;
			temp = y3;
			y3 = y4;
			y4 = temp;
		}
		if (y1 != y2) {
			k1 = (y2 - y1) / (x2 - x1);	
		}
		if (y3 != y4) {
			k2 = (y4 - y3) / (x4 - x3);
		}

		if (k1 == k2) return false;
		
		b1 = y1 - k1 * x1; 
		b2 = y3 - k2 * x3;
		
		double x = (b2 - b1) / (k1 - k2);
		double y = k1*x + b1;
		
		if (((x1 <= x) && (x2 >= x) && (x3 <= x) && (x4 >= x)) 
				|| ((y1 <= y) && (y2 >= y) && (y3 <= y) && (y4 >= y))) {
			return true;
		}
		return false;
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
	private int[] getMaxImageSize() {
		
		int[] imageSize = new int[2];
		
		Queue<Integer> xCoordinates = new PriorityQueue<>(new Comparator<Integer>() {
			
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
		
		Queue<Integer> yCoordinates = new PriorityQueue<>(new Comparator<Integer>() {
			
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
		
        if(lines.getModel().getRowCount() != 0) {
	        
    	DefaultTableModel tableModel = (DefaultTableModel) lines.getModel();
    	
    	for (int i = 0; i < tableModel.getRowCount(); i++) {
    		xCoordinates.add(Integer.valueOf(lines.getValueAt(i, 0).toString()));
    		xCoordinates.add(Integer.valueOf(lines.getValueAt(i, 2).toString()));
    		yCoordinates.add(Integer.valueOf(lines.getValueAt(i, 1).toString()));
    		yCoordinates.add(Integer.valueOf(lines.getValueAt(i, 3).toString()));
			}
        }
        if(rectangle != null) {
        	xCoordinates.add((int)rectangle.getWidth() + (int)rectangle.getX());
    		yCoordinates.add((int)rectangle.getHeight() + (int)rectangle.getY());
        }
        imageSize[0] = xCoordinates.poll();
        imageSize[1] = yCoordinates.poll();
		return imageSize;
	}
	/*
	 * Метод предназначен для добавления отрезка
	 */
	private void addLine() {
		/*
		 * Получаю координаты отрезка
		 */
		int[] lineCoord = readCoordinates(lineStartX, lineStartY, 
				lineEndX, lineEndY);
		/*
		 * Если отрезок задан, добавляю 
		 * строку с координатами в таблицу 
		 */
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
		/*
		 * Получаю индекс выбранной строки
		 */
		int row = lines.getSelectedRow();
		/*
		 * Если строка выбрана, удаляю
		 */
		if (row != -1) {
			tableModel.removeRow(row);	
		}
	}
	/*
	 * Метод создает прямоугольник
	 */
	private void createRect(){
		/*
		 * Получаю абсолютные координаты прямоугольника
		 */
		int[] rectCoord = readCoordinates(rectUpX, rectUpY, 
				rectDownX, rectDownY);
		if(rectCoord != null) {
			/*
			 * Если координаты заданы, создаю прямоугольник
			 * используя Rectangle2D класс
			 */
			rectangle = new Rectangle2D.Double(rectCoord[0], rectCoord[1],
					rectCoord[2] - rectCoord[0], rectCoord[3] - rectCoord[1]);
			/*
			 * Вывожу информацию о фигуре в текстовую область
			 */
			rectInfo.setText("");
			rectInfo.setText("Задан прямоугольник с координатами:\nX="
					+ rectangle.getX() + "\nY=" + rectangle.getY()
					+ "\nШирина=" + rectangle.getWidth() + "\nВысота=" + rectangle.getHeight());
		}
	}
	/*
	 * Метод для вывода отрезков
	 * и прямоугольника на панели
	 */
	private void drawShapes() {
		
		/*
		 * Удаляю все компоненты из контейнера
		 * и валидирую контейнер
		 */
		panelDrawShapes.removeAll();
		panelDrawShapes.validate();
		
		/*
		 * Если нет элементов для отображения,
		 * то отображаю сообщение в область вывода
		 */
		if(lines.getModel().getRowCount() == 0 && rectangle == null) {
			JLabel tempLabel = new JLabel("Нет объектов для отрисовки");
			tempLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tempLabel.setSize(345, 16);
			tempLabel.setLocation(4, 4);
			panelDrawShapes.add(tempLabel);
			panelDrawShapes.repaint();
			return;
		}
		/*
		 * Для отображения элементов создаю экземпляр
		 * пользовательской панели, в котором выполняются
		 * все необходимые процедуры по подготовке и выводу
		 * изображения и размещаю его на панель 
		 */
		PanelWithShapes customDrawPanel = new PanelWithShapes();
		customDrawPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		customDrawPanel.setSize(panelDrawShapes.getSize());
		customDrawPanel.setLocation(0, 0);
		panelDrawShapes.add(customDrawPanel);
		panelDrawShapes.repaint();
	}
	/*
	 * Метод для получения масштабированного изображения
	 */
	private BufferedImage getScaledImage(BufferedImage src, int w, int h){
	    
		int finalw = w;
	    int finalh = h;
	    double factorW = 1.0d;
	    double factorH = 1.0d;
    
	    /*
	     * Получаю коэффициенты для масштабирования
	     * по двум осям и применяю больший 
	     * (меньшее значение) 
	     */
	    factorW = (w / (double)src.getWidth());
	    factorH = (h / (double)src.getHeight());
	    
	    if(factorW < factorH) {
        	finalw = (int)(src.getWidth() * factorW);
        	finalh = (int)(src.getHeight() * factorW);
	    } else {
        	finalw = (int)(src.getWidth() * factorH);
        	finalh = (int)(src.getHeight() * factorH);
	    }
	    /*
	     * Создаю и возвращаю масштабированное изображение
	     */
	    BufferedImage resizedImg = new BufferedImage(finalw, finalh, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(src, 0, 0, finalw, finalh, null);
	    g2.dispose();
	    return resizedImg;
	}
	/*
	 * Создаю пользовательский объект, расширяющий JPanel
	 * в которой переопределяю метод, ответственный
	 * за отображение элемента, в котором реализован
	 * вывод всех элементов, заданных пользователем
	 * 
	 * Абсолютный ноль всех элементов находится в 
	 * левом верхнем углу области вывода
	 */
	public class PanelWithShapes extends JPanel {

	    @Override
	    protected void paintComponent(Graphics g) {
	        
	    	super.paintComponent(g);
	    	
	    	/*
	    	 * Для вывода геометрических фигур
	    	 * использую класс Graphics2D
	    	 */
	        Graphics2D g2d = (Graphics2D) g;
	        
	        /*
	         * Определяю максимальные размеры изображения
	         */
	        int[] maxImageSize = getMaxImageSize();
	        
	        /*
	         *  Создаю новое изображение используя
	         *  максимальные размеры изображения и
	         *  запас 10 пикс. по двум осям
	         */
	        BufferedImage img = new BufferedImage(maxImageSize[0]+10, maxImageSize[1]+10, BufferedImage.TRANSLUCENT);
	        Graphics2D gr = img.createGraphics();
	        gr.setColor(new Color(0, 0, 0));
	        
	        /*
	         * Если есть отрезки, то вывожу
	         * в цикле все заданные отрезки
	         */
	        if(lines.getModel().getRowCount() != 0) {
	        
        	DefaultTableModel tableModel = (DefaultTableModel) lines.getModel();
        	
        	for (int k = 0; k < tableModel.getRowCount(); k++) {
        		gr.drawLine(Integer.valueOf(lines.getValueAt(k, 0).toString()),
        				Integer.valueOf(lines.getValueAt(k, 1).toString()),
        						Integer.valueOf(lines.getValueAt(k, 2).toString()), 
        							 Integer.valueOf(lines.getValueAt(k, 3).toString()));
				}
	        }
	        /*
	         * Если есть прямоугольник, 
	         * то вывожу прямоугольник
	         */
	        if(rectangle != null) {
		        gr.draw(rectangle);
	        }

	        gr.dispose();

	        /*
	         * Вывожу изображение.
	         * Если изображение больше, чем размер панели,
	         * то предварительно изображение масштабируется
	         */
	        if(panelDrawShapes.getWidth() >= img.getWidth() 
	        		&& panelDrawShapes.getHeight() >= img.getHeight()) {
		        g2d.drawImage(img, 2, 2, null);
	        } else {
	        	BufferedImage resizedImage = getScaledImage(img, panelDrawShapes.getWidth(),
		        		panelDrawShapes.getHeight());
		        g2d.drawImage(resizedImage, 2, 2, null);
	        }
	    }
	} // end of PanelWithShapes class
} // end of opJavaTask3 class
