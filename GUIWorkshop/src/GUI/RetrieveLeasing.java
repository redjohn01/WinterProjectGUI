package GUI;

import static UILayer.MenuText.FAILURE;
import static UILayer.MenuText.SUCCESS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.LoanControl;
import UILayer.InputChecker;
import UILayer.MenuText;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RetrieveLeasing extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JButton btnBack;
	private JButton btnRetrieve;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetrieveLeasing frame = new RetrieveLeasing();
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
	public RetrieveLeasing() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(12, 99, 126, 22);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblInputNumberId = new JLabel("Input number ID");
		lblInputNumberId.setBounds(12, 74, 126, 16);
		contentPane.add(lblInputNumberId);
		
		btnRetrieve = new JButton("Retrieve");
		
		btnRetrieve.setBounds(41, 137, 97, 25);
		contentPane.add(btnRetrieve);
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeasingMenu leasingMenu = new LeasingMenu();
				dispose();
				leasingMenu.main(null);
			}
		});
		
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanControl loanControl = new LoanControl();
				String numberID = textFieldSearch.getText();
				InputChecker.verifySaleNumberID(numberID);
		        if(loanControl.retrieveLoan(numberID)) {
		        	JOptionPane.showMessageDialog(null, "Operation has finished with success!");
		        }
		        else {
		        	JOptionPane.showMessageDialog(null, "Operation has failed!");
		        }
			}
		});
		
	}

}
