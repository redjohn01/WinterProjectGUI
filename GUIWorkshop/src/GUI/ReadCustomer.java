package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ControlLayer.CustomerControl;
import UILayer.InputChecker;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ReadCustomer extends JFrame {

	private JPanel contentPane;
	private JButton btnSearch;
	private JTextField textFieldCPR;
	private JTextField textFieldPrint;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldCity;
	private JButton btnBack;
	private JButton btnExitProgram;
	private JLabel mouseDrag;
	private JLabel lblFemale;
	private JLabel lblMale;
	int xMouse, yMouse; // for smooth dragging

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadCustomer frame = new ReadCustomer();
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
	public ReadCustomer() {
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
		btnSearch.setBounds(415, 41, 49, 41);
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorder(null);
		ImageIcon img = new ImageIcon(CustomerMenu.class.getResource("/components/search.png"));
		ImageIcon btnSearchImg = new ImageIcon( img.getImage().getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), Image.SCALE_SMOOTH) );
		btnSearch.setIcon(btnSearchImg);
		contentPane.add(btnSearch);
		
		//BACK BUTTON
		btnBack = new JButton();
		btnBack.setBounds(10, 388, 49, 43);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new LineBorder(Color.orange, 5));
		ImageIcon img1 = new ImageIcon(CustomerMenu.class.getResource("/components/back.png"));
		ImageIcon btnImageIcon = new ImageIcon( img1.getImage().getScaledInstance(btnBack.getWidth()-10, btnBack.getHeight()-10, Image.SCALE_SMOOTH) );
		btnBack.setIcon(btnImageIcon);
		contentPane.add(btnBack);
		
		//EXIT BUTTON
		btnExitProgram = new JButton();
		btnExitProgram.setBounds(314, 0, 42, 32);
		ImageIcon img2 = new ImageIcon(CustomerMenu.class.getResource("/components/x.png"));
		ImageIcon btnExitProgramImg = new ImageIcon( img2.getImage().getScaledInstance(btnExitProgram.getWidth()-10, btnExitProgram.getHeight()-10, Image.SCALE_SMOOTH) );
		btnExitProgram.setIcon(btnExitProgramImg);
		btnExitProgram.setContentAreaFilled(false);
		btnExitProgram.setBorder(null);
		btnExitProgram.setOpaque(false);
		contentPane.add(btnExitProgram);
		
		//MOUSE DRAG
		mouseDrag =  new JLabel();
		mouseDrag.setBounds(0, 0, 677, 30);
		ImageIcon img3 = new ImageIcon(CustomerMenu.class.getResource("/components/drag.gif"));
		ImageIcon dragImg = new ImageIcon( img3.getImage().getScaledInstance(mouseDrag.getWidth()-5, mouseDrag.getHeight()-5, Image.SCALE_SMOOTH) );
		mouseDrag.setIcon(dragImg);
		contentPane.add(mouseDrag);
		
		lblMale = new JLabel();
		lblMale.setBounds(174, 111, 239, 189);
		ImageIcon img4 = new ImageIcon(CustomerMenu.class.getResource("/components/male.png"));
		ImageIcon lblMaleImg = new ImageIcon( img4.getImage().getScaledInstance(lblMale.getWidth()-5, lblMale.getHeight()-5, Image.SCALE_SMOOTH) );
		lblMale.setIcon(lblMaleImg);
		lblMale.setBorder(null);
		lblMale.setVisible(false);
		contentPane.add(lblMale);
		
		lblFemale = new JLabel();
		lblFemale.setBounds(174, 132, 239, 189);
		ImageIcon img5 = new ImageIcon(CustomerMenu.class.getResource("/components/female.png"));
		ImageIcon lblFemaleImg = new ImageIcon( img5.getImage().getScaledInstance(lblFemale.getWidth()-5, lblFemale.getHeight()-5, Image.SCALE_SMOOTH) );
		lblFemale.setIcon(lblFemaleImg);
		lblFemale.setBorder(null);
		lblFemale.setVisible(false);
		contentPane.add(lblFemale);
		
		JLabel lblSearchByCpr = new JLabel("Search by CPR");
		lblSearchByCpr.setBounds(281, 43, 92, 16);
		lblSearchByCpr.setForeground(Color.ORANGE);
		lblSearchByCpr.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblSearchByCpr);
		
		JLabel lblSearch = new JLabel();
		lblSearch.setBounds(386, 209, 228, 222);
		lblSearch.setBorder(new LineBorder(Color.ORANGE, 6));
		ImageIcon img6 = new ImageIcon(CustomerMenu.class.getResource("/components/searchImg.jpg"));
		ImageIcon lblSearchImg = new ImageIcon( img6.getImage().getScaledInstance(lblSearch.getWidth(), lblSearch.getHeight(), Image.SCALE_SMOOTH) );
		lblSearch.setIcon(lblSearchImg);
		contentPane.add(lblSearch);
		
		JLabel lblCpr = new JLabel("CPR ");
		lblCpr.setBounds(10, 97, 56, 16);
		lblCpr.setForeground(Color.ORANGE);
		lblCpr.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblCpr);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setBounds(98, 132, 56, 16);
		lblName.setForeground(Color.ORANGE);
		lblName.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 169, 56, 16);
		lblAddress.setForeground(Color.ORANGE);
		lblAddress.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 208, 56, 16);
		lblEmail.setForeground(Color.ORANGE);
		lblEmail.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(98, 249, 56, 16);
		lblPhone.setForeground(Color.ORANGE);
		lblPhone.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblPhone);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 284, 56, 16);
		lblCity.setForeground(Color.ORANGE);
		lblCity.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblCity);
		
		
		textFieldPrint = new JTextField();
		textFieldPrint.setBounds(10, 111, 144, 22);
		textFieldPrint.setForeground(Color.black);
		textFieldPrint.setBackground(Color.orange);
		textFieldPrint.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldPrint.setEditable(false);
		contentPane.add(textFieldPrint);
		textFieldPrint.setColumns(10);
		
		textFieldCPR = new JTextField();
		textFieldCPR.setColumns(10);
		textFieldCPR.setBounds(271, 70, 116, 22);
		textFieldCPR.setForeground(Color.ORANGE);
		textFieldCPR.setBackground(Color.black);
		textFieldCPR.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldCPR.setEditable(true);
		contentPane.add(textFieldCPR);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(10, 147, 144, 22);
		textFieldName.setForeground(Color.black);
		textFieldName.setBackground(Color.orange);
		textFieldName.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldName.setEditable(false);
		contentPane.add(textFieldName);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(10, 186, 144, 22);
		textFieldAddress.setForeground(Color.black);
		textFieldAddress.setBackground(Color.orange);
		textFieldAddress.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldAddress.setEditable(false);
		contentPane.add(textFieldAddress);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(10, 225, 144, 22);
		textFieldEmail.setForeground(Color.black);
		textFieldEmail.setBackground(Color.orange);
		textFieldEmail.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldEmail.setEditable(false);
		contentPane.add(textFieldEmail);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(10, 263, 144, 22);
		textFieldPhone.setForeground(Color.black);
		textFieldPhone.setBackground(Color.orange);
		textFieldPhone.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldPhone.setEditable(false);
		contentPane.add(textFieldPhone);
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(10, 302, 144, 22);
		textFieldCity.setForeground(Color.black);
		textFieldCity.setBackground(Color.orange);
		textFieldCity.setBorder(new LineBorder(Color.ORANGE,1));
		textFieldCity.setEditable(false);
		contentPane.add(textFieldCity);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerMenu customerMenu = new CustomerMenu();
				dispose();
				customerMenu.main(null);
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerControl customerControl = new CustomerControl();
				
				String cpr = textFieldCPR.getText();
				ArrayList<String> result = customerControl.getCustomerByCpr(cpr);
				
				lblMale.setVisible(false); //reset their visibility
				lblFemale.setVisible(false);

				if(result != null) {
					textFieldPrint.setText(result.get(0).substring(8));
						if( Double.parseDouble( result.get(0).substring(8) ) % 2 == 0) //if the last digit of the CPR is divisible by 2, it means the person is a she
							lblFemale.setVisible(true);
						else
							lblMale.setVisible(true);
					textFieldName.setText(result.get(1).substring(9));
					textFieldAddress.setText(result.get(2).substring(12));
					textFieldEmail.setText(result.get(3).substring(10));
					textFieldPhone.setText(result.get(4).substring(10));
					textFieldCity.setText(result.get(5).substring(9));
                }
                else {
                	JOptionPane.showMessageDialog(null, "Sorry, there is no such user!");
                }
				
			}
		});
		
		btnExitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?");
				if(confirm == JOptionPane.YES_OPTION) {
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
