package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditSale extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditSale frame = new EditSale();
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
	public EditSale() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblSearchByNumber = new JLabel("Search by Number ID");
		lblSearchByNumber.setBounds(12, 75, 129, 16);
		contentPane.add(lblSearchByNumber);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(12, 104, 116, 22);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(31, 154, 97, 25);
		contentPane.add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(311, 104, 153, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(311, 144, 153, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(311, 183, 153, 22);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Number ID");
		lblNewLabel.setBounds(206, 107, 77, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(206, 147, 77, 16);
		contentPane.add(lblPrice);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(206, 186, 77, 16);
		contentPane.add(lblCustomer);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(358, 75, 56, 16);
		contentPane.add(lblResults);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(367, 248, 97, 25);
		contentPane.add(btnSave);
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaleMenu saleMenu = new SaleMenu();
				dispose();
				saleMenu.main(null);
			}
		});
	}
}
