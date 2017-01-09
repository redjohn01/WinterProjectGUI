package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.CustomerControl;
import UILayer.InputChecker;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ReadCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCPR;
	private JButton btnBack;
	private JButton btnSearch;
	private JTextField textFieldPrint;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldCity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadCustomer frame = new ReadCustomer();
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
	public ReadCustomer() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldCPR = new JTextField();
		textFieldCPR.setBounds(12, 103, 116, 22);
		contentPane.add(textFieldCPR);
		textFieldCPR.setColumns(10);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblSearchByCpr = new JLabel("Search by CPR");
		lblSearchByCpr.setBounds(23, 79, 92, 16);
		contentPane.add(lblSearchByCpr);
		
		btnSearch = new JButton("Search");
		
		btnSearch.setBounds(39, 138, 92, 25);
		contentPane.add(btnSearch);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(369, 79, 56, 16);
		contentPane.add(lblResults);
		
		JLabel lblCpr = new JLabel("CPR ");
		lblCpr.setBounds(259, 106, 56, 16);
		contentPane.add(lblCpr);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setBounds(259, 142, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(259, 175, 56, 16);
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(259, 210, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(259, 245, 56, 16);
		contentPane.add(lblPhone);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(259, 281, 56, 16);
		contentPane.add(lblCity);
		
		textFieldPrint = new JTextField();
		textFieldPrint.setBounds(327, 103, 144, 22);
		contentPane.add(textFieldPrint);
		textFieldPrint.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(327, 139, 144, 22);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(327, 172, 144, 22);
		contentPane.add(textFieldAddress);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(327, 207, 144, 22);
		contentPane.add(textFieldEmail);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(327, 242, 144, 22);
		contentPane.add(textFieldPhone);
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(327, 278, 144, 22);
		contentPane.add(textFieldCity);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerMenu customerMenu = new CustomerMenu();
				dispose();
				customerMenu.main(null);
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerControl customerControl = new CustomerControl();
				
				String cpr = textFieldCPR.getText();
				ArrayList<String> result = customerControl.getCustomerByCpr(cpr);

				if(result != null) {
					textFieldPrint.setText(result.get(0).substring(8)); 
					textFieldName.setText(result.get(1).substring(9));
					textFieldAddress.setText(result.get(2).substring(12));
					textFieldEmail.setText(result.get(3).substring(10));
					textFieldPhone.setText(result.get(4).substring(10));
					textFieldCity.setText(result.get(5).substring(9));
                }
                else {
                	JOptionPane.showMessageDialog(null, "Sorry, there is no such user!");
                }
				
			}
		});
	}
}
