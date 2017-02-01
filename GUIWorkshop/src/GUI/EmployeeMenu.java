package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnCreateEmployee;
	private JButton btnReadEmployee;
	private JButton btnUpdateEmployee;
	private JButton btnDeleteEmployee;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMenu frame = new EmployeeMenu();
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
	public EmployeeMenu() {
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
		
		btnCreateEmployee = new JButton("Create Employee");
		btnCreateEmployee.setBounds(193, 51, 134, 37);
		contentPane.add(btnCreateEmployee);
		
		btnReadEmployee = new JButton("Read Employee");
		
		btnReadEmployee.setBounds(193, 101, 134, 37);
		contentPane.add(btnReadEmployee);
		
		btnUpdateEmployee = new JButton("Update Employee");
		btnUpdateEmployee.setBounds(193, 151, 134, 37);
		contentPane.add(btnUpdateEmployee);
		
		btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.setBounds(193, 201, 134, 37);
		contentPane.add(btnDeleteEmployee);
		
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
		btnCreateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateEmployee createEmployee = new CreateEmployee();
				dispose();
				createEmployee.main(null);
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMenu chMenu = new ChooseMenu();
				dispose();
				chMenu.main(null);
			}
		});
		
		btnReadEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadEmployee readEmployee = new ReadEmployee();
				dispose();
				//readEmployee.main(null);
			}
		});
	}

}
