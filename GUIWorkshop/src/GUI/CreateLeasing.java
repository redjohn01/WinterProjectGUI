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
import UILayer.InputChecker;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class CreateLeasing extends JFrame {

	private JPanel contentPane;
	private JButton btnCheckQuantity;
	private JButton btnSubmit;
	private JButton btnExitProgram;
	private JButton btnBack;
	private JTextField textFieldBarcode;
	private JTextField textFieldPlace;
	private JTextField textFieldAvailable;
	private JTextField textFieldQuantity;
	private JTextField textFieldID;
	private JTextField textFieldPeriod;
	private JTextField textFieldCPR;
	private JLabel mouseDrag;
	private JLabel logo;
	private String place, barcode;
	private int availableQuantity;
	private static int period;
	int xMouse, yMouse; // for smooth dragging
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateLeasing frame = new CreateLeasing();
					frame.setUndecorated(true); // bordeless
					frame.setVisible(true);
					frame.setSize(640,480);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateLeasing() {
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
		
		//CHECK QUANTITY BUTTON
		btnCheckQuantity = new JButton("Check quantity");
		btnCheckQuantity.setBounds(421, 95, 77, 67);
		btnCheckQuantity.setContentAreaFilled(false);
		btnCheckQuantity.setBorder(null);
		ImageIcon img = new ImageIcon(CustomerMenu.class.getResource("/components/checkQuantity.png"));
		ImageIcon btnCheckQuantityImg = new ImageIcon( img.getImage().getScaledInstance(btnCheckQuantity.getWidth()-20, btnCheckQuantity.getHeight()-20, Image.SCALE_SMOOTH) );
		btnCheckQuantity.setIcon(btnCheckQuantityImg);
		contentPane.add(btnCheckQuantity);
		
		//SUBMIT BUTTON
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(433, 326, 77, 58);
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBorder(new LineBorder(Color.orange, 5));
		ImageIcon img1 = new ImageIcon(CustomerMenu.class.getResource("/components/submit.png"));
		ImageIcon btnSubmitImg = new ImageIcon( img1.getImage().getScaledInstance(btnSubmit.getWidth(), btnSubmit.getHeight(), Image.SCALE_SMOOTH) );
		btnSubmit.setIcon(btnSubmitImg);
		contentPane.add(btnSubmit);
		
		//BACK BUTTON
				btnBack = new JButton();
				btnBack.setBounds(10, 388, 49, 43);
				btnBack.setContentAreaFilled(false);
				btnBack.setBorder(new LineBorder(Color.orange, 5));
				ImageIcon img3 = new ImageIcon(CustomerMenu.class.getResource("/components/back.png"));
				ImageIcon btnImageIcon = new ImageIcon( img3.getImage().getScaledInstance(btnBack.getWidth()-10, btnBack.getHeight()-10, Image.SCALE_SMOOTH) );
				btnBack.setIcon(btnImageIcon);
				contentPane.add(btnBack);
				
		//EXIT BUTTON
				btnExitProgram = new JButton();
				btnExitProgram.setBounds(314, 0, 42, 32);
				ImageIcon img4 = new ImageIcon(CustomerMenu.class.getResource("/components/x.png"));
				ImageIcon btnExitProgramImg = new ImageIcon( img4.getImage().getScaledInstance(btnExitProgram.getWidth()-10, btnExitProgram.getHeight()-10, Image.SCALE_SMOOTH) );
				btnExitProgram.setIcon(btnExitProgramImg);
				btnExitProgram.setContentAreaFilled(false);
				btnExitProgram.setBorder(null);
				btnExitProgram.setOpaque(false);
				contentPane.add(btnExitProgram);
				
			
		//LOGO LABEL
				logo = new JLabel();
				logo.setBounds(547, 373, 67, 58);
				logo.setBorder(new LineBorder(Color.white, 5));
				ImageIcon img5 = new ImageIcon(CustomerMenu.class.getResource("/components/logo.png"));
				ImageIcon logoImg = new ImageIcon( img5.getImage().getScaledInstance(logo.getWidth()-10, logo.getHeight()-10, Image.SCALE_SMOOTH) );
				logo.setIcon(logoImg);
				contentPane.add(logo);
					
					
		//MOUSE DRAG
				mouseDrag =  new JLabel();
				mouseDrag.setBounds(0, 0, 677, 30);
				ImageIcon img6 = new ImageIcon(CustomerMenu.class.getResource("/components/drag.gif"));
				ImageIcon dragImg = new ImageIcon( img6.getImage().getScaledInstance(mouseDrag.getWidth()-5, mouseDrag.getHeight()-5, Image.SCALE_SMOOTH) );
				mouseDrag.setIcon(dragImg);
				contentPane.add(mouseDrag);
					
		
		//BARCODE TEXTFIELD
		textFieldBarcode = new JTextField();
		textFieldBarcode.setColumns(10);
		textFieldBarcode.setBounds(284, 140, 116, 22);
		textFieldBarcode.setBackground(Color.ORANGE);
		textFieldBarcode.setForeground(Color.BLACK);
		contentPane.add(textFieldBarcode);
		
		//PLACE TEXTFIELD
		textFieldPlace = new JTextField();
		textFieldPlace.setColumns(10);
		textFieldPlace.setBounds(284, 105, 116, 22);
		textFieldPlace.setBackground(Color.ORANGE);
		textFieldPlace.setForeground(Color.BLACK);
		contentPane.add(textFieldPlace);
		
		//AVAILABLE TEXTFIELD
		textFieldAvailable = new JTextField();
		textFieldAvailable.setColumns(10);
		textFieldAvailable.setBounds(284, 227, 116, 22);
		textFieldAvailable.setBackground(Color.ORANGE);
		textFieldAvailable.setForeground(Color.BLACK);
		contentPane.add(textFieldAvailable);
		
		//QUANTITY TEXTFIELD
		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(284, 291, 116, 22);
		textFieldQuantity.setBackground(Color.ORANGE);
		textFieldQuantity.setForeground(Color.BLACK);
		contentPane.add(textFieldQuantity);
		
		//ID TEXTFIELD
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(284, 326, 116, 22);
		textFieldID.setBackground(Color.ORANGE);
		textFieldID.setForeground(Color.BLACK);
		contentPane.add(textFieldID);
		
		//PERIOD TEXTFIELD
		textFieldPeriod = new JTextField();
		textFieldPeriod.setColumns(10);
		textFieldPeriod.setBounds(284, 361, 116, 22);
		textFieldPeriod.setBackground(Color.ORANGE);
		textFieldPeriod.setForeground(Color.BLACK);
		contentPane.add(textFieldPeriod);
		
		//CPR TEXTFIELD
		textFieldCPR = new JTextField();
		textFieldCPR.setColumns(10);
		textFieldCPR.setBounds(284, 396, 116, 22);
		textFieldCPR.setBackground(Color.ORANGE);
		textFieldCPR.setForeground(Color.BLACK);
		contentPane.add(textFieldCPR);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 210, 498, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 262, 498, 2);
		contentPane.add(separator_1);
		
		
		JLabel lblPlacetimberOrDiy = new JLabel("Place(Timber or DIY)");
		lblPlacetimberOrDiy.setBounds(139, 108, 133, 16);
		lblPlacetimberOrDiy.setForeground(Color.ORANGE);
		contentPane.add(lblPlacetimberOrDiy);
		
		JLabel lblItemBarcode = new JLabel("Item barcode");
		lblItemBarcode.setBounds(139, 143, 133, 16);
		lblItemBarcode.setForeground(Color.ORANGE);
		contentPane.add(lblItemBarcode);
		
		JLabel lblAvailablePieces = new JLabel("Available pieces");
		lblAvailablePieces.setBounds(139, 225, 133, 24);
		lblAvailablePieces.setForeground(Color.ORANGE);
		contentPane.add(lblAvailablePieces);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(139, 294, 133, 16);
		lblQuantity.setForeground(Color.ORANGE);
		contentPane.add(lblQuantity);
		
		JLabel lblLeasingNumberid = new JLabel("Leasing number ID");
		lblLeasingNumberid.setBounds(139, 329, 133, 16);
		lblLeasingNumberid.setForeground(Color.ORANGE);
		contentPane.add(lblLeasingNumberid);
		
		JLabel lblPeriodOfTime = new JLabel("Period of time");
		lblPeriodOfTime.setBounds(139, 364, 133, 16);
		lblPeriodOfTime.setForeground(Color.ORANGE);
		contentPane.add(lblPeriodOfTime);
		
		JLabel lblUserSpr = new JLabel("User CPR/CVR");
		lblUserSpr.setBounds(139, 399, 133, 16);
		lblUserSpr.setForeground(Color.ORANGE);
		contentPane.add(lblUserSpr);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		
		btnCheckQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputChecker.verifyPlace(textFieldPlace.getText());
				InputChecker.verifyItemBarcode(textFieldBarcode.getText());
				place = textFieldPlace.getText().toLowerCase();
				barcode = textFieldBarcode.getText().toLowerCase();
				availableQuantity = InputChecker.returnQuantityAtPlace(place, barcode);
				String request = String.valueOf(availableQuantity);
				textFieldAvailable.setText(request);
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanControl loanControl = new LoanControl();
				
				int quantity = Integer.parseInt(textFieldQuantity.getText());
				period = Integer.parseInt(textFieldPeriod.getText());
				
				InputChecker.getQuantityAtPlace(place, barcode, quantity);
				
				String numberID = textFieldID.getText();
				String cpr = textFieldCPR.getText();
				InputChecker.verifySaleNumberID(numberID);
				InputChecker.verifyId(2,cpr);
				InputChecker.verifyPeriod(period);
				//InputChecker.verifyId(1,cpr);
				HashMap<String,Integer> items = new HashMap<>();
				
				if(quantity > 0) {
					items.put(barcode, quantity);
				}
				
				if(loanControl.getAvailableItems(place, items, numberID, cpr, period)) {
					JOptionPane.showMessageDialog(null, "Operation finished with success.");
					textFieldPlace.setText("");
					textFieldBarcode.setText("");
					textFieldID.setText("");
					textFieldCPR.setText("");
					textFieldQuantity.setText("");
					textFieldAvailable.setText("");
					textFieldPeriod.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Operation failed.");
				}
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
	
	protected static int getPeriod() {
		return period;
	}
}
