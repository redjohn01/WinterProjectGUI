package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.CustomerControl;
import UILayer.InputChecker;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSeparator;

public class CreateCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnBack;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCustomer frame = new CreateCustomer();
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
	public CreateCustomer() {
		initializeComponents();
		createEvents();
	}


	private void initializeComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(237, 55, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(237, 90, 116, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(237, 125, 116, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(237, 160, 116, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(237, 195, 116, 22);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(237, 230, 116, 22);
		contentPane.add(textField_5);
		
		JLabel lblCPR = new JLabel("CPR");
		lblCPR.setBounds(112, 58, 90, 16);
		contentPane.add(lblCPR);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(112, 93, 90, 16);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(112, 128, 90, 16);
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(112, 163, 90, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(112, 198, 90, 16);
		contentPane.add(lblPhone);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(112, 233, 90, 16);
		contentPane.add(lblCity);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(392, 300, 97, 25);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(0, 13, 97, 25);
		contentPane.add(btnBack);
	}
	
	private void createEvents() {
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerMenu cMenu = new CustomerMenu();
				dispose();
				cMenu.main(null);
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CustomerControl customerControler = new CustomerControl();
					String cpr = textField.getText();
					String name = textField_1.getText();
					String address = textField_2.getText();
					String email = textField_3.getText();
					String phone = textField_4.getText();
					String city = textField_5.getText();
					
					/*InputChecker.verifyId(1);
					InputChecker.verifyName();
					InputChecker.verifyAddress();
					InputChecker.verifyEmail();
					InputChecker.verifyPhone();
					InputChecker.verifyCity();*/
					if((cpr.equals("") || name.equals("") || address.equals("") || email.equals("") || phone.equals("") || city.equals("")) ) {
						JOptionPane.showMessageDialog(null, "You need to fill out all the fields!");
					}
					else {
						if(customerControler.createCustomer(cpr, name, address, email, phone, city)) {
							JOptionPane.showMessageDialog(null, "Operation finished with success.");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");

						}
						else {
							JOptionPane.showMessageDialog(null, "Operation failed.");
						}
					}
					//customerControler.createCustomer(cpr, name, address, email, phone, city);
										
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Operation failed.");
				}
			}
		});
	}
}
