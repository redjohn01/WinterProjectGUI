package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.SaleControl;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class EditSale extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnBack;
	private JButton btnSearch;
	private JTextField textFieldObject;
	private JTextField textFieldChoice;
	private JButton btnSave;
	SaleControl saleControl = new SaleControl();
	String search = "";
	ArrayList<String> readResult = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditSale frame = new EditSale();
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
	public EditSale() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblSearchByNumber = new JLabel("Search by Number ID");
		lblSearchByNumber.setBounds(12, 75, 129, 16);
		contentPane.add(lblSearchByNumber);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(12, 104, 116, 22);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		btnSearch = new JButton("Search");
		
		btnSearch.setBounds(31, 154, 97, 25);
		contentPane.add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(311, 104, 153, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(311, 144, 153, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(311, 183, 153, 22);
		contentPane.add(textField_2);
		
		JLabel lblNumID = new JLabel("1.Number ID");
		lblNumID.setBounds(206, 107, 77, 16);
		contentPane.add(lblNumID);
		
		JLabel lblPrice = new JLabel("2.Price");
		lblPrice.setBounds(206, 147, 77, 16);
		contentPane.add(lblPrice);
		
		JLabel lblCustomer = new JLabel("3.Customer");
		lblCustomer.setBounds(206, 186, 77, 16);
		contentPane.add(lblCustomer);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(358, 75, 56, 16);
		contentPane.add(lblResults);
		
		btnSave = new JButton("Save");
		
		btnSave.setBounds(404, 392, 97, 25);
		contentPane.add(btnSave);
		
		textFieldObject = new JTextField();
		textFieldObject.setBounds(358, 320, 143, 22);
		contentPane.add(textFieldObject);
		textFieldObject.setColumns(10);
		
		JLabel lblMakeChanges = new JLabel("Change to >>>");
		lblMakeChanges.setBounds(385, 258, 105, 16);
		contentPane.add(lblMakeChanges);
		
		JLabel lblNew = new JLabel("Change field to");
		lblNew.setBounds(206, 323, 140, 16);
		contentPane.add(lblNew);
		
		JLabel lblChoice = new JLabel("Select field from 1 to 3");
		lblChoice.setBounds(206, 290, 140, 16);
		contentPane.add(lblChoice);
		
		textFieldChoice = new JTextField();
		textFieldChoice.setColumns(10);
		textFieldChoice.setBounds(358, 287, 143, 22);
		contentPane.add(textFieldChoice);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 218, 489, 25);
		contentPane.add(separator);
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaleMenu saleMenu = new SaleMenu();
				dispose();
				saleMenu.main(null);
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search = textFieldSearch.getText();
				readResult = saleControl.readSale(search);
				if(readResult != null) {
					textField.setText(readResult.get(0).substring(12));
					textField_1.setText(readResult.get(1).substring(9));
					textField_2.setText(readResult.get(2).substring(12) + " -CPR");
				}
				else {
					JOptionPane.showMessageDialog(null, "There is no such sale!");
				}	
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fieldChoice = Integer.parseInt(textFieldChoice.getText());
				Object object = textFieldObject.getText();
				
				try{
					saleControl.updateSale(search, fieldChoice, object); 	
					JOptionPane.showMessageDialog(null, "Successfuly saved!");
					textFieldSearch.setText("");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textFieldChoice.setText("");
					textFieldObject.setText("");
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error, please try again!");
				}
			}
		});
	}
}
