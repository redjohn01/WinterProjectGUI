package GUI;

import static UILayer.MenuText.FAILURE;
import static UILayer.MenuText.SUCCESS;

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
import UILayer.MenuText;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class RetrieveLeasing extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JButton btnBack;
	private JButton btnRetrieve;
	private JButton btnExitProgram;
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
					RetrieveLeasing frame = new RetrieveLeasing();
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
	public RetrieveLeasing() {
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
		
		
		JLabel lblRetrieve = new JLabel(" Retrieve");
		lblRetrieve.setBackground(Color.ORANGE);
		lblRetrieve.setForeground(Color.BLACK);
		lblRetrieve.setOpaque(true);
		lblRetrieve.setBounds(169, 116, 49, 25);
		contentPane.add(lblRetrieve);
		//RETRIEVE BUTTON
			btnRetrieve = new JButton("Retrieve");
			btnRetrieve.setBounds(148, 63, 95, 65);
			btnRetrieve.setContentAreaFilled(false);
			btnRetrieve.setBorder(null);
			ImageIcon img = new ImageIcon(CustomerMenu.class.getResource("/components/retriveLeasing.png"));
			ImageIcon btnRetrieveImg = new ImageIcon( img.getImage().getScaledInstance(btnRetrieve.getWidth()-10, btnRetrieve.getHeight()-10, Image.SCALE_SMOOTH) );
			btnRetrieve.setIcon(btnRetrieveImg);
			contentPane.add(btnRetrieve);
			
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
			logo.setBounds(251, 153, 379, 299);
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
		textFieldSearch.setBounds(12, 99, 126, 22);
		textFieldSearch.setForeground(Color.orange);
		textFieldSearch.setBackground(Color.black);
		textFieldSearch.setBorder(new LineBorder(Color.white,1));
		textFieldSearch.setEditable(true);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		

		JLabel lblInputNumberId = new JLabel("Input number ID");
		lblInputNumberId.setBounds(12, 74, 126, 16);
		lblInputNumberId.setForeground(Color.ORANGE);
		contentPane.add(lblInputNumberId);
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		
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
