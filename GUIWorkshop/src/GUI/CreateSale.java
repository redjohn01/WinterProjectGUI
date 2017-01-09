package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateSale extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		JLabel lblPlace = new JLabel("Place");
		lblPlace.setBounds(131, 96, 103, 26);
		contentPane.add(lblPlace);
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setBounds(131, 128, 103, 26);
		contentPane.add(lblItem);
		
		JLabel lblSaleNumberId = new JLabel("Sale number ID");
		lblSaleNumberId.setBounds(131, 163, 103, 26);
		contentPane.add(lblSaleNumberId);
		
		JLabel lblUserCprcvr = new JLabel("User CPR/CVR");
		lblUserCprcvr.setBounds(131, 199, 103, 26);
		contentPane.add(lblUserCprcvr);
		
		textField = new JTextField();
		textField.setBounds(271, 98, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(271, 130, 116, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(271, 165, 116, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(271, 201, 116, 22);
		contentPane.add(textField_3);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String place = textField.getText();
					
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Operation failed.");
				}
			}
		});
		btnSubmit.setBounds(385, 272, 97, 25);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
}
