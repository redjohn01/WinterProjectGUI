package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.ItemControl;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class EditItem extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBack;
	private JButton btnSearch;
	private JTextField textFieldObject;
	private JTextField textFieldChoice;
	private JButton btnSave;
	ItemControl itemControl = new ItemControl();
	private String search;
	ArrayList<String> readResult = new ArrayList<>();
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditItem frame = new EditItem();
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
	public EditItem() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblSearchByNumber = new JLabel("Search by Barcode");
		lblSearchByNumber.setBounds(12, 52, 129, 16);
		contentPane.add(lblSearchByNumber);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(12, 91, 129, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		btnSearch = new JButton("Search");
		
		btnSearch.setBounds(12, 130, 97, 25);
		contentPane.add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(348, 14, 153, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(348, 40, 153, 22);
		contentPane.add(textField_1);
		
		JLabel lblNumID = new JLabel("1.Name");
		lblNumID.setBounds(258, 17, 77, 16);
		contentPane.add(lblNumID);
		
		JLabel lblPrice = new JLabel("2.Type");
		lblPrice.setBounds(258, 43, 77, 16);
		contentPane.add(lblPrice);
		
		JLabel lblCustomer = new JLabel("3.Barcode");
		lblCustomer.setBounds(258, 69, 77, 16);
		contentPane.add(lblCustomer);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(404, 0, 56, 16);
		contentPane.add(lblResults);
		
		btnSave = new JButton("Save");
		
		btnSave.setBounds(404, 371, 97, 25);
		contentPane.add(btnSave);
		
		textFieldObject = new JTextField();
		textFieldObject.setBounds(348, 320, 153, 22);
		contentPane.add(textFieldObject);
		textFieldObject.setColumns(10);
		
		JLabel lblMakeChanges = new JLabel("Change to >>>");
		lblMakeChanges.setBounds(385, 258, 105, 16);
		contentPane.add(lblMakeChanges);
		
		JLabel lblNew = new JLabel("Change field to");
		lblNew.setBounds(206, 323, 140, 16);
		contentPane.add(lblNew);
		
		JLabel lblChoice = new JLabel("Select field from 1 to 7");
		lblChoice.setBounds(206, 290, 140, 16);
		contentPane.add(lblChoice);
		
		textFieldChoice = new JTextField();
		textFieldChoice.setColumns(10);
		textFieldChoice.setBounds(348, 287, 153, 22);
		contentPane.add(textFieldChoice);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 218, 489, 25);
		contentPane.add(separator);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(348, 92, 153, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(348, 118, 153, 22);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(348, 144, 153, 22);
		contentPane.add(textField_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(348, 66, 153, 22);
		contentPane.add(textField_2);
		
		JLabel lbltradeAllowance = new JLabel("4.Cost price");
		lbltradeAllowance.setBounds(258, 95, 88, 16);
		contentPane.add(lbltradeAllowance);
		
		JLabel lblretailPrice = new JLabel("5.Trade allowance");
		lblretailPrice.setBounds(258, 121, 88, 16);
		contentPane.add(lblretailPrice);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(348, 170, 153, 22);
		contentPane.add(textField_6);
		
		JLabel lblquantity = new JLabel("6.Retail price");
		lblquantity.setBounds(258, 147, 88, 16);
		contentPane.add(lblquantity);
		
		JLabel lblplace = new JLabel("7.Quantity");
		lblplace.setBounds(258, 174, 88, 16);
		contentPane.add(lblplace);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(348, 196, 153, 22);
		contentPane.add(textField_7);
		
		JLabel lblplace_1 = new JLabel("8.Place");
		lblplace_1.setBounds(258, 200, 88, 16);
		contentPane.add(lblplace_1);
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ItemMenu itemMenu = new ItemMenu();
				dispose();
				itemMenu.main(null);
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search = textFieldSearch.getText();
				readResult = itemControl.getItemByBarcode(search);
				if(readResult != null) {
					textField.setText(readResult.get(0).substring(9));
					int sizeOfField = readResult.get(0).substring(9).length();
					textField_1.setText(readResult.get(1).substring(9));
					textField_2.setText(readResult.get(2).substring(12));
					textField_3.setText(readResult.get(3).substring(15) + " DKK");
					textField_4.setText(readResult.get(4).substring(20) + " DKK");
					textField_5.setText(readResult.get(5).substring(17) + " DKK");
					textField_6.setText(readResult.get(6).substring(24+sizeOfField));
					textField_7.setText(readResult.get(7).substring(27+sizeOfField));
				}
				else {
					JOptionPane.showMessageDialog(null, "There is no such sale!");
				}	
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fieldChoice = 0;
				try {
					fieldChoice = Integer.parseInt(textFieldChoice.getText());
					Object object = textFieldObject.getText();
					
					try{
						itemControl.changeItemFieldByBarcode(search, fieldChoice, object); 	
						JOptionPane.showMessageDialog(null, "Successfuly saved!");
						textFieldSearch.setText("");
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						textField_6.setText("");
						textField_7.setText("");
						textFieldChoice.setText("");
						textFieldObject.setText("");
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Error, please try again!");
					}
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Empty fields not allowed!");
				}
				
				
			}
		});
	}
}
