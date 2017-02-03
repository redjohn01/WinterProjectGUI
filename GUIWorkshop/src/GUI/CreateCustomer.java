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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSeparator;

public class CreateCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnAdd;
	private JButton btnBack;
	private JButton btnExitProgram;
	private JLabel mouseDrag;
	int xMouse, yMouse; // for smooth dragging

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCustomer frame = new CreateCustomer();
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
	public CreateCustomer() {
		initializeComponents();
		createEvents();
	}


	private void initializeComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setOpaque(true);
		contentPane.setBackground(new Color(27,28,28, 255)); // background color
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(443, 65, 116, 22);
		textField.setForeground(Color.ORANGE);
		textField.setBackground(Color.BLACK);
		textField.setBorder(new LineBorder(Color.ORANGE,1));
		contentPane.add(textField);
		//textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(443, 98, 116, 22);
		textField_1.setForeground(Color.ORANGE);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBorder(new LineBorder(Color.ORANGE,1));
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(443, 131, 116, 22);
		textField_2.setForeground(Color.ORANGE);
		textField_2.setBackground(Color.BLACK);
		textField_2.setBorder(new LineBorder(Color.ORANGE,1));
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(443, 164, 116, 22);
		textField_3.setForeground(Color.ORANGE);
		textField_3.setBackground(Color.BLACK);
		textField_3.setBorder(new LineBorder(Color.ORANGE,1));
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(443, 197, 116, 22);
		textField_4.setForeground(Color.ORANGE);
		textField_4.setBackground(Color.BLACK);
		textField_4.setBorder(new LineBorder(Color.ORANGE,1));
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(443, 230, 116, 22);
		textField_5.setForeground(Color.ORANGE);
		textField_5.setBackground(Color.BLACK);
		textField_5.setBorder(new LineBorder(Color.ORANGE,1));
		contentPane.add(textField_5);
		
		JLabel lblCPR = new JLabel("CPR");
		lblCPR.setBounds(294, 58, 90, 16);
		lblCPR.setForeground(Color.ORANGE);
		lblCPR.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblCPR);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(294, 91, 90, 16);
		lblName.setForeground(Color.ORANGE);
		lblName.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(294, 124, 90, 16);
		lblAddress.setForeground(Color.ORANGE);
		lblAddress.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(294, 163, 90, 16);
		lblEmail.setForeground(Color.ORANGE);
		lblEmail.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(294, 198, 90, 16);
		lblPhone.setForeground(Color.ORANGE);
		lblPhone.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblPhone);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(294, 233, 90, 16);
		lblCity.setForeground(Color.ORANGE);
		lblCity.setBorder(new LineBorder(Color.ORANGE, 2));
		contentPane.add(lblCity);
		
		JLabel lblCreateCustomer = new JLabel();
		lblCreateCustomer.setBounds(24, 41, 247, 239);
		ImageIcon img = new ImageIcon(CustomerMenu.class.getResource("/components/CreateCustomer.png"));
		ImageIcon lblCreateCustomerImg = new ImageIcon( img.getImage().getScaledInstance(lblCreateCustomer.getWidth()-10, lblCreateCustomer.getHeight()-10, Image.SCALE_SMOOTH) );
		lblCreateCustomer.setIcon(lblCreateCustomerImg);
		lblCreateCustomer.setOpaque(false);
		contentPane.add(lblCreateCustomer);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(527, 367, 97, 64);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorder(null);
		ImageIcon img2 = new ImageIcon(CustomerMenu.class.getResource("/components/add.png"));
		ImageIcon btnAddImg = new ImageIcon( img2.getImage().getScaledInstance(btnAdd.getWidth()-5, btnAdd.getHeight(), Image.SCALE_SMOOTH) );
		btnAdd.setIcon(btnAddImg);
		contentPane.add(btnAdd);
		
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
				
				//MOUSE DRAG
				mouseDrag =  new JLabel();
				mouseDrag.setBounds(0, 0, 677, 30);
				ImageIcon img5 = new ImageIcon(CustomerMenu.class.getResource("/components/drag.gif"));
				ImageIcon dragImg = new ImageIcon( img5.getImage().getScaledInstance(mouseDrag.getWidth()-5, mouseDrag.getHeight()-5, Image.SCALE_SMOOTH) );
				mouseDrag.setIcon(dragImg);
				contentPane.add(mouseDrag);
	}
	
	private void createEvents() {
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerMenu cMenu = new CustomerMenu();
				dispose();
				cMenu.main(null);
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerControl customerControler = new CustomerControl();
				String cpr = textField.getText();
				String name = textField_1.getText();
				String address = textField_2.getText();
				String email = textField_3.getText();
				String phone = textField_4.getText();
				String city = textField_5.getText();
				boolean ok = true;
				
				if( !InputChecker.verifyId(2,cpr) )
					ok = false;
				if( !InputChecker.verifyName(name) )
					ok = false;
				if( !InputChecker.verifyAddress(address) )
					ok = false;
				if( !InputChecker.verifyEmail(email) )
					ok = false;
				if( !InputChecker.verifyPhone(phone) )
					ok = false;
				if( !InputChecker.verifyCity(city) )
					ok = false;

				if(ok)
					if(InputChecker.verifyId(1, cpr) && customerControler.createCustomer(cpr, name, address, email, phone, city)) {
					
					JOptionPane.showMessageDialog(null, "Operation finished with success.");

					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
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
