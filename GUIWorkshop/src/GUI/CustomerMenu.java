package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class CustomerMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnCreateCustomer;
	private JButton btnReadCustomer;
	private JButton btnUpdateCustomer;
	private JButton btnDeleteCustomer;
	private JButton btnBack;
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
					CustomerMenu frame = new CustomerMenu();
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
	public CustomerMenu() {
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
		
		//CREATE BUTTON
		btnCreateCustomer = new JButton();
		btnCreateCustomer.setBounds(175, 54, 147, 135);
		ImageIcon img = new ImageIcon(CustomerMenu.class.getResource("/components/Customer+.png"));
		ImageIcon btnCreateCustomerImg = new ImageIcon( img.getImage().getScaledInstance(btnCreateCustomer.getWidth()-10, btnCreateCustomer.getHeight()-10, Image.SCALE_SMOOTH) );
		btnCreateCustomer.setIcon(btnCreateCustomerImg);
		btnCreateCustomer.setContentAreaFilled(false);
		btnCreateCustomer.setOpaque(false);
		btnCreateCustomer.setBorder(new LineBorder(Color.ORANGE, 5));
		contentPane.add(btnCreateCustomer);
		
		//READ BUTTON
		btnReadCustomer = new JButton("Read Customer");
		btnReadCustomer.setBounds(175, 200, 147, 135);
		ImageIcon img1 = new ImageIcon(CustomerMenu.class.getResource("/components/Customer Read.png"));
		ImageIcon btnReadCustomerImg = new ImageIcon( img1.getImage().getScaledInstance(btnReadCustomer.getWidth()-10, btnReadCustomer.getHeight()-10, Image.SCALE_SMOOTH) );
		btnReadCustomer.setIcon(btnReadCustomerImg);
		btnReadCustomer.setContentAreaFilled(false);
		btnReadCustomer.setOpaque(false);
		btnReadCustomer.setBorder(new LineBorder(Color.ORANGE, 5));
		contentPane.add(btnReadCustomer);
		
		//UPDATE BUTTON
		btnUpdateCustomer = new JButton("Update Customer");
		btnUpdateCustomer.setBounds(353, 54, 161, 135);
		ImageIcon img2 = new ImageIcon(CustomerMenu.class.getResource("/components/Customer Update.png"));
		ImageIcon btnUpdateCustomerImg = new ImageIcon( img2.getImage().getScaledInstance(btnUpdateCustomer.getWidth()-10, btnUpdateCustomer.getHeight()-10, Image.SCALE_SMOOTH) );
		btnUpdateCustomer.setIcon(btnUpdateCustomerImg);
		btnUpdateCustomer.setContentAreaFilled(false);
		btnUpdateCustomer.setOpaque(false);
		btnUpdateCustomer.setBorder(new LineBorder(Color.ORANGE, 5));
		contentPane.add(btnUpdateCustomer);
		
		//DELETE BUTTON
		btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.setBounds(353, 200, 161, 135);
		ImageIcon img3 = new ImageIcon(CustomerMenu.class.getResource("/components/Customer Delete.png"));
		ImageIcon btnDeleteCustomerImg = new ImageIcon( img3.getImage().getScaledInstance(btnDeleteCustomer.getWidth()+10, btnDeleteCustomer.getHeight()-10, Image.SCALE_SMOOTH) );
		btnDeleteCustomer.setIcon(btnDeleteCustomerImg);
		btnDeleteCustomer.setContentAreaFilled(false);
		btnDeleteCustomer.setOpaque(false);
		btnDeleteCustomer.setBorder(new LineBorder(Color.ORANGE, 5));
		contentPane.add(btnDeleteCustomer);
		
		//BACK BUTTON
		btnBack = new JButton();
		btnBack.setBounds(10, 388, 49, 43);
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
		logo.setBounds(521, 349, 93, 82);
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
		btnDeleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCustomer deleteCustomer = new DeleteCustomer();
				dispose();
				deleteCustomer.main(null);
			}
		});
		
		btnUpdateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCustomer updateCustomer = new UpdateCustomer();
				dispose();
				updateCustomer.main(null);
			}
		});
		
		btnCreateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateCustomer createCustomer = new CreateCustomer();
				dispose();
				createCustomer.main(null);
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMenu chMenu = new ChooseMenu();
				dispose();
				chMenu.main(null);
			}
		});
		
		btnReadCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadCustomer readCustomer = new ReadCustomer();
				dispose();
				readCustomer.main(null);
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
