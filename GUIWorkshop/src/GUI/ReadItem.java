package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.ItemControl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ReadItem extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JTextField textFieldBarcode;
	private JButton btnSearch;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
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
					ReadItem frame = new ReadItem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReadItem() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		textFieldBarcode = new JTextField();
		textFieldBarcode.setBounds(12, 116, 116, 22);
		contentPane.add(textFieldBarcode);
		textFieldBarcode.setColumns(10);
		
		JLabel lblSearchByBarcode = new JLabel("Search by barcode");
		lblSearchByBarcode.setBounds(12, 87, 116, 16);
		contentPane.add(lblSearchByBarcode);
		
		btnSearch = new JButton("Search");
		
		btnSearch.setBounds(46, 151, 83, 25);
		contentPane.add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(347, 116, 137, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(347, 152, 137, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(347, 186, 137, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(347, 219, 137, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(347, 252, 137, 22);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(347, 288, 137, 22);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(347, 323, 137, 22);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(347, 357, 137, 22);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(201, 119, 134, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(201, 155, 134, 16);
		contentPane.add(lblType);
		
		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(201, 189, 134, 16);
		contentPane.add(lblBarcode);
		
		JLabel lblCostPrice = new JLabel("Cost price");
		lblCostPrice.setBounds(201, 222, 134, 16);
		contentPane.add(lblCostPrice);
		
		JLabel lblTradeAllo = new JLabel("Trade allowance price");
		lblTradeAllo.setBounds(201, 255, 134, 16);
		contentPane.add(lblTradeAllo);
		
		JLabel lblRetailPrice = new JLabel("Retail price");
		lblRetailPrice.setBounds(201, 291, 134, 16);
		contentPane.add(lblRetailPrice);
		
		JLabel lblQuantity = new JLabel("Quantity at DIY");
		lblQuantity.setBounds(201, 326, 134, 16);
		contentPane.add(lblQuantity);
		
		JLabel lblPlace = new JLabel("Quantity at Timber");
		lblPlace.setBounds(201, 360, 134, 16);
		contentPane.add(lblPlace);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemMenu itemMenu = new ItemMenu();
				dispose();
				itemMenu.main(null);
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemControl itemControl = new ItemControl();
				
				String barcode = textFieldBarcode.getText();
				ArrayList<String> result = itemControl.getItemByBarcode(barcode);
				
				if(result != null) {
					textField.setText(result.get(0).substring(9));
					int sizeOfField = result.get(0).substring(9).length();
					textField_1.setText(result.get(1).substring(9));
					textField_2.setText(result.get(2).substring(12));
					textField_3.setText(result.get(3).substring(15) + " DKK");
					textField_4.setText(result.get(4).substring(20) + " DKK");
					textField_5.setText(result.get(5).substring(17) + " DKK");
					textField_6.setText(result.get(6).substring(24+sizeOfField));
					textField_7.setText(result.get(7).substring(27+sizeOfField));
				}
				else {
                	JOptionPane.showMessageDialog(null, "Sorry, there is no such item!");
                }
			}
		});
	}

}
