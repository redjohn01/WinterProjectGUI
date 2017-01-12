package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.LoanControl;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ReadLeasing extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JTextField textFieldSearch;
	private JTextField textFieldID;
	private JTextField textFieldPrice;
	private JTextField textFieldPeriod;
	private JTextField textFieldCustomer;
	private JButton btnSearch;
	private JTextField textFieldStatus;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadLeasing frame = new ReadLeasing();
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
	public ReadLeasing() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(12, 98, 116, 22);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Search by ID number");
		lblNewLabel.setBounds(12, 75, 131, 16);
		contentPane.add(lblNewLabel);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(326, 98, 151, 22);
		contentPane.add(textFieldID);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(326, 133, 151, 22);
		contentPane.add(textFieldPrice);
		
		textFieldPeriod = new JTextField();
		textFieldPeriod.setColumns(10);
		textFieldPeriod.setBounds(326, 168, 151, 22);
		contentPane.add(textFieldPeriod);
		
		textFieldCustomer = new JTextField();
		textFieldCustomer.setColumns(10);
		textFieldCustomer.setBounds(326, 203, 151, 22);
		contentPane.add(textFieldCustomer);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(375, 75, 78, 16);
		contentPane.add(lblResults);
		
		JLabel lblNewLabel_1 = new JLabel("Number ID");
		lblNewLabel_1.setBounds(217, 101, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(217, 136, 97, 16);
		contentPane.add(lblPrice);
		
		JLabel lblPeriodOfTime = new JLabel("Period of time");
		lblPeriodOfTime.setBounds(217, 171, 97, 16);
		contentPane.add(lblPeriodOfTime);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(217, 206, 97, 16);
		contentPane.add(lblCustomer);
		
		btnSearch = new JButton("Search");
		
		btnSearch.setBounds(31, 132, 97, 25);
		contentPane.add(btnSearch);
		
		textFieldStatus = new JTextField();
		textFieldStatus.setColumns(10);
		textFieldStatus.setBounds(326, 236, 151, 22);
		contentPane.add(textFieldStatus);
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(217, 239, 97, 16);
		contentPane.add(lblStatus);
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeasingMenu leasingMenu = new LeasingMenu();
				dispose();
				leasingMenu.main(null);
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanControl loanControl = new LoanControl();
				String idNum = textFieldSearch.getText();
				ArrayList<String> readResult = loanControl.readLoan(idNum);
				
				if(readResult != null) {
					textFieldID.setText(readResult.get(0).substring(12));
					textFieldPrice.setText(readResult.get(1).substring(9));
					textFieldCustomer.setText(readResult.get(2).substring(12) + " -CPR");
					textFieldPeriod.setText(readResult.get(3).substring(2) + " " + readResult.get(4).substring(2));
					textFieldStatus.setText(readResult.get(5).substring(10));
				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry, there is no such sale!");
				}
			}
		});
	}
}
