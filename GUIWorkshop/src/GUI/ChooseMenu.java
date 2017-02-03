package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ControlLayer.Brexit;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ChooseMenu extends JFrame {

	private JPanel contentPane;
	private JButton btCustomer;
	private JButton btEmployee;
	private JButton btItem;
	private JButton btContractor;
	private JButton btSale;
	private JButton btLeasing;
	private JButton btnLogout;
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
					ChooseMenu frame = new ChooseMenu();
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
	public ChooseMenu() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {

		ImageIcon img = new ImageIcon(CustomerMenu.class.getResource("/components/system.png"));
		setIconImage(img.getImage());
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		contentPane = new JPanel();
		contentPane.setOpaque(true);
		contentPane.setBackground(new Color(27,28,28, 255)); // background color
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//LOGOUT BUTTON
		btnLogout = new JButton("Log Out");
		btnLogout.setBounds(295, 2, 30, 30);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorder(null);
		ImageIcon img1 = new ImageIcon(CustomerMenu.class.getResource("/components/log out.png"));
		ImageIcon btnImageIcon = new ImageIcon( img1.getImage().getScaledInstance(btnLogout.getWidth(), btnLogout.getHeight(), Image.SCALE_SMOOTH) );
		btnLogout.setIcon(btnImageIcon);
		contentPane.add(btnLogout);
		
		JLabel lblCustomer = new JLabel("Customer Menu");
		lblCustomer.setBounds(44,161,96,25);
		contentPane.add(lblCustomer);
		//CUSTOMER BUTTON
			btCustomer = new JButton("Customer Menu");
			btCustomer.setBounds(10, 85, 158, 101);
			btCustomer.setContentAreaFilled(false);
			btCustomer.setBorder(null);
			ImageIcon img2 = new ImageIcon(CustomerMenu.class.getResource("/components/customer.png"));
			ImageIcon btCustomerImg = new ImageIcon( img2.getImage().getScaledInstance(btCustomer.getWidth(), btCustomer.getHeight(), Image.SCALE_SMOOTH) );
			btCustomer.setIcon(btCustomerImg);
			contentPane.add(btCustomer);
		
			JLabel lblEmployee = new JLabel("Employee Menu");
			lblEmployee.setBounds(44, 301, 96, 25);
			contentPane.add(lblEmployee);
		//EMPLOYEE BUTTON
			btEmployee = new JButton("Employee Menu");
			btEmployee.setBounds(20, 220, 148, 106);
			btEmployee.setContentAreaFilled(false);
			btEmployee.setBorder(null);
			ImageIcon img3 = new ImageIcon(CustomerMenu.class.getResource("/components/employee.png"));
			ImageIcon btEmployeeImg = new ImageIcon( img3.getImage().getScaledInstance(btEmployee.getWidth(), btEmployee.getHeight(), Image.SCALE_SMOOTH) );
			btEmployee.setIcon(btEmployeeImg);
			contentPane.add(btEmployee);
		
			JLabel lblItem = new JLabel(" Item Menu");
			lblItem.setBounds(522, 176, 59, 25);
			lblItem.setOpaque(true);
			lblItem.setBackground(Color.ORANGE);
			lblItem.setBorder(new LineBorder(Color.BLACK, 1));
			contentPane.add(lblItem);
		//ITEM BUTTON
			btItem = new JButton("Item Menu");
			btItem.setBounds(480, 73, 158, 113);
			btItem.setContentAreaFilled(false);
			btItem.setBorder(null);
			ImageIcon img4 = new ImageIcon(CustomerMenu.class.getResource("/components/items.png"));
			ImageIcon btItemImg = new ImageIcon( img4.getImage().getScaledInstance(btItem.getWidth(), btItem.getHeight(), Image.SCALE_SMOOTH) );
			btItem.setIcon(btItemImg);
			contentPane.add(btItem);
		
			JLabel lblContractor = new JLabel("Contracotr Menu");
			lblContractor.setBounds(180, 406, 88, 25);
			lblContractor.setBackground(Color.ORANGE);
			lblContractor.setOpaque(true);
			lblContractor.setBorder(new LineBorder(Color.BLACK, 1));
			contentPane.add(lblContractor);
		//CONTRACTOR BUTTON
			btContractor = new JButton("Contractor Menu");
			btContractor.setBounds(142, 337, 180, 94);
			btContractor.setContentAreaFilled(false);
			btContractor.setBorder(null);
			ImageIcon img5 = new ImageIcon(CustomerMenu.class.getResource("/components/contractor.png"));
			ImageIcon btContractorImg = new ImageIcon( img5.getImage().getScaledInstance(btItem.getWidth(), btItem.getHeight(), Image.SCALE_SMOOTH) );
			btContractor.setIcon(btContractorImg);
			contentPane.add(btContractor);
		
			JLabel lblSale = new JLabel("Sale Menu");
			lblSale.setBounds(391, 390, 59, 25);
			contentPane.add(lblSale);
		//SALE BUTTON
			btSale = new JButton("Sale Menu");
			btSale.setBounds(351, 331, 148, 100);
			btSale.setContentAreaFilled(false);
			btSale.setBorder(null);
			ImageIcon img6 = new ImageIcon(CustomerMenu.class.getResource("/components/sale.png"));
			ImageIcon btSaleImg = new ImageIcon( img6.getImage().getScaledInstance(btSale.getWidth(), btSale.getHeight(), Image.SCALE_SMOOTH) );
			btSale.setIcon(btSaleImg);
			contentPane.add(btSale);
		
			JLabel lblLeasing = new JLabel(" Leasing Menu");
			lblLeasing.setBounds(510, 320, 84, 25);
			lblLeasing.setOpaque(true);
			lblLeasing.setBackground(Color.ORANGE);
			lblLeasing.setBorder(new LineBorder(Color.BLACK, 1));
			contentPane.add(lblLeasing);
		//LEASING BUTTON
			btLeasing = new JButton("Leasing Menu");
			btLeasing.setBounds(480, 222, 158, 104);
			btLeasing.setContentAreaFilled(false);
			btLeasing.setBorder(null);
			ImageIcon img7 = new ImageIcon(CustomerMenu.class.getResource("/components/leasing.png"));
			ImageIcon btLeasingImg = new ImageIcon( img7.getImage().getScaledInstance(btLeasing.getWidth(), btLeasing.getHeight(), Image.SCALE_SMOOTH) );
			btLeasing.setIcon(btLeasingImg);
			contentPane.add(btLeasing);
			
		//EXIT BUTTON
			btnExitProgram = new JButton();
			btnExitProgram.setBounds(335, 2, 42, 32);
			ImageIcon img8 = new ImageIcon(CustomerMenu.class.getResource("/components/x.png"));
			ImageIcon btnExitProgramImg = new ImageIcon( img8.getImage().getScaledInstance(btnExitProgram.getWidth()-10, btnExitProgram.getHeight()-10, Image.SCALE_SMOOTH) );
			btnExitProgram.setIcon(btnExitProgramImg);
			btnExitProgram.setContentAreaFilled(false);
			btnExitProgram.setBorder(null);
			btnExitProgram.setOpaque(false);
			contentPane.add(btnExitProgram);
			
		
			//LOGO LABEL
				logo = new JLabel();
				logo.setBounds(202, 48, 266, 215);
				logo.setBorder(new LineBorder(Color.white, 5));
				ImageIcon img9 = new ImageIcon(CustomerMenu.class.getResource("/components/logo.png"));
				ImageIcon logoImg = new ImageIcon( img9.getImage().getScaledInstance(logo.getWidth()-10, logo.getHeight()-10, Image.SCALE_SMOOTH) );
				logo.setIcon(logoImg);
				contentPane.add(logo);
				
				
			//MOUSE DRAG
				mouseDrag =  new JLabel();
				mouseDrag.setBounds(0, 0, 677, 30);
				ImageIcon img10 = new ImageIcon(CustomerMenu.class.getResource("/components/drag.gif"));
				ImageIcon dragImg = new ImageIcon( img10.getImage().getScaledInstance(mouseDrag.getWidth()-5, mouseDrag.getHeight()-5, Image.SCALE_SMOOTH) );
				mouseDrag.setIcon(dragImg);
				contentPane.add(mouseDrag);
	}
	
	private void createEvents() {
		
		btCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerMenu customerMenu = new CustomerMenu();
				dispose();
				customerMenu.main(null);
			}
		});
		
		btEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeMenu employeeMenu = new EmployeeMenu();
				dispose();
				employeeMenu.main(null);
			}
		});
		
		btSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleMenu saleMenu = new SaleMenu();
				dispose();
				saleMenu.main(null);
			}
		});
		
		btLeasing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeasingMenu lMenu = new LeasingMenu();
				dispose();
				lMenu.main(null);
			}
		});
		
		btItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemMenu itemMenu = new ItemMenu();
				dispose();
				itemMenu.main(null);
			}
		});
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout ?");
				if(confirm == JOptionPane.YES_OPTION) {
					dispose();
					LoginMenu loginMenu = new LoginMenu();
					loginMenu.main(null);
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
