package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class LeasingMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnCreateLeasing;
	private JButton btnReadleasing;
	private JButton btnEditleasing;
	private JButton btnPreviousMenu;
	private JButton btnRetrieveLeasing;
	private JButton btnExitProgram;
	private JButton btnBack;
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
					LeasingMenu frame = new LeasingMenu();
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
	public LeasingMenu() {
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
		
		JLabel lblCreate = new JLabel(" Create Leasing");
		lblCreate.setBounds(32, 121, 80, 25);
		lblCreate.setOpaque(true);
		lblCreate.setBackground(Color.ORANGE);
		contentPane.add(lblCreate);
		//CREATE LEASING BUTTON
		btnCreateLeasing = new JButton("Create Leasing");
		btnCreateLeasing.setBounds(10, 36, 134, 104);
		ImageIcon img = new ImageIcon(CustomerMenu.class.getResource("/components/createLeasing.png"));
		ImageIcon btnCreateLeasingImg = new ImageIcon( img.getImage().getScaledInstance(btnCreateLeasing.getWidth()+10, btnCreateLeasing.getHeight()+10, Image.SCALE_SMOOTH) );
		btnCreateLeasing.setIcon(btnCreateLeasingImg);
		btnCreateLeasing.setContentAreaFilled(false);
		btnCreateLeasing.setBorder(null);
		btnCreateLeasing.setOpaque(false);
		contentPane.add(btnCreateLeasing);
		
		JLabel lblRead = new JLabel(" Read Leasing");
		lblRead.setBounds(169, 250, 80, 25);
		lblRead.setOpaque(true);
		lblRead.setBackground(Color.ORANGE);
		contentPane.add(lblRead);
		//READ LEASING BUTTON
		btnReadleasing = new JButton("Read Leasing");
		btnReadleasing.setBounds(143, 149, 134, 104);
		ImageIcon img1 = new ImageIcon(CustomerMenu.class.getResource("/components/readLeasing.jpg"));
		ImageIcon btnReadleasingImg = new ImageIcon( img1.getImage().getScaledInstance(btnReadleasing.getWidth(), btnReadleasing.getHeight(), Image.SCALE_SMOOTH) );
		btnReadleasing.setIcon(btnReadleasingImg);
		btnReadleasing.setContentAreaFilled(false);
		btnReadleasing.setBorder(null);
		btnReadleasing.setOpaque(false);
		contentPane.add(btnReadleasing);
		
		JLabel lblEdit = new JLabel(" Edit Leasing");
		lblEdit.setBounds(345, 138, 80, 25);
		lblEdit.setOpaque(true);
		lblEdit.setBackground(Color.ORANGE);
		contentPane.add(lblEdit);
		//EDIT LEASING BUTTON
		btnEditleasing = new JButton("Edit Leasing");
		btnEditleasing.setBounds(324, 43, 134, 104);
		ImageIcon img2 = new ImageIcon(CustomerMenu.class.getResource("/components/editLeasing.png"));
		ImageIcon btnEditleasingImg = new ImageIcon( img2.getImage().getScaledInstance(btnEditleasing.getWidth()-10, btnEditleasing.getHeight(), Image.SCALE_SMOOTH) );
		btnEditleasing.setIcon(btnEditleasingImg);
		btnEditleasing.setContentAreaFilled(false);
		btnEditleasing.setBorder(null);
		btnEditleasing.setOpaque(false);
		contentPane.add(btnEditleasing);
		
		JLabel lblRetrieve = new JLabel(" Retrieve Leasing");
		lblRetrieve.setBounds(527, 250, 80, 25);
		lblRetrieve.setOpaque(true);
		lblRetrieve.setBackground(Color.ORANGE);
		contentPane.add(lblRetrieve);
		//RETRIVE LEASING BUTTON
		btnRetrieveLeasing = new JButton("Retrieve Leasing");
		btnRetrieveLeasing.setBounds(487, 149, 164, 115);
		ImageIcon img3 = new ImageIcon(CustomerMenu.class.getResource("/components/retriveLeasing.png"));
		ImageIcon btnRetrieveLeasingImg = new ImageIcon( img3.getImage().getScaledInstance(btnRetrieveLeasing.getWidth(), btnRetrieveLeasing.getHeight()-10, Image.SCALE_SMOOTH) );
		btnRetrieveLeasing.setIcon(btnRetrieveLeasingImg);
		btnRetrieveLeasing.setContentAreaFilled(false);
		btnRetrieveLeasing.setBorder(null);
		btnRetrieveLeasing.setOpaque(false);
		contentPane.add(btnRetrieveLeasing);
		
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
		
		
		btnCreateLeasing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateLeasing createLeasing = new CreateLeasing();
				dispose();
				createLeasing.main(null);
			}
		});
		
		btnReadleasing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadLeasing readLeasing = new ReadLeasing();
				dispose();
				readLeasing.main(null);
			}
		});
		
		btnEditleasing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditLeasing editLeasing = new EditLeasing();
				dispose();
				editLeasing.main(null);
			}
		});
		
		btnRetrieveLeasing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetrieveLeasing rLeasing = new RetrieveLeasing();
				dispose();
				rLeasing.main(null);
					
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMenu chMenu = new ChooseMenu();
				dispose();
				chMenu.main(null);
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
