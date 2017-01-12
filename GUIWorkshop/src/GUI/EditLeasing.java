package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.LoanControl;
import ControlLayer.SaleControl;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EditLeasing extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JTextField textFieldSearch;
	private JTextField textFieldID;
	private JTextField textFieldPrice;
	private JTextField textFieldPeriod;
	private JTextField textFieldCustomer;
	private JTextField textFieldChoose;
	private JTextField textFieldObject;
	private JButton btnSearch;
	private JButton btnSave;
	LoanControl loanControl = new LoanControl();
	private String search;
	ArrayList<String> readResult = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditLeasing frame = new EditLeasing();
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
	public EditLeasing() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(12, 94, 116, 22);
		contentPane.add(textFieldSearch);
		
		JLabel lblSearch = new JLabel("Search by Number ID");
		lblSearch.setBounds(12, 66, 129, 16);
		contentPane.add(lblSearch);
		
		btnSearch = new JButton("Search");
		
		btnSearch.setBounds(33, 129, 97, 25);
		contentPane.add(btnSearch);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(347, 94, 153, 22);
		contentPane.add(textFieldID);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(347, 130, 153, 22);
		contentPane.add(textFieldPrice);
		
		textFieldPeriod = new JTextField();
		textFieldPeriod.setColumns(10);
		textFieldPeriod.setBounds(347, 163, 153, 22);
		contentPane.add(textFieldPeriod);
		
		textFieldCustomer = new JTextField();
		textFieldCustomer.setColumns(10);
		textFieldCustomer.setBounds(347, 198, 153, 22);
		contentPane.add(textFieldCustomer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 244, 488, 2);
		contentPane.add(separator);
		
		textFieldChoose = new JTextField();
		textFieldChoose.setColumns(10);
		textFieldChoose.setBounds(347, 301, 153, 22);
		contentPane.add(textFieldChoose);
		
		textFieldObject = new JTextField();
		textFieldObject.setColumns(10);
		textFieldObject.setBounds(347, 338, 153, 22);
		contentPane.add(textFieldObject);
		
		btnSave = new JButton("Save");
		
		btnSave.setBounds(403, 384, 97, 25);
		contentPane.add(btnSave);
		
		JLabel lblNumberId = new JLabel("1.Number ID");
		lblNumberId.setBounds(238, 97, 97, 16);
		contentPane.add(lblNumberId);
		
		JLabel lblPrice = new JLabel("2.Price");
		lblPrice.setBounds(238, 133, 97, 16);
		contentPane.add(lblPrice);
		
		JLabel lblPeriodOfTime = new JLabel("3.Period of time");
		lblPeriodOfTime.setBounds(238, 166, 97, 16);
		contentPane.add(lblPeriodOfTime);
		
		JLabel lblCustomer = new JLabel("4.Customer");
		lblCustomer.setBounds(238, 201, 97, 16);
		contentPane.add(lblCustomer);
		
		JLabel lblSelectFieldFrom = new JLabel("Select field from 1 to 4");
		lblSelectFieldFrom.setBounds(192, 304, 143, 16);
		contentPane.add(lblSelectFieldFrom);
		
		JLabel lblChangeFieldTo = new JLabel("Change field to");
		lblChangeFieldTo.setBounds(192, 341, 143, 16);
		contentPane.add(lblChangeFieldTo);
		
		JLabel lblChangeTo = new JLabel("Change to >>>");
		lblChangeTo.setBounds(377, 272, 104, 16);
		contentPane.add(lblChangeTo);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(389, 66, 77, 16);
		contentPane.add(lblResults);
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
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search = textFieldSearch.getText();
				readResult = loanControl.readLoan(search);
				if(readResult != null) {
					textFieldID.setText(readResult.get(0).substring(12));
					textFieldPrice.setText(readResult.get(1).substring(9));
					textFieldCustomer.setText(readResult.get(2).substring(12) + " -CPR");
					textFieldPeriod.setText(readResult.get(3).substring(2) + " for " + CreateLeasing.getPeriod() + " weeks");
				}
				else {
					JOptionPane.showMessageDialog(null, "There is no such sale!");
				}	
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fieldChoice = Integer.parseInt(textFieldChoose.getText());
				Object object = textFieldObject.getText();
				
				try{
					loanControl.updateLoan(search, fieldChoice, object); 	
					JOptionPane.showMessageDialog(null, "Successfuly saved!");
					textFieldSearch.setText("");
					textFieldID.setText("");
					textFieldPrice.setText("");
					textFieldPeriod.setText("");
					textFieldCustomer.setText("");
					textFieldChoose.setText("");
					textFieldObject.setText("");
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error, please try again!");
				}
			}
		});
	}


}
