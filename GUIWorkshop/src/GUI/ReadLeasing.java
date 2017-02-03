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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ReadLeasing extends JFrame {

	private JPanel contentPane;
	private JButton btnSearch;
	private JButton btnExitProgram;
	private JButton btnBack;
	private JTextField textFieldSearch;
	private JTextField textFieldID;
	private JTextField textFieldPrice;
	private JTextField textFieldPeriod;
	private JTextField textFieldCustomer;
	private JTextField textFieldStatus;
	private JLabel lblStatus;
	private JLabel mouseDrag;
	private JLabel logo;
	int xMouse, yMouse; // for smooth dragging

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadLeasing frame = new ReadLeasing();
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
	public ReadLeasing() {
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
		btnSearch.setBounds(138, 75, 56, 43);
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorder(null);
		ImageIcon img = new ImageIcon(CustomerMenu.class.getResource("/components/search.png"));
		ImageIcon btnSearchImg = new ImageIcon( img.getImage().getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), Image.SCALE_SMOOTH) );
		btnSearch.setIcon(btnSearchImg);
		contentPane.add(btnSearch);
		
	//BACK BUTTON
		btnBack = new JButton();
		btnBack.setBounds(12, 388, 49, 43);
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
		
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(12, 98, 116, 22);
		textFieldSearch.setForeground(Color.orange);
		textFieldSearch.setBackground(Color.black);
		textFieldSearch.setBorder(new LineBorder(Color.white,1));
		textFieldSearch.setEditable(true);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(326, 98, 151, 22);
		textFieldID.setForeground(Color.black);
		textFieldID.setBackground(Color.orange);
		textFieldID.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldID.setEditable(false);
		contentPane.add(textFieldID);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(326, 133, 151, 22);
		textFieldPrice.setForeground(Color.black);
		textFieldPrice.setBackground(Color.orange);
		textFieldPrice.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldPrice.setEditable(false);
		contentPane.add(textFieldPrice);
		
		textFieldPeriod = new JTextField();
		textFieldPeriod.setColumns(10);
		textFieldPeriod.setBounds(326, 168, 151, 22);
		textFieldPeriod.setForeground(Color.black);
		textFieldPeriod.setBackground(Color.orange);
		textFieldPeriod.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldPeriod.setEditable(false);
		contentPane.add(textFieldPeriod);
		
		textFieldCustomer = new JTextField();
		textFieldCustomer.setColumns(10);
		textFieldCustomer.setBounds(326, 203, 151, 22);
		textFieldCustomer.setForeground(Color.black);
		textFieldCustomer.setBackground(Color.orange);
		textFieldCustomer.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldCustomer.setEditable(false);
		contentPane.add(textFieldCustomer);
		
		textFieldStatus = new JTextField();
		textFieldStatus.setColumns(10);
		textFieldStatus.setBounds(326, 236, 151, 22);
		textFieldStatus.setForeground(Color.black);
		textFieldStatus.setBackground(Color.orange);
		textFieldStatus.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldStatus.setEditable(false);
		contentPane.add(textFieldStatus);
		
		
		JLabel lblNewLabel = new JLabel(" Search by ID number");
		lblNewLabel.setBounds(12, 75, 131, 16);
		lblNewLabel.setForeground(Color.ORANGE);
		contentPane.add(lblNewLabel);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(375, 75, 78, 16);
		lblResults.setForeground(Color.ORANGE);
		contentPane.add(lblResults);
		
		JLabel lblNewLabel_1 = new JLabel("Number ID");
		lblNewLabel_1.setBounds(217, 101, 97, 16);
		lblNewLabel_1.setForeground(Color.ORANGE);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(217, 136, 97, 16);
		lblPrice.setForeground(Color.ORANGE);
		contentPane.add(lblPrice);
		
		JLabel lblPeriodOfTime = new JLabel("Period of time");
		lblPeriodOfTime.setBounds(217, 171, 97, 16);
		lblPeriodOfTime.setForeground(Color.ORANGE);
		contentPane.add(lblPeriodOfTime);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(217, 206, 97, 16);
		lblCustomer.setForeground(Color.ORANGE);
		contentPane.add(lblCustomer);
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(217, 239, 97, 16);
		lblStatus.setForeground(Color.ORANGE);
		contentPane.add(lblStatus);
		
	//LOGO LABEL
		logo = new JLabel();
		logo.setBounds(512, 350, 95, 81);
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
				LoanControl loanControl = new LoanControl();
				String idNum = textFieldSearch.getText();
				ArrayList<String> readResult = loanControl.readLoan(idNum);
				
				if(readResult != null) {
					textFieldID.setText(readResult.get(0).substring(12));
					textFieldPrice.setText(readResult.get(1).substring(9));
					textFieldCustomer.setText(readResult.get(2).substring(12) + " -CPR");
					textFieldPeriod.setText(readResult.get(3).substring(2) + " " + readResult.get(4).substring(2));
					textFieldStatus.setText(readResult.get(5).substring(10));
				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry, there is no such sale!");
				}
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
