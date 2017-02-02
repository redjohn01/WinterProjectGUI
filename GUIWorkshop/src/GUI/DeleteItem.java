package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ControlLayer.ItemControl;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class DeleteItem extends JFrame {

	private JPanel contentPane;
	private JButton btnSave;
	private JButton btnBack;
	private JTextField textFieldBarcode;
	private JLabel lblBarcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteItem frame = new DeleteItem();
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
	public DeleteItem() {
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
		
		textFieldBarcode = new JTextField();
		textFieldBarcode.setColumns(10);
		textFieldBarcode.setBounds(215, 144, 143, 22);
		contentPane.add(textFieldBarcode);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		btnSave = new JButton("Delete");
		
		btnSave.setBounds(371, 348, 97, 25);
		contentPane.add(btnSave);
		
		lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(70, 147, 133, 16);
		contentPane.add(lblBarcode);
		
		
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ItemControl itemControl = new ItemControl();
					String barcode = textFieldBarcode.getText();
					
					if( barcode.equals("") ) {
						JOptionPane.showMessageDialog(null, "You need to fill out all the fields!");
					}
					else {
						if(itemControl.deleteItem (barcode)) {
							JOptionPane.showMessageDialog(null, "Operation finished with success!");

							textFieldBarcode.setText("");
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
