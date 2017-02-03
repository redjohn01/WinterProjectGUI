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

import ControlLayer.Brexit;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class SaleMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnCreateSale;
	private JButton btnReadSale;
	private JButton btnEditSale;
	private JButton btnPreviousMenu;
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
					SaleMenu frame = new SaleMenu();
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
	public SaleMenu() {
		initializeComponents();
		createEvents();
	}

	

	private void initializeComponents() {
		setTitle("Sale Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		contentPane = new JPanel();
		contentPane.setOpaque(true);
		contentPane.setBackground(new Color(27,28,28, 255)); // background color
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//CREATE SALE BUTTON
		btnCreateSale = new JButton("Create Sale");
		btnCreateSale.setBounds(285, 48, 100, 94);
		btnCreateSale.setContentAreaFilled(false);
		btnCreateSale.setBorder(null);
		ImageIcon img = new ImageIcon(CustomerMenu.class.getResource("/components/createLeasing.png"));
		ImageIcon btnCreateSaleiMG = new ImageIcon( img.getImage().getScaledInstance(btnCreateSale.getWidth(), btnCreateSale.getHeight(), Image.SCALE_SMOOTH) );
		btnCreateSale.setIcon(btnCreateSaleiMG);
		contentPane.add(btnCreateSale);
		
		//READ SALE BUTTON
		btnReadSale = new JButton("Read Sale");
		btnReadSale.setBounds(285, 153, 100, 94);
		btnReadSale.setContentAreaFilled(false);
		btnReadSale.setBorder(null);
		ImageIcon img2 = new ImageIcon(CustomerMenu.class.getResource("/components/readLeasing.jpg"));
		ImageIcon btnReadSaleImg = new ImageIcon( img2.getImage().getScaledInstance(btnReadSale.getWidth(), btnReadSale.getHeight(), Image.SCALE_SMOOTH) );
		btnReadSale.setIcon(btnReadSaleImg);
		contentPane.add(btnReadSale);
		
		//EDIT SALE BUTTON
		btnEditSale = new JButton("Edit Sale");
		btnEditSale.setBounds(285, 277, 111, 94);
		btnEditSale.setContentAreaFilled(false);
		btnEditSale.setBorder(null);
		ImageIcon img3 = new ImageIcon(CustomerMenu.class.getResource("/components/editLeasing.png"));
		ImageIcon btnEditSaleImg = new ImageIcon( img3.getImage().getScaledInstance(btnEditSale.getWidth(), btnEditSale.getHeight(), Image.SCALE_SMOOTH) );
		btnEditSale.setIcon(btnEditSaleImg);
		contentPane.add(btnEditSale);
		
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
		btnExitProgram.setBounds(315, 0, 42, 32);
		ImageIcon img8 = new ImageIcon(CustomerMenu.class.getResource("/components/x.png"));
		ImageIcon btnExitProgramImg = new ImageIcon( img8.getImage().getScaledInstance(btnExitProgram.getWidth()-10, btnExitProgram.getHeight()-10, Image.SCALE_SMOOTH) );
		btnExitProgram.setIcon(btnExitProgramImg);
		btnExitProgram.setContentAreaFilled(false);
		btnExitProgram.setBorder(null);
		btnExitProgram.setOpaque(false);
		contentPane.add(btnExitProgram);
		
	
		//LOGO LABEL
			logo = new JLabel();
			logo.setBounds(513, 365, 111, 94);
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
		// TODO Auto-generated method stub
		
		
		btnCreateSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateSale createSale = new CreateSale();
				dispose();
				createSale.main(null);
			}
		});
		
		btnReadSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadSale readSale = new ReadSale();
				dispose();
				readSale.main(null);
			}
		});
		
		btnEditSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditSale editSale = new EditSale();
				dispose();
				editSale.main(null);
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
