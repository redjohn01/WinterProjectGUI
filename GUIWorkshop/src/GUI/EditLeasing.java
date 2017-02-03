package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ControlLayer.LoanControl;
import ControlLayer.SaleControl;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EditLeasing extends JFrame {

	private JPanel contentPane;
	private JButton btnExitProgram;
	private JButton btnBack;
	private JButton btnSearch;
	private JButton btnSave;
	private JTextField textFieldSearch;
	private JTextField textFieldID;
	private JTextField textFieldPrice;
	private JTextField textFieldPeriod;
	private JTextField textFieldCustomer;
	private JTextField textFieldChoose;
	private JTextField textFieldObject;
	private JLabel mouseDrag;
	private JLabel logo;
	ArrayList<String> readResult = new ArrayList<>();
	LoanControl loanControl = new LoanControl();
	private String search;
	int xMouse, yMouse; // for smooth dragging
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditLeasing frame = new EditLeasing();
					frame.setUndecorated(true); // bordeless
					frame.setVisible(true);
					frame.setSize(640, 480);
					
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
		setBounds(100, 100, 640, 480);
		
		contentPane = new JPanel();
		contentPane.setOpaque(true);
		contentPane.setBackground(new Color(27,28,28, 255)); // background color
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//SEARCH BUTTON
			btnSearch = new JButton("Search");
			btnSearch.setBounds(22, 127, 54, 58);
			btnSearch.setContentAreaFilled(false);
			btnSearch.setBorder(null);
			ImageIcon img = new ImageIcon(CustomerMenu.class.getResource("/components/search.png"));
			ImageIcon btnSearchImg = new ImageIcon( img.getImage().getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), Image.SCALE_SMOOTH) );
			btnSearch.setIcon(btnSearchImg);
			contentPane.add(btnSearch);
		
		//SAVE BUTTON
			btnSave = new JButton("Save");
			btnSave.setBounds(525, 294, 77, 66);
			btnSave.setContentAreaFilled(false);
			btnSave.setBorder(null);
			ImageIcon img2 = new ImageIcon(CustomerMenu.class.getResource("/components/save.png"));
			ImageIcon btnSaveImg = new ImageIcon( img2.getImage().getScaledInstance(btnSave.getWidth(), btnSave.getHeight(), Image.SCALE_SMOOTH) );
			btnSave.setIcon(btnSaveImg);
			contentPane.add(btnSave);
			
		//BACK BUTTON
				btnBack = new JButton();
				btnBack.setBounds(0, 409, 49, 43);
				btnBack.setContentAreaFilled(false);
				btnBack.setBorder(new LineBorder(Color.orange, 5));
				ImageIcon img4 = new ImageIcon(CustomerMenu.class.getResource("/components/back.png"));
				ImageIcon btnImageIcon = new ImageIcon( img4.getImage().getScaledInstance(btnBack.getWidth()-10, btnBack.getHeight()-10, Image.SCALE_SMOOTH) );
				btnBack.setIcon(btnImageIcon);
				contentPane.add(btnBack);
				
		//EXIT BUTTON
				btnExitProgram = new JButton();
				btnExitProgram.setBounds(314, 0, 42, 32);
				ImageIcon img5 = new ImageIcon(CustomerMenu.class.getResource("/components/x.png"));
				ImageIcon btnExitProgramImg = new ImageIcon( img5.getImage().getScaledInstance(btnExitProgram.getWidth()-10, btnExitProgram.getHeight()-10, Image.SCALE_SMOOTH) );
				btnExitProgram.setIcon(btnExitProgramImg);
				btnExitProgram.setContentAreaFilled(false);
				btnExitProgram.setBorder(null);
				btnExitProgram.setOpaque(false);
				contentPane.add(btnExitProgram);
				

				
				//LOGO LABEL
					logo = new JLabel();
					logo.setBounds(535, 371, 95, 81);
					logo.setBorder(new LineBorder(Color.white, 5));
					ImageIcon img6 = new ImageIcon(CustomerMenu.class.getResource("/components/logo.png"));
					ImageIcon logoImg = new ImageIcon( img6.getImage().getScaledInstance(logo.getWidth()-10, logo.getHeight()-10, Image.SCALE_SMOOTH) );
					logo.setIcon(logoImg);
					contentPane.add(logo);
					
				//MOUSE DRAG
					mouseDrag =  new JLabel();
					mouseDrag.setBounds(0, 0, 677, 30);
					ImageIcon img7 = new ImageIcon(CustomerMenu.class.getResource("/components/drag.gif"));
					ImageIcon dragImg = new ImageIcon( img7.getImage().getScaledInstance(mouseDrag.getWidth()-5, mouseDrag.getHeight()-5, Image.SCALE_SMOOTH) );
					mouseDrag.setIcon(dragImg);
					contentPane.add(mouseDrag);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(12, 94, 116, 22);
		textFieldSearch.setForeground(Color.black);
		textFieldSearch.setBackground(Color.orange);
		textFieldSearch.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldSearch.setEditable(false);
		contentPane.add(textFieldSearch);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(347, 94, 153, 22);
		textFieldID.setForeground(Color.black);
		textFieldID.setBackground(Color.orange);
		textFieldID.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldID.setEditable(false);
		contentPane.add(textFieldID);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(347, 130, 153, 22);
		textFieldPrice.setForeground(Color.black);
		textFieldPrice.setBackground(Color.orange);
		textFieldPrice.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldPrice.setEditable(false);
		contentPane.add(textFieldPrice);
		
		textFieldPeriod = new JTextField();
		textFieldPeriod.setColumns(10);
		textFieldPeriod.setBounds(347, 163, 153, 22);
		textFieldPeriod.setForeground(Color.black);
		textFieldPeriod.setBackground(Color.orange);
		textFieldPeriod.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldPeriod.setEditable(false);
		contentPane.add(textFieldPeriod);
		
		textFieldCustomer = new JTextField();
		textFieldCustomer.setColumns(10);
		textFieldCustomer.setBounds(347, 198, 153, 22);
		textFieldCustomer.setForeground(Color.black);
		textFieldCustomer.setBackground(Color.orange);
		textFieldCustomer.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldCustomer.setEditable(false);
		contentPane.add(textFieldCustomer);
		
		textFieldChoose = new JTextField();
		textFieldChoose.setColumns(10);
		textFieldChoose.setBounds(347, 301, 153, 22);
		textFieldChoose.setForeground(Color.orange);
		textFieldChoose.setBackground(Color.black);
		textFieldChoose.setBorder(new LineBorder(Color.white,1));
		textFieldChoose.setEditable(true);
		contentPane.add(textFieldChoose);
		
		textFieldObject = new JTextField();
		textFieldObject.setColumns(10);
		textFieldObject.setBounds(347, 338, 153, 22);
		textFieldObject.setForeground(Color.orange);
		textFieldObject.setBackground(Color.black);
		textFieldObject.setBorder(new LineBorder(Color.white,1));
		textFieldObject.setEditable(true);
		contentPane.add(textFieldObject);
		
		
		JLabel lblNumberId = new JLabel("1.Number ID");
		lblNumberId.setBounds(238, 97, 97, 16);
		lblNumberId.setForeground(Color.ORANGE);
		contentPane.add(lblNumberId);
		
		JLabel lblPrice = new JLabel("2.Price");
		lblPrice.setBounds(238, 133, 97, 16);
		lblPrice.setForeground(Color.ORANGE);
		contentPane.add(lblPrice);
		
		JLabel lblPeriodOfTime = new JLabel("3.Period of time");
		lblPeriodOfTime.setBounds(238, 166, 97, 16);
		lblPeriodOfTime.setForeground(Color.ORANGE);
		contentPane.add(lblPeriodOfTime);
		
		JLabel lblCustomer = new JLabel("4.Customer");
		lblCustomer.setBounds(238, 201, 97, 16);
		lblCustomer.setForeground(Color.ORANGE);
		contentPane.add(lblCustomer);
		
		JLabel lblSelectFieldFrom = new JLabel("Select field from 1 to 4");
		lblSelectFieldFrom.setBounds(192, 304, 143, 16);
		lblSelectFieldFrom.setForeground(Color.ORANGE);
		contentPane.add(lblSelectFieldFrom);
		
		JLabel lblChangeFieldTo = new JLabel("Change field to");
		lblChangeFieldTo.setBounds(192, 341, 143, 16);
		lblChangeFieldTo.setForeground(Color.ORANGE);
		contentPane.add(lblChangeFieldTo);
		
		JLabel lblChangeTo = new JLabel("Change to >>>");
		lblChangeTo.setBounds(377, 272, 104, 16);
		lblChangeTo.setForeground(Color.ORANGE);
		contentPane.add(lblChangeTo);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(389, 66, 77, 16);
		lblResults.setForeground(Color.ORANGE);
		contentPane.add(lblResults);
		
		JLabel lblSearch = new JLabel("Search by Number ID");
		lblSearch.setBounds(12, 66, 129, 16);
		lblSearch.setForeground(Color.ORANGE);
		contentPane.add(lblSearch);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 244, 488, 2);
		contentPane.add(separator);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		
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
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeasingMenu leasingMenu = new LeasingMenu();
				dispose();
				leasingMenu.main(null);
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
		
		mouseDrag.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		mouseDrag.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
			}
		});
	}


}
