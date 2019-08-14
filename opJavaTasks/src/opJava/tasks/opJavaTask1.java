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
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 829, 1025);
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
		panel_1.setBounds(469, 13, 332, 303);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Тип создаваемой коллекции...");
		label.setBounds(10, 10, 223, 20);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(label);
		
		rbVector = new JRadioButton("Vector");
		rbVector.setSelected(true);
		radioButtonsGroup.add(rbVector);
		rbVector.setBackground(new Color(175, 238, 238));
		rbVector.setFont(new Font("Tahoma", Font.ITALIC, 16));
		rbVector.setBounds(20, 52, 127, 25);
		panel_1.add(rbVector);
		
		rbArrayList = new JRadioButton("ArrayList");
		radioButtonsGroup.add(rbArrayList);
		rbArrayList.setBackground(new Color(175, 238, 238));
		rbArrayList.setFont(new Font("Tahoma", Font.ITALIC, 16));
		rbArrayList.setBounds(20, 82, 127, 25);
		panel_1.add(rbArrayList);
		
		rbLinkedList = new JRadioButton("LinkedList");
		radioButtonsGroup.add(rbLinkedList);
		rbLinkedList.setBackground(new Color(175, 238, 238));
		rbLinkedList.setFont(new Font("Tahoma", Font.ITALIC, 16));
		rbLinkedList.setBounds(20, 111, 127, 25);
		panel_1.add(rbLinkedList);
		
		rbHashMap = new JRadioButton("HashMap");
		radioButtonsGroup.add(rbHashMap);
		rbHashMap.setBackground(new Color(175, 238, 238));
		rbHashMap.setFont(new Font("Tahoma", Font.ITALIC, 16));
		rbHashMap.setBounds(20, 141, 127, 25);
		panel_1.add(rbHashMap);
		
		rbTreeMap = new JRadioButton("TreeMap");
		radioButtonsGroup.add(rbTreeMap);
		rbTreeMap.setBackground(new Color(175, 238, 238));
		rbTreeMap.setFont(new Font("Tahoma", Font.ITALIC, 16));
		rbTreeMap.setBounds(20, 171, 127, 25);
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
		panel_3.setBounds(427, 329, 374, 174);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnFindItems = new JButton("Вывести найденые элементы в виде списка");
		btnFindItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findItemsInCollections();
			}
		});
		btnFindItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFindItems.setBounds(0, 13, 374, 30);
		panel_3.add(btnFindItems);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(64, 56, 228, 105);
		panel_3.add(scrollPane_1);
		
		listModelItemsFound = new DefaultListModel();
		listItemsFound = new JList(listModelItemsFound);
		scrollPane_1.setViewportView(listItemsFound);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 228, 225));
		panel_4.setBounds(12, 516, 789, 239);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Тип добавляемого элемента:");
		lblNewLabel.setBounds(12, 5, 215, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel);
		
		JComboBox typeOfItemsCombo = new JComboBox();
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
		btnAddItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddItem.setBounds(433, 13, 303, 30);
		panel_4.add(btnAddItem);
		
		JButton btnShowCollection = new JButton("Отобразить коллекцию");
		btnShowCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printCollection();
			}
		});
		btnShowCollection.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnShowCollection.setBounds(433, 52, 303, 30);
		panel_4.add(btnShowCollection);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(479, 85, 231, 141);
		panel_4.add(scrollPane_2);
		
		JList listCollectionContent = new JList();
		scrollPane_2.setViewportView(listCollectionContent);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(221, 160, 221));
		panel_5.setBounds(12, 768, 789, 200);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_3 = new JLabel("Индекс удаляемого элемента:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(12, 13, 237, 20);
		panel_5.add(label_3);
		
		indexField = new JTextField();
		indexField.setColumns(10);
		indexField.setBounds(12, 46, 279, 30);
		panel_5.add(indexField);
		
		JButton btnDeleteItem = new JButton("Удалить элемент и отобразить коллекцию");
		btnDeleteItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteItem.setBounds(417, 13, 360, 30);
		panel_5.add(btnDeleteItem);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(479, 51, 229, 139);
		panel_5.add(scrollPane_3);
		
		JList listDeleteAndShow = new JList();
		scrollPane_3.setViewportView(listDeleteAndShow);
	}
	
	private <T> void printCollectionToTextArea(Collection<T> c, JRadioButton rb) {
		textAreaCollectionInfo.setText("Коллекция \"" + rb.getText() + "\"\n{\n");
		
		for (Object item : c) {
			textAreaCollectionInfo.append(item.toString() + ", (" + item.getClass().getName() + ")\n");
		}
		textAreaCollectionInfo.append("}\n");
	}
	private <K, V> void printMapToTextArea(Map<K, V> m, JRadioButton rb) {
		
		textAreaCollectionInfo.setText("Коллекция \"" + rb.getText() + "\"\n{\n");
		
		for (Map.Entry<K, V> entry : m.entrySet()) {
			textAreaCollectionInfo.append(entry.getKey() + " : " + entry.getValue() + 
					", (" + entry.getKey().getClass().getName() + " : " + entry.getValue().getClass().getName() + ")\n");
		}
		textAreaCollectionInfo.append("}\n");
	}

	private void printCollectionToList(ArrayList<String> s, DefaultListModel listModel) {
		
		listModel.clear();
		
		for (String string : s) {
			listModel.addElement(string);
		}
	}
	private void printNoCollectionMessageToList(DefaultListModel listModel) {
		
		listModel.clear();
		listModel.addElement("Коллекция не найдена");
	}
	private <T> ArrayList<String> findItemsInList(String type, Collection<T> c) {
		
		ArrayList<String> items = new ArrayList<>();
		
		for (T t : c) {
			if(t.getClass().getSimpleName().equals(type)) {
				items.add(t.toString());
			}
		}
		if(items.size() == 0) {
			items.add("Элементы не найдены");
		}
		return items;
	}
	private <K, V> ArrayList<String> findItemsInMap(String type, Map<K, V> m) {
		
		ArrayList<String> items = new ArrayList<>();
		
		for (Map.Entry<K, V> entry : m.entrySet()) {
			if (entry.getValue().getClass().getSimpleName().equals(type)) {
				items.add(entry.getKey() + " : " + entry.getValue());
			}
		}	
		if(items.size() == 0) {
			items.add("Элементы не найдены");
		}
		return items;
	}
	private void findItemsInCollections() {

		String selVal = listItemsTypes.getSelectedValue().toString();
		
		if (rbVector.isSelected()) {
			if(vector != null) {
				printCollectionToList(findItemsInList(selVal, vector), listModelItemsFound);
			} else {
				printNoCollectionMessageToList(listModelItemsFound);
			}
		} else if (rbArrayList.isSelected()) {
			if(arrayList != null) {
				printCollectionToList(findItemsInList(selVal, arrayList), listModelItemsFound);
			} else {
				printNoCollectionMessageToList(listModelItemsFound);
			}
		} else if (rbLinkedList.isSelected()) {
			if(linkedList != null) {
				printCollectionToList(findItemsInList(selVal, linkedList), listModelItemsFound);
			} else {
				printNoCollectionMessageToList(listModelItemsFound);
			}
		} else if (rbHashMap.isSelected()) {
			if(hashMap != null) {
				printCollectionToList(findItemsInMap(selVal, hashMap), listModelItemsFound);
			} else {
				printNoCollectionMessageToList(listModelItemsFound);
			}
		} else if (rbTreeMap.isSelected()) {
			if(treeMap != null) {
				printCollectionToList(findItemsInMap(selVal, treeMap), listModelItemsFound);
			} else {
				printNoCollectionMessageToList(listModelItemsFound);
			}
		}
	}
	private void createCollection() {
		
		if (rbVector.isSelected()) {
			if(vector == null) {
				vector = new Vector();
			}
			printCollectionToTextArea(vector, rbVector);
		} else if (rbArrayList.isSelected()) {
			if(arrayList == null) {
				arrayList = new ArrayList();
			}
			printCollectionToTextArea(arrayList, rbArrayList);
		} else if (rbLinkedList.isSelected()) {
			if(linkedList == null) {
				linkedList = new LinkedList();
			}
			printCollectionToTextArea(linkedList, rbLinkedList);
		} else if (rbHashMap.isSelected()) {
			if(hashMap == null) {
				hashMap = new HashMap();
			}
			printMapToTextArea(hashMap, rbHashMap);
		} else if (rbTreeMap.isSelected()) {
			if(treeMap == null) {
				treeMap = new TreeMap();
			}
			printMapToTextArea(treeMap, rbTreeMap);
		}
	}
	private void clearCollection() {
		
		if (rbVector.isSelected()) {
			if(vector != null) {
				vector.clear();
			}
			printCollectionToTextArea(vector, rbVector);
		} else if (rbArrayList.isSelected()) {
			if(arrayList != null) {
				arrayList.clear();
			}
			printCollectionToTextArea(arrayList, rbArrayList);
		} else if (rbLinkedList.isSelected()) {
			if(linkedList != null) {
				linkedList.clear();
			}
			printCollectionToTextArea(linkedList, rbLinkedList);
		} else if (rbHashMap.isSelected()) {
			if(hashMap != null) {
				hashMap.clear();
			}
			printMapToTextArea(hashMap, rbHashMap);
		} else if (rbTreeMap.isSelected()) {
			if(treeMap != null) {
				treeMap.clear();
			}
			printMapToTextArea(treeMap, rbTreeMap);
		}
	}

	private void printCollection() {
		
	}
}
