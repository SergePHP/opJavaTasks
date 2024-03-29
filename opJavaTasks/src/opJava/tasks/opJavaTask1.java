package opJava.tasks;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class opJavaTask1 {

	private JFrame frame;
	private JTextField valueField;
	private String[] types = new String[] {"Integer", "String", "Float", "Object", "Date"};
	private JTextField indexField;
	private final ButtonGroup radioButtonsGroup = new ButtonGroup();
	
	private List vector;
	private List arrayList;
	private List linkedList;
	private Map hashMap;
	private Map treeMap;
	
	private JRadioButton rbVector;
	private JRadioButton rbArrayList;
	private JRadioButton rbLinkedList;
	private JRadioButton rbHashMap;
	private JRadioButton rbTreeMap;
	private JTextArea textAreaCollectionInfo;
	private JList listItemsTypes;
	private JList listItemsFound;
	private DefaultListModel listModelItemsFound;
	private DefaultListModel listModelCollectionContent;
	private JComboBox typeOfItemsCombo;
	private DefaultListModel listModelDeleteAndShow;
	
	private Queue<Integer> hmDelIndexes = new PriorityQueue<>();
	private Queue<Integer> tmDelIndexes = new PriorityQueue<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opJavaTask1 window = new opJavaTask1();
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
	public opJavaTask1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame();
		frame.setTitle("Коллекции");
		frame.setBounds(100, 100, 860, 1025);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(12, 13, 445, 303);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCreateCollection = new JButton("Создать и отобразить коллекцию");
		btnCreateCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCollection();
			}
		});
		btnCreateCollection.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateCollection.setBounds(30, 13, 382, 30);
		panel.add(btnCreateCollection);
		
		JButton btnClearCollection = new JButton("Очистить коллекцию");
		btnClearCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearCollection();
			}
		});
		btnClearCollection.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClearCollection.setBounds(30, 48, 382, 30);
		panel.add(btnClearCollection);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 91, 313, 185);
		panel.add(scrollPane);
		
		textAreaCollectionInfo = new JTextArea();
		textAreaCollectionInfo.setEditable(false);
		scrollPane.setViewportView(textAreaCollectionInfo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBounds(469, 13, 361, 303);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Тип создаваемой коллекции...");
		label.setBounds(10, 10, 223, 20);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(label);
		
		rbVector = new JRadioButton("Vector");
		rbVector.setForeground(new Color(0, 0, 255));
		rbVector.setSelected(true);
		radioButtonsGroup.add(rbVector);
		rbVector.setBackground(new Color(175, 238, 238));
		rbVector.setFont(new Font("Arial", Font.ITALIC, 17));
		rbVector.setBounds(34, 55, 127, 25);
		panel_1.add(rbVector);
		
		rbArrayList = new JRadioButton("ArrayList");
		rbArrayList.setForeground(new Color(0, 0, 255));
		radioButtonsGroup.add(rbArrayList);
		rbArrayList.setBackground(new Color(175, 238, 238));
		rbArrayList.setFont(new Font("Arial", Font.ITALIC, 17));
		rbArrayList.setBounds(34, 85, 127, 25);
		panel_1.add(rbArrayList);
		
		rbLinkedList = new JRadioButton("LinkedList");
		rbLinkedList.setForeground(new Color(0, 0, 255));
		radioButtonsGroup.add(rbLinkedList);
		rbLinkedList.setBackground(new Color(175, 238, 238));
		rbLinkedList.setFont(new Font("Arial", Font.ITALIC, 17));
		rbLinkedList.setBounds(34, 114, 127, 25);
		panel_1.add(rbLinkedList);
		
		rbHashMap = new JRadioButton("HashMap");
		rbHashMap.setForeground(new Color(0, 0, 255));
		radioButtonsGroup.add(rbHashMap);
		rbHashMap.setBackground(new Color(175, 238, 238));
		rbHashMap.setFont(new Font("Arial", Font.ITALIC, 17));
		rbHashMap.setBounds(34, 144, 127, 25);
		panel_1.add(rbHashMap);
		
		rbTreeMap = new JRadioButton("TreeMap");
		rbTreeMap.setForeground(new Color(0, 0, 255));
		radioButtonsGroup.add(rbTreeMap);
		rbTreeMap.setBackground(new Color(175, 238, 238));
		rbTreeMap.setFont(new Font("Arial", Font.ITALIC, 17));
		rbTreeMap.setBounds(34, 174, 127, 25);
		panel_1.add(rbTreeMap);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(253, 245, 230));
		panel_2.setBounds(12, 329, 403, 174);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("Найти в коллекции все элементы указанного типа:");
		label_1.setBounds(12, 13, 377, 20);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(label_1);
		
		listItemsTypes = new JList();
		listItemsTypes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listItemsTypes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listItemsTypes.setBounds(22, 46, 147, 115);
		panel_2.add(listItemsTypes);
		listItemsTypes.setModel(new AbstractListModel() {
			public int getSize() {
				return types.length;
			}
			public Object getElementAt(int index) {
				return types[index];
			}
		});
		listItemsTypes.setSelectedIndex(0);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(253, 245, 230));
		panel_3.setBounds(427, 329, 403, 174);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnFindItems = new JButton("Вывести найденные элементы в виде списка");
		btnFindItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findItemsInCollections();
			}
		});
		btnFindItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFindItems.setBounds(12, 13, 374, 30);
		panel_3.add(btnFindItems);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(62, 56, 280, 105);
		panel_3.add(scrollPane_1);
		
		listModelItemsFound = new DefaultListModel();
		listItemsFound = new JList(listModelItemsFound);
		scrollPane_1.setViewportView(listItemsFound);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 228, 225));
		panel_4.setBounds(12, 516, 818, 239);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Тип добавляемого элемента:");
		lblNewLabel.setBounds(12, 5, 350, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel);
		
		typeOfItemsCombo = new JComboBox();
		typeOfItemsCombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		typeOfItemsCombo.setModel(new DefaultComboBoxModel(types));
		typeOfItemsCombo.setBounds(12, 38, 279, 25);
		panel_4.add(typeOfItemsCombo);
		
		valueField = new JTextField();
		valueField.setBounds(12, 98, 279, 30);
		panel_4.add(valueField);
		valueField.setColumns(10);
		
		JLabel label_2 = new JLabel("Значение добавляемого элемента:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(12, 73, 279, 20);
		panel_4.add(label_2);
		
		JButton btnAddItem = new JButton("Добавить элемент коллекции");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemsToCollection();
			}
		});
		btnAddItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddItem.setBounds(468, 13, 303, 30);
		panel_4.add(btnAddItem);
		
		JButton btnShowCollection = new JButton("Отобразить коллекцию");
		btnShowCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printCollection();
			}
		});
		btnShowCollection.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnShowCollection.setBounds(468, 52, 303, 30);
		panel_4.add(btnShowCollection);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(478, 85, 279, 141);
		panel_4.add(scrollPane_2);
		
		listModelCollectionContent = new DefaultListModel();
		JList listCollectionContent = new JList(listModelCollectionContent);
		scrollPane_2.setViewportView(listCollectionContent);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(221, 160, 221));
		panel_5.setBounds(12, 768, 818, 200);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_3 = new JLabel("Индекс удаляемого элемента:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(12, 13, 350, 20);
		panel_5.add(label_3);
		
		indexField = new JTextField();
		indexField.setColumns(10);
		indexField.setBounds(12, 46, 279, 30);
		panel_5.add(indexField);
		
		JButton btnDeleteItem = new JButton("Удалить элемент и отобразить коллекцию");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAndShow();
			}
		});
		btnDeleteItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteItem.setBounds(446, 13, 360, 30);
		panel_5.add(btnDeleteItem);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(479, 51, 279, 139);
		panel_5.add(scrollPane_3);
		
		listModelDeleteAndShow = new DefaultListModel();
		JList listDeleteAndShow = new JList(listModelDeleteAndShow);
		scrollPane_3.setViewportView(listDeleteAndShow);
	}
	/*
	 *  Метод реализует функцию: 
	 * "Вывести найденные элементы в виде списка"
	 */
	
	private void findItemsInCollections() {

		String selectedValue = listItemsTypes.getSelectedValue().toString();
		
		if (rbVector.isSelected()) {
			
			if(vector != null) {
				ColJob.printCollection(ColJob.findItems(selectedValue, vector),
						listModelItemsFound);
			} else {
				ColJob.printNoCollectionMessage(listModelItemsFound);
			}
		} else if (rbArrayList.isSelected()) {
			
			if(arrayList != null) {
				ColJob.printCollection(ColJob.findItems(selectedValue, arrayList),
						listModelItemsFound);
			} else {
				ColJob.printNoCollectionMessage(listModelItemsFound);
			}
		} else if (rbLinkedList.isSelected()) {
			
			if(linkedList != null) {
				ColJob.printCollection(ColJob.findItems(selectedValue, linkedList),
						listModelItemsFound);
			} else {
				ColJob.printNoCollectionMessage(listModelItemsFound);
			}
		} else if (rbHashMap.isSelected()) {
			
			if(hashMap != null) {
				ColJob.printCollection(ColJob.findItems(selectedValue, hashMap),
						listModelItemsFound);
			} else {
				ColJob.printNoCollectionMessage(listModelItemsFound);
			}
		} else if (rbTreeMap.isSelected()) {
			
			if(treeMap != null) {
				ColJob.printCollection(ColJob.findItems(selectedValue, treeMap),
						listModelItemsFound);
			} else {
				ColJob.printNoCollectionMessage(listModelItemsFound);
			}
		}
	}
	/*
	 * Метод реализует функцию: 
	 * "Создать и отобразить коллекцию"
	 */
	private void createCollection() {
		
		if (rbVector.isSelected()) {
			if(vector == null) {
				vector = new Vector();
			}
			ColJob.printCollection(ColJob.findAllItems(vector, true),
					textAreaCollectionInfo);

		} else if (rbArrayList.isSelected()) {
			if(arrayList == null) {
				arrayList = new ArrayList();
			}
			ColJob.printCollection(ColJob.findAllItems(arrayList, true),
					textAreaCollectionInfo);
			
		} else if (rbLinkedList.isSelected()) {
			if(linkedList == null) {
				linkedList = new LinkedList();
			}
			ColJob.printCollection(ColJob.findAllItems(linkedList, true),
					textAreaCollectionInfo);
			
		} else if (rbHashMap.isSelected()) {
			if(hashMap == null) {
				hashMap = new HashMap();
			}
			ColJob.printCollection(ColJob.findAllItems(hashMap, true),
					textAreaCollectionInfo);
			
		} else if (rbTreeMap.isSelected()) {
			if(treeMap == null) {
				treeMap = new TreeMap();
			}
			ColJob.printCollection(ColJob.findAllItems(treeMap, true),
					textAreaCollectionInfo);
		}
	}
	/*
	 * Метод реализует функцию: 
	 * "Очистить коллекцию"
	 */
	private void clearCollection() {
		
		if (rbVector.isSelected()) {
			
			if(vector != null) {
				vector.clear();
				ColJob.printCollection(ColJob.findAllItems(vector, true),
						textAreaCollectionInfo);
			} else {
				ColJob.printNoCollectionMessage(textAreaCollectionInfo);
			}
		} else if (rbArrayList.isSelected()) {
			
			if(arrayList != null) {
				arrayList.clear();
				ColJob.printCollection(ColJob.findAllItems(arrayList, true),
						textAreaCollectionInfo);
			} else {
				ColJob.printNoCollectionMessage(textAreaCollectionInfo);
			}

		} else if (rbLinkedList.isSelected()) {
			
			if(linkedList != null) {
				linkedList.clear();
				ColJob.printCollection(ColJob.findAllItems(linkedList, true),
						textAreaCollectionInfo);
			} else {
				ColJob.printNoCollectionMessage(textAreaCollectionInfo);
			}
		} else if (rbHashMap.isSelected()) {
			
			if(hashMap != null) {
				hashMap.clear();
				ColJob.printCollection(ColJob.findAllItems(hashMap, true),
						textAreaCollectionInfo);
			} else {
				ColJob.printNoCollectionMessage(textAreaCollectionInfo);
			}
		} else if (rbTreeMap.isSelected()) {
			
			if(treeMap != null) {
				treeMap.clear();
				ColJob.printCollection(ColJob.findAllItems(treeMap, true),
						textAreaCollectionInfo);
			} else {
				ColJob.printNoCollectionMessage(textAreaCollectionInfo);
			}
		}
	}
	/*
	 * Метод реализует функцию:
	 * "Отобразить коллекцию"
	 */
	private void printCollection() {
		
		if (rbVector.isSelected()) {
			
			if(vector != null) {
				ColJob.printCollection(ColJob.findAllItems(vector, false),
						listModelCollectionContent);
			} else {
				ColJob.printNoCollectionMessage(listModelCollectionContent);
			}
		} else if (rbArrayList.isSelected()) {
			
			if(arrayList != null) {
				ColJob.printCollection(ColJob.findAllItems(arrayList, false),
						listModelCollectionContent);
			} else {
				ColJob.printNoCollectionMessage(listModelCollectionContent);
			}

		} else if (rbLinkedList.isSelected()) {
			
			if(linkedList != null) {
				ColJob.printCollection(ColJob.findAllItems(linkedList, false),
						listModelCollectionContent);
			} else {
				ColJob.printNoCollectionMessage(listModelCollectionContent);
			}
		} else if (rbHashMap.isSelected()) {
			
			if(hashMap != null) {
				ColJob.printCollection(ColJob.findAllItems(hashMap, false),
						listModelCollectionContent);
			} else {
				ColJob.printNoCollectionMessage(listModelCollectionContent);
			}
		} else if (rbTreeMap.isSelected()) {
			
			if(treeMap != null) {
				ColJob.printCollection(ColJob.findAllItems(treeMap, false),
						listModelCollectionContent);
			} else {
				ColJob.printNoCollectionMessage(listModelCollectionContent);
			}
		}
	}
	/*
	 * Метод реализует функцию:
	 * "Добавить элемент коллекции"
	 */
	private void addItemsToCollection() {
		
		listModelCollectionContent.clear();

		Object value = parseValue();
		
		if (value == null) {
			return;
		}

		if (rbVector.isSelected()) {
			
			if(vector != null) {
				vector.add(value);
			} else {
				ColJob.printNoCollectionMessage(listModelCollectionContent);
			}
		} else if (rbArrayList.isSelected()) {
			
			if(arrayList != null) {
				arrayList.add(value);
			} else {
				ColJob.printNoCollectionMessage(listModelCollectionContent);
			}
		} else if (rbLinkedList.isSelected()) {
			
			if(linkedList != null) {
				linkedList.add(value);
			} else {
				ColJob.printNoCollectionMessage(listModelCollectionContent);
			}
		} else if (rbHashMap.isSelected()) {
			
			if(hashMap != null) {
				if(hmDelIndexes.peek() != null) {
					hashMap.put(hmDelIndexes.poll(), value);
				} else {
					hashMap.put(hashMap.size(), value);
				}
			} else {
				ColJob.printNoCollectionMessage(listModelCollectionContent);
			}
		} else if (rbTreeMap.isSelected()) {
			
			if(treeMap != null) {
				if (tmDelIndexes.peek() != null) {
					treeMap.put(tmDelIndexes.poll(), value);
				} else {
					treeMap.put(treeMap.size(), value);
				}

			} else {
				ColJob.printNoCollectionMessage(listModelCollectionContent);
			}
		}
	}
	/*
	 * Метод реализует функцию:
	 * "Удалить элемент и отобразить коллекцию"
	 */
	private void deleteAndShow() {
	
		try {
			
			int index = Integer.valueOf(indexField.getText());
			
			if (rbVector.isSelected()) {
				
				if(vector != null) {
					vector.remove(index);
					ColJob.printCollection(ColJob.findAllItems(vector, false),
							listModelDeleteAndShow);
				} else {
					ColJob.printNoCollectionMessage(listModelDeleteAndShow);
				}
			} else if (rbArrayList.isSelected()) {
				
				if(arrayList != null) {
					arrayList.remove(index);
					ColJob.printCollection(ColJob.findAllItems(arrayList, false),
							listModelDeleteAndShow);
				} else {
					ColJob.printNoCollectionMessage(listModelDeleteAndShow);
				}
			} else if (rbLinkedList.isSelected()) {
				
				if(linkedList != null) {
					linkedList.remove(index);
					ColJob.printCollection(ColJob.findAllItems(linkedList, false),
							listModelDeleteAndShow);
				} else {
					ColJob.printNoCollectionMessage(listModelDeleteAndShow);
				}
			} else if (rbHashMap.isSelected()) {
				
				if(hashMap != null) {
					
					if(hashMap.remove((Integer)index) == null) {
						throw new IndexOutOfBoundsException("Array index out of range.");
					}
					/*
					 * Если элемент по индексу удален,
					 * то индекс сохраняется в стеке
					 * и используется для добавления
					 * новых элементов в коллекцию.
					 */
					hmDelIndexes.add(index);						
					ColJob.printCollection(ColJob.findAllItems(hashMap, false),
							listModelDeleteAndShow);
				} else {
					ColJob.printNoCollectionMessage(listModelDeleteAndShow);
				}
			} else if (rbTreeMap.isSelected()) {
				
				if(treeMap != null) {
					
					if(treeMap.remove((Integer)index) == null) {
						throw new IndexOutOfBoundsException("Array index out of range.");
					}
					/*
					 * Если элемент по индексу удален,
					 * то индекс сохраняется в стеке
					 * и используется для добавления
					 * новых элементов в коллекцию.
					 */
					tmDelIndexes.add(index);
					ColJob.printCollection(ColJob.findAllItems(treeMap, false),
							listModelDeleteAndShow);
				} else {
					ColJob.printNoCollectionMessage(listModelDeleteAndShow);
				}
			}
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Ошибка выполнения операции\n" + e.getMessage(), 
					"Ошибка", JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * Метод определяет тип добавляемого значения
	 * и возвращает введенное значение в поле 
	 * ввода в виде объекта этого типа или null,
	 * если введенное значение не соответствует
	 * указанному типу 
	 */
	
	private Object parseValue() {
		
		try {
			String selectedType = typeOfItemsCombo.getSelectedItem().toString();
			
			if(selectedType.equals(new Integer(0).getClass().getSimpleName())) {
				
				return Integer.valueOf(valueField.getText());
				
			} else if (selectedType.equals(new String().getClass().getSimpleName())) {
				
				return valueField.getText();
				
			} else if (selectedType.equals(new Float(0F).getClass().getSimpleName())) {
				
				return Float.valueOf(valueField.getText());
				
			} else if (selectedType.equals(new Object().getClass().getSimpleName())) {
				
				return new Object();
				
			} else if (selectedType.equals(new Date().getClass().getSimpleName())) {
				
				String[] date = valueField.getText().split("\\.");
				
				// Формат даты ДД.ММ.ГГГГ
				int day = Integer.valueOf(date[0]);
				int month = Integer.valueOf(date[1]);
				int year = Integer.valueOf(date[2]);
				return new Date(year - 1900, month, day);
			}
			
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Неверно задано значение\n" + e.getMessage(), 
					"Ошибка", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
	}
	/*
	 * Статический класс, в котором реализован
	 * набор методов для работы с коллекциями
	 * и вывода отформатированной информации
	 * в указанные поля вывода
	 */
	private static class ColJob {
		/*
		 * Метод выполняет поиск элементов
		 * указанного типа в коллекциях, которые
		 * реализуют интерфейс Collection
		 * и возвращает массив, содержащий найденные
		 * объекты или строку "Элементы не найдены"
		 */
		private static <T> List<String> findItems(String type, Collection<T> collection) {
			
			List<String> itemsToPrint = new ArrayList<>();
			
			for (T item : collection) {
				if(item.getClass().getSimpleName().equals(type)) {
					itemsToPrint.add(item.toString());
				}
			}
			if(itemsToPrint.size() == 0) {
				itemsToPrint.add("Элементы не найдены");
			}
			return itemsToPrint;
		}
		/*
		 * Метод выполняет поиск элементов
		 * указанного типа в коллекциях, которые
		 * реализуют интерфейс Map и возвращает массив,
		 * содержащий найденные объекты 
		 * или строку "Элементы не найдены"
		 */
		private static <K, V> List<String> findItems(String type, Map<K, V> map) {
			
			List<String> itemsToPrint = new ArrayList<>();
			
			for (Map.Entry<K, V> entry : map.entrySet()) {
				if (entry.getValue().getClass().getSimpleName().equals(type)) {
					itemsToPrint.add(entry.getKey() + " : " + entry.getValue());
				}
			}	
			if(itemsToPrint.size() == 0) {
				itemsToPrint.add("Элементы не найдены");
			}
			return itemsToPrint;
		}
		/*
		 * Метод выполняет поиск всех элементов
		 * в коллекциях, которые реализуют 
		 * интерфейс Collection и возвращает массив,
		 * содержащий найденные объекты 
		 * или строку "Пустая коллекция"
		 * Если установлен флаг formatted=true, то 
		 * массив дополнительно форматируется
		 */
		private static <T> List<String> findAllItems(Collection<T> collection, Boolean formatted) {
			
			List<String> itemsToPrint = new ArrayList<>();
			
			if(!formatted) {
				for (T item : collection) {
					itemsToPrint.add(item.toString());
				}
				if(itemsToPrint.size() == 0) {
					itemsToPrint.add("Пустая коллекция");
				}
			} else {
				itemsToPrint.add("Коллекция \"" + collection.getClass().getName() + "\"\n{");
				
				int index = 0; 
				
				for (T item : collection) {
					itemsToPrint.add(index + " : " + item.toString() + ", (" + item.getClass().getName() + ")");
					++index;
				}
				itemsToPrint.add("}");
			}
			return itemsToPrint;
		}
		/*
		 * Метод выполняет поиск всех элементов
		 * в коллекциях, которые реализуют 
		 * интерфейс Map и возвращает массив,
		 * содержащий найденные объекты 
		 * или строку "Пустая коллекция"
		 * Если установлен флаг formatted=true, то 
		 * массив дополнительно форматируется
		 */
		private static <K, V> List<String> findAllItems(Map<K, V> map, Boolean formatted) {
			
			List<String> itemsToPrint = new ArrayList<>();
			
			if(!formatted) {
				for (Map.Entry<K, V> entry : map.entrySet()) {
				itemsToPrint.add(entry.getKey() + " : " + entry.getValue());
				}
				if(itemsToPrint.size() == 0) {
					itemsToPrint.add("Пустая коллекция");
				}	
			} else {
				itemsToPrint.add("Коллекция \"" + map.getClass().getName() + "\"\n{");
				
				for (Map.Entry<K, V> entry : map.entrySet()) {
					itemsToPrint.add(entry.getKey() + " : " + entry.getValue() + 
							", (" + entry.getKey().getClass().getName() + " : " + entry.getValue().getClass().getName() + ")");
				}
				itemsToPrint.add("}");
			}
			return itemsToPrint;
		}
		/*
		 * Метод выполняет вывод массива строк
		 * на элемент типа JList 
		 */
		private static void printCollection(List<String> printData, DefaultListModel listModel) {
			
			listModel.clear();
			
			for (String string : printData) {
				listModel.addElement(string);
			}
		}
		/*
		 * Метод выполняет вывод массива строк
		 * на элемент типа JTextArea 
		 */
		private static void printCollection(List<String> printData, JTextArea textArea) {
			
			textArea.setText("");
			
			for (String string : printData) {
				textArea.append(string + "\n");
			}
		}
		/*
		 * Метод выполняет вывод сообщения:
		 * "Коллекция не найдена"
		 * на элемент типа JList 
		 */
		private static void printNoCollectionMessage(DefaultListModel listModel) {
			
			listModel.clear();
			listModel.addElement("Коллекция не найдена");
			
		}
		/*
		 * Метод выполняет вывод сообщения:
		 * "Коллекция не найдена"
		 * на элемент типа JTextArea 
		 */
		private static void printNoCollectionMessage(JTextArea textArea) {
			
			textArea.setText("Коллекция не найдена");
			
		}

	}
}
