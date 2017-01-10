package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.ItemControl;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateItem extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldType;
	private JTextField textFieldBarcode;
	private JTextField textFieldCost;
	private JTextField textFieldTrade;
	private JTextField textFieldRetail;
	private JTextField textFieldQuantity;
	private JTextField textFieldPlace;
	private JLabel lblType;
	private JLabel lblBarcode;
	private JLabel lblCostPrice;
	private JLabel lblTradeAllowancePrice;
	private JLabel lblRetailPrice;
	private JLabel lblQuantity;
	private JLabel lblPlacetimberdiy;
	private JButton btnSave;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateItem frame = new CreateItem();
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
	public CreateItem() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(215, 74, 143, 22);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldType = new JTextField();
		textFieldType.setColumns(10);
		textFieldType.setBounds(215, 109, 143, 22);
		contentPane.add(textFieldType);
		
		textFieldBarcode = new JTextField();
		textFieldBarcode.setColumns(10);
		textFieldBarcode.setBounds(215, 144, 143, 22);
		contentPane.add(textFieldBarcode);
		
		textFieldCost = new JTextField();
		textFieldCost.setColumns(10);
		textFieldCost.setBounds(215, 179, 143, 22);
		contentPane.add(textFieldCost);
		
		textFieldTrade = new JTextField();
		textFieldTrade.setColumns(10);
		textFieldTrade.setBounds(215, 213, 143, 22);
		contentPane.add(textFieldTrade);
		
		textFieldRetail = new JTextField();
		textFieldRetail.setColumns(10);
		textFieldRetail.setBounds(215, 250, 143, 22);
		contentPane.add(textFieldRetail);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(215, 287, 143, 22);
		contentPane.add(textFieldQuantity);
		
		textFieldPlace = new JTextField();
		textFieldPlace.setColumns(10);
		textFieldPlace.setBounds(215, 322, 143, 22);
		contentPane.add(textFieldPlace);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		btnSave = new JButton("Save");
		
		btnSave.setBounds(371, 348, 97, 25);
		contentPane.add(btnSave);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(70, 77, 133, 16);
		contentPane.add(lblName);
		
		lblType = new JLabel("Type");
		lblType.setBounds(70, 112, 133, 16);
		contentPane.add(lblType);
		
		lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(70, 147, 133, 16);
		contentPane.add(lblBarcode);
		
		lblCostPrice = new JLabel("Cost price");
		lblCostPrice.setBounds(70, 181, 133, 16);
		contentPane.add(lblCostPrice);
		
		lblTradeAllowancePrice = new JLabel("Trade allowance price");
		lblTradeAllowancePrice.setBounds(70, 216, 133, 16);
		contentPane.add(lblTradeAllowancePrice);
		
		lblRetailPrice = new JLabel("Retail price");
		lblRetailPrice.setBounds(70, 253, 133, 16);
		contentPane.add(lblRetailPrice);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(70, 288, 133, 16);
		contentPane.add(lblQuantity);
		
		lblPlacetimberdiy = new JLabel("Place-Timber/DIY");
		lblPlacetimberdiy.setBounds(70, 325, 133, 16);
		contentPane.add(lblPlacetimberdiy);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ItemControl itemControl = new ItemControl();
					String name = textFieldName.getText();
					String type = textFieldType.getText();
					String barcode = textFieldBarcode.getText();
					double costPrice = Double.parseDouble(textFieldCost.getText());
					double tradeAllPrice = Double.parseDouble(textFieldTrade.getText());
					double retailPrice = Double.parseDouble(textFieldRetail.getText());
					int quantity = Integer.parseInt(textFieldQuantity.getText());
					String place = textFieldPlace.getText().toLowerCase();
					
					if(name.equals("") || type.equals("") || barcode.equals("") || costPrice == 0 || tradeAllPrice == 0
							|| retailPrice == 0 || quantity == 0 || place.equals("")) {
						JOptionPane.showMessageDialog(null, "You need to fill out all the fields!");
					}
					else {
						if(itemControl.addItem(name, type, barcode, costPrice, tradeAllPrice, retailPrice, quantity, place)) {
							JOptionPane.showMessageDialog(null, "Operation finished with success!");
							textFieldName.setText("");
							textFieldType.setText("");
							textFieldBarcode.setText("");
							textFieldCost.setText("");
							textFieldTrade.setText("");
							textFieldRetail.setText("");
							textFieldQuantity.setText("");
							textFieldPlace.setText("");
						}
						else {
							JOptionPane.showMessageDialog(null, "Operation failed.");
						}
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Operation failed.");
				}
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemMenu itemMenu = new ItemMenu();
				dispose();
				itemMenu.main(null);
			}
		});
	}
}
