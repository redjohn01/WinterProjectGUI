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
import java.util.HashMap;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 512, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlace = new JLabel("Place(Timber or DIY )");
		lblPlace.setBounds(131, 60, 128, 26);
		contentPane.add(lblPlace);
		
		JLabel lblItem = new JLabel("Item barcode");
		lblItem.setBounds(131, 95, 103, 26);
		contentPane.add(lblItem);
		
		JLabel lblSaleNumberId = new JLabel("Sale number ID");
		lblSaleNumberId.setBounds(131, 163, 103, 26);
		contentPane.add(lblSaleNumberId);
		
		JLabel lblUserCpr = new JLabel("User CPR/CVR");
		lblUserCpr.setBounds(131, 199, 103, 26);
		contentPane.add(lblUserCpr);
		
		textFieldPlace = new JTextField();
		textFieldPlace.setBounds(271, 62, 116, 22);
		contentPane.add(textFieldPlace);
		textFieldPlace.setColumns(10);
		
		textFieldBarcode = new JTextField();
		textFieldBarcode.setColumns(10);
		textFieldBarcode.setBounds(271, 97, 116, 22);
		contentPane.add(textFieldBarcode);
		
		textFieldIDNum = new JTextField();
		textFieldIDNum.setColumns(10);
		textFieldIDNum.setBounds(271, 165, 116, 22);
		contentPane.add(textFieldIDNum);
		
		textFieldCPR = new JTextField();
		textFieldCPR.setColumns(10);
		textFieldCPR.setBounds(271, 201, 116, 22);
		contentPane.add(textFieldCPR);
		
		btnSubmit = new JButton("Submit");
		
		btnSubmit.setBounds(385, 272, 97, 25);
		contentPane.add(btnSubmit);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(271, 130, 116, 22);
		contentPane.add(textFieldQuantity);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(131, 134, 56, 16);
		contentPane.add(lblQuantity);
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
				try{
					SaleControl saleControl = new SaleControl();
					
					String place = textFieldPlace.getText().toLowerCase();
					String barcode = textFieldBarcode.getText();
					int quantity = Integer.parseInt(textFieldQuantity.getText());
					String numberID = textFieldIDNum.getText();
					String cpr = textFieldCPR.getText();
					
					HashMap<String,Integer> map = new HashMap<>();
					map.put(barcode, quantity);
					
					if(saleControl.getAvailableItems(place, map, numberID, cpr)) {
						JOptionPane.showMessageDialog(null, "Operation finished with success.");
						textFieldPlace.setText("");
						textFieldBarcode.setText("");
						textFieldIDNum.setText("");
						textFieldCPR.setText("");
						textFieldQuantity.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "Operation failed.");
					}
					
					
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Operation failed.");
				}
			}
		});
	}
}
