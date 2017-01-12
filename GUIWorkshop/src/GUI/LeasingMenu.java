package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeasingMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JButton btnCreateLeasing;
	private JButton btnReadleasing;
	private JButton btnEditleasing;
	private JButton btnPreviousMenu;
	private JButton btnRetrieveLeasing;
	private JButton btnExitProgram;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeasingMenu frame = new LeasingMenu();
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
	public LeasingMenu() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		btnCreateLeasing = new JButton("Create Leasing");
		
		btnCreateLeasing.setBounds(180, 67, 135, 36);
		contentPane.add(btnCreateLeasing);
		
		btnReadleasing = new JButton("Read Leasing");
		
		btnReadleasing.setBounds(180, 117, 135, 36);
		contentPane.add(btnReadleasing);
		
		btnEditleasing = new JButton("Edit Leasing");
		
		btnEditleasing.setBounds(180, 166, 135, 36);
		contentPane.add(btnEditleasing);
		
		btnPreviousMenu = new JButton("Previous Menu");
		
		btnPreviousMenu.setBounds(180, 267, 135, 36);
		contentPane.add(btnPreviousMenu);
		
		btnExitProgram = new JButton("Exit Program");
		
		btnExitProgram.setBounds(180, 316, 135, 36);
		contentPane.add(btnExitProgram);
		
		btnRetrieveLeasing = new JButton("Retrieve Leasing");
		
		btnRetrieveLeasing.setBounds(180, 218, 135, 36);
		contentPane.add(btnRetrieveLeasing);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMenu chMenu = new ChooseMenu();
				dispose();
				chMenu.main(null);
			}
		});
		
		btnCreateLeasing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateLeasing createLeasing = new CreateLeasing();
				dispose();
				createLeasing.main(null);
			}
		});
		
		btnReadleasing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadLeasing readLeasing = new ReadLeasing();
				dispose();
				readLeasing.main(null);
			}
		});
		
		btnEditleasing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditLeasing editLeasing = new EditLeasing();
				dispose();
				editLeasing.main(null);
			}
		});
		
		btnPreviousMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMenu chMenu = new ChooseMenu();
				dispose();
				chMenu.main(null);
			}
		});
		
		btnRetrieveLeasing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetrieveLeasing rLeasing = new RetrieveLeasing();
				dispose();
				rLeasing.main(null);
					
			}
		});
		
		btnExitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?");
				if(confirm == JOptionPane.YES_OPTION) {
					//Brexit brexit = new Brexit();
					LoginMenu.brexit.exit();
					System.exit(0);
				}
			}
		});
	}
}
