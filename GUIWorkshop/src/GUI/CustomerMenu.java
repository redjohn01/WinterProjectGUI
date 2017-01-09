package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnCreateCustomer;
	private JButton btnReadCustomer;
	private JButton btnUpdateCustomer;
	private JButton btnDeleteCustomer;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMenu frame = new CustomerMenu();
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
	public CustomerMenu() {
		initializeComponents();
		createEvents();
	}


	private void initializeComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCreateCustomer = new JButton("Create Customer");
		btnCreateCustomer.setBounds(193, 51, 134, 37);
		contentPane.add(btnCreateCustomer);
		
		btnReadCustomer = new JButton("Read Customer");
		
		btnReadCustomer.setBounds(193, 101, 134, 37);
		contentPane.add(btnReadCustomer);
		
		btnUpdateCustomer = new JButton("Update Customer");
		btnUpdateCustomer.setBounds(193, 151, 134, 37);
		contentPane.add(btnUpdateCustomer);
		
		btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.setBounds(193, 201, 134, 37);
		contentPane.add(btnDeleteCustomer);
		
		JButton btnPreviousMenu = new JButton("Previous Menu");
		btnPreviousMenu.setBounds(193, 251, 134, 37);
		contentPane.add(btnPreviousMenu);
		
		JButton btnExitProgram = new JButton("Exit Program");
		btnExitProgram.setBounds(193, 302, 134, 37);
		contentPane.add(btnExitProgram);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
	}
	
	private void createEvents() {
		btnCreateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateCustomer createCustomer = new CreateCustomer();
				dispose();
				createCustomer.main(null);
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMenu chMenu = new ChooseMenu();
				dispose();
				chMenu.main(null);
			}
		});
		
		btnReadCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadCustomer readCustomer = new ReadCustomer();
				dispose();
				readCustomer.main(null);
			}
		});
	}

}
