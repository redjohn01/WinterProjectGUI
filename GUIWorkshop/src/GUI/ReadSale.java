package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.SaleControl;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ReadSale extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JTextField textFieldID;
	private JTextField textFieldSearch;
	private JTextField textFieldPrice;
	private JTextField textFieldCustomer;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadSale frame = new ReadSale();
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
	public ReadSale() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblSearchById = new JLabel("Search by ID number");
		lblSearchById.setBounds(12, 69, 129, 16);
		contentPane.add(lblSearchById);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(330, 105, 151, 22);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(12, 89, 116, 22);
		contentPane.add(textFieldSearch);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(330, 140, 151, 22);
		contentPane.add(textFieldPrice);
		
		textFieldCustomer = new JTextField();
		textFieldCustomer.setColumns(10);
		textFieldCustomer.setBounds(330, 175, 151, 22);
		contentPane.add(textFieldCustomer);
		
		btnSearch = new JButton("Search");
		
		btnSearch.setBounds(31, 124, 97, 25);
		contentPane.add(btnSearch);
		
		JLabel lblNumberId = new JLabel("Number ID");
		lblNumberId.setBounds(217, 108, 70, 16);
		contentPane.add(lblNumberId);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(217, 143, 70, 16);
		contentPane.add(lblPrice);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(217, 178, 70, 16);
		contentPane.add(lblCustomer);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(376, 69, 56, 16);
		contentPane.add(lblResults);
		
		JList list = new JList();
		list.setBounds(158, 257, -80, -37);
		contentPane.add(list);
	}

	private void createEvents() {
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleMenu saleMenu = new SaleMenu();
				dispose();
				saleMenu.main(null);
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleControl saleControl = new SaleControl();
				String barcode = textFieldSearch.getText();
				ArrayList<String> readResult = saleControl.readSale(barcode);
				
				if(readResult != null) {
					textFieldID.setText(readResult.get(0).substring(12));
					textFieldPrice.setText(readResult.get(9));
					textFieldCustomer.setText(readResult.get(12) + " -CPR");
				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry, there is no such sale!");
				}
				
			}
		});
	}
}
