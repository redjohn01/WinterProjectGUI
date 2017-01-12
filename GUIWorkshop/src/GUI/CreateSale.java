package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.SaleControl;
import UILayer.InputChecker;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class CreateSale extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPlace;
	private JTextField textFieldBarcode;
	private JTextField textFieldIDNum;
	private JTextField textFieldCPR;
	private JButton btnBack;
	private JTextField textFieldQuantity;
	private JLabel lblQuantity;
	private JButton btnSubmit;
	private JTextField textFieldAvailable;
	private JButton btnCheckQuantity;
	private String place, barcode;
	private int availableQuantity;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateSale frame = new CreateSale();
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
	public CreateSale() {
		setTitle("Create Sale");
		initializeComponents();
		createEvents();
	}


	private void initializeComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlace = new JLabel("Place(Timber or DIY )");
		lblPlace.setBounds(147, 95, 128, 26);
		contentPane.add(lblPlace);
		
		JLabel lblItem = new JLabel("Item barcode");
		lblItem.setBounds(147, 130, 128, 26);
		contentPane.add(lblItem);
		
		JLabel lblSaleNumberId = new JLabel("Sale number ID");
		lblSaleNumberId.setBounds(147, 321, 128, 26);
		contentPane.add(lblSaleNumberId);
		
		JLabel lblUserCpr = new JLabel("User CPR/CVR");
		lblUserCpr.setBounds(147, 356, 128, 26);
		contentPane.add(lblUserCpr);
		
		textFieldPlace = new JTextField();
		textFieldPlace.setBounds(287, 97, 116, 22);
		contentPane.add(textFieldPlace);
		textFieldPlace.setColumns(10);
		
		textFieldBarcode = new JTextField();
		textFieldBarcode.setColumns(10);
		textFieldBarcode.setBounds(287, 132, 116, 22);
		contentPane.add(textFieldBarcode);
		
		textFieldIDNum = new JTextField();
		textFieldIDNum.setColumns(10);
		textFieldIDNum.setBounds(287, 323, 116, 22);
		contentPane.add(textFieldIDNum);
		
		textFieldCPR = new JTextField();
		textFieldCPR.setColumns(10);
		textFieldCPR.setBounds(287, 358, 116, 22);
		contentPane.add(textFieldCPR);
		
		btnSubmit = new JButton("Submit");
		
		btnSubmit.setBounds(375, 393, 122, 25);
		contentPane.add(btnSubmit);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(287, 290, 116, 22);
		contentPane.add(textFieldQuantity);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(147, 288, 128, 26);
		contentPane.add(lblQuantity);
		
		textFieldAvailable = new JTextField();
		textFieldAvailable.setColumns(10);
		textFieldAvailable.setBounds(287, 220, 116, 22);
		contentPane.add(textFieldAvailable);
		
		JLabel lblAvailablePieces = new JLabel("Available pieces");
		lblAvailablePieces.setBounds(147, 218, 128, 26);
		contentPane.add(lblAvailablePieces);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 205, 497, 2);
		contentPane.add(separator);
		
		btnCheckQuantity = new JButton("Check quantity");
		
		btnCheckQuantity.setBounds(375, 167, 122, 25);
		contentPane.add(btnCheckQuantity);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 255, 497, 2);
		contentPane.add(separator_1);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleMenu saleMenu = new SaleMenu();
				dispose();
				saleMenu.main(null);
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaleControl saleControl = new SaleControl();
				
				int quantity = Integer.parseInt(textFieldQuantity.getText());
				
				InputChecker.getQuantityAtPlace(place, barcode, quantity);
				
				String numberID = textFieldIDNum.getText();
				String cpr = textFieldCPR.getText();
				InputChecker.verifySaleNumberID(numberID);
				InputChecker.verifyId(2,cpr);
				//InputChecker.verifyId(1,cpr);
				HashMap<String,Integer> items = new HashMap<>();
				
				if(quantity > 0) {
					items.put(barcode, quantity);
				}
				
				if(saleControl.getAvailableItems(place, items, numberID, cpr)) {
					JOptionPane.showMessageDialog(null, "Operation finished with success.");
					textFieldPlace.setText("");
					textFieldBarcode.setText("");
					textFieldIDNum.setText("");
					textFieldCPR.setText("");
					textFieldQuantity.setText("");
					textFieldAvailable.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Operation failed.");
				}
				/////
//				  place = InputChecker.verifyPlace(textFieldPlace.getText().toLowerCase());
//                HashMap<String, Integer> items = new HashMap<>();
//                String barcode;
//                int quantity;
//                do {
//                    barcode = InputChecker.verifyItemBarcode(textFieldBarcode.getText());
//                    if (!barcode.isEmpty()) {
//                        quantity = InputChecker.getQuantityAtPlace(place, barcode);
//                        if (quantity > 0) items.put(barcode, quantity);
//                    }
//                } while (!barcode.equals("done"));
//                saleControl.getAvailableItems(place, items, InputChecker.verifySaleNumberID(), InputChecker.verifyId(2));
//                break;
			}
		});
		
		btnCheckQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InputChecker.verifyPlace(textFieldPlace.getText());
				InputChecker.verifyItemBarcode(textFieldBarcode.getText());
				place = textFieldPlace.getText().toLowerCase();
				barcode = textFieldBarcode.getText().toLowerCase();
				availableQuantity = InputChecker.returnQuantityAtPlace(place, barcode);
				String request = String.valueOf(availableQuantity);
				textFieldAvailable.setText(request);
			}
		});
	}
}
