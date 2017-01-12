package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.LoanControl;
import UILayer.InputChecker;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class CreateLeasing extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBarcode;
	private JTextField textFieldPlace;
	private JTextField textFieldAvailable;
	private JTextField textFieldQuantity;
	private JTextField textFieldID;
	private JTextField textFieldPeriod;
	private JTextField textFieldCPR;
	private JButton btnBack;
	private JButton btnCheckQuantity;
	private JButton btnSubmit;
	private String place, barcode;
	private int availableQuantity;
	private static int period;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateLeasing frame = new CreateLeasing();
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
	public CreateLeasing() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		btnCheckQuantity = new JButton("Check quantity");
		
		btnCheckQuantity.setBounds(370, 175, 128, 25);
		contentPane.add(btnCheckQuantity);
		
		btnSubmit = new JButton("Submit");
		
		btnSubmit.setBounds(383, 431, 115, 25);
		contentPane.add(btnSubmit);
		
		textFieldBarcode = new JTextField();
		textFieldBarcode.setColumns(10);
		textFieldBarcode.setBounds(284, 140, 116, 22);
		contentPane.add(textFieldBarcode);
		
		textFieldPlace = new JTextField();
		textFieldPlace.setColumns(10);
		textFieldPlace.setBounds(284, 105, 116, 22);
		contentPane.add(textFieldPlace);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 210, 498, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 262, 498, 2);
		contentPane.add(separator_1);
		
		textFieldAvailable = new JTextField();
		textFieldAvailable.setColumns(10);
		textFieldAvailable.setBounds(284, 227, 116, 22);
		contentPane.add(textFieldAvailable);
		
		JLabel lblPlacetimberOrDiy = new JLabel("Place(Timber or DIY )");
		lblPlacetimberOrDiy.setBounds(139, 108, 133, 16);
		contentPane.add(lblPlacetimberOrDiy);
		
		JLabel lblItemBarcode = new JLabel("Item barcode");
		lblItemBarcode.setBounds(139, 143, 133, 16);
		contentPane.add(lblItemBarcode);
		
		JLabel lblAvailablePieces = new JLabel("Available pieces");
		lblAvailablePieces.setBounds(139, 225, 133, 24);
		contentPane.add(lblAvailablePieces);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(284, 291, 116, 22);
		contentPane.add(textFieldQuantity);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(284, 326, 116, 22);
		contentPane.add(textFieldID);
		
		textFieldPeriod = new JTextField();
		textFieldPeriod.setColumns(10);
		textFieldPeriod.setBounds(284, 361, 116, 22);
		contentPane.add(textFieldPeriod);
		
		textFieldCPR = new JTextField();
		textFieldCPR.setColumns(10);
		textFieldCPR.setBounds(284, 396, 116, 22);
		contentPane.add(textFieldCPR);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(139, 294, 133, 16);
		contentPane.add(lblQuantity);
		
		JLabel lblLeasingNumberid = new JLabel("Leasing number ID");
		lblLeasingNumberid.setBounds(139, 329, 133, 16);
		contentPane.add(lblLeasingNumberid);
		
		JLabel lblPeriodOfTime = new JLabel("Period of time");
		lblPeriodOfTime.setBounds(139, 364, 133, 16);
		contentPane.add(lblPeriodOfTime);
		
		JLabel lblUserSpr = new JLabel("User CPR/CVR");
		lblUserSpr.setBounds(139, 399, 133, 16);
		contentPane.add(lblUserSpr);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LeasingMenu leasingMenu = new LeasingMenu();
				dispose();
				leasingMenu.main(null);
			}
		});
		
		btnCheckQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputChecker.verifyPlace(textFieldPlace.getText());
				InputChecker.verifyItemBarcode(textFieldBarcode.getText());
				place = textFieldPlace.getText().toLowerCase();
				barcode = textFieldBarcode.getText().toLowerCase();
				availableQuantity = InputChecker.returnQuantityAtPlace(place, barcode);
				String request = String.valueOf(availableQuantity);
				textFieldAvailable.setText(request);
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanControl loanControl = new LoanControl();
				
				int quantity = Integer.parseInt(textFieldQuantity.getText());
				period = Integer.parseInt(textFieldPeriod.getText());
				
				InputChecker.getQuantityAtPlace(place, barcode, quantity);
				
				String numberID = textFieldID.getText();
				String cpr = textFieldCPR.getText();
				InputChecker.verifySaleNumberID(numberID);
				InputChecker.verifyId(2,cpr);
				InputChecker.verifyPeriod(period);
				//InputChecker.verifyId(1,cpr);
				HashMap<String,Integer> items = new HashMap<>();
				
				if(quantity > 0) {
					items.put(barcode, quantity);
				}
				
				if(loanControl.getAvailableItems(place, items, numberID, cpr, period)) {
					JOptionPane.showMessageDialog(null, "Operation finished with success.");
					textFieldPlace.setText("");
					textFieldBarcode.setText("");
					textFieldID.setText("");
					textFieldCPR.setText("");
					textFieldQuantity.setText("");
					textFieldAvailable.setText("");
					textFieldPeriod.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Operation failed.");
				}
			}
		});
	}
	
	protected static int getPeriod() {
		return period;
	}
}
