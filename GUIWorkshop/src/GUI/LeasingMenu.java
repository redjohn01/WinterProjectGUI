package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
		setBounds(100, 100, 476, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		btnCreateLeasing = new JButton("Create Leasing");
		btnCreateLeasing.setBounds(165, 68, 123, 36);
		contentPane.add(btnCreateLeasing);
		
		btnReadleasing = new JButton("ReadLeasing");
		btnReadleasing.setBounds(165, 117, 123, 36);
		contentPane.add(btnReadleasing);
		
		btnEditleasing = new JButton("EditLeasing");
		btnEditleasing.setBounds(165, 166, 123, 36);
		contentPane.add(btnEditleasing);
		
		btnPreviousMenu = new JButton("Previous Menu");
		btnPreviousMenu.setBounds(165, 215, 123, 36);
		contentPane.add(btnPreviousMenu);
		
		JButton btnExitProgram = new JButton("Exit Program");
		btnExitProgram.setBounds(165, 264, 123, 36);
		contentPane.add(btnExitProgram);
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
	}

}
